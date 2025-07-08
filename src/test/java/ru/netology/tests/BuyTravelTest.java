package ru.netology.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.AuthInfo;
import ru.netology.data.DataHelper;
import ru.netology.pages.DashboardPage;
import ru.netology.utils.DBHelper;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyTravelTest {
    private DashboardPage dashboardPage;

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void setUp() {
        Selenide.open("http://localhost:8080");
        dashboardPage = new DashboardPage();
    }

    @AfterEach
    void cleanDB() throws SQLException {
        DBHelper.clearData();
    }

    @Test
    void shouldSuccessPaymentWithApprovedCard() throws SQLException {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getApprovedCard());
        dashboardPage.checkSuccessNotification();
    }

    @Test
    void shouldSuccessCreditWithApprovedCard() throws SQLException {
        dashboardPage.clickCredit();
        dashboardPage.fillForm(DataHelper.getApprovedCard());
        dashboardPage.checkSuccessNotification();
    }

    @Test
    void shouldFailPaymentWithDeclinedCard() {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getDeclinedCard());
        dashboardPage.checkErrorNotification();
    }

    @Test
    void shouldFailCreditWithDeclinedCard() {
        dashboardPage.clickCredit();
        dashboardPage.fillForm(DataHelper.getDeclinedCard());
        dashboardPage.checkErrorNotification();
    }

    @Test
    void shouldFailPaymentWithInvalidCard() {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getInvalidCard());
        dashboardPage.checkErrorNotification();
    }

    @Test
    void shouldFailCreditWithInvalidCard() {
        dashboardPage.clickCredit();
        dashboardPage.fillForm(DataHelper.getInvalidCard());
        dashboardPage.checkErrorNotification();
    }

    @Test
    void shouldFailPaymentWithInvalidMonthBoundary() {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getCardWithInvalidMonth());
        dashboardPage.checkValidationMessage("Неверно указан срок действия карты");
    }

    @Test
    void shouldFailPaymentWithInvalidYearBoundary() {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getCardWithExpiredYear());
        dashboardPage.checkValidationMessage("Истёк срок действия карты");
    }

    @Test
    void shouldFailPaymentWithCyrillicName() {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getCardWithCyrillicName());
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void shouldFailPaymentWithInvalidCvvBoundary() {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getCardWithLongCvc());
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void shouldFailCreditWithInvalidCvvBoundary() {
        dashboardPage.clickCredit();
        dashboardPage.fillForm(DataHelper.getCardWithLongCvc());
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void shouldFailCreditWithSpecialSymbolsInYear() {
        dashboardPage.clickCredit();
        dashboardPage.fillForm(DataHelper.getCardWithSpecialSymbolsInYear());
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void shouldFailPaymentWithTextInMonth() {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getCardWithTextInMonth());
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void shouldFailPaymentWithTextInYear() {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getCardWithTextInYear());
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void shouldFailPaymentWithTextInCvv() {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getCardWithTextInCvv());
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void shouldFailPaymentWithNonExistentMonth() {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getCardWithNonExistentMonth());
        dashboardPage.checkValidationMessage("Неверно указан срок действия карты");
    }

    @Test
    void shouldFailPaymentWithLastYear() {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getCardWithLastYear());
        dashboardPage.checkValidationMessage("Истёк срок действия карты");
    }

    @Test
    void shouldFailCreditWithNonExistentMonth() {
        dashboardPage.clickCredit();
        dashboardPage.fillForm(DataHelper.getCardWithNonExistentMonth());
        dashboardPage.checkValidationMessage("Неверно указан срок действия карты");
    }

    @Test
    void shouldFailPaymentWithInvalidCvvBoundary2() {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getCardWithLongCvc());
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void shouldFailPaymentWithTextInMonth2() {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getCardWithTextInMonth());
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void shouldFailCreditWithNumericName() {
        dashboardPage.clickCredit();
        dashboardPage.fillForm(DataHelper.getCardWithNumericName());
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void shouldFailCreditWithTextInCvv() {
        dashboardPage.clickCredit();
        dashboardPage.fillForm(DataHelper.getCardWithTextInCvv());
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void shouldFailPaymentWithSpecialSymbolsInMonth() {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getCardWithSpecialSymbolsInMonth());
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void shouldFailPaymentWithSpecialSymbolsInYear() {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getCardWithSpecialSymbolsInYear());
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void shouldFailPaymentWithSpecialSymbolsInName() {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getCardWithSpecialSymbolsInName());
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void shouldFailPaymentWithSpecialSymbolsInCvv() {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getCardWithSpecialSymbolsInCvv());
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void shouldFailCreditWithSpecialSymbolsInMonth() {
        dashboardPage.clickCredit();
        dashboardPage.fillForm(DataHelper.getCardWithSpecialSymbolsInMonth());
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void shouldFailCreditWithSpecialSymbolsInName() {
        dashboardPage.clickCredit();
        dashboardPage.fillForm(DataHelper.getCardWithSpecialSymbolsInName());
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void shouldFailCreditWithSpecialSymbolsInCvv() {
        dashboardPage.clickCredit();
        dashboardPage.fillForm(DataHelper.getCardWithSpecialSymbolsInCvv());
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void shouldFailPaymentWithLongCardNumber() {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getCardWithLongNumber());
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void shouldFailPaymentWithTextInCardNumber() {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getCardWithTextInNumber());
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void shouldFailPaymentWithSpecialSymbolsInCardNumber() {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getCardWithSpecialSymbolsInNumber());
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void shouldFailCreditWithTextInCardNumber() {
        dashboardPage.clickCredit();
        dashboardPage.fillForm(DataHelper.getCardWithTextInNumber());
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void shouldFailPaymentWithTextInCardNumber2() {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getCardWithTextInNumber());
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void shouldFailCreditWithSpecialSymbolsInCardNumber() {
        dashboardPage.clickCredit();
        dashboardPage.fillForm(DataHelper.getCardWithSpecialSymbolsInNumber());
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void shouldFailPaymentWithEmptyCardNumber() {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getCardWithoutNumber());
        dashboardPage.checkValidationMessage("Поле обязательно для заполнения");
    }

    @Test
    void shouldFailPaymentWithEmptyMonth() {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getCardWithoutMonth());
        dashboardPage.checkValidationMessage("Поле обязательно для заполнения");
    }

    @Test
    void shouldFailPaymentWithEmptyYear() {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getCardWithoutYear());
        dashboardPage.checkValidationMessage("Поле обязательно для заполнения");
    }

    @Test
    void shouldFailPaymentWithEmptyCvv() {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getCardWithoutCvc());
        dashboardPage.checkValidationMessage("Поле обязательно для заполнения");
    }

    @Test
    void shouldFailCreditWithEmptyCardNumber() {
        dashboardPage.clickCredit();
        dashboardPage.fillForm(DataHelper.getCardWithoutNumber());
        dashboardPage.checkValidationMessage("Поле обязательно для заполнения");
    }

    @Test
    void shouldFailCreditWithEmptyMonth() {
        dashboardPage.clickCredit();
        dashboardPage.fillForm(DataHelper.getCardWithoutMonth());
        dashboardPage.checkValidationMessage("Поле обязательно для заполнения");
    }

    @Test
    void shouldFailCreditWithEmptyYear() {
        dashboardPage.clickCredit();
        dashboardPage.fillForm(DataHelper.getCardWithoutYear());
        dashboardPage.checkValidationMessage("Поле обязательно для заполнения");
    }

    @Test
    void shouldFailCreditWithEmptyName() {
        dashboardPage.clickCredit();
        dashboardPage.fillForm(DataHelper.getCardWithoutName());
        dashboardPage.checkValidationMessage("Поле обязательно для заполнения");
    }

    @Test
    void shouldFailCreditWithEmptyCvv() {
        dashboardPage.clickCredit();
        dashboardPage.fillForm(DataHelper.getCardWithoutCvc());
        dashboardPage.checkValidationMessage("Поле обязательно для заполнения");
    }

    @Test
    void shouldFailCreditWithSpecialSymbolsInCardNumber2() {
        dashboardPage.clickCredit();
        dashboardPage.fillForm(DataHelper.getCardWithSpecialSymbolsInNumber());
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void shouldFailCreditWithSpecialSymbolsInName2() {
        dashboardPage.clickCredit();
        dashboardPage.fillForm(DataHelper.getCardWithSpecialSymbolsInName());
        dashboardPage.checkValidationMessage("Неверный формат");
    }
}