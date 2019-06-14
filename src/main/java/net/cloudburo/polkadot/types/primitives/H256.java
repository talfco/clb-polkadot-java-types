package net.cloudburo.polkadot.types.primitives;

import net.cloudburo.polkadot.types.base.InvalidScaleTypeValueException;
import net.cloudburo.polkadot.types.base.RemainingScaleBytesNotEmptyException;
import net.cloudburo.polkadot.types.base.ScaleBytes;
import net.cloudburo.polkadot.types.base.ScaleType;
import org.apache.commons.codec.binary.Hex;

import java.io.IOException;

/**
 * Hash containing 256 bits (32 bytes), typically used in blocks, extrinsics and as a sane default
 */
public class H256 extends ScaleType {

    public H256(ScaleBytes data, String subType) {
        super(data, subType, null);
    }
    public H256(ScaleBytes data) {
        super(data, null);
    }

    public Object process() throws IOException, InvalidScaleTypeValueException, RemainingScaleBytesNotEmptyException {
        String hex = "0x";
        hex += Hex.encodeHexString(this.getNextBytes(32));
        return hex;
    }
}