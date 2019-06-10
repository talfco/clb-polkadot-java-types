package net.cloudburo.substrate.scalecodec.base;

/*
** A Scale Type holds the byte data of the object and the logic to convert the data to
* java type or object via the process method.
 */
public abstract class ScaleType extends ScaleDecoder {
    Object metaData;
    public ScaleType(ScaleBytes data, String subType, Object metaData) {
        super(data, subType);
        this.metaData = metaData;
    }
}