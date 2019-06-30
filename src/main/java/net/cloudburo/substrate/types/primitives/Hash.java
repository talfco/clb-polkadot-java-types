package net.cloudburo.substrate.types.primitives;

import net.cloudburo.substrate.types.common.ScaleBytes;

/**
 * 	The default hash that is used accross the system. It is just a thin wrapper around [[H256]]
 */
public class Hash extends H256 {
    public Hash(ScaleBytes data) {
        super(data);
    }
}
