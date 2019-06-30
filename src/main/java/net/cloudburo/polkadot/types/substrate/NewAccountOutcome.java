package net.cloudburo.polkadot.types.substrate;

import net.cloudburo.polkadot.types.common.SubstrateTypeException;
import net.cloudburo.polkadot.types.common.ScaleBytes;
import net.cloudburo.polkadot.types.primitives.U32;

/**
 * Enum to track the outcome for creation of an [[AccountId]]
 */
public class NewAccountOutcome extends U32 {
    public NewAccountOutcome(ScaleBytes data) throws SubstrateTypeException {
        super(data);
    }
}
