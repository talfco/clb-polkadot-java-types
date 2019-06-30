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

import net.cloudburo.substrate.types.common.*;

import java.io.IOException;
import java.math.BigInteger;

public class ScaleUInt extends ScaleType {

    UIntBitLength bitLength;

    public ScaleUInt(ScaleBytes data) {
        super(data);
    }

    public ScaleUInt(ScaleBytes data, String subType) {
        super(data, subType);
    }

    @Override
    public Object process() throws InvalidScaleTypeValueException, IOException, RemainingScaleBytesNotEmptyException {
        return BigInteger.valueOf(Helper.byteArrayToLeInt(this.getNextBytes(this.bitLength.inBytes)));
    }
}
