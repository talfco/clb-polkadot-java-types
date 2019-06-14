package net.cloudburo.polkadot.types.substrate;

import net.cloudburo.polkadot.types.base.ScaleBytes;
import net.cloudburo.polkadot.types.primitives.U32;

/**
 * An increasing number that represents a specific council proposal index in the system
 */
public class ProposalIndex extends U32 {
    public ProposalIndex(ScaleBytes data) {
        super(data);
    }
}
