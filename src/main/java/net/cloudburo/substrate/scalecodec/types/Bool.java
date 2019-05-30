package net.cloudburo.substrate.scalecodec.types;

import net.cloudburo.substrate.scalecodec.base.InvalidScaleTypeValueException;
import net.cloudburo.substrate.scalecodec.base.ScaleBytes;
import net.cloudburo.substrate.scalecodec.base.ScaleType;

public class Bool extends ScaleType {

    public Bool(ScaleBytes data ) {
        super(data,"Bool",null);
        // TODO metaData
    }

    public  Object  process() throws InvalidScaleTypeValueException {
        return Boolean.valueOf(this.getNextBool());
    }
}
