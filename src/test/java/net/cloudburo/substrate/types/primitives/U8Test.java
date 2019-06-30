package net.cloudburo.substrate.types.primitives;

import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.common.SubstrateTypeException;
import org.junit.Test;

public class U8Test {

    @Test
    public void constructorTest() throws SubstrateTypeException {
        U8 ui = new U8(32);
        assert(ui.toU8Array().getDataAsHex().equals("20"));
        U8 ui1 = new U8(ui.toU8Array());
        assert(ui1.intValue()==ui.intValue());
        // Doesn't fit
        try {
            ui = new U8(256);
        } catch (SubstrateTypeException ex) {
            assert(ex.code == SubstrateTypeException.Code.UIntSizeTooSmall);
        }
    }

}