package per.itachi.java.json.gson;

import com.google.gson.Gson;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import per.itachi.java.json.gson.dto.UserDto;

public class GsonEntry {

    public static void main(String[] args) {
        Gson gson = new Gson();
        UserDto userDto = new UserDto();
        userDto.setFirstName(UUID.randomUUID().toString());
        userDto.setHeight(ThreadLocalRandom.current().nextInt(200));

        String json = gson.toJson(userDto);
        System.out.printf("The json from gson is %s %n", json);
    }
}
