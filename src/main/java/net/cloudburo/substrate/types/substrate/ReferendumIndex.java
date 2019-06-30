package net.cloudburo.substrate.types.substrate;

import net.cloudburo.substrate.types.common.SubstrateTypeException;
import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.primitives.U32;


/**
 *  An increasing number that represents a specific referendum in the system
 */
public class ReferendumIndex extends U32 {
    public ReferendumIndex(ScaleBytes data) throws SubstrateTypeException { super(data); }

}
