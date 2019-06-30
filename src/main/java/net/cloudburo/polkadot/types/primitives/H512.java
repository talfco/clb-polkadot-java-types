package net.cloudburo.polkadot.types.primitives;

import net.cloudburo.polkadot.types.common.InvalidScaleTypeValueException;
import net.cloudburo.polkadot.types.common.RemainingScaleBytesNotEmptyException;
import net.cloudburo.polkadot.types.common.ScaleBytes;
import net.cloudburo.polkadot.types.common.ScaleType;
import org.apache.commons.codec.binary.Hex;

import java.io.IOException;

/**
 Hash containing 512 bits (64 bytes), typically used for signatures
 */
public class H512 extends ScaleType {

    public H512(ScaleBytes data, String subType) {
        super(data, subType);
    }
    public H512(ScaleBytes data) {
        super(data, null);
    }

    public Object process() throws IOException, InvalidScaleTypeValueException, RemainingScaleBytesNotEmptyException {
        String hex = "0x";
        hex += Hex.encodeHexString(this.getNextBytes(64));
        return hex;
    }


}
