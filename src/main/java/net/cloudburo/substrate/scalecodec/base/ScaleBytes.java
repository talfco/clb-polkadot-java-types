package net.cloudburo.substrate.scalecodec.base;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.util.Arrays;

/**
 * ScaleByte Objects can be seen as the data container for an array of Bytes which must be processed by the Parity Codec
 * A Scale Byte Object stores the provided Byte Array in the data instance variable.
 */
public class ScaleBytes {

    private int offset = 0;
    private byte[] data;
    private int length;

    /**
     * Instance Creator
     * @param data The Byte Array to be processed
     */
    public  ScaleBytes(byte[] data) {
        this.data = data;
        this.length = data.length;
    }

    /**
     * Instance Creator
     * @param data The Byte Array to be processed, encoded as a hexi decimal string with a prefix '0x'
     * @throws ValueError
     * @throws DecoderException
     */
    public  ScaleBytes(String data) throws ValueError, DecoderException {
        if (data.startsWith("0x")) {
            this.data = Hex.decodeHex(data.substring(2));
        } else {
            throw new ValueError("Provided data is not in supported hexadecimal format: provided: '"+data+"' expected string start with '0x'");
        }
        this.length = this.data.length;
    }

    /**
     *
     * @return The initial data record (as Byte Array)
     */
    public byte[] getData() {
        return data;
    }

    /**
     *
     * @return The length of the data record
     */
    public int getLength() {
        return length;
    }

    /**
     *
     * @return The current index offset of the data Byte array. Calling the method 'getNextBytes' will increase the
     * offset.
     */
    public int getOffset() {
        return offset;
    }

    /**
     * Read a number of Bytes of the data record. Each call will increment the offset instance variable
     * @param numberOfBytes number of bytes to be returned
     * @return the requested byte range
     */
    public byte[] getNextBytes(int numberOfBytes) {
        byte[] res =Arrays.copyOfRange(this.data,this.offset,this.offset+numberOfBytes);
        this.offset += numberOfBytes;
        return res;
    }

    /**
     * Read the remaining Bytes of the data record up to its maximum length
     * @return
     */
    public byte[] getRemainingBytes() {
        byte[] res = Arrays.copyOfRange( this.data,this.offset,this.length);
        this.offset = this.length;
        return res;
    }

    /**
     * Returns the number of Bytes no fetched alreasy via 'getNextBytes'
     * @return
     */
    public int getRemainingLength() {
        return this.length - this.offset;
    }

    /**
     * Set the offset back to 0
     */
    public void reset() {
        this.offset = 0;
    }
}
