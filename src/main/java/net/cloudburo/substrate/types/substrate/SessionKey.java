package net.cloudburo.substrate.types.substrate;

import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.primitives.H256;

/**
 * Wrapper for a SessionKey. Same as an normal [[AuthorityId]], i.e. a wrapper around publicKey
 */
public class SessionKey extends H256 {
    public SessionKey(ScaleBytes data) {
        super(data);
    }
}
