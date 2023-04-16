package per.itachi.java.json.jsonpath.joint.json;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import per.itachi.java.json.jsonpath.joint.json.entity.NpmPackageScripts;

@Slf4j
public class JsonPathParserTest {

    @Test
    public void parse_npmPackageScripts() {
        JsonParser jsonParser = new JsonPathParser();
        try(InputStream fis = JsonPathParser.class.getResourceAsStream("/json/package.json")) {
            NpmPackageScripts bean = jsonParser.parse(fis, NpmPackageScripts.class);
            log.info("NpmPackageScripts={}", bean);
        }
        catch (IOException e) {
            log.error("Error occurred when loading json/package.json", e);
        }
    }

    @Test
    public void parseIntoMap_npmPackageScripts() {
        JsonParser jsonParser = new JsonPathParser();
        try(InputStream fis = JsonPathParser.class.getResourceAsStream("/json/package.json")) {
            Map<String, Object> map = jsonParser.parseIntoMap(fis);
            log.info("NpmPackageScripts={}", map);
        }
        catch (IOException e) {
            log.error("Error occurred when loading json/package.json", e);
        }
    }
}
