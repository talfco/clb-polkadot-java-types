package net.cloudburo.substrate.scalecodec.base;

import net.cloudburo.substrate.scalecodec.types.Bool;
import net.cloudburo.substrate.scalecodec.types.ScaleTypeFactory;
import net.cloudburo.substrate.scalecodec.types.U32;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScaleDecoderTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void scaleTypeBooleanTest() throws Exception {
        ScaleType obj = ScaleTypeFactory.createScaleTypeObject("bool", new ScaleBytes("0x00"));
        assert(obj instanceof Bool);
        Boolean bol = (Boolean)obj.decode(true);
        assert(!bol.booleanValue());
        obj = ScaleTypeFactory.createScaleTypeObject("bool", new ScaleBytes("0x01"));
        assert(obj instanceof Bool);
        bol = (Boolean)obj.decode(true);
        assert(bol.booleanValue());
        try {
            obj = ScaleTypeFactory.createScaleTypeObject("bool", new ScaleBytes("0x03"));
            bol = (Boolean)obj.decode(true);
            assert(false);
        } catch (InvalidScaleTypeValueException e) {
            assert(true);
        }
    }

    @Test
    public void scaleTypeU8Test() throws  Exception {
        ScaleType obj = ScaleTypeFactory.createScaleTypeObject("Compact<u32>", new ScaleBytes("0x18"));
        assert(obj instanceof U32);
        Integer u32 = (Integer)obj.decode(true);
        assert(u32.intValue() == 6);
    }
}