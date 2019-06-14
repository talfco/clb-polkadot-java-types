package net.cloudburo.polkadot.types.substrate;

import net.cloudburo.polkadot.types.base.ScaleBytes;
import net.cloudburo.polkadot.types.primitives.U64;

/**
 * SubscriptionId, implemented as a [[U64]]
 */
public class SubscriptionId extends U64 {

    public SubscriptionId(ScaleBytes data) {
        super(data);
    }

}
