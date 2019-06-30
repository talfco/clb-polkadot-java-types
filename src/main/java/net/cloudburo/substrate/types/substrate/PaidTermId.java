package net.cloudburo.substrate.types.substrate;

import net.cloudburo.substrate.types.common.SubstrateTypeException;
import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.primitives.U64;

/**
 * TODO: Type not in NPM Ref List
 **/
public class PaidTermId extends U64 {

    public PaidTermId(ScaleBytes data) throws SubstrateTypeException {
        super(data);
    }
}
