package net.cloudburo.substrate.scalecodec.types;

import net.cloudburo.substrate.scalecodec.base.ScaleBytes;
import net.cloudburo.substrate.scalecodec.base.ScaleType;

public class ScaleTypeFactory {


    public static ScaleType createScaleTypeObject(String type, ScaleBytes bytes) {
        if (type.equals("bool")) {
            return new Bool(bytes);
        } else if (type.equals("Compact<u32>")) {
            return new U32(bytes);
        }
        return null;
    }
}
