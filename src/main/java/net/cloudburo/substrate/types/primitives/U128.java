package net.cloudburo.substrate.types.primitives;

import net.cloudburo.substrate.types.common.SubstrateTypeException;
import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.codec.UInt;
import net.cloudburo.substrate.types.codec.UIntBitLength;

import java.math.BigInteger;


/**
 * A 128 bit unsigned integer
 */
public class U128 extends UInt {

    public static String MAX ="340282366920938463463374607431768211455";
    public static String MIN = "0";


    public U128(BigInteger bn) throws SubstrateTypeException {
        super(bn,new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L128));
    }

    public U128(ScaleBytes data ) throws SubstrateTypeException {
        super(data,new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L128));
    }

    public U128(ScaleBytes data, String subType ) throws SubstrateTypeException {
        super(data,subType,new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L128));
    }

}
