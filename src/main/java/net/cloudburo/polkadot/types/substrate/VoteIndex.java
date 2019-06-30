package net.cloudburo.polkadot.types.substrate;

import net.cloudburo.polkadot.types.common.SubstrateTypeException;
import net.cloudburo.polkadot.types.common.ScaleBytes;
import net.cloudburo.polkadot.types.primitives.U32;

/**
 * Voting index, implemented as a [[U32]]
 */
public class VoteIndex extends U32 {
    public VoteIndex(ScaleBytes data) throws SubstrateTypeException {
        super(data);
    }
}
