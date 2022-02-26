package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static data.DBHelper.setEndStep;
import static data.DBHelper.setStartStep;
import static java.time.Duration.ofSeconds;

public class CalculatorPage {

    SelenideElement header = $x("//h1[text()='Вклады']");
    SelenideElement buttonAtBankBranch = $x("//label[text()='Открытие вклада']/..//span[text()='В отделении банка']/../..//div[@class='jq-checkbox calculator__check']");
    SelenideElement inputAmount = $x("//label[text()='Сумма вклада']/..//input");
    SelenideElement sliderTerm = $x("//div[@data-property='period']//span");
    SelenideElement forPeriod = $x("//label[text()='На срок']");
    SelenideElement buttonTariffsAndConditions = $x("//div[@class='footer-mobile-nav__content js-footer-mobile-nav']//a[text()='Тарифы и условия']");

    @Step("Открытие страницы Вкладов")
    public void openCalculatorPage() {
        header.shouldBe(visible);
        setEndStep();
        new CalculatorPage();
    }

    @Step("Заполнение полей на странице Вкладов")
    public ServicePage profitCalculator(String amount) {
        setStartStep("Выбрать чекбокс - В отделении банка");
        buttonAtBankBranch.click();
        setEndStep();
        setStartStep("Ввести сумму вклада");
        inputAmount.setValue(amount);
        setEndStep();
        setStartStep("Передвинуть ползунок - На срок");
        sliderTerm.dragAndDropTo(forPeriod);
        setEndStep();
        setStartStep("Выгрузить актуальную печатную Форму" +
                " - Общие условия открытия и обслуживания банковских счетов физических лиц" +
                " и размещения вкладов " +
                "в КБ «Ренессанс Кредит» (ООО)");
        buttonTariffsAndConditions.shouldBe(visible, ofSeconds(15)).click();
        return new ServicePage();
    }
}