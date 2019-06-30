package net.cloudburo.substrate.types.codec;

import net.cloudburo.substrate.types.common.Helper;
import net.cloudburo.substrate.types.common.ScaleBytes;
import net.cloudburo.substrate.types.common.SubstrateTypeException;
import org.apache.commons.codec.binary.Hex;

import java.math.BigInteger;

/**
 * Basic integers are encoded using a fixed-width little-endian (LE) format.
 * A generic unsigned integer codec. For Substrate all numbers are Little Endian encoded,
 * this handles the encoding and decoding of those numbers. Upon construction
 * the bitLength is provided and any additional use keeps the number to this
 * length.
 */
public class UInt extends AbstractInt {

    /* Use these constructors for Integers not encoded */
    public UInt(BigInteger bn) throws SubstrateTypeException {
        super(bn,new UIntBitLength(UIntBitLength.setFromInt(UIntBitLength.DEFAULT_UINT_BITS)));
    }

    public UInt(BigInteger bn, UIntBitLength bl) throws SubstrateTypeException {
        super(bn,bl);
    }

    /* Use these constructors for encoded Integers */
    public UInt(ScaleBytes data)throws SubstrateTypeException {
        super(data, new UIntBitLength(UIntBitLength.setFromInt(UIntBitLength.DEFAULT_UINT_BITS)));
    }

    public UInt(ScaleBytes data, UIntBitLength len) throws SubstrateTypeException {
        super(data,len);
    }

    public UInt(ScaleBytes data, String subType,UIntBitLength len) throws SubstrateTypeException {
        super(data,len,subType);
    }

    /**
     * Returns the Hex Representation of the Value
     */
    public String toHex() {
        return Hex.encodeHexString(this.toByteArray());
    }

    /**
     *
     * @return Type Name
     */
    public String toRawType() {
        return "u" + this.getUIntBitLength().bitLength;
    }

    /**
     * Returns the SCALE Code encoded fixed-width Integer.
     * Basic integers are encoded using a fixed-width little-endian (LE) format. E.g.
     *
     * unsigned 16-bit integer 42: 0x2a00
     * unsigned 32-bit integer 16777215: 0xffffff00
     */
    public ScaleBytes toU8Array() {
        return new ScaleBytes(Helper.bigIntegerToByteArrayWithSize(this,this.getUIntBitLength(),true));
    }
}
