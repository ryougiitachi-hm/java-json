package per.itachi.java.json.jsonpath.joint.json;

import java.io.InputStream;
import java.util.Map;

public interface JsonParser {

    <T> T parse(InputStream is, Class<T> beanClazz);

    Map<String, Object> parseIntoMap(InputStream is);
}
