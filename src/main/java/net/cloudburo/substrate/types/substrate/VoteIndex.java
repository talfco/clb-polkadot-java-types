package net.cloudburo.substrate.types.substrate;

import net.cloudburo.substrate.types.common.SubstrateTypeException;
import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.primitives.U32;

/**
 * Voting index, implemented as a [[U32]]
 */
public class VoteIndex extends U32 {
    public VoteIndex(ScaleBytes data) throws SubstrateTypeException {
        super(data);
    }
}
