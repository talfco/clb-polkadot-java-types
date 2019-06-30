package net.cloudburo.polkadot.types.codec;

import net.cloudburo.polkadot.types.common.Helper;
import net.cloudburo.polkadot.types.common.ScaleBytes;

import java.io.IOException;
import java.math.BigInteger;

/** The class works for unsigned numbers up to 4 bytes, which represents the data type int */
public class CompactU32 extends Compact {

    public CompactU32(ScaleBytes data) {
        super(data,"Compact<u32>");
    }

    public Object process() throws IOException {
        this.processCompactBytes();
        if (this.getCompactLength() <= 4) {
            //BigInteger val = new BigInteger(this.getCompactBytes());
            BigInteger val = Helper.toBigIntFromLittleEndian(this.getCompactBytes());
            int val1=  Integer.divideUnsigned(val.intValue(),4);
            return BigInteger.valueOf(val1);
        } else {
            return new BigInteger(this.getCompactBytes()).intValue();
        }
    }

    public byte[] encode(int value) {
        if (Integer.compareUnsigned(value, 63)<=0) {  // 0b00111111
            int a = value << 2;
            return Helper.leIntToByteArrayWithSize(a,1);
        } else if (Integer.compareUnsigned(value, 16383)<=0) {  // 0b0011111111111111
            int b = 1;
            int a = (value << 2)| b;
            return Helper.leIntToByteArrayWithSize(a,2);
        } else if (Integer.compareUnsigned(value, 1073741823)<=0) { // 0b00111111111111111111111111111111
            int b = 2;
            int a = (value << 2)| b;
            return Helper.leIntToByteArrayWithSize(a,4);
        } else {
            return null;
        }
    }

}
