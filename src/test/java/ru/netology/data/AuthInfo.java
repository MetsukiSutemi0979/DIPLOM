package ru.netology.data;

import lombok.Value;

@Value
public class AuthInfo {
    String number;
    String month;
    String year;
    String name;
    String code;


}