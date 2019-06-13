package net.cloudburo.polkadot.types.primitives;

import net.cloudburo.polkadot.types.base.ScaleBytes;

public class SessionKey extends H256 {
    public SessionKey(ScaleBytes data) {
        super(data, SessionKey.class.getSimpleName());
    }
}
