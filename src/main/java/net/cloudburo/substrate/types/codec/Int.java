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

package net.cloudburo.substrate.types.codec;

import net.cloudburo.substrate.types.common.Helper;
import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.common.SubstrateTypeException;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Basic integers are encoded using a fixed-width little-endian (LE) format.
 * A generic unsigned integer codec. For Substrate all numbers are Little Endian encoded,
 * this handles the encoding and decoding of those numbers. Upon construction
 * the bitLength is provided and any additional use keeps the number to this
 * length.
 */
public  class Int extends AbstractInt {

    public static BigInteger decode(ScaleBytes data,UIntBitLength len) throws SubstrateTypeException {
        BigInteger bi =  Helper.toBigIntFromLittleEndian(data.getData());
        if (len.inBytes>64)
            // FIXME implement
            throw new SubstrateTypeException(SubstrateTypeException.Code.ConversionException);
        if (isSet(data.getData(),len.bitLength-1)) {
            if (len.inBytes<64)
                BigInteger.valueOf(ByteBuffer.wrap(data.getData()).order(ByteOrder.LITTLE_ENDIAN).getInt());
            else
                BigInteger.valueOf(ByteBuffer.wrap(data.getData()).order(ByteOrder.LITTLE_ENDIAN).getLong());
        }
        return bi;
    }

    public static boolean isSet(byte[] arr, int bit) {
        int index = bit / 8;  // Get the index of the array for the byte with this bit
        int bitPosition = bit % 8;  // Position of this bit in a byte
        return (arr[index] >> bitPosition & 1) == 1;
    }


    /* Use these constructors for Integers not encoded */
    public Int(BigInteger bn) throws SubstrateTypeException {
        super(bn,new UIntBitLength(UIntBitLength.setFromInt(UIntBitLength.DEFAULT_UINT_BITS)));
    }

    public Int(BigInteger bn, UIntBitLength bl) throws SubstrateTypeException {
        super(bn,bl);
    }

    /* Use these constructors for encoded Integers */
    public Int(ScaleBytes data)throws SubstrateTypeException {
        this(data, new UIntBitLength(UIntBitLength.setFromInt(UIntBitLength.DEFAULT_UINT_BITS)));
    }

    public Int(ScaleBytes data, UIntBitLength len) throws SubstrateTypeException {
        super(Int.decode(data,len),len) ;
}

    public Int(ScaleBytes data, String subType, UIntBitLength len) throws SubstrateTypeException {
        this(data,len);
        this.subType = subType;
    }

   //public  abstract boolean isNegative(BigInteger bi);


    /**
     *
     * @return Type Name
     */
    public String toRawType() {
        return "i" + this.getUIntBitLength().bitLength;
    }


}
