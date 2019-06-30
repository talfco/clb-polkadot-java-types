package net.cloudburo.polkadot.types.substrate;

import net.cloudburo.polkadot.types.common.ScaleBytes;
import net.cloudburo.polkadot.types.primitives.H256;

/**
 * An attested candidate
 */
public class AttestedCandidate extends H256 {
    public AttestedCandidate(ScaleBytes data) {
        super(data);
    }
}
