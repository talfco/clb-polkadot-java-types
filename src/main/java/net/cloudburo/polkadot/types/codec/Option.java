package net.cloudburo.polkadot.types.codec;

import net.cloudburo.polkadot.types.common.Helper;
import net.cloudburo.polkadot.types.common.InvalidScaleTypeValueException;
import net.cloudburo.polkadot.types.common.ScaleBytes;
import net.cloudburo.polkadot.types.common.ScaleType;

public class Option extends ScaleType {

    public Option(ScaleBytes data ) {
        super(data, null);
    }

    // TODO Implrmrnz
    public  Object  process() throws InvalidScaleTypeValueException {
        Integer option_byte =  Integer.valueOf(Helper.byteArrayToLeInt(this.getNextBytes(1)));
        return null;
    }
}
