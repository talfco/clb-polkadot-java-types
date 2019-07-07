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

import net.cloudburo.substrate.types.common.SubstrateTypeException;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class IntTest {

    @Test
    public void toLittleEndian() throws SubstrateTypeException {
        // Default bitlength  is set 64
        Int ui = new Int(BigInteger.valueOf(-6));
        assert(ui.toU8Array().getDataAsHex().equals("faffffffffffffff"));
        ui = new Int(BigInteger.valueOf(6),new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L16));
        assert(ui.toU8Array().getDataAsHex().equals("0006"));
        // unsigned 16-bit integer 42: 0x2a00
        ui = new Int(BigInteger.valueOf(42),new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L16));
        assert(ui.toU8Array().getDataAsHex().equals("2a00"));
        // unsigned 32-bit integer 16777215: 0x00ffffff
        ui = new Int(BigInteger.valueOf(16777215),new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L32));
        assert(ui.toU8Array().getDataAsHex().equals("ffffff00"));
        //
        ui = new Int(BigInteger.valueOf(-6),new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L16));
        assert(ui.toU8Array().getDataAsHex().equals("faff"));
        // unsigned 16-bit integer 42: 0x2a00
        ui = new Int(BigInteger.valueOf(-42),new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L16));
        assert(ui.toU8Array().getDataAsHex().equals("d6ff"));
    }


}