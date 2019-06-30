package net.cloudburo.substrate.types.primitives;

import net.cloudburo.substrate.types.common.InvalidScaleTypeValueException;
import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.common.ScaleType;

/**
 * Representation for a boolean value in the system
 */
public class Bool extends ScaleType {

    public Bool(ScaleBytes data ) {
        super(data, null);
    }

    public  Object  process() throws InvalidScaleTypeValueException {
        return Boolean.valueOf(this.getNextBool());
    }
}
