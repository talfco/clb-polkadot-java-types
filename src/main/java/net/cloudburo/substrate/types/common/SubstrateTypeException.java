package net.cloudburo.substrate.types.common;

public class SubstrateTypeException extends Exception {

    public Code code;

    public enum Code {
        SizeException,
        UIntSizeTooSmall,
        InvalidScaleType,
        RemainingScaleBytesNotEmpty;
    }

    public SubstrateTypeException(SubstrateTypeException.Code code, String msg) {
        super(msg+": "+code.name());
        this.code = code;
    }

    public SubstrateTypeException(SubstrateTypeException.Code code) {
        super("Substrate Type Exception Code: "+code.name());
        this.code = code;
    }
}
