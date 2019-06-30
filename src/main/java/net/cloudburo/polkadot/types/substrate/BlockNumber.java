package net.cloudburo.polkadot.types.substrate;

import net.cloudburo.polkadot.types.common.SubstrateTypeException;
import net.cloudburo.polkadot.types.common.ScaleBytes;
import net.cloudburo.polkadot.types.primitives.U64;

/**
 * A representation of a Substrate BlockNumber, implemented as a [[U64]]
 */
public class BlockNumber extends U64 {
    public BlockNumber(ScaleBytes data) throws SubstrateTypeException {
        super(data);
    }
}
