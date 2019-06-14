package net.cloudburo.polkadot.types.primitives;

import net.cloudburo.polkadot.types.base.Helper;
import net.cloudburo.polkadot.types.base.InvalidScaleTypeValueException;
import net.cloudburo.polkadot.types.base.ScaleBytes;
import net.cloudburo.polkadot.types.base.ScaleType;

public class U64 extends ScaleType {

    public U64(ScaleBytes data ) {
        super(data,null);
        // TODO metaData
    }

    public U64(ScaleBytes data, String subType ) {
        super(data,subType,null);
        // TODO metaData
    }

    public  Object  process() throws InvalidScaleTypeValueException {
        return Integer.valueOf(Helper.byteArrayToLeInt(this.getNextBytes(8)));
    }
}
