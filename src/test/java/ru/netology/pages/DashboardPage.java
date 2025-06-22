package ru.netology.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement buttonDebCard = $(".button:first-of-type");
    private SelenideElement buttonCredit = $(".button_view_extra");
    private SelenideElement cardNumber = $(".input__control[placeholder='0000 0000 0000 0000']");
    private SelenideElement month = $(".input__control[placeholder='08']");
    private SelenideElement year = $(".input__control[placeholder='22']");
    private SelenideElement name = $$("span.input__top").findBy(text("Владелец")).parent().$("input");
    private SelenideElement code = $(".input__control[placeholder='999']");
    private SelenideElement succesNotification = $(".notification_status_ok");
    private SelenideElement errorNotification = $(".notification_status_error") ;
    private SelenideElement submitButton = $("form button.button");

    public DashboardPage clickDebCard(){
        buttonDebCard.click();
        return new DashboardPage();
    }

    public DashboardPage clickCredit(){
        buttonCredit.click();
        return new DashboardPage();
    }

    public DashboardPage fillFormApproved(){
        cardNumber.setValue("4444 4444 4444 4441");
        month.setValue("08");
        year.setValue("27");
        name.setValue("DANIL");
        code.setValue("123");
        submitButton.click();
        return new DashboardPage();
    }

    public DashboardPage fillFormBlocked(){
        cardNumber.setValue("4444 4444 4444 4442");
        month.setValue("08");
        year.setValue("27");
        name.setValue("DANIL");
        code.setValue("123");
        submitButton.click();
        return new DashboardPage();
    }

    public DashboardPage fillFormNullCard(){
        cardNumber.setValue("4444 4444 4444 4443");
        month.setValue("08");
        year.setValue("27");
        name.setValue("DANIL");
        code.setValue("123");
        submitButton.click();
        return new DashboardPage();
    }

    public DashboardPage fillFormWithoutNumber() {
        month.setValue("08");
        year.setValue("27");
        name.setValue("DANIL");
        code.setValue("123");
        submitButton.click();
        $(".input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
        return new DashboardPage();
    }

    public DashboardPage fillFormWithoutMonth() {
        cardNumber.setValue("4444 4444 4444 4441");
        year.setValue("27");
        name.setValue("DANIL");
        code.setValue("123");
        submitButton.click();
        $(".input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
        return new DashboardPage();
    }

    public DashboardPage fillFormWithoutYear() {
        cardNumber.setValue("4444 4444 4444 4441");
        month.setValue("08");
        name.setValue("DANIL");
        code.setValue("123");
        submitButton.click();
        $(".input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
        return new DashboardPage();
    }

    public DashboardPage fillFormWithoutName() {
        cardNumber.setValue("4444 4444 4444 4441");
        month.setValue("08");
        year.setValue("27");
        code.setValue("123");
        submitButton.click();
        $(".input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
        return new DashboardPage();
    }

    public DashboardPage fillFormWithoutCode() {
        cardNumber.setValue("4444 4444 4444 4441");
        month.setValue("08");
        year.setValue("27");
        name.setValue("DANIL");
        submitButton.click();
        $(".input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
        return new DashboardPage();
    }

    public DashboardPage fillFormWithSpecNumber1(){
        cardNumber.setValue("4444 4444 4444 44451");
        month.setValue("08");
        year.setValue("27");
        name.setValue("DANIL");
        code.setValue("123");
        submitButton.click();
        $(".input__sub").shouldHave(exactText("Неверный формат"));
        return new DashboardPage();
    }

    public DashboardPage fillFormWithSpecMonth1(){
        cardNumber.setValue("4444 4444 4444 4441");
        month.setValue("13");
        year.setValue("27");
        name.setValue("DANIL");
        code.setValue("123");
        submitButton.click();
        $(".input__sub").shouldHave(exactText("Неверно указан срок действия карты"));
        return new DashboardPage();
    }

    public DashboardPage fillFormWithSpecYear1(){
        cardNumber.setValue("4444 4444 4444 4441");
        month.setValue("08");
        year.setValue("24");
        name.setValue("DANIL");
        code.setValue("123");
        submitButton.click();
        $(".input__sub").shouldHave(exactText("Неверно указан срок действия карты"));
        return new DashboardPage();
    }

    public DashboardPage fillFormWithSpecName1(){
        cardNumber.setValue("4444 4444 4444 4441");
        month.setValue("08");
        year.setValue("27");
        name.setValue("ДАНИЛ");
        code.setValue("123");
        submitButton.click();
        $(".input__sub").shouldHave(exactText("Неверный формат"));
        return new DashboardPage();
    }

    public DashboardPage fillFormWithSpecCode1(){
        cardNumber.setValue("4444 4444 4444 4441");
        month.setValue("08");
        year.setValue("27");
        name.setValue("DANIL");
        code.setValue("1000");
        submitButton.click();
        $(".input__sub").shouldHave(exactText("Неверный формат"));
        return new DashboardPage();
    }

    public DashboardPage fillFormWithSpecNumber2(){
        cardNumber.setValue("Карточка");
        month.setValue("08");
        year.setValue("27");
        name.setValue("DANIL");
        code.setValue("123");
        submitButton.click();
        $(".input__sub").shouldHave(exactText("Неверный формат"));
        return new DashboardPage();
    }

    public DashboardPage fillFormWithSpecMonth2(){
        cardNumber.setValue("4444 4444 4444 4441");
        month.setValue("Май");
        year.setValue("27");
        name.setValue("DANIL");
        code.setValue("123");
        submitButton.click();
        $(".input__sub").shouldHave(exactText("Неверный формат"));
        return new DashboardPage();
    }

    public DashboardPage fillFormWithSpecYear2(){
        cardNumber.setValue("4444 4444 4444 4441");
        month.setValue("08");
        year.setValue("четыре");
        name.setValue("DANIL");
        code.setValue("123");
        submitButton.click();
        $(".input__sub").shouldHave(exactText("Неверный формат"));
        return new DashboardPage();
    }

    public DashboardPage fillFormWithSpecName2(){
        cardNumber.setValue("4444 4444 4444 4441");
        month.setValue("08");
        year.setValue("27");
        name.setValue("12345");
        code.setValue("123");
        submitButton.click();
        $(".input__sub").shouldHave(exactText("Неверный формат"));
        return new DashboardPage();
    }

    public DashboardPage fillFormWithSpecCode2(){
        cardNumber.setValue("4444 4444 4444 4441");
        month.setValue("08");
        year.setValue("27");
        name.setValue("DANIL");
        code.setValue("Триста");
        submitButton.click();
        $(".input__sub").shouldHave(exactText("Неверный формат"));
        return new DashboardPage();
    }

    public DashboardPage fillFormWithSpecNumber3(){
        cardNumber.setValue("!@");
        month.setValue("08");
        year.setValue("27");
        name.setValue("DANIL");
        code.setValue("123");
        submitButton.click();
        $(".input__sub").shouldHave(exactText("Неверный формат"));
        return new DashboardPage();
    }

    public DashboardPage fillFormWithSpecMonth3(){
        cardNumber.setValue("4444 4444 4444 4441");
        month.setValue("!@");
        year.setValue("27");
        name.setValue("DANIL");
        code.setValue("123");
        submitButton.click();
        $(".input__sub").shouldHave(exactText("Неверный формат"));
        return new DashboardPage();
    }

    public DashboardPage fillFormWithSpecYear3(){
        cardNumber.setValue("4444 4444 4444 4441");
        month.setValue("08");
        year.setValue("!@");
        name.setValue("DANIL");
        code.setValue("123");
        submitButton.click();
        $(".input__sub").shouldHave(exactText("Неверный формат"));
        return new DashboardPage();
    }

    public DashboardPage fillFormWithSpecName3(){
        cardNumber.setValue("4444 4444 4444 4441");
        month.setValue("08");
        year.setValue("27");
        name.setValue("!@");
        code.setValue("123");
        submitButton.click();
        $(".input__sub").shouldHave(exactText("Неверный формат"));
        return new DashboardPage();
    }

    public DashboardPage fillFormWithSpecCode3(){
        cardNumber.setValue("4444 4444 4444 4441");
        month.setValue("08");
        year.setValue("27");
        name.setValue("DANIL");
        code.setValue("!@");
        submitButton.click();
        $(".input__sub").shouldHave(exactText("Неверный формат"));
        return new DashboardPage();
    }



    public void checkSuccessNotification() {
        succesNotification.shouldBe(visible, Duration.ofSeconds(15));
        succesNotification.shouldHave(text("Успешно"));
        succesNotification.shouldHave(text("Операция одобрена Банком."));
    }

    public void checkErrorNotification() {
        errorNotification.shouldBe(visible, Duration.ofSeconds(15));
        errorNotification.shouldHave(text("Ошибка"));
        errorNotification.shouldHave(text("Банк отказал в проведении операции."));
    }
}
