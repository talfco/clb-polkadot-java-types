package net.cloudburo.polkadot.types.base;

import net.cloudburo.polkadot.types.TypeFactory;
import net.cloudburo.polkadot.types.codec.CompactU32;
import net.cloudburo.polkadot.types.codec.VecU32;
import net.cloudburo.polkadot.types.primitives.Bool;
import org.apache.commons.codec.binary.Hex;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Vector;

public class ScaleDecoderTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void scaleTypeBooleanTest() throws Exception {
        ScaleType obj = TypeFactory.createScaleTypeObject("bool", new ScaleBytes("0x00"));
        assert (obj instanceof Bool);
        Boolean bol = (Boolean) obj.decode(true);
        assert (!bol.booleanValue());
        obj = TypeFactory.createScaleTypeObject("bool", new ScaleBytes("0x01"));
        assert (obj instanceof Bool);
        bol = (Boolean) obj.decode(true);
        assert (bol.booleanValue());
        try {
            obj = TypeFactory.createScaleTypeObject("bool", new ScaleBytes("0x03"));
            bol = (Boolean) obj.decode(true);
            assert (false);
        } catch (InvalidScaleTypeValueException e) {
            assert (true);
        }
    }

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

    @Test
    public void scaleTypeAccountIdVector() throws Exception {
        // Address is 32 bytes, which results in hex format 64 characters, here 2x64 bytes
        ScaleType obj = TypeFactory.createScaleTypeObject("Vec<AccountId>", new ScaleBytes("0x0865d2273adeb04478658e183dc5edf41f1d86e42255442af62e72dbf1e6c0b97765d2273adeb04478658e183dc5edf41f1d86e42255442af62e72dbf1e6c0b977"));
        assert (obj instanceof VecU32);
        obj.decode(true);
        Vector<String> vec = (Vector<String>)obj.getValue();
        assert(vec.size()==2);
        assert(vec.get(0).equals("0x65d2273adeb04478658e183dc5edf41f1d86e42255442af62e72dbf1e6c0b977"));
        assert(vec.get(1).equals("0x65d2273adeb04478658e183dc5edf41f1d86e42255442af62e72dbf1e6c0b977"));
    }
}