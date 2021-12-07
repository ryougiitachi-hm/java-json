package per.itachi.java.json.jsonpath;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jayway.jsonpath.JsonPath;
import lombok.extern.slf4j.Slf4j;
import per.itachi.java.json.jsonpath.entity.Address;
import per.itachi.java.json.jsonpath.entity.Customer;
import per.itachi.java.json.jsonpath.entity.PhoneNumber;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

/**
 * documentation: https://github.com/json-path/JsonPath
 * */
@Slf4j
public class Entry {

    public static void main(String[] args) {
        Customer customer = Customer.builder()
                .name("name")
                .birthday(LocalDate.now())
                .idNumber(UUID.randomUUID().toString())
                .nationality("nationality")
                .phoneNumber(Arrays.asList(
                        PhoneNumber.builder()
                                .type("1")
                                .phoneNumber(UUID.randomUUID().toString())
                                .build(),
                        PhoneNumber.builder()
                                .type("1")
                                .phoneNumber(UUID.randomUUID().toString())
                                .build()
                ))
                .address(Address.builder()
                        .province("province")
                        .city("city")
                        .district("district")
                        .build())
                .build();
        ObjectMapper objectMapper = createObjectMapper();
        try {
            String strJson = objectMapper.writeValueAsString(customer);
            log.info("json is {}.", strJson);
            // java.lang.ClassCastException: java.util.LinkedHashMap
//            PhoneNumber phoneNumber = JsonPath.read(strJson, "$.phoneNumber[0]");
//            Address address = JsonPath.read(strJson, "$.address");
//            log.info("$.phoneNumbers[0]={}. ", phoneNumber);
//            log.info("$.address={}. ", address);
            String strPhoneNumber = JsonPath.read(strJson, "$.phoneNumber[0].phoneNumber");
            log.info("$.phoneNumber[0].phoneNumber={}. ", strPhoneNumber);
            String strProvince = JsonPath.read(strJson, "$.address.province");
            log.info("$.address.province={}. ", strProvince);
            PhoneNumber phoneNumber = JsonPath.parse(strJson)
                    .read( "$.phoneNumber[0]", PhoneNumber.class);
            log.info("$.phoneNumbers[0]={}. ", phoneNumber);
        }
        catch (JsonProcessingException e) {
            log.error("", e);
        }
    }

    private static ObjectMapper createObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.registerModule(new Jdk8Module());
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        return objectMapper;
    }
}
