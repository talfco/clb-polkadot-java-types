package net.cloudburo.polkadot.types.primitives;

import net.cloudburo.polkadot.types.TypeFactory;
import net.cloudburo.polkadot.types.common.InvalidScaleTypeValueException;
import net.cloudburo.polkadot.types.common.ScaleBytes;
import net.cloudburo.polkadot.types.common.ScaleType;
import org.junit.Test;

public class BoolTest {

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

}