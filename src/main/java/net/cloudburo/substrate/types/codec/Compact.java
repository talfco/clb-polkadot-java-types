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
        // TODO metaData
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

        // TODO
        return null;
    }


}
