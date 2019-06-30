package net.cloudburo.polkadot.types.substrate;

import net.cloudburo.polkadot.types.common.SubstrateTypeException;
import net.cloudburo.polkadot.types.common.ScaleBytes;
import net.cloudburo.polkadot.types.primitives.U32;


/**
 *  An increasing number that represents a specific referendum in the system
 */
public class ReferendumIndex extends U32 {
    public ReferendumIndex(ScaleBytes data) throws SubstrateTypeException { super(data); }

}
