package net.cloudburo.polkadot.types.substrate;

import net.cloudburo.polkadot.types.common.SubstrateTypeException;
import net.cloudburo.polkadot.types.common.ScaleBytes;
import net.cloudburo.polkadot.types.primitives.U32;

/**
 * 	An increasing number that represents a specific council proposal index in the system
 */
public class PropIndex extends U32 {
    public PropIndex(ScaleBytes data)throws SubstrateTypeException {
        super(data);
    }
}
