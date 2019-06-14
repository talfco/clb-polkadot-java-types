package net.cloudburo.polkadot.types.substrate;

import net.cloudburo.polkadot.types.base.ScaleBytes;
import net.cloudburo.polkadot.types.primitives.H256;

public class ContentId extends H256 {
    public ContentId(ScaleBytes data) {
        super(data);
    }
}
