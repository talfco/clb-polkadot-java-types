package net.cloudburo.substrate.types.primitives;

import net.cloudburo.substrate.types.TypeFactory;
import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.common.ScaleType;
import net.cloudburo.substrate.types.codec.VecU32;
import org.junit.Test;

import java.util.Vector;

public class AccountIdTest {

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