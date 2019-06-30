package net.cloudburo.polkadot.types.codec;

import net.cloudburo.polkadot.types.common.SubstrateTypeException;
import org.junit.Test;

import java.math.BigInteger;

public class UIntTest {


    @Test
    public void toNumberTest() throws SubstrateTypeException {
        assert(new UInt(BigInteger.valueOf(4567)).intValue()==4567);
    }

    @Test
    public void toLittleEndian() throws SubstrateTypeException {
        // Default bitlength  is set 64
        UInt ui = new UInt(BigInteger.valueOf(6));
        assert(ui.toU8().getDataAsHex().equals("0000000000000006"));
        //
        ui = new UInt(BigInteger.valueOf(6),new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L16));
        assert(ui.toU8().getDataAsHex().equals("0006"));
        // unsigned 16-bit integer 42: 0x2a00
        ui = new UInt(BigInteger.valueOf(42),new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L16));
        assert(ui.toU8().getDataAsHex().equals("002a"));
        // unsigned 32-bit integer 16777215: 0x00ffffff
        ui = new UInt(BigInteger.valueOf(16777215),new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L32));
        assert(ui.toU8().getDataAsHex().equals("00ffffff"));
    }

}