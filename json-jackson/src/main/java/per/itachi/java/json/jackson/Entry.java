package per.itachi.java.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.Base64;

@Slf4j
public class Entry {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
//        objectMapper.registerModule(new Jdk8Module());
//        testBytes(objectMapper);
        testGetterSetter(objectMapper);

    }

    private static void testBytes(ObjectMapper objectMapper) {
//        testBase64(objectMapper);
        testBytes(objectMapper);

    }

    private static void testBase64(ObjectMapper objectMapper) {
        byte[] bytesDocumentData = new byte[10];
        try {
            byte[] bytesResult = objectMapper.writeValueAsBytes(bytesDocumentData);
            String strResult = new String(bytesResult);
            log.info("strResult is {}", strResult);
            strResult = Base64.getEncoder().encodeToString(bytesDocumentData);
            log.info("strResult is {}", strResult);
        }
        catch (JsonProcessingException e) {
            log.error("", e);
        }
    }

    private static void testGetterSetter(ObjectMapper objectMapper) {
        Order order = new Order(ThreadLocalRandom.current().nextLong(100000L),
                UUID.randomUUID().toString());
        try {
            String json = objectMapper.writeValueAsString(order);
            log.info("The result of json is {}. ", json);
            order = objectMapper.readValue(json, Order.class);
            log.info("The result of Object is {}. ", order);
        }
        catch (JsonProcessingException e) {
            log.error("", e);
        }
    }

    private static void testBytes(ObjectMapper objectMapper) {
        Map<String, Object> map = new HashMap<>();
        map.put("content", new byte[10]);
        map.put("code", 200);
        try {
            // byte[] will be converted as base64 string automatically.
            String strJson = objectMapper.writeValueAsString(map);
            log.info("strJson is {}", strJson);
        }
        catch (JsonProcessingException e) {
            log.error("", e);
        }
    }
}
