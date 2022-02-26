package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;

public class PassportVerifyPage {

    SelenideElement openedPassportVerify = $x("//*[@data-message-title='Серия и номер паспорта']");

    @Step("Открытие формы заполнения паспортных данных")
    public void openPassportVerifyPage() {
        openedPassportVerify.shouldBe(visible, ofSeconds(15));
    }
}
