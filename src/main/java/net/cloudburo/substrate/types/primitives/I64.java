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

package net.cloudburo.substrate.types.primitives;

import net.cloudburo.substrate.types.codec.Int;
import net.cloudburo.substrate.types.codec.UIntBitLength;
import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.common.SubstrateTypeException;

import java.math.BigInteger;

/**
 * A 64 bit unsigned integer
 */
public class I64 extends Int {

    public static String MAX ="9223372036854775807";
    public static String MIN = "−9223372036854775808";

    public I64(BigInteger bn) throws SubstrateTypeException {
        super(bn,new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L64));
    }

    public I64(long bn) throws SubstrateTypeException {
        super(BigInteger.valueOf(bn),new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L64));
    }

    public I64(ScaleBytes data ) throws SubstrateTypeException {
        super(data,new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L64));
    }

    public I64(ScaleBytes data, String subType ) throws SubstrateTypeException {
        super(data,subType,new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L64));
    }

    public  boolean isNegative(BigInteger bi) {
        return (bi.compareTo(new BigInteger(MAX))==1) ?  true: false;
    }
}
