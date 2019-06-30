package net.cloudburo.substrate.types.common;

import net.cloudburo.substrate.types.codec.UIntBitLength;
import org.junit.Test;

import java.math.BigInteger;

public class HelperTest {

    @Test
    public void bigIntegerToByteArrayWithSize() throws SubstrateTypeException {
        String str = Integer.toUnsignedString(1234567,16);
        BigInteger big = BigInteger.valueOf(1234567);
        //
        byte[] b = Helper.bigIntegerToByteArrayWithSize(big, new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L16),false);
        assert(b.length == 2 && b[0] ==18 && b[1] == -42);
        b = Helper.bigIntegerToByteArrayWithSize(big,new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L32),false);
        assert(b.length == 4 && b[0] ==18 && b[1] == -42 && b[2] == -121 &&  b[3] == 0);
        //byte[] b1 = Helper.leIntToByteArrayWithSize(23,4);
    }

    @Test
    public void leIntToByteArrayWithSize() {

    }
}