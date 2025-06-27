package ru.netology.data;

import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {
    private static Faker faker = new Faker(new Locale("en"));

    private DataHelper() {}

    public static String getApprovedCardNumber() {
        return "4444 4444 4444 4441";
    }

    public static String getDeclinedCardNumber() {
        return "4444 4444 4444 4442";
    }

    public static String getInvalidCardNumber() {
        return "4444 4444 4444 4443";
    }

    public static String getCurrentMonth() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getNextYear() {
        return LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getPreviousYear() {
        return LocalDate.now().minusYears(1).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getValidName() {
        return faker.name().firstName().toUpperCase() + " " + faker.name().lastName().toUpperCase();
    }

    public static String getValidCvc() {
        return faker.number().digits(3);
    }

    public static AuthInfo getInvalidCard() {
        return new AuthInfo(
                getInvalidCardNumber(),
                getCurrentMonth(),
                getNextYear(),
                getValidName(),
                getValidCvc()
        );
    }

    public static AuthInfo getApprovedCard() {
        return new AuthInfo(
                getApprovedCardNumber(),
                getCurrentMonth(),
                getNextYear(),
                getValidName(),
                getValidCvc()
        );
    }

    public static AuthInfo getDeclinedCard() {
        return new AuthInfo(
                getDeclinedCardNumber(),
                getCurrentMonth(),
                getNextYear(),
                getValidName(),
                getValidCvc()
        );
    }

    public static AuthInfo getCardWithExpiredYear() {
        return new AuthInfo(
                getApprovedCardNumber(),
                getCurrentMonth(),
                getPreviousYear(),  // Используем просроченный год
                getValidName(),
                getValidCvc()
        );
    }
}