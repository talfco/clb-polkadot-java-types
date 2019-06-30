package net.cloudburo.substrate.types.primitives;

import net.cloudburo.substrate.types.common.SubstrateTypeException;
import net.cloudburo.substrate.types.common.ScaleBytes;

/**
 * 	A wrapper around an AccountIndex, which is a shortened, variable-length encoding for an Account
 */
public class AccountIndex extends U32 {

    public AccountIndex(ScaleBytes data) throws SubstrateTypeException {
        super(data);
    }
}
