package net.cloudburo.substrate.types.primitives;

import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.common.SubstrateTypeException;
import org.junit.Test;

import java.math.BigInteger;

public class U32Test {
    @Test
    public void constructorTest() throws SubstrateTypeException {
        // 4 Bytes
        U32 ui = new U32(2147483647);
        assert(ui.toU8Array().getDataAsHex().equals("ffffff7f"));
        U32 ui1 = new U32(new ScaleBytes(ui.toU8Array().getData()));
        // 65537 - 3 Byte
        ui = new U32(65537);
        assert(ui.toU8Array().getDataAsHex().equals("01000100"));
        ui1 = new U32(new ScaleBytes(ui.toU8Array().getData()));
        assert(ui1.intValue()==ui1.intValue());
        // 2 Byte
        ui = new U32(8192);
        assert(ui.toU8Array().getDataAsHex().equals("00200000"));
        ui1 = new U32(new ScaleBytes(ui.toU8Array().getData()));
        assert(ui1.intValue()==ui1.intValue());
        // 1 Byte
        ui = new U32(256);
        assert(ui.toU8Array().getDataAsHex().equals("00010000"));
        ui1 = new U32(new ScaleBytes(ui.toU8Array().getData()));
        assert(ui1.intValue()==ui1.intValue());
        // doesn't fit
        try {
            ui = new U32(BigInteger.valueOf(U32.MAX+1));
        } catch (SubstrateTypeException ex) {
            assert(ex.code == SubstrateTypeException.Code.UIntSizeTooSmall);
            return;
        }
        assert(false);
    }

}