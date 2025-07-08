package ru.netology.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.AuthInfo;

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
    private SelenideElement errorNotification = $(".notification_status_error");
    private SelenideElement submitButton = $("form button.button");
    private SelenideElement validationMessage = $(".input__sub");

    public void clickDebCard() {
        buttonDebCard.click();
    }

    public void clickCredit() {
        buttonCredit.click();
    }

    public void fillForm(AuthInfo authInfo) {
        cardNumber.setValue(authInfo.getNumber());
        month.setValue(authInfo.getMonth());
        year.setValue(authInfo.getYear());
        name.setValue(authInfo.getName());
        code.setValue(authInfo.getCode());
        submitButton.click();
    }

    public void checkValidationMessage(String expectedText) {
        validationMessage.shouldBe(Condition.visible);
        validationMessage.shouldHave(Condition.exactText(expectedText));
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