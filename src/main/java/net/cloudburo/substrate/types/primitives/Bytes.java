package net.cloudburo.substrate.types.primitives;

import net.cloudburo.substrate.types.common.InvalidScaleTypeValueException;
import net.cloudburo.substrate.types.common.RemainingScaleBytesNotEmptyException;
import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.common.ScaleType;

import java.io.IOException;
import java.math.BigInteger;

public class Bytes extends ScaleType {

    public Bytes(ScaleBytes data ) {
        super(data,"'Vec<u8>");
    }

    // TODO
    public  Object  process() throws InvalidScaleTypeValueException, IOException, RemainingScaleBytesNotEmptyException {
        BigInteger elementCount = (BigInteger)this.decodeType("Compact<u32>").getValue();
        byte[] value = this.getNextBytes(elementCount.intValue());
        return null;
    }

}
