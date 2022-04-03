package per.itachi.java.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.Base64;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import lombok.extern.slf4j.Slf4j;
import per.itachi.java.json.jackson.entity.Order;

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
}
