package net.cloudburo.substrate.types.primitives;

import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.common.SubstrateTypeException;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class U128Test {


    @Test
    public void constructorTest() throws SubstrateTypeException {
        // 16 Bytes
        U128 ui = new U128(new BigInteger("170141183460469231731687303715884105727"));
        assert (ui.toU8Array().getDataAsHex().equals("ffffffffffffffffffffffffffffff7f"));
        U128 ui1 = new U128(new ScaleBytes(ui.toU8Array().getData()));
        assert (ui1.equals(ui1));
        // 8 Bytes
        ui = new U128(new BigInteger("1224979098644840449"));
        assert (ui.toU8Array().getDataAsHex().equals("01000100000000110000000000000000"));
        ui1 = new U128(new ScaleBytes(ui.toU8Array().getData()));
        assert (ui1.longValue() == ui1.longValue());
        // 4 Bytes
        ui = new U128(new BigInteger("147483647"));
        assert (ui.toU8Array().getDataAsHex().equals("ff6bca08000000000000000000000000"));
        ui1 = new U128(new ScaleBytes(ui.toU8Array().getData()));
        // 65537 - 3 Byte
        ui = new U128(new BigInteger("65537"));
        assert (ui.toU8Array().getDataAsHex().equals("01000100000000000000000000000000"));
        ui1 = new U128(new ScaleBytes(ui.toU8Array().getData()));
        assert (ui1.intValue() == ui1.intValue());
        // 2 Byte
        ui = new U128(new BigInteger("8192"));
        assert (ui.toU8Array().getDataAsHex().equals("00200000000000000000000000000000"));
        ui1 = new U128(new ScaleBytes(ui.toU8Array().getData()));
        assert (ui1.intValue() == ui1.intValue());
        // 1 Byte
        ui = new U128(new BigInteger("256"));
        assert (ui.toU8Array().getDataAsHex().equals("00010000000000000000000000000000"));
        ui1 = new U128(new ScaleBytes(ui.toU8Array().getData()));
        assert (ui1.intValue() == ui1.intValue());
        // doesn't fit
            try {
            ui = new U128(new BigInteger(U128.MAX).add(BigInteger.valueOf(1)));
        } catch (
        SubstrateTypeException ex) {
            assert (ex.code == SubstrateTypeException.Code.UIntSizeTooSmall);
            return;
        }
        assert (false);
    }

}