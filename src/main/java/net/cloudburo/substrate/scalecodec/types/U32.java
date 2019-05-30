package net.cloudburo.substrate.scalecodec.types;

import net.cloudburo.substrate.scalecodec.base.Helper;
import net.cloudburo.substrate.scalecodec.base.InvalidScaleTypeValueException;
import net.cloudburo.substrate.scalecodec.base.ScaleBytes;
import net.cloudburo.substrate.scalecodec.base.ScaleType;

public class U32 extends ScaleType {

    public U32(ScaleBytes data ) {
        super(data,"Compact<u32>",null);
        // TODO metaData
    }

    public  Object  process() throws InvalidScaleTypeValueException {
        return Integer.valueOf(Helper.byteArrayToLeInt(this.getNextBytes(4)));
    }
}
