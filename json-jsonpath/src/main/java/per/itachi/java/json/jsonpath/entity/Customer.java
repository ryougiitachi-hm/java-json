package per.itachi.java.json.jsonpath.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
public class Customer {

    private String name;

    private String idNumber;

    private String nationality;

    private LocalDate birthday;

    private Address address;

    private List<PhoneNumber> phoneNumber;
}
