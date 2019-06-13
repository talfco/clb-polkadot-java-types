package net.cloudburo.polkadot.types.primitives;

import net.cloudburo.polkadot.types.base.ScaleBytes;

public class AccountId extends H256 {

    public AccountId(ScaleBytes data) {
        super(data, AccountId.class.getSimpleName());
    }
}
