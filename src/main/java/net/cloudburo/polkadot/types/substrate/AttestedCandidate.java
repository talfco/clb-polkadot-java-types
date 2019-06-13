package net.cloudburo.polkadot.types.substrate;

import net.cloudburo.polkadot.types.base.ScaleBytes;
import net.cloudburo.polkadot.types.primitives.H256;

public class AttestedCandidate extends H256 {
    public AttestedCandidate(ScaleBytes data) {
        super(data, AttestedCandidate.class.getSimpleName());
    }
}
