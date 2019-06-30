package net.cloudburo.substrate.types.substrate;

import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.primitives.H256;

/**
 * An attested candidate
 */
public class AttestedCandidate extends H256 {
    public AttestedCandidate(ScaleBytes data) {
        super(data);
    }
}
