package net.cloudburo.substrate.scalecodec.types;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import net.cloudburo.substrate.scalecodec.base.ScaleDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.cloudburo.substrate.scalecodec.base.Helper;
import net.cloudburo.substrate.scalecodec.base.ScaleBytes;
import net.cloudburo.substrate.scalecodec.base.ScaleType;


public class ScaleTypeFactory {

    static final Logger logger = LoggerFactory.getLogger(ScaleTypeFactory.class);

    // Singleton
    private static Map<String, String> typeMapper = null;

    public static ScaleType createScaleTypeObject(String type, ScaleBytes bytes) {
        if (type.equals("bool")) {
            return new Bool(bytes);
        } else if (type.equals("Compact<u32>")) {
            return new CompactU32(bytes);
        }
        return null;
    }

    public static ScaleDecoder getDecoderObject(String type, ScaleBytes data ) {
        logger.debug("Decoder Class for "+type);
        type = ScaleTypeFactory.convertType(type);
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
            Map <String, String> typeMapper = ScaleTypeFactory.loadTypeMapperFromFile("@","typeMapper.txt");
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
