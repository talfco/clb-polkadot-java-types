package net.cloudburo.substrate.types.primitives;

import net.cloudburo.substrate.types.common.SubstrateTypeException;
import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.codec.UInt;
import net.cloudburo.substrate.types.codec.UIntBitLength;

import java.math.BigInteger;

/**
 * A 16 bit unsigned integer
 */
public class U16 extends UInt {

    public static int MAX=65535;
    public static int MIN=0;

    public U16(BigInteger bn) throws SubstrateTypeException {
        super(bn,new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L16));
    }

    public U16(int bn) throws SubstrateTypeException {
        super(BigInteger.valueOf(bn),new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L16));
    }

    public U16(ScaleBytes data ) throws SubstrateTypeException {
        super(data,new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L16));
    }

    public U16(ScaleBytes data, String subType ) throws SubstrateTypeException {
        super(data,subType,new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L16));
    }


}
