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

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.common.ScaleType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Compact extends ScaleType {

    static final Logger logger = LoggerFactory.getLogger(Compact.class);

    private int compactLength;
    private byte[] compactBytes;

    public Compact(ScaleBytes data, String subType) {
        super(data,subType);
    }

    public int getCompactLength() {
        return compactLength;
    }

    public byte[] getCompactBytes() {
        return compactBytes;
    }

    public byte[] processCompactBytes() throws java.io.IOException {
        byte[] compactByte = this.getNextBytes(1);
        int byteMod = Integer.remainderUnsigned(compactByte[0], 4);
        if (byteMod == 0) {
            this.compactLength = 1;
            this.compactBytes = compactByte;
        }
        else if (byteMod ==1) {
            this.compactLength = 2;
            ByteArrayOutputStream myStream = new ByteArrayOutputStream();
            myStream.write(compactByte);
            myStream.write(this.getNextBytes(this.compactLength-1));
            this.compactBytes = myStream.toByteArray();
        }
        else if (byteMod == 2 ) {
            this.compactLength = 4;
            ByteArrayOutputStream myStream = new ByteArrayOutputStream();
            myStream.write(compactByte);
            myStream.write(this.getNextBytes(this.compactLength-1));
            this.compactBytes = myStream.toByteArray();
        }
        else {
            this.compactLength = 5 + (Byte.toUnsignedInt(compactByte[0]) - 3) / 4;
            this.compactBytes = this.getNextBytes(this.compactLength-1);
        }
        return this.compactBytes;
    }

    public Object process() throws IOException {
        this.processCompactBytes();
        if (this.subType!=null) {

        } else
            return this.compactBytes;

        // TODO Finalize
        return null;
    }


}
