package net.cloudburo.polkadot.types.primitives;

import net.cloudburo.polkadot.types.common.SubstrateTypeException;
import net.cloudburo.polkadot.types.common.ScaleBytes;

/**
 * 	A wrapper around an AccountIndex, which is a shortened, variable-length encoding for an Account
 */
public class AccountIndex extends U32 {

    public AccountIndex(ScaleBytes data) throws SubstrateTypeException {
        super(data);
    }
}
