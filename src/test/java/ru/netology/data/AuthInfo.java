package ru.netology.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;

@Getter
@Setter
@Value
public class AuthInfo {
    String number;
    String month;
    String year;
    String name;
    String code;


}