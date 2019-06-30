package net.cloudburo.polkadot.types.common;

public class SubstrateTypeException extends Exception {

    public Code code;

    public enum Code {
        SizeException,
        InvalidScaleType,
        RemainingScaleBytesNotEmpty;
    }

    SubstrateTypeException(SubstrateTypeException.Code code, String msg) {
        super(msg);
        this.code = code;
    }
}
