package net.cloudburo.substrate.types.common;

import net.cloudburo.substrate.types.TypeFactory;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public abstract class ScaleDecoder {
    static boolean debug = false;
    static final Logger logger = LoggerFactory.getLogger(ScaleDecoder.class);

    protected String subType;
    protected ScaleBytes data;
    protected String hexValue;
    protected Object value;


    public ScaleDecoder(ScaleBytes data, String subType) {
        this.subType = subType;
        this.data = data;
        this.hexValue = "";
        this.value = null;
    }

    public ScaleDecoder(ScaleBytes data) {
        this.data = data;
        this.hexValue = "";
        this.value = null;
    }

    public String getSubType() {
        if (subType == null)
            return this.getClass().getSimpleName();
        else
            return subType;
    }

    public ScaleBytes getData() {
        return data;
    }

    public String getHexValue() {
        return hexValue;
    }

    public Object getValue() {
        return value;
    }

    public abstract Object  process() throws InvalidScaleTypeValueException, IOException, RemainingScaleBytesNotEmptyException;

    public ScaleType decodeType(String typeString) throws InvalidScaleTypeValueException, RemainingScaleBytesNotEmptyException, IOException {
        ScaleType obj = TypeFactory.createScaleTypeObject(typeString, this.data);
        obj.decode(false);
        return obj;
    }

    /**
     * Decode the scale endoded data (Scale Bytes)
     * @param checkRemaining
     * @return
     * @throws RemainingScaleBytesNotEmptyException
     * @throws InvalidScaleTypeValueException
     * @throws IOException
     */
    public Object decode(boolean checkRemaining) throws RemainingScaleBytesNotEmptyException, InvalidScaleTypeValueException, IOException {
        this.value = process();
        if (checkRemaining && this.data.getOffset() != this.data.getLength()) {
            throw new RemainingScaleBytesNotEmptyException("Current offset: "+this.data.getOffset()+" / length; "+this.data.getLength());
        }
        return this.value;
    }

    /**
     *
     * @param numberOfBytes Number of Bytes to be returned
     * @return the requested rang of Bytes.
     * Subsequent call will return the next bytes (offset state is internally kept)
     */
    public byte[] getNextBytes(int numberOfBytes) {
        byte[] data = this.data.getNextBytes(numberOfBytes);
        this.hexValue += Hex.encodeHexString(data);
        return data;
    }

    public byte[] getRemainingBytes() {
        byte[] data = this.data.getRemainingBytes();
        this.hexValue += Hex.encodeHexString(data);
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

}
