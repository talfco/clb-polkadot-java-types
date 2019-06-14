package net.cloudburo.polkadot.types.substrate;

import net.cloudburo.polkadot.types.base.ScaleBytes;
import net.cloudburo.polkadot.types.primitives.H256;

/**
 * Wrapper for a SessionKey. Same as an normal [[AuthorityId]], i.e. a wrapper around publicKey
 */
public class SessionKey extends H256 {
    public SessionKey(ScaleBytes data) {
        super(data);
    }
}
