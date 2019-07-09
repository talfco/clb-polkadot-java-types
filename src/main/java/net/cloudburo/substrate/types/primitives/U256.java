package net.cloudburo.substrate.types.primitives;

import net.cloudburo.substrate.types.common.SubstrateTypeException;
import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.codec.UInt;
import net.cloudburo.substrate.types.codec.UIntBitLength;

import java.math.BigInteger;

/**
 * A 256 bit unsigned integer
 */
public class U256 extends UInt {

    public static String MAX="115792089237316195423570985008687907853269984665640564039457584007913129639935";
    public static String MIN="0";

    public U256(BigInteger bn) throws SubstrateTypeException {
        super(bn,new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L256));
    }

    public U256(ScaleBytes data ) throws SubstrateTypeException {
        super(data,new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L256));
    }

    public U256(ScaleBytes data, String subType ) throws SubstrateTypeException {
        super(data,subType,new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L256));
    }
}
