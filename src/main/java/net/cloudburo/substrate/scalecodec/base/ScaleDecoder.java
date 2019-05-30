package net.cloudburo.substrate.scalecodec.base;

import org.apache.commons.codec.binary.Hex;

import java.io.IOException;
import java.math.BigInteger;

public abstract class ScaleDecoder {
    static boolean debug = false;

    String subType;
    ScaleBytes data;
    String rawValue;
    Object value;


    public ScaleDecoder(ScaleBytes data, String subType) {
        this.subType = subType;
        this.data = data;
        this.rawValue = "";
        this.value = null;
    }

    public abstract Object  process() throws InvalidScaleTypeValueException, IOException;

    public Object decode(boolean checkRemaining) throws RemainingScaleBytesNotEmptyException, InvalidScaleTypeValueException, IOException {
        this.value = process();
        if (checkRemaining && this.data.getOffset() != this.data.getLength()) {
            throw new RemainingScaleBytesNotEmptyException("Current offset: "+this.data.getOffset()+" / length; "+this.data.getLength());
        }
        return this.value;
    }

    public byte[] getNextBytes(int length) {
        byte[] data = this.data.getNextBytes(length);
        this.rawValue += Hex.encodeHexString(data);
        return data;
    }

    public int getNextU8() {
        return Helper.toBigIntFromLittleEndian(getNextBytes(1)).intValue();

    }

    public boolean getNextBool()throws InvalidScaleTypeValueException {
        byte[] data = this.getNextBytes(1);
        byte res = data[0];
        if (res == 0 || res ==1) {
            return res == 1;
        } else {
            throw new InvalidScaleTypeValueException("Invalid value for datatype 'boolean':"+data);
        }
    }

    public byte[] getRemainingBytes() {
        byte[] data = this.data.getRemainingBytes();
        this.rawValue += Hex.encodeHexString(data);
        return data;
    }

}
