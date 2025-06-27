package ru.netology.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import ru.netology.data.AuthInfo;
import ru.netology.data.DataHelper;
import ru.netology.pages.DashboardPage;
import ru.netology.utils.DBHelper;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyTravelTest {
    private DashboardPage dashboardPage;

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
    void buyDebWithApprovedCard() throws SQLException {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getApprovedCard());
        dashboardPage.checkSuccessNotification();
        assertEquals("APPROVED", DBHelper.getPaymentStatus());
    }

    @Test
    void buyCreditWithApprovedCard() throws SQLException {
        dashboardPage.clickCredit();
        dashboardPage.fillForm(DataHelper.getApprovedCard());
        dashboardPage.checkSuccessNotification();
        assertEquals("APPROVED", DBHelper.getCreditRequestStatus());
    }

    @Test
    void buyDebWithDeclinedCard() throws SQLException {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getDeclinedCard());
        dashboardPage.checkErrorNotification();
        assertEquals("DECLINED", DBHelper.getPaymentStatus());
    }

    @Test
    void buyCreditWithDeclinedCard() throws SQLException {
        dashboardPage.clickCredit();
        dashboardPage.fillForm(DataHelper.getDeclinedCard());
        dashboardPage.checkErrorNotification();
        assertEquals("DECLINED", DBHelper.getCreditRequestStatus());
    }

    @Test
    void buyDebWithNonexistentCard() {
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(DataHelper.getInvalidCard());
        dashboardPage.checkErrorNotification();
    }

    @Test
    void buyCreditWithNonexistentCard() {
        dashboardPage.clickCredit();
        dashboardPage.fillForm(DataHelper.getInvalidCard());
        dashboardPage.checkErrorNotification();
    }

    @Test
    void buyDebWithoutCardNumber() {
        AuthInfo emptyCard = new AuthInfo("", "08", "27", "DANIL", "123");
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(emptyCard);
        dashboardPage.checkValidationMessage("Поле обязательно для заполнения");
    }

    @Test
    void buyCreditWithoutCardNumber() {
        AuthInfo emptyCard = new AuthInfo("", "08", "27", "DANIL", "123");
        dashboardPage.clickCredit();
        dashboardPage.fillForm(emptyCard);
        dashboardPage.checkValidationMessage("Поле обязательно для заполнения");
    }

    @Test
    void buyDebWithoutMonth() {
        AuthInfo emptyMonth = new AuthInfo("4444 4444 4444 4441", "", "27", "DANIL", "123");
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(emptyMonth);
        dashboardPage.checkValidationMessage("Поле обязательно для заполнения");
    }

    @Test
    void buyCreditWithoutMonth() {
        AuthInfo emptyMonth = new AuthInfo("4444 4444 4444 4441", "", "27", "DANIL", "123");
        dashboardPage.clickCredit();
        dashboardPage.fillForm(emptyMonth);
        dashboardPage.checkValidationMessage("Поле обязательно для заполнения");
    }

    @Test
    void buyDebWithoutYear() {
        AuthInfo emptyYear = new AuthInfo("4444 4444 4444 4441", "08", "", "DANIL", "123");
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(emptyYear);
        dashboardPage.checkValidationMessage("Поле обязательно для заполнения");
    }

    @Test
    void buyCreditWithoutYear() {
        AuthInfo emptyYear = new AuthInfo("4444 4444 4444 4441", "08", "", "DANIL", "123");
        dashboardPage.clickCredit();
        dashboardPage.fillForm(emptyYear);
        dashboardPage.checkValidationMessage("Поле обязательно для заполнения");
    }

    @Test
    void buyDebWithoutName() {
        AuthInfo emptyName = new AuthInfo("4444 4444 4444 4441", "08", "27", "", "123");
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(emptyName);
        dashboardPage.checkValidationMessage("Поле обязательно для заполнения");
    }

    @Test
    void buyCreditWithoutName() {
        AuthInfo emptyName = new AuthInfo("4444 4444 4444 4441", "08", "27", "", "123");
        dashboardPage.clickCredit();
        dashboardPage.fillForm(emptyName);
        dashboardPage.checkValidationMessage("Поле обязательно для заполнения");
    }

    @Test
    void buyDebWithoutCode() {
        AuthInfo emptyCode = new AuthInfo("4444 4444 4444 4441", "08", "27", "DANIL", "");
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(emptyCode);
        dashboardPage.checkValidationMessage("Поле обязательно для заполнения");
    }

    @Test
    void buyCreditWithoutCode() {
        AuthInfo emptyCode = new AuthInfo("4444 4444 4444 4441", "08", "27", "DANIL", "");
        dashboardPage.clickCredit();
        dashboardPage.fillForm(emptyCode);
        dashboardPage.checkValidationMessage("Поле обязательно для заполнения");
    }

    @Test
    void buyDebWithInvalidMonth() {
        AuthInfo invalidMonth = new AuthInfo("4444 4444 4444 4441", "13", "27", "DANIL", "123");
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(invalidMonth);
        dashboardPage.checkValidationMessage("Неверно указан срок действия карты");
    }

    @Test
    void buyCreditWithInvalidMonth() {
        AuthInfo invalidMonth = new AuthInfo("4444 4444 4444 4441", "13", "27", "DANIL", "123");
        dashboardPage.clickCredit();
        dashboardPage.fillForm(invalidMonth);
        dashboardPage.checkValidationMessage("Неверно указан срок действия карты");
    }

    @Test
    void buyDebWithExpiredYear() {
        AuthInfo expiredYear = new AuthInfo("4444 4444 4444 4441", "08", DataHelper.getPreviousYear(), "DANIL", "123");
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(expiredYear);
        dashboardPage.checkValidationMessage("Истёк срок действия карты");
    }

    @Test
    void buyCreditWithExpiredYear() {
        AuthInfo expiredYear = new AuthInfo("4444 4444 4444 4441", "08", DataHelper.getPreviousYear(), "DANIL", "123");
        dashboardPage.clickCredit();
        dashboardPage.fillForm(expiredYear);
        dashboardPage.checkValidationMessage("Истёк срок действия карты");
    }

    @Test
    void buyDebWithCyrillicName() {
        AuthInfo cyrillicName = new AuthInfo("4444 4444 4444 4441", "08", "27", "ДАНИЛ", "123");
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(cyrillicName);
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void buyCreditWithCyrillicName() {
        AuthInfo cyrillicName = new AuthInfo("4444 4444 4444 4441", "08", "27", "ДАНИЛ", "123");
        dashboardPage.clickCredit();
        dashboardPage.fillForm(cyrillicName);
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void buyDebWithNumericName() {
        AuthInfo numericName = new AuthInfo("4444 4444 4444 4441", "08", "27", "12345", "123");
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(numericName);
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void buyCreditWithNumericName() {
        AuthInfo numericName = new AuthInfo("4444 4444 4444 4441", "08", "27", "12345", "123");
        dashboardPage.clickCredit();
        dashboardPage.fillForm(numericName);
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void buyDebWithLongCvc() {
        AuthInfo longCvc = new AuthInfo("4444 4444 4444 4441", "08", "27", "DANIL", "1234");
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(longCvc);
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void buyCreditWithLongCvc() {
        AuthInfo longCvc = new AuthInfo("4444 4444 4444 4441", "08", "27", "DANIL", "1234");
        dashboardPage.clickCredit();
        dashboardPage.fillForm(longCvc);
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void buyDebWithInvalidCardFormat() {
        AuthInfo invalidCard = new AuthInfo("4444 4444 4444 444", "08", "27", "DANIL", "123");
        dashboardPage.clickDebCard();
        dashboardPage.fillForm(invalidCard);
        dashboardPage.checkValidationMessage("Неверный формат");
    }

    @Test
    void buyCreditWithInvalidCardFormat() {
        AuthInfo invalidCard = new AuthInfo("4444 4444 4444 444", "08", "27", "DANIL", "123");
        dashboardPage.clickCredit();
        dashboardPage.fillForm(invalidCard);
        dashboardPage.checkValidationMessage("Неверный формат");
    }
}