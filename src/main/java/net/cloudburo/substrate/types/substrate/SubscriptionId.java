package net.cloudburo.substrate.types.substrate;

import net.cloudburo.substrate.types.common.SubstrateTypeException;
import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.primitives.U64;

/**
 * SubscriptionId, implemented as a [[U64]]
 */
public class SubscriptionId extends U64 {

    public SubscriptionId(ScaleBytes data) throws SubstrateTypeException {
        super(data);
    }

}
