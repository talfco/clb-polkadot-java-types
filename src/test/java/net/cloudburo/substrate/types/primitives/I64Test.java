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

public class I64Test {

    @Test
    public void constructorTest() throws SubstrateTypeException {
        // 1224979098644840449
        // 8 Bytes
        I64 ui = new I64(1224979098644840449L);
        assert (ui.toU8Array().getDataAsHex().equals("0100010000000011"));
        I64 ui1 = new I64(new ScaleBytes(ui.toU8Array().getData()));
        assert (ui1.longValue() == ui1.longValue());
        // 4 Bytes
        ui = new I64(2147483647);
        assert (ui.toU8Array().getDataAsHex().equals("ffffff7f00000000"));
        ui1 = new I64(new ScaleBytes(ui.toU8Array().getData()));
        // 65537 - 3 Byte
        ui = new I64(65537);
        assert (ui.toU8Array().getDataAsHex().equals("0100010000000000"));
        ui1 = new I64(new ScaleBytes(ui.toU8Array().getData()));
        assert (ui1.intValue() == ui1.intValue());
        // 2 Byte
        ui = new I64(8192);
        assert (ui.toU8Array().getDataAsHex().equals("0020000000000000"));
        ui1 = new I64(new ScaleBytes(ui.toU8Array().getData()));
        assert (ui1.intValue() == ui1.intValue());
        // 1 Byte
        ui = new I64(256);
        assert (ui.toU8Array().getDataAsHex().equals("0001000000000000"));
        ui1 = new I64(new ScaleBytes(ui.toU8Array().getData()));
        assert (ui1.intValue() == ui1.intValue());
        ui = new I64(-6);
        assert(ui.toU8Array().getDataAsHex().equals("faffffffffffffff"));
        // doesn't fit
        try {
            ui = new I64(new BigInteger(I64.MAX).add(BigInteger.valueOf(1)));
        } catch (
                SubstrateTypeException ex) {
            assert (ex.code == SubstrateTypeException.Code.UIntSizeTooSmall);
            return;
        }
        assert (false);
    }
}