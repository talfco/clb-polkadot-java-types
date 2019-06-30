package net.cloudburo.substrate.types.common;

/*
** A Scale Type holds the byte data of the object and the logic to convert the data to
* java type or object via the process method.
 */
public abstract class ScaleType extends ScaleDecoder {

    public ScaleType(ScaleBytes data) {
        super(data);

    }
    public ScaleType(ScaleBytes data, String subType) {
        super(data, subType);
    }

}