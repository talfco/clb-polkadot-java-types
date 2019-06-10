package net.cloudburo.substrate.scalecodec.base;

import net.cloudburo.substrate.scalecodec.types.Bool;
import net.cloudburo.substrate.scalecodec.types.CompactU32;
import net.cloudburo.substrate.scalecodec.types.ScaleTypeFactory;
import org.apache.commons.codec.binary.Hex;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class ScaleDecoderTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void scaleTypeBooleanTest() throws Exception {
        ScaleType obj = ScaleTypeFactory.createScaleTypeObject("bool", new ScaleBytes("0x00"));
        assert (obj instanceof Bool);
        Boolean bol = (Boolean) obj.decode(true);
        assert (!bol.booleanValue());
        obj = ScaleTypeFactory.createScaleTypeObject("bool", new ScaleBytes("0x01"));
        assert (obj instanceof Bool);
        bol = (Boolean) obj.decode(true);
        assert (bol.booleanValue());
        try {
            obj = ScaleTypeFactory.createScaleTypeObject("bool", new ScaleBytes("0x03"));
            bol = (Boolean) obj.decode(true);
            assert (false);
        } catch (InvalidScaleTypeValueException e) {
            assert (true);
        }
    }

    @Test
    public void scaleTypeCompactU32Test_1Byte() throws Exception {
        ScaleType obj = ScaleTypeFactory.createScaleTypeObject("Compact<u32>", new ScaleBytes("0x18"));
        assert (obj instanceof CompactU32);
        BigInteger res = (BigInteger) obj.decode(true);
        assert (res.intValue() == 6);
        String res2 = Hex.encodeHexString((new CompactU32(new ScaleBytes("0x00"))).encode(6));
        assert("18".equals(res2));
    }

    @Test
    public void scaleTypeCompactU32Test_2Bytes() throws Exception {
        ScaleType obj = ScaleTypeFactory.createScaleTypeObject("Compact<u32>", new ScaleBytes("0xc15d"));
        assert (obj instanceof CompactU32);
        BigInteger res = (BigInteger) obj.decode(true);
        assert (res.intValue() == 6000);
        String res2 = Hex.encodeHexString((new CompactU32(new ScaleBytes("0x00"))).encode(6000));
        assert("c15d".equals(res2));
    }

    @Test
    public void scaleTypeCompactU32Test_4Bytes() throws Exception {
        ScaleType obj = ScaleTypeFactory.createScaleTypeObject("Compact<u32>", new ScaleBytes("0x02093d00"));
        assert (obj instanceof CompactU32);
        BigInteger res = (BigInteger) obj.decode(true);
        assert (res.intValue() == 1000000);
        String res2 = Hex.encodeHexString((new CompactU32(new ScaleBytes("0x00"))).encode(1000000));
        assert("02093d00".equals(res2));

    }
}