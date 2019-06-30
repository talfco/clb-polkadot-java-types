package net.cloudburo.polkadot.types.primitives;

import net.cloudburo.polkadot.types.common.ScaleBytes;

/**
 * A wrapper around an AccountId/PublicKey representation
 */
public class AccountId extends H256 {

    public AccountId(ScaleBytes data) {
        super(data);
    }
}
