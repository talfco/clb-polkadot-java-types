package net.cloudburo.substrate.types.substrate;

import net.cloudburo.substrate.types.common.SubstrateTypeException;
import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.primitives.U32;

/**
 * Identifier for a deployed parachain implemented as a [[U32]]
 */
public class ParaId extends U32 {
    public ParaId(ScaleBytes data) throws SubstrateTypeException {
        super(data);
    }
}
