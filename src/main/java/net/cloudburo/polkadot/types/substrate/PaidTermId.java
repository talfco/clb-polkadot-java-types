package net.cloudburo.polkadot.types.substrate;

import net.cloudburo.polkadot.types.common.SubstrateTypeException;
import net.cloudburo.polkadot.types.common.ScaleBytes;
import net.cloudburo.polkadot.types.primitives.U64;

/**
 * TODO: Type not in NPM Ref List
 **/
public class PaidTermId extends U64 {

    public PaidTermId(ScaleBytes data) throws SubstrateTypeException {
        super(data);
    }
}
