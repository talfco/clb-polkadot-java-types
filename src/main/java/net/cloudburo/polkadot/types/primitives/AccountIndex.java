package net.cloudburo.polkadot.types.primitives;

import net.cloudburo.polkadot.types.base.ScaleBytes;

/**
 * 	A wrapper around an AccountIndex, which is a shortened, variable-length encoding for an Account
 */
public class AccountIndex extends U32 {

    public AccountIndex(ScaleBytes data) {
        super(data);
    }
}
