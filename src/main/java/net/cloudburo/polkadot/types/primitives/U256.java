package net.cloudburo.polkadot.types.primitives;

import net.cloudburo.polkadot.types.common.SubstrateTypeException;
import net.cloudburo.polkadot.types.common.ScaleBytes;
import net.cloudburo.polkadot.types.codec.UInt;
import net.cloudburo.polkadot.types.codec.UIntBitLength;

import java.math.BigInteger;

/**
 * A 256 bit unsigned integer
 */
public class U256 extends UInt {

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
