package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.SneakyThrows;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static data.DBHelper.setEndStep;
import static java.time.Duration.ofSeconds;

public class ServicePage {

    SelenideElement header = $x("//h1[text()='Тарифы и условия']");
    SelenideElement printedForm = $x("//h2[contains(text(), 'Общие условия открытия и обслуживания')]/..//h3/a[1]");

    @Step("Переход на страницу Тарифов и условий")
    public ServicePage openServicePage() {
        header.shouldBe(visible, ofSeconds(15));
        return new ServicePage();
    }

    @Step("Скачивание актуального документа")
    @SneakyThrows
    public void downloadPrintedForm() {
        printedForm.download();
        setEndStep();
    }
}