package net.cloudburo.polkadot.types.primitives;

import net.cloudburo.polkadot.types.common.SubstrateTypeException;
import net.cloudburo.polkadot.types.common.ScaleBytes;
import net.cloudburo.polkadot.types.codec.UInt;
import net.cloudburo.polkadot.types.codec.UIntBitLength;

import java.math.BigInteger;

/**
 * A 32-bit unsigned integer
 */
public class U32 extends UInt {

    public U32(BigInteger bn) throws SubstrateTypeException {
        super(bn,new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L32));
    }

    public U32(int bn) throws SubstrateTypeException {
        super(BigInteger.valueOf(bn),new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L32));
    }

    public U32(ScaleBytes data ) throws SubstrateTypeException {
        super(data,new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L32));
    }

    public U32(ScaleBytes data, String subType ) throws SubstrateTypeException {
        super(data,subType,new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L32));
    }
}
