package net.cloudburo.substrate.types.substrate;

import net.cloudburo.substrate.types.common.SubstrateTypeException;
import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.primitives.U64;

/**
 * A representation of a Substrate BlockNumber, implemented as a [[U64]]
 */
public class BlockNumber extends U64 {
    public BlockNumber(ScaleBytes data) throws SubstrateTypeException {
        super(data);
    }
}
