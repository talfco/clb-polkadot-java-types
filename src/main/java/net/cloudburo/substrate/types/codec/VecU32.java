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

import net.cloudburo.substrate.types.common.RemainingScaleBytesNotEmptyException;
import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.common.ScaleType;
import net.cloudburo.substrate.types.common.InvalidScaleTypeValueException;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Vector;

public class VecU32 extends ScaleType {

    private Vector elements = new Vector();

    public VecU32(ScaleBytes data, String subType) {
        super(data,subType);
    }

    public Object process() throws IOException, InvalidScaleTypeValueException, RemainingScaleBytesNotEmptyException {
        BigInteger elementCount = (BigInteger) this.decodeType("Compact<u32>").getValue();
        Vector res = new Vector();
        for (int i=0;i< elementCount.intValue();i++){
            ScaleType elem = this.decodeType(this.subType);
            elements.add(elem);
            res.add(elem.getValue());
        }
        return res;
    }

}
