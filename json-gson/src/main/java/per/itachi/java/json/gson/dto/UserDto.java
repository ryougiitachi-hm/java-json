package per.itachi.java.json.gson.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    @SerializedName("first_name")
    private String firstName;

    private int height;

    private byte[] data;
}
