package net.cloudburo.substrate.types.codec;

import net.cloudburo.substrate.types.TypeFactory;
import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.common.ScaleType;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import java.math.BigInteger;

public class CompactU32Test {

    @Test
    public void scaleTypeCompactU32Test_1Byte() throws Exception {
        ScaleType obj = TypeFactory.createScaleTypeObject("Compact<u32>", new ScaleBytes("0x18"));
        assert (obj instanceof CompactU32);
        BigInteger res = (BigInteger) obj.decode(true);
        assert (res.intValue() == 6);
        String res2 = Hex.encodeHexString((new CompactU32(new ScaleBytes("0x00"))).encode(6));
        assert("18".equals(res2));
    }

    @Test
    public void scaleTypeCompactU32Test_2Bytes() throws Exception {
        ScaleType obj = TypeFactory.createScaleTypeObject("Compact<u32>", new ScaleBytes("0xc15d"));
        assert (obj instanceof CompactU32);
        BigInteger res = (BigInteger) obj.decode(true);
        assert (res.intValue() == 6000);
        String res2 = Hex.encodeHexString((new CompactU32(new ScaleBytes("0x00"))).encode(6000));
        assert("c15d".equals(res2));
    }

    @Test
    public void scaleTypeCompactU32Test_4Bytes() throws Exception {
        ScaleType obj = TypeFactory.createScaleTypeObject("Compact<u32>", new ScaleBytes("0x02093d00"));
        assert (obj instanceof CompactU32);
        BigInteger res = (BigInteger) obj.decode(true);
        assert (res.intValue() == 1000000);
        String res2 = Hex.encodeHexString((new CompactU32(new ScaleBytes("0x00"))).encode(1000000));
        assert("02093d00".equals(res2));
    }

}