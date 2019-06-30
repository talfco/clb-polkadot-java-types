package net.cloudburo.polkadot.types.common;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class HelperTest {

    @Test
    public void bigIntegerToByteArrayWithSize() {
        String str = Integer.toUnsignedString(1234567,16);
        BigInteger big = BigInteger.valueOf(1234567);
        //
        byte[] b = Helper.bigIntegerToByteArrayWithSize(big,2,false);
        assert(b.length == 2 && b[0] ==18 && b[1] == -42);
        b = Helper.bigIntegerToByteArrayWithSize(big,4,false);
        assert(b.length == 4 && b[0] ==18 && b[1] == -42 && b[2] == -121 &&  b[3] == 0);
        //byte[] b1 = Helper.leIntToByteArrayWithSize(23,4);
    }

    @Test
    public void leIntToByteArrayWithSize() {

    }
}