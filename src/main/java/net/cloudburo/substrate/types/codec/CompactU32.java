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

import java.io.IOException;
import java.math.BigInteger;

/** The class works for unsigned numbers up to 4 bytes, which represents the data type int */
public class CompactU32 extends Compact {

    public CompactU32(ScaleBytes data) {
        super(data,"Compact<u32>");
    }

    public Object process() throws IOException {
        this.processCompactBytes();
        if (this.getCompactLength() <= 4) {
            //BigInteger val = new BigInteger(this.getCompactBytes());
            BigInteger val = Helper.toBigIntFromLittleEndian(this.getCompactBytes());
            int val1=  Integer.divideUnsigned(val.intValue(),4);
            return BigInteger.valueOf(val1);
        } else {
            return new BigInteger(this.getCompactBytes()).intValue();
        }
    }

    public byte[] encode(int value) {
        if (Integer.compareUnsigned(value, 63)<=0) {  // 0b00111111
            int a = value << 2;
            return Helper.leIntToByteArrayWithSize(a,1);
        } else if (Integer.compareUnsigned(value, 16383)<=0) {  // 0b0011111111111111
            int b = 1;
            int a = (value << 2)| b;
            return Helper.leIntToByteArrayWithSize(a,2);
        } else if (Integer.compareUnsigned(value, 1073741823)<=0) { // 0b00111111111111111111111111111111
            int b = 2;
            int a = (value << 2)| b;
            return Helper.leIntToByteArrayWithSize(a,4);
        } else {
            return null;
        }
    }

}
