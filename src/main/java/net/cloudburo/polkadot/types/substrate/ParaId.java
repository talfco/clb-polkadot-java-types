package net.cloudburo.polkadot.types.substrate;

import net.cloudburo.polkadot.types.common.SubstrateTypeException;
import net.cloudburo.polkadot.types.common.ScaleBytes;
import net.cloudburo.polkadot.types.primitives.U32;

/**
 * Identifier for a deployed parachain implemented as a [[U32]]
 */
public class ParaId extends U32 {
    public ParaId(ScaleBytes data) throws SubstrateTypeException {
        super(data);
    }
}
