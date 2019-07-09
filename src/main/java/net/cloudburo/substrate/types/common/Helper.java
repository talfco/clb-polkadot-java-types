/*
 * Copyright (c) 2019. Cloudburo.net (Atnode GmbH)
 *
 * Licensed under the GNU General Public License v3.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package net.cloudburo.substrate.types.common;

import net.cloudburo.substrate.types.TypeFactory;
import net.cloudburo.substrate.types.codec.UIntBitLength;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Helper {

    static final Logger logger = LoggerFactory.getLogger(Helper.class);

    // https://stackoverflow.com/questions/140131/convert-a-string-representation-of-a-hex-dump-to-a-byte-array-using-java
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    public static BigInteger toBigIntFromLittleEndian(byte[] arr) {
        byte[] rev = new byte[arr.length + 1];
        for (int i = 0, j = arr.length; j > 0; i++, j--)
            rev[j] = arr[i];
        return new BigInteger(rev);
    }

    public static int byteArrayToLeInt(byte[] b) {
        final ByteBuffer bb = ByteBuffer.wrap(b);
        bb.order(ByteOrder.LITTLE_ENDIAN);
        return bb.getInt();
    }

    public static byte[] byteArrayToLeByteArray (byte[] theBytes,  int numBytes) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(theBytes);
        ByteBuffer destByteBuffer = ByteBuffer.allocate(theBytes.length);
        destByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        int offset = 0;
        while (byteBuffer.hasRemaining())
        {
            byte[] dest = new byte[numBytes];
            byteBuffer.get(dest,offset,numBytes);
            destByteBuffer.put(dest);
            offset += numBytes;
        }
        return destByteBuffer.array();
    }

    //public static byte[] leIntToByteArray(int i) {
    //    return leIntToByteArrayWithSize(i,Integer.SIZE);
    //}
    public static byte[] bigIntegerToByteArrayWithSize(BigInteger bigI, UIntBitLength bl, boolean littleEndian)
        throws SubstrateTypeException {
        int numBytes = bl.inBytes;
        // Now do a little endian on the big inter received bytes
        byte[] bigIA = null;
        if (littleEndian) {
            switch (bl.bitLength) {
                case 8:
                    bigIA = bigI.toByteArray();
                    break;
                case 16:
                    short swapS = Short.valueOf(ByteSwapper.swap(bigI.shortValue()));
                    bigIA = ByteBuffer.allocate(2).putShort(swapS).array();
                    break;
                case 32:
                    int swapI = Integer.valueOf(ByteSwapper.swap(bigI.intValue()));
                    bigIA = ByteBuffer.allocate(4).putInt(swapI).array();
                    break;
                case 64:
                    long swapL = Long.valueOf(ByteSwapper.swap(bigI.longValue()));
                    bigIA =  ByteBuffer.allocate(8).putLong(swapL).array();
                    break;
                case 128:
                    String hexValue = Hex.encodeHexString(bigI.toByteArray());
                    String revHex = reverseHex(hexValue);
                    try {                        // Positive Number initalize with 0
                        // Positive Number initalize with 0
                        if (bigI.signum() == 1) {
                            bigIA = ByteBuffer.allocate(16).put(Hex.decodeHex(revHex)).array();
                        } else {
                            byte[] tmpl = new byte[]{
                                    (byte)255,(byte)255,(byte)255,(byte)255,(byte)255,(byte)255,(byte)255,(byte)255,
                                    (byte)255,(byte)255,(byte)255,(byte)255,(byte)255,(byte)255,(byte)255,(byte)255
                            };
                            bigIA = ByteBuffer.wrap(tmpl).put(Hex.decodeHex(revHex)).array();
                        }
                        break;
                    } catch (DecoderException ex) {
                        throw new SubstrateTypeException(SubstrateTypeException.Code.ConversionException,
                                "DecoderException: " + ex.getMessage());
                    }
                case 256:
                    hexValue = Hex.encodeHexString(bigI.toByteArray());
                    revHex = reverseHex(hexValue);
                    try {
                        // Positive Number initalize with 0
                        if (bigI.signum() == 1) {
                            bigIA = ByteBuffer.allocate(32).put(Hex.decodeHex(revHex)).array();
                            break;
                        } else {
                            byte[] tmpl = new byte[]{
                                    (byte)255,(byte)255,(byte)255,(byte)255,(byte)255,(byte)255,(byte)255,(byte)255,
                                    (byte)255,(byte)255,(byte)255,(byte)255,(byte)255,(byte)255,(byte)255,(byte)255,
                                    (byte)255,(byte)255,(byte)255,(byte)255,(byte)255,(byte)255,(byte)255,(byte)255,
                                    (byte)255,(byte)255,(byte)255,(byte)255,(byte)255,(byte)255,(byte)255,(byte)255
                            };
                            bigIA = ByteBuffer.wrap(tmpl).put(Hex.decodeHex(revHex)).array();
                        }
                    } catch (DecoderException ex) {
                        throw new SubstrateTypeException(SubstrateTypeException.Code.ConversionException,
                                "DecoderException: " + ex.getMessage());
                    }
            }
        }
        else
            bigIA = bigI.toByteArray();

        ByteBuffer bb= ByteBuffer.wrap(bigIA,0,bigIA.length);
        byte[] dest = new byte[numBytes];
        if (bigIA.length<numBytes)
            bb.get(dest,0,bigIA.length);
        else
            bb.get(dest,0,numBytes);
        return dest;
    }

    public static String reverseHex(String originalHex) {
        if (originalHex.length()%2==1)
            originalHex = '0'+originalHex;
        int lengthInBytes = originalHex.length() / 2;
        char[] chars = new char[lengthInBytes * 2];
        for (int index = 0; index < lengthInBytes; index++) {
            int reversedIndex = lengthInBytes - 1 - index;
            chars[reversedIndex * 2] = originalHex.charAt(index * 2);
            chars[reversedIndex * 2 + 1] = originalHex.charAt(index * 2 + 1);
        }
        return new String(chars);
    }


    public static byte[] leIntToByteArrayWithSize(int i, int numBytes) {
        final ByteBuffer bb = ByteBuffer.allocate(Integer.SIZE / Byte.SIZE);
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.putInt(i);

        int len = bb.array().length;
        int clen;
        if (numBytes-len<0)
            clen = numBytes;
        else
            clen = len;
        byte[] res = new byte[numBytes];
        for (int j=0; j<clen;j++)
             res[j] = bb.get(j);
        if (numBytes-len>0) {
            for (int k=len; k<numBytes;k++) {
                res[k] = bb.get(k);
            }
        }
        return res;
    }

    public static byte[] adjustByteArray(byte[] buf, int len) throws SubstrateTypeException {
        int fill = len - buf.length;
        if (fill < 0 )
            throw new SubstrateTypeException(SubstrateTypeException.Code.SizeException,"Byte Buffer to small: "+fill);
        byte[] result = new byte[len];
        byte[] filler = new byte[fill];
        System.arraycopy(filler, 0, result, 0, fill);
        System.arraycopy(buf, 0, result, fill, buf.length);
        return result;


    }

    public static Map<String, String> loadHashMapFromFile(String delimiter, String fileName) throws URISyntaxException, IOException {
        Map<String, String> map = new HashMap<>();
        try (Stream<String> lines = Files.lines(Paths.get(TypeFactory.class.getClassLoader()
                .getResource(fileName).toURI()))) {
            lines.filter(line -> line.contains(delimiter)).forEach(
                    line -> map.putIfAbsent(line.split(delimiter)[0], line.split(delimiter)[1])
            );
        }
        logger.debug("Loaded Hashmap from "+fileName+":"+map.toString());
        return map;
    }
}
