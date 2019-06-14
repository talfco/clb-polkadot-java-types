package net.cloudburo.polkadot.types.primitives;

import net.cloudburo.polkadot.types.base.Helper;
import net.cloudburo.polkadot.types.base.InvalidScaleTypeValueException;
import net.cloudburo.polkadot.types.base.ScaleBytes;
import net.cloudburo.polkadot.types.base.ScaleType;

/**
 * A 32-bit unsigned integer
 */
public class U32 extends ScaleType {

    public U32(ScaleBytes data ) {
        super(data,null);
        // TODO metaData
    }

    public U32(ScaleBytes data, String subType ) {
        super(data,subType,null);
        // TODO metaData
    }

    public  Object  process() throws InvalidScaleTypeValueException {
        return Integer.valueOf(Helper.byteArrayToLeInt(this.getNextBytes(4)));
    }
}
