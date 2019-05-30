package net.cloudburo.substrate.scalecodec.base;

public abstract class ScaleType extends ScaleDecoder {
    Object metaData;
    public ScaleType(ScaleBytes data, String subType, Object metaData) {
        super(data, subType);
        this.metaData = metaData;
    }
}