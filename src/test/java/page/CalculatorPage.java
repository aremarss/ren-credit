package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;

public class CalculatorPage {

    SelenideElement header = $x("//h1[text()='Вклады']");
    SelenideElement buttonAtBankBranch = $x("//label[text()='Открытие вклада']/..//span[text()='В отделении банка']/../..//div[@class='jq-checkbox calculator__check']");
    SelenideElement inputAmount = $x("//label[text()='Сумма вклада']/..//input");
    SelenideElement sliderTerm = $x("//div[@data-property='period']//span");
    SelenideElement forPeriod = $x("//label[text()='На срок']");
    SelenideElement buttonTariffsAndConditions = $x("//a[text()='Тарифы и условия']");

    @Step("Открытие страницы Вкладов")
    public void openCalculatorPage() {
        header.shouldBe(visible);
        new CalculatorPage();
    }

    @Step("Заполнение полей на странице Вкладов")
    public ServicePage profitCalculator(String amount) {
        buttonAtBankBranch.click();
        inputAmount.setValue(amount);
        sliderTerm.dragAndDropTo(forPeriod);
        buttonTariffsAndConditions.shouldBe(visible, ofSeconds(15)).click();
        return new ServicePage();
    }
}