package net.cloudburo.polkadot.types.substrate;

import net.cloudburo.polkadot.types.common.SubstrateTypeException;
import net.cloudburo.polkadot.types.common.ScaleBytes;
import net.cloudburo.polkadot.types.primitives.U32;

/**
 * Parts per million (See also [[Perbill]])
 */
public class Permill extends U32 {
    public Permill(ScaleBytes data) throws SubstrateTypeException {
        super(data);
    }
}
