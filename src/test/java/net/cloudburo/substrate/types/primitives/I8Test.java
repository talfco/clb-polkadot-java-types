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

import net.cloudburo.substrate.types.common.SubstrateTypeException;
import org.junit.Test;

public class I8Test {

    @Test
    public void constructorTest() throws SubstrateTypeException {
        I8 ui = new I8(32);
        assert(ui.toU8Array().getDataAsHex().equals("20"));
        U8 ui1 = new U8(ui.toU8Array());
        assert(ui1.intValue()==ui.intValue());
        ui = new I8(-6);
        assert(ui.toU8Array().getDataAsHex().equals("fa"));
        // Doesn't fit
        try {
            ui = new I8(128);
        } catch (SubstrateTypeException ex) {
            assert(ex.code == SubstrateTypeException.Code.UIntSizeTooSmall);
            return;
        }
        assert(false);
    }

}