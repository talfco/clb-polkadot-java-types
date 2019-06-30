package net.cloudburo.substrate.types.codec;

import net.cloudburo.substrate.types.common.Helper;
import net.cloudburo.substrate.types.common.SubstrateTypeException;
import net.cloudburo.substrate.types.common.ScaleBytes;

import java.math.BigInteger;

public abstract class AbstractInt extends BigInteger {

    protected UIntBitLength bitLength;
    protected boolean isNegative;
    protected String subType;


    public static BigInteger decode(ScaleBytes data) {
        return Helper.toBigIntFromLittleEndian(data.getData());
    }

    public AbstractInt(BigInteger bi,UIntBitLength bl) throws SubstrateTypeException {
        super(bi.toByteArray());
        if (bi.toByteArray().length > bl.inBytes)
            throw new SubstrateTypeException( SubstrateTypeException.Code.UIntSizeTooSmall);
        this.bitLength =  bl;
        this.isNegative = bi.signum() == -1;
    }

    public AbstractInt(ScaleBytes data, UIntBitLength bl){
        super(AbstractInt.decode(data).toByteArray()) ;
        this.bitLength =  bl;
        this.isNegative = false;
    }

    public AbstractInt(ScaleBytes data,  UIntBitLength bl,String subType){
        this(data,bl);
        this.subType = subType;
    }


    /**
     *  The length of the value when encoded as a Uint8Array
     */
    public int getEncodedLength() { return this.bitLength.inBytes; }

    /**
     *  Returns the number of bits in the value
     */
    public UIntBitLength getUIntBitLength() { return this.bitLength; }


    /**
     * returns a hex string representation of the value
     */
    public abstract String toHex();

    /**
   * Returns the common runtime type name for this instance
   */
    public abstract String toRawType();

    /**
     * Encodes the value as a Uint8Array as per the SCALE specifications
     */
    public abstract ScaleBytes toU8Array();


}
