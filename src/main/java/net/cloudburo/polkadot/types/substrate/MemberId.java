package net.cloudburo.polkadot.types.substrate;

import net.cloudburo.polkadot.types.base.ScaleBytes;
import net.cloudburo.polkadot.types.primitives.U64;

/**
 * TODO: Type not in NPM Ref List
 */
public class MemberId extends U64 {
    public MemberId(ScaleBytes data) {
        super(data);
    }
}
