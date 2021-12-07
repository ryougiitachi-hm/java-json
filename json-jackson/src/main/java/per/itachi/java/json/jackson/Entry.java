package per.itachi.java.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.Base64;

@Slf4j
public class Entry {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
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
}
