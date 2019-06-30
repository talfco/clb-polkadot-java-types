package net.cloudburo.substrate.types.substrate;

import net.cloudburo.substrate.types.common.SubstrateTypeException;
import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.primitives.U32;

/**
 * Enum to track the outcome for creation of an [[AccountId]]
 */
public class NewAccountOutcome extends U32 {
    public NewAccountOutcome(ScaleBytes data) throws SubstrateTypeException {
        super(data);
    }
}
