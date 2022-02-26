package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;

public class HomePage {

    SelenideElement header = $x("//div[@class='site-header__content']//img");
    SelenideElement buttonMenuDeposits = $x("//@data-site-header-content/..//span[contains(text(), 'Вклады')]");
    SelenideElement buttonMenuCards = $x("//@data-site-header-content/..//span[contains(text(), 'Карты')]");
    SelenideElement buttonOrderCard = $x("//div[contains(text(), 'Кредитные и дебетовые карты')]/../..//span[contains(text(), 'Заполнить заявку')]");
    SelenideElement buttonProfitCalculator = $x("//@data-site-header-content/..//a[contains(text(), 'Калькулятор доходности')]");

    // Первое задание

    @Step("Переход на главную страницу rencredit.ru")
    public void openHomePage() {
        header.shouldBe(visible, ofSeconds(15));
    }

    @Step("Переход на страницу Калькулятора доходности")
    public CalculatorPage goProfitCalculatorPage() {
        buttonMenuDeposits.click();
        buttonProfitCalculator.click();
        return new CalculatorPage();
    }

    // Второе задание

    @Step("Переход на страницу Заполнения заявки на карту")
    public OrderCardPage goOrderCardPage() {
        buttonMenuCards.click();
        buttonOrderCard.click();
        return new OrderCardPage();
    }
}