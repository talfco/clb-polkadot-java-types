package net.cloudburo.substrate.types.primitives;

import net.cloudburo.substrate.types.common.SubstrateTypeException;
import net.cloudburo.substrate.types.common.ScaleBytes;

/**
 * A wrapper around seconds/timestamps. I
 * Internally the representation only has second precicion (aligning with Rust)
 */
public class Moment extends U32  {
    public Moment(ScaleBytes data) throws SubstrateTypeException {
        super(data);
    }
}
