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

import net.cloudburo.substrate.types.TypeFactory;
import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.common.ScaleType;
import net.cloudburo.substrate.types.codec.VecU32;
import org.junit.Test;

import java.util.Vector;

public class AccountIdTest {

    @Test
    public void scaleTypeAccountIdVector() throws Exception {
        // Address is 32 bytes, which results in hex format 64 characters, here 2x64 bytes
        ScaleType obj = TypeFactory.createScaleTypeObject("Vec<AccountId>", new ScaleBytes("0x0865d2273adeb04478658e183dc5edf41f1d86e42255442af62e72dbf1e6c0b97765d2273adeb04478658e183dc5edf41f1d86e42255442af62e72dbf1e6c0b977"));
        assert (obj instanceof VecU32);
        obj.decode(true);
        Vector<String> vec = (Vector<String>)obj.getValue();
        assert(vec.size()==2);
        assert(vec.get(0).equals("0x65d2273adeb04478658e183dc5edf41f1d86e42255442af62e72dbf1e6c0b977"));
        assert(vec.get(1).equals("0x65d2273adeb04478658e183dc5edf41f1d86e42255442af62e72dbf1e6c0b977"));
    }

}