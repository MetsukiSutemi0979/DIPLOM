package ru.netology.data;

import ru.netology.data.AuthInfo;
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

    public static String getShortCardNumber() {
        return "4444 4444 4444 444";
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

    public static String getFutureYear(int years) {
        return LocalDate.now().plusYears(years).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getValidName() {
        return faker.name().firstName().toUpperCase() + " " + faker.name().lastName().toUpperCase();
    }

    public static String getCyrillicName() {
        Faker ruFaker = new Faker(new Locale("ru"));
        return ruFaker.name().firstName().toUpperCase() + " " + ruFaker.name().lastName().toUpperCase();
    }

    public static String getNumericName() {
        return faker.numerify("##########");
    }

    public static String getSpecialCharsName() {
        return "!@#$%^&*()_+";
    }

    public static String getValidCvc() {
        return faker.number().digits(3);
    }

    public static String getInvalidCvc() {
        return faker.number().digits(4);
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

    public static AuthInfo getInvalidCard() {
        return new AuthInfo(
                getInvalidCardNumber(),
                getCurrentMonth(),
                getNextYear(),
                getValidName(),
                getValidCvc()
        );
    }

    public static AuthInfo getEmptyCard() {
        return new AuthInfo(
                "",
                "",
                "",
                "",
                ""
        );
    }

    public static AuthInfo getCardWithoutNumber() {
        return new AuthInfo(
                "",
                getCurrentMonth(),
                getNextYear(),
                getValidName(),
                getValidCvc()
        );
    }

    public static AuthInfo getCardWithoutMonth() {
        return new AuthInfo(
                getApprovedCardNumber(),
                "",
                getNextYear(),
                getValidName(),
                getValidCvc()
        );
    }

    public static AuthInfo getCardWithoutYear() {
        return new AuthInfo(
                getApprovedCardNumber(),
                getCurrentMonth(),
                "",
                getValidName(),
                getValidCvc()
        );
    }

    public static AuthInfo getCardWithoutName() {
        return new AuthInfo(
                getApprovedCardNumber(),
                getCurrentMonth(),
                getNextYear(),
                "",
                getValidCvc()
        );
    }

    public static AuthInfo getCardWithoutCvc() {
        return new AuthInfo(
                getApprovedCardNumber(),
                getCurrentMonth(),
                getNextYear(),
                getValidName(),
                ""
        );
    }

    public static AuthInfo getCardWithInvalidMonth() {
        return new AuthInfo(
                getApprovedCardNumber(),
                "13",
                getNextYear(),
                getValidName(),
                getValidCvc()
        );
    }

    public static AuthInfo getCardWithZeroMonth() {
        return new AuthInfo(
                getApprovedCardNumber(),
                "00",
                getNextYear(),
                getValidName(),
                getValidCvc()
        );
    }

    public static AuthInfo getCardWithSingleDigitMonth() {
        return new AuthInfo(
                getApprovedCardNumber(),
                "5",
                getNextYear(),
                getValidName(),
                getValidCvc()
        );
    }

    public static AuthInfo getCardWithExpiredYear() {
        return new AuthInfo(
                getApprovedCardNumber(),
                getCurrentMonth(),
                getPreviousYear(),
                getValidName(),
                getValidCvc()
        );
    }

    public static AuthInfo getCardWithDistantFutureYear() {
        return new AuthInfo(
                getApprovedCardNumber(),
                getCurrentMonth(),
                getFutureYear(10),
                getValidName(),
                getValidCvc()
        );
    }

    public static AuthInfo getCardWithCyrillicName() {
        return new AuthInfo(
                getApprovedCardNumber(),
                getCurrentMonth(),
                getNextYear(),
                getCyrillicName(),
                getValidCvc()
        );
    }

    public static AuthInfo getCardWithNumericName() {
        return new AuthInfo(
                getApprovedCardNumber(),
                getCurrentMonth(),
                getNextYear(),
                getNumericName(),
                getValidCvc()
        );
    }

    public static AuthInfo getCardWithSpecialCharsName() {
        return new AuthInfo(
                getApprovedCardNumber(),
                getCurrentMonth(),
                getNextYear(),
                getSpecialCharsName(),
                getValidCvc()
        );
    }

    public static AuthInfo getCardWithLongCvc() {
        return new AuthInfo(
                getApprovedCardNumber(),
                getCurrentMonth(),
                getNextYear(),
                getValidName(),
                getInvalidCvc()
        );
    }

    public static AuthInfo getCardWithShortNumber() {
        return new AuthInfo(
                getShortCardNumber(),
                getCurrentMonth(),
                getNextYear(),
                getValidName(),
                getValidCvc()
        );
    }

    public static AuthInfo getCardWithLettersInNumber() {
        return new AuthInfo(
                "ABCD EFGH IJKL MNOP",
                getCurrentMonth(),
                getNextYear(),
                getValidName(),
                getValidCvc()
        );
    }

    public static AuthInfo getCardWithLettersInMonth() {
        return new AuthInfo(
                getApprovedCardNumber(),
                "AB",
                getNextYear(),
                getValidName(),
                getValidCvc()
        );
    }

    public static AuthInfo getCardWithLettersInYear() {
        return new AuthInfo(
                getApprovedCardNumber(),
                getCurrentMonth(),
                "AB",
                getValidName(),
                getValidCvc()
        );
    }

    public static AuthInfo getCardWithLettersInCvc() {
        return new AuthInfo(
                getApprovedCardNumber(),
                getCurrentMonth(),
                getNextYear(),
                getValidName(),
                "ABC"
        );
    }

    public static AuthInfo getCardWithSpecialSymbolsInYear() {
        return new AuthInfo(
                getApprovedCardNumber(),
                getCurrentMonth(),
                "!@",
                getValidName(),
                getValidCvc()
        );
    }

    public static AuthInfo getCardWithTextInMonth() {
        return new AuthInfo(
                getApprovedCardNumber(),
                "Май",
                getNextYear(),
                getValidName(),
                getValidCvc()
        );
    }

    public static AuthInfo getCardWithTextInYear() {
        return new AuthInfo(
                getApprovedCardNumber(),
                getCurrentMonth(),
                "Четыре",
                getValidName(),
                getValidCvc()
        );
    }

    public static AuthInfo getCardWithTextInCvv() {
        return new AuthInfo(
                getApprovedCardNumber(),
                getCurrentMonth(),
                getNextYear(),
                getValidName(),
                "Триста"
        );
    }


    public static AuthInfo getCardWithSpecialSymbolsInMonth() {
        return new AuthInfo(
                getApprovedCardNumber(),
                "!@",
                getNextYear(),
                getValidName(),
                getValidCvc()
        );
    }

    public static AuthInfo getCardWithSpecialSymbolsInName() {
        return new AuthInfo(
                getApprovedCardNumber(),
                getCurrentMonth(),
                getNextYear(),
                "!@#$%^&*()_+",
                getValidCvc()
        );
    }

    public static AuthInfo getCardWithSpecialSymbolsInCvv() {
        return new AuthInfo(
                getApprovedCardNumber(),
                getCurrentMonth(),
                getNextYear(),
                getValidName(),
                "!@"
        );
    }

    public static AuthInfo getCardWithLongNumber() {
        return new AuthInfo(
                "4444 4444 4444 44451",
                getCurrentMonth(),
                getNextYear(),
                getValidName(),
                getValidCvc()
        );
    }

    public static AuthInfo getCardWithTextInNumber() {
        return new AuthInfo(
                "Карточка",
                getCurrentMonth(),
                getNextYear(),
                getValidName(),
                getValidCvc()
        );
    }

    public static AuthInfo getCardWithSpecialSymbolsInNumber() {
        return new AuthInfo(
                "!@",
                getCurrentMonth(),
                getNextYear(),
                getValidName(),
                getValidCvc()
        );
    }
}