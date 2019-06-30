package net.cloudburo.polkadot.types.primitives;

import net.cloudburo.polkadot.types.common.InvalidScaleTypeValueException;
import net.cloudburo.polkadot.types.common.RemainingScaleBytesNotEmptyException;
import net.cloudburo.polkadot.types.common.ScaleBytes;
import net.cloudburo.polkadot.types.common.ScaleType;
import org.apache.commons.codec.binary.Hex;

import java.io.IOException;

/**
 * Hash containing 160 bits (20 bytes), typically used in blocks, extrinsics and
 * as a sane default for fixed-length hash
 */
public class H160 extends ScaleType {

    public H160(ScaleBytes data, String subType) {
        super(data, subType);
    }
    public H160(ScaleBytes data) {
        super(data, null);
    }

    public Object process() throws IOException, InvalidScaleTypeValueException, RemainingScaleBytesNotEmptyException {
        String hex = "0x";
        hex += Hex.encodeHexString(this.getNextBytes(20));
        return hex;
    }
}
