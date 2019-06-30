package net.cloudburo.substrate.types.primitives;

import net.cloudburo.substrate.types.common.ScaleBytes;

/**
 * A wrapper around an AccountId/PublicKey representation
 */
public class AccountId extends H256 {

    public AccountId(ScaleBytes data) {
        super(data);
    }
}
