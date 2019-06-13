package net.cloudburo.polkadot.types.codec;

import net.cloudburo.polkadot.types.base.Helper;
import net.cloudburo.polkadot.types.base.InvalidScaleTypeValueException;
import net.cloudburo.polkadot.types.base.ScaleBytes;
import net.cloudburo.polkadot.types.base.ScaleType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class U32 extends ScaleType {

    static final Logger logger = LoggerFactory.getLogger(ScaleType.class);

    public U32(ScaleBytes data ) {
        super(data,"Compact<u32>",null);
        // TODO metaData
    }

    public  Object  process() throws InvalidScaleTypeValueException {
        return Integer.valueOf(Helper.byteArrayToLeInt(this.getNextBytes(4)));
    }
}
