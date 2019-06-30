package net.cloudburo.substrate.types.substrate;

import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.primitives.H256;

public class ContentId extends H256 {
    public ContentId(ScaleBytes data) {
        super(data);
    }
}
