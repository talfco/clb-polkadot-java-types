package net.cloudburo.substrate.types.codec;

import net.cloudburo.substrate.types.common.*;

import java.io.IOException;
import java.math.BigInteger;

public class ScaleUInt extends ScaleType {

    UIntBitLength bitLength;

    public ScaleUInt(ScaleBytes data) {
        super(data);
    }

    public ScaleUInt(ScaleBytes data, String subType) {
        super(data, subType);
    }

    @Override
    public Object process() throws InvalidScaleTypeValueException, IOException, RemainingScaleBytesNotEmptyException {
        return BigInteger.valueOf(Helper.byteArrayToLeInt(this.getNextBytes(this.bitLength.inBytes)));
    }
}
