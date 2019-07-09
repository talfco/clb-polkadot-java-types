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
import net.cloudburo.substrate.types.common.SubstrateTypeException;
import net.cloudburo.substrate.types.common.ScaleBytes;
import org.apache.commons.codec.binary.Hex;

import java.math.BigInteger;

public abstract class AbstractInt extends BigInteger implements Codec {

    protected UIntBitLength bitLength;
    protected boolean isNegative;
    protected String subType;

    public AbstractInt(BigInteger bi,UIntBitLength bl) throws SubstrateTypeException {
        super(bi.toByteArray());
        if (bi.toByteArray().length > bl.inBytes)
            throw new SubstrateTypeException( SubstrateTypeException.Code.UIntSizeTooSmall);
        this.bitLength =  bl;
        this.isNegative = bi.signum() == -1;
    }


    /**
     *  The length of the value when encoded as a Uint8Array
     */
    public int getEncodedLength() { return this.bitLength.inBytes; }

    /**
     *  Returns the number of bits in the value
     */
    public UIntBitLength getUIntBitLength() { return this.bitLength; }

    /**
     * Returns the Hex Representation of the Value
     */
    public String toHex() {
        return Hex.encodeHexString(this.toByteArray());
    }

    /**
     * Returns the SCALE Code encoded fixed-width Integer.
     * Basic integers are encoded using a fixed-width little-endian (LE) format. E.g.
     *
     * unsigned 16-bit integer 42: 0x2a00
     * unsigned 32-bit integer 16777215: 0xffffff00
     */
    public ScaleBytes toU8Array() throws SubstrateTypeException {
        return new ScaleBytes(Helper.bigIntegerToByteArrayWithSize(this,this.getUIntBitLength(),true));
    }

    /**
     * Returns the common runtime type name for this instance
     */
    public abstract String toRawType();


}
