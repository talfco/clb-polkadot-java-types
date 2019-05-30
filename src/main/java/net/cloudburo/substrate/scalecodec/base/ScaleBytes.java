package net.cloudburo.substrate.scalecodec.base;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.util.Arrays;

public class ScaleBytes {

    private int offset = 0;
    private byte[] data;
    private int length;

    public byte[] getData() {
        return data;
    }

    public int getLength() {
        return length;
    }

    public int getOffset() {
        return offset;
    }

    public  ScaleBytes(byte[] data) {
        this.data = data;
        this.length = data.length;
    }

    public  ScaleBytes(String data) throws ValueError, DecoderException {
        if (data.startsWith("0x")) {
            this.data = Hex.decodeHex(data.substring(2));
        } else {
            throw new ValueError("Provided data is not in supported format: provided: "+data);
        }
        this.length = this.data.length;
    }

    public byte[] getNextBytes(int length) {
        byte[] res =Arrays.copyOfRange(this.data,this.offset,length);
        this.offset += length;;
        return res;
    }

    public byte[] getRemainingBytes() {
        byte[] res = Arrays.copyOfRange( this.data,this.offset,this.length);
        this.offset = this.length;
        return res;
    }

    public int getRemainingLength() {
        return this.length - this.offset;
    }

    public void reset() {
        this.offset = 0;
    }
}
