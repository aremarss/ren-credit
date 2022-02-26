package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class OrderCardPage {

    SelenideElement header = $x("//*[text()='Общие данные']");
    SelenideElement inputLastName = $x("//input[@name='ClientLastName']");
    SelenideElement inputFirstName = $x("//input[@name='ClientName']");
    SelenideElement inputPhone = $x("//input[@name='ClientMobilePhone']");
    SelenideElement inputMail = $x("//input[@name='AdditionalEmail']");
    SelenideElement checkboxNotHavePatronymic = $x("//*[@data-ignoreid='1']");
    SelenideElement checkboxGender;
    SelenideElement selectPlace = $x("//div[text()='Где Вы желаете получить карту?']");
    SelenideElement buttonPlace;
    SelenideElement selectCity = $x("//div[text()='Город']");
    SelenideElement buttonCity;
    SelenideElement buttonNext = $x("//*[@data-messageid='1']/../..//a[text()='Далее']");


    @Step("Открытие страницы Заказа карты")
    public void openOrderCardPage() {
        header.shouldBe(visible);
    }

    @Step("Ввод корректных значений в поля")
    public PassportVerifyPage validOrderCard(DataHelper.AuthInfo info) {
        enterInputs(info);
        return new PassportVerifyPage();
    }

    private void enterInputs(DataHelper.AuthInfo info) {
        getGenderAndLocationInfo(info);
        inputLastName.setValue(info.getLastName());
        inputFirstName.setValue(info.getFirstName());
        inputPhone.setValue(info.getPhone());
        inputMail.setValue(info.getMail());
        checkboxNotHavePatronymic.click();
        checkboxGender.click();
        selectPlace.click();
        buttonPlace.click();
        selectCity.click();
        buttonCity.click();
        buttonNext.click();
    }

    private void getGenderAndLocationInfo(DataHelper.AuthInfo info) {
        checkboxGender = $x("//*[contains(text(), '" + info.getGender() + "')]/div");
        buttonPlace = $x("//li[contains(text(), '" + info.getPlace() + "')]");
        buttonCity = $x("//li[contains(text(), '" + info.getCity() + "')]");
    }
}