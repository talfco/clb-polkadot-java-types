package net.cloudburo.polkadot.types.common;

import net.cloudburo.polkadot.types.TypeFactory;
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

    public static byte[] byteArrayToLeByteArray (byte[] b) {
        final ByteBuffer bb = ByteBuffer.wrap(b);
        bb.order(ByteOrder.LITTLE_ENDIAN);
        return bb.array();
    }

    //public static byte[] leIntToByteArray(int i) {
    //    return leIntToByteArrayWithSize(i,Integer.SIZE);
    //}
    public static byte[] bigIntegerToByteArrayWithSize(BigInteger bigI, int numBytes, boolean littleEndian) {
        ByteBuffer bb;
        // Allocate full size
        int bigIlen = bigI.toByteArray().length;
        if ( bigIlen> numBytes)
           bb = ByteBuffer.allocate(bigIlen);
        else
            bb = ByteBuffer.allocate(numBytes);
        // Now do a little endian on the big inter received bytes
        byte[] bigIA;
        if (littleEndian)
             bigIA = Helper.byteArrayToLeByteArray(bigI.toByteArray());
        else
            bigIA = bigI.toByteArray();

        if (numBytes > bigIlen) {
            for (int i=0;i<numBytes-bigIlen;i++) {
                bb.put((byte)0);
            }
        }
        bb.put(bigIA);

        byte[] res = new byte[numBytes];
        for (int j=0; j<numBytes;j++)
            res[j] = bb.get(j);
        return res;
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
