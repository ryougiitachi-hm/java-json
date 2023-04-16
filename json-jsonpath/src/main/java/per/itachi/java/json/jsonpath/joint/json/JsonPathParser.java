package per.itachi.java.json.jsonpath.joint.json;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import java.io.InputStream;
import java.util.Map;

public class JsonPathParser implements JsonParser{

    static final String JSON_PATH_NPM_PACKAGE_SCRIPTS = "$.scripts";

    @Override
    public <T> T parse(InputStream is, Class<T> beanClazz) {
        Configuration configuration = Configuration.defaultConfiguration();
//        configuration.jsonProvider().parse();
        DocumentContext context = JsonPath.parse(is);
        T bean = context.read(JSON_PATH_NPM_PACKAGE_SCRIPTS, beanClazz);
        return bean; // null, maybe some providers is required, such as jackson.
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> parseIntoMap(InputStream is) {
        Configuration configuration = Configuration.defaultConfiguration();
//        configuration.jsonProvider().parse();
        DocumentContext context = JsonPath.parse(is);
        Map<String, Object> map = context.read(JSON_PATH_NPM_PACKAGE_SCRIPTS, Map.class);
        return map;
    }
}
