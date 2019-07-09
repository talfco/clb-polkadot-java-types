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

import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.common.SubstrateTypeException;

public interface Codec {

    /**
     * returns a hex string representation of the value
     */
    public abstract String toHex();

    /**
     * Returns the common runtime type name for this instance
     */
    public abstract String toRawType();

    /**
     * Encodes the value as a Uint8Array as per the SCALE specifications
     */
    public abstract ScaleBytes toU8Array() throws SubstrateTypeException;
}
