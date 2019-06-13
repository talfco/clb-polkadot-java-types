package net.cloudburo.polkadot.types.primitives;

import net.cloudburo.polkadot.types.base.ScaleBytes;

public class Hash extends H256 {
    public Hash(ScaleBytes data) {
        super(data, Hash.class.getSimpleName());
    }
}
