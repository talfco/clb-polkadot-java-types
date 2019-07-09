package net.cloudburo.substrate.types.primitives;

import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.common.SubstrateTypeException;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class U64Test {

    @Test
    public void constructorTest() throws SubstrateTypeException {
        // 1224979098644840449
        // 8 Bytes
        U64 ui = new U64(1224979098644840449L);
        assert (ui.toU8Array().getDataAsHex().equals("0100010000000011"));
        U64 ui1 = new U64(new ScaleBytes(ui.toU8Array().getData()));
        assert (ui1.longValue() == ui1.longValue());
        // 4 Bytes
        ui = new U64(2147483647);
        assert (ui.toU8Array().getDataAsHex().equals("ffffff7f00000000"));
        ui1 = new U64(new ScaleBytes(ui.toU8Array().getData()));
        // 65537 - 3 Byte
        ui = new U64(65537);
        assert (ui.toU8Array().getDataAsHex().equals("0100010000000000"));
        ui1 = new U64(new ScaleBytes(ui.toU8Array().getData()));
        assert (ui1.intValue() == ui1.intValue());
        // 2 Byte
        ui = new U64(8192);
        assert (ui.toU8Array().getDataAsHex().equals("0020000000000000"));
        ui1 = new U64(new ScaleBytes(ui.toU8Array().getData()));
        assert (ui1.intValue() == ui1.intValue());
        // 1 Byte
        ui = new U64(256);
        assert (ui.toU8Array().getDataAsHex().equals("0001000000000000"));
        ui1 = new U64(new ScaleBytes(ui.toU8Array().getData()));
        assert (ui1.intValue() == ui1.intValue());
        // doesn't fit
        try {
            ui = new U64(new BigInteger(U64.MAX).add(BigInteger.valueOf(1)));
        } catch (
                SubstrateTypeException ex) {
            assert (ex.code == SubstrateTypeException.Code.UIntSizeTooSmall);
            return;
        }
        assert (false);
    }
}