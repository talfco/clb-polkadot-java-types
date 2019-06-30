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

package net.cloudburo.substrate.types.common;

/*
** A Scale Type holds the byte data of the object and the logic to convert the data to
* java type or object via the process method.
 */
public abstract class ScaleType extends ScaleDecoder {

    public ScaleType(ScaleBytes data) {
        super(data);

    }
    public ScaleType(ScaleBytes data, String subType) {
        super(data, subType);
    }

}