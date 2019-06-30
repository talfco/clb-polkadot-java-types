package net.cloudburo.substrate.types.primitives;

import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.common.SubstrateTypeException;
import org.junit.Test;

public class U16Test {

    @Test
    public void constructorTest() throws SubstrateTypeException {
        U16 ui = new U16(8192);
        assert(ui.toU8Array().getDataAsHex().equals("0020"));
        U16 ui1 = new U16(ui.toU8Array());
        assert(ui1.intValue()==ui.intValue());
        // doesn't fit in short
        try {
            ui = new U16(65536);
        } catch (SubstrateTypeException ex) {
            assert(ex.code == SubstrateTypeException.Code.UIntSizeTooSmall);
            return;
        }
        assert(false);
    }

}