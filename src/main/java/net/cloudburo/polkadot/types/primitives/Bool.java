package net.cloudburo.polkadot.types.primitives;

import net.cloudburo.polkadot.types.base.InvalidScaleTypeValueException;
import net.cloudburo.polkadot.types.base.ScaleBytes;
import net.cloudburo.polkadot.types.base.ScaleType;

public class Bool extends ScaleType {

    public Bool(ScaleBytes data ) {
        super(data,Bool.class.getSimpleName(),null);
        // TODO metaData
    }

    public  Object  process() throws InvalidScaleTypeValueException {
        return Boolean.valueOf(this.getNextBool());
    }
}
