package ru.netology.data;

public class DataHelper {
    private DataHelper() {}

    public static AuthInfo getValidCard() {
        return new AuthInfo("4444 4444 4444 4441", "08", "27", "DANIL", "123");
    }

    public static AuthInfo getBlockCard() {
        return new AuthInfo("4444 4444 4444 4442", "08", "27", "DANIL", "123");
    }
}
