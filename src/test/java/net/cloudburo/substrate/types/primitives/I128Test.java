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

import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.common.SubstrateTypeException;
import org.junit.Test;

import java.math.BigInteger;

public class I128Test {


    @Test
    public void constructorTest() throws SubstrateTypeException {
        // 16 Bytes
        I128 ui = new I128(new BigInteger("170141183460469231731687303715884105727"));
        assert (ui.toU8Array().getDataAsHex().equals("ffffffffffffffffffffffffffffff7f"));
        I128 ui1 = new I128(new ScaleBytes(ui.toU8Array().getData()));
        assert (ui1.equals(ui1));
        // 8 Bytes
        ui = new I128(new BigInteger("1224979098644840449"));
        assert (ui.toU8Array().getDataAsHex().equals("01000100000000110000000000000000"));
        ui1 = new I128(new ScaleBytes(ui.toU8Array().getData()));
        assert (ui1.longValue() == ui1.longValue());
        // 4 Bytes
        ui = new I128(new BigInteger("147483647"));
        assert (ui.toU8Array().getDataAsHex().equals("ff6bca08000000000000000000000000"));
        ui1 = new I128(new ScaleBytes(ui.toU8Array().getData()));
        // 65537 - 3 Byte
        ui = new I128(new BigInteger("65537"));
        assert (ui.toU8Array().getDataAsHex().equals("01000100000000000000000000000000"));
        ui1 = new I128(new ScaleBytes(ui.toU8Array().getData()));
        assert (ui1.intValue() == ui1.intValue());
        // 2 Byte
        ui = new I128(new BigInteger("8192"));
        assert (ui.toU8Array().getDataAsHex().equals("00200000000000000000000000000000"));
        ui1 = new I128(new ScaleBytes(ui.toU8Array().getData()));
        assert (ui1.intValue() == ui1.intValue());
        // 1 Byte
        ui = new I128(new BigInteger("256"));
        assert (ui.toU8Array().getDataAsHex().equals("00010000000000000000000000000000"));
        ui1 = new I128(new ScaleBytes(ui.toU8Array().getData()));
        assert (ui1.intValue() == ui1.intValue());
        ui = new I128(BigInteger.valueOf(-6));
        assert(ui.toU8Array().getDataAsHex().equals("faffffffffffffffffffffffffffffff"));
        // doesn't fit
            try {
            ui = new I128(new BigInteger("1701411834604692317316873037158841057278"));
        } catch (
        SubstrateTypeException ex) {
            assert (ex.code == SubstrateTypeException.Code.UIntSizeTooSmall);
            return;
        }
        assert (false);
    }

}