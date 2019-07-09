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

public class I16Test {

    @Test
    public void constructorTest() throws SubstrateTypeException {
        I16 ui = new I16(8192);
        assert(ui.toU8Array().getDataAsHex().equals("0020"));
        I16 ui1 = new I16(ui.toU8Array());
        assert(ui1.intValue()==ui.intValue());
        ui = new I16(I16.MAX);
        assert(ui.toU8Array().getDataAsHex().equals("ff7f"));
        ui = new I16(-6);
        assert(ui.toU8Array().getDataAsHex().equals("faff"));
        ui = new I16(I16.MIN);
        assert(ui.toU8Array().getDataAsHex().equals("0080"));
        // doesn't fit in short
        try {
            ui = new I16(I16.MAX+1);
        } catch (SubstrateTypeException ex) {
            assert(ex.code == SubstrateTypeException.Code.UIntSizeTooSmall);
            return;
        }
        try {
            ui = new I16(I16.MIN-1);
        } catch (SubstrateTypeException ex) {
            assert(ex.code == SubstrateTypeException.Code.UIntSizeTooSmall);
            return;
        }
        assert(false);
    }

}