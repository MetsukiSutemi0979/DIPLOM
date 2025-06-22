package ru.netology.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.pages.DashboardPage;
import ru.netology.utils.DBHelper;

public class BuyTravelTest {
    @BeforeEach
    void setUp(){
        Selenide.open("http://localhost:8080");
    }

    @Test
    void buyDebWithApprovedCard(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickDebCard();
        dashboardPage.fillFormApproved();
        dashboardPage.checkSuccessNotification();
    }

    @Test
    void buyCreditWithApprovedCard(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickCredit();
        dashboardPage.fillFormApproved();
        dashboardPage.checkSuccessNotification();
    }

    @Test
    void buyDebWithBlockedCard(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickDebCard();
        dashboardPage.fillFormBlocked();
        dashboardPage.checkErrorNotification();
    }

    @Test
    void buyCreditWithBlockedCard(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickCredit();
        dashboardPage.fillFormBlocked();
        dashboardPage.checkErrorNotification();
    }

    @Test
    void buyDebWithoutCardNumber(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickDebCard();
        dashboardPage.fillFormWithoutNumber();
    }

    @Test
    void buyDebWithoutMonth() {
        var dashboardPage = new DashboardPage();
        dashboardPage.clickDebCard();
        dashboardPage.fillFormWithoutMonth();
    }

    @Test
    void buyDebWithoutYear() {
        var dashboardPage = new DashboardPage();
        dashboardPage.clickDebCard();
        dashboardPage.fillFormWithoutYear();
    }

    @Test
    void buyDebWithoutName() {
        var dashboardPage = new DashboardPage();
        dashboardPage.clickDebCard();
        dashboardPage.fillFormWithoutName();
    }

    @Test
    void buyDebWithoutCode() {
        var dashboardPage = new DashboardPage();
        dashboardPage.clickDebCard();
        dashboardPage.fillFormWithoutCode();
    }

    @Test
    void buyCreditWithoutCardNumber() {
        var dashboardPage = new DashboardPage();
        dashboardPage.clickCredit();
        dashboardPage.fillFormWithoutNumber();
    }

    @Test
    void buyCreditWithoutMonth() {
        var dashboardPage = new DashboardPage();
        dashboardPage.clickCredit();
        dashboardPage.fillFormWithoutMonth();
    }

    @Test
    void buyCreditWithoutYear() {
        var dashboardPage = new DashboardPage();
        dashboardPage.clickCredit();
        dashboardPage.fillFormWithoutYear();
    }

    @Test
    void buyCreditWithoutName() {
        var dashboardPage = new DashboardPage();
        dashboardPage.clickCredit();
        dashboardPage.fillFormWithoutName();
    }

    @Test
    void buyCreditWithoutCode() {
        var dashboardPage = new DashboardPage();
        dashboardPage.clickCredit();
        dashboardPage.fillFormWithoutCode();
    }

    @Test
    void buyDebWithNonexistentCard(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickDebCard();
        dashboardPage.fillFormNullCard();
        dashboardPage.checkErrorNotification();
    }

    @Test
    void buyCreditWithNonexistentCard(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickCredit();
        dashboardPage.fillFormNullCard();
        dashboardPage.checkErrorNotification();
    }

    @Test
    void buyDebWithLimitValuesNumber(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickDebCard();
        dashboardPage.fillFormWithSpecNumber1();
    }

    @Test
    void buyCreditWithLimitValuesNumber(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickCredit();
        dashboardPage.fillFormWithSpecNumber1();
    }

    @Test
    void buyDebWithLimitValuesMonth(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickDebCard();
        dashboardPage.fillFormWithSpecMonth1();
    }

    @Test
    void buyCreditWithLimitValuesMonth(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickCredit();
        dashboardPage.fillFormWithSpecMonth1();
    }

    @Test
    void buyDebWithLimitValuesYear(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickDebCard();
        dashboardPage.fillFormWithSpecYear1();
    }

    @Test
    void buyCreditWithLimitValuesYear(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickCredit();
        dashboardPage.fillFormWithSpecYear1();
    }

    @Test
    void buyDebWithRussianName(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickDebCard();
        dashboardPage.fillFormWithSpecName1();
    }

    @Test
    void buyCreditWithRussianName(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickCredit();
        dashboardPage.fillFormWithSpecName1();
    }

    @Test
    void buyDebWithLimitValuesCode(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickDebCard();
        dashboardPage.fillFormWithSpecCode1();
    }

    @Test
    void buyCreditWithLimitValuesCode(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickCredit();
        dashboardPage.fillFormWithSpecCode1();
    }

    @Test
    void buyDebWithWordsInNumber(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickDebCard();
        dashboardPage.fillFormWithSpecNumber2();
    }

    @Test
    void buyCreditWithWordsInNumber(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickCredit();
        dashboardPage.fillFormWithSpecNumber2();
    }

    @Test
    void buyDebWithWordsInMonth(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickDebCard();
        dashboardPage.fillFormWithSpecMonth2();
    }

    @Test
    void buyCreditWithWordsInMonth(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickCredit();
        dashboardPage.fillFormWithSpecMonth2();
    }

    @Test
    void buyDebWithWordsInYear(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickDebCard();
        dashboardPage.fillFormWithSpecYear2();
    }

    @Test
    void buyCreditWithWordsInYear(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickCredit();
        dashboardPage.fillFormWithSpecYear2();
    }

    @Test
    void buyDebWithNumbersInName(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickDebCard();
        dashboardPage.fillFormWithSpecName2();
    }

    @Test
    void buyCreditWithNumbersInName(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickCredit();
        dashboardPage.fillFormWithSpecName2();
    }

    @Test
    void buyDebWithWordsInCode(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickDebCard();
        dashboardPage.fillFormWithSpecCode2();
    }

    @Test
    void buyCreditWithWordsInCode(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickCredit();
        dashboardPage.fillFormWithSpecCode2();
    }

    @Test
    void buyDebWithSpecSymbolsInNumber(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickDebCard();
        dashboardPage.fillFormWithSpecNumber3();
    }

    @Test
    void buyCreditWithSpecSymbolsInNumber(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickCredit();
        dashboardPage.fillFormWithSpecNumber3();
    }

    @Test
    void buyDebWithSpecSymbolsInMonth(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickDebCard();
        dashboardPage.fillFormWithSpecMonth3();
    }

    @Test
    void buyCreditWithSpecSymbolsInMonth(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickCredit();
        dashboardPage.fillFormWithSpecMonth3();
    }

    @Test
    void buyDebWithWithSpecSymbolsYear(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickDebCard();
        dashboardPage.fillFormWithSpecYear3();
    }

    @Test
    void buyCreditWithSpecSymbolsInYear(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickCredit();
        dashboardPage.fillFormWithSpecYear3();
    }

    @Test
    void buyDebWithSpecSymbolsInName(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickDebCard();
        dashboardPage.fillFormWithSpecName3();
    }

    @Test
    void buyCreditWithSpecSymbolsInName(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickCredit();
        dashboardPage.fillFormWithSpecName3();
    }

    @Test
    void buyDebWithSpecSymbolsInCode(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickDebCard();
        dashboardPage.fillFormWithSpecCode3();
    }

    @Test
    void buyCreditWithSpecSymbolsInCode(){
        var dashboardPage = new DashboardPage();
        dashboardPage.clickCredit();
        dashboardPage.fillFormWithSpecCode3();
    }

}
