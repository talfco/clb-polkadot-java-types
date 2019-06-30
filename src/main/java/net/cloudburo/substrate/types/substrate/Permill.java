package net.cloudburo.substrate.types.substrate;

import net.cloudburo.substrate.types.common.SubstrateTypeException;
import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.primitives.U32;

/**
 * Parts per million (See also [[Perbill]])
 */
public class Permill extends U32 {
    public Permill(ScaleBytes data) throws SubstrateTypeException {
        super(data);
    }
}
