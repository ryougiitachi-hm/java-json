package per.itachi.java.json.jsonpath.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Address {

    private String province;

    private String city;

    private String district;
}
