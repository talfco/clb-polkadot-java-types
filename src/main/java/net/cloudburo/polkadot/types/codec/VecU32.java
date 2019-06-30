package net.cloudburo.polkadot.types.codec;

import net.cloudburo.polkadot.types.common.RemainingScaleBytesNotEmptyException;
import net.cloudburo.polkadot.types.common.ScaleBytes;
import net.cloudburo.polkadot.types.common.ScaleType;
import net.cloudburo.polkadot.types.common.InvalidScaleTypeValueException;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Vector;

public class VecU32 extends ScaleType {

    private Vector elements = new Vector();

    public VecU32(ScaleBytes data, String subType) {
        super(data,subType);
    }

    public Object process() throws IOException, InvalidScaleTypeValueException, RemainingScaleBytesNotEmptyException {
        BigInteger elementCount = (BigInteger) this.decodeType("Compact<u32>").getValue();
        Vector res = new Vector();
        for (int i=0;i< elementCount.intValue();i++){
            ScaleType elem = this.decodeType(this.subType);
            elements.add(elem);
            res.add(elem.getValue());
        }
        return res;
    }

}
