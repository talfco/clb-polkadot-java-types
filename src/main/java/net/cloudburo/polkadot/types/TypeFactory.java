package net.cloudburo.polkadot.types;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import net.cloudburo.polkadot.types.common.Helper;
import net.cloudburo.polkadot.types.common.ScaleBytes;
import net.cloudburo.polkadot.types.common.ScaleDecoder;
import net.cloudburo.polkadot.types.common.ScaleType;
import net.cloudburo.polkadot.types.codec.CompactU32;
import net.cloudburo.polkadot.types.codec.VecU32;
import net.cloudburo.polkadot.types.primitives.AccountId;
import net.cloudburo.polkadot.types.primitives.Bool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TypeFactory {

    static final Logger logger = LoggerFactory.getLogger(TypeFactory.class);

    // Singleton
    private static Map<String, String> typeMapper = null;

    public static ScaleType createScaleTypeObject(String type, ScaleBytes bytes) {
        if (type.equals("bool")) {
            return new Bool(bytes);
        } else if (type.equals("Compact<u32>")) {
            return new CompactU32(bytes);
        } else if (type.equals(("Vec<AccountId>"))) {
            return new VecU32(bytes, "AccountId");
        } else if (type.equals(("AccountId"))) {
            return new AccountId(bytes);
        }
        return null;
    }

    public static ScaleDecoder getDecoderObject(String type, ScaleBytes data ) {
        logger.debug("Decoder Class for "+type);
        type = TypeFactory.convertType(type);
        if (type.equals("Compact<u32>")) {
            return new CompactU32(data);
        }
        return null;
    }


    private static String convertType(String name) {
        name = name.replace("T::", "");
        name = name.replace("<T>", "");
        name = name.replace("<T as Trait>::", "");
        try {
            Map <String, String> typeMapper = TypeFactory.loadTypeMapperFromFile("@","typeMapper.txt");
            String mappedType = typeMapper.get(name);
            if (mappedType != null)
                name = mappedType;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return name;
    }

    private static Map<String, String> loadTypeMapperFromFile(String delimiter, String fileName) throws URISyntaxException, IOException {
        if (typeMapper == null)
            typeMapper = Helper.loadHashMapFromFile(delimiter, fileName);
        return typeMapper;
    }

}
