package net.cloudburo.substrate.types.substrate;

import net.cloudburo.substrate.types.common.SubstrateTypeException;
import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.primitives.U64;

/**
 * TODO: Type not in NPM Ref List
 */
public class MemberId extends U64 {
    public MemberId(ScaleBytes data) throws SubstrateTypeException {
        super(data);
    }
}
