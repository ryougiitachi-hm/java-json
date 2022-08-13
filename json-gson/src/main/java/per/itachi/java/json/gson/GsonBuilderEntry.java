package per.itachi.java.json.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Modifier;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import per.itachi.java.json.gson.dto.UserDto;

public class GsonBuilderEntry {

    public static void main(String[] args) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder
                .excludeFieldsWithModifiers(Modifier.STATIC, Modifier.TRANSIENT)
                .serializeNulls()
                .generateNonExecutableJson()
                .setPrettyPrinting()
                .setVersion(1.1)
                .create();

        UserDto userDto = new UserDto();
        userDto.setFirstName(UUID.randomUUID().toString());
        userDto.setHeight(ThreadLocalRandom.current().nextInt());
        userDto.setData(new byte[10]); // serialized as an array of bytes, just like [0, 1, 2 ... ].

        String json = gson.toJson(userDto);
        System.out.printf("The json from gson is %s %n", json);
    }
}
