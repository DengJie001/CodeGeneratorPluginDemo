package club.codemata.utils;

import club.codemata.exception.YamlException;
import org.apache.commons.lang3.StringUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;

public class YamlUtil {
    public static final String YAML_PATH = "src/main/resources/data.yaml";

    private static LinkedHashMap<String, Object> parseYaml() throws IOException {
        Yaml yaml = new Yaml();
        InputStream inputStream = new FileInputStream(YAML_PATH);
        LinkedHashMap<String, Object> linkedHashMap = (LinkedHashMap<String, Object>) yaml.load(inputStream);
        inputStream.close();
        return linkedHashMap;
    }

    /**
     * 根据key获取yaml中的参数
     * @param key 如果有层级关系，需要用小数点进行分割，例如：spring.application.datasource
     * @return
     * @throws YamlException 当key不存在时会抛出异常
     */
    public static String getString(String key) throws YamlException, IOException {
        Object result = null;
        LinkedHashMap<String, Object> linkedHashMap = parseYaml();
        LinkedHashMap<String, Object> temp = (LinkedHashMap<String, Object>) linkedHashMap.clone();
        if (StringUtils.isBlank(key)) {
            throw new YamlException("No such key in the file: " + YAML_PATH);
        }
        String[] keys = key.split("\\.");
        for (int i = 0; i < keys.length; ++i) {
            Object obj = temp.get(keys[i]);
            if (i < keys.length - 1) {
                temp = (LinkedHashMap<String, Object>) obj;
            } else if (obj == null) {
                throw new YamlException("The value corresponding to this key(" + keys[i] + ") is empty");
            } else {
                result = obj;
            }
        }
        return result.toString();
    }
}
