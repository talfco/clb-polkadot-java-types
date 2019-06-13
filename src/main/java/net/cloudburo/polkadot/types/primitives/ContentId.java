package net.cloudburo.polkadot.types.primitives;

import net.cloudburo.polkadot.types.base.ScaleBytes;

public class ContentId extends H256 {
    public ContentId(ScaleBytes data) {
        super(data, ContentId.class.getSimpleName());
    }
}
