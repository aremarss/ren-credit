package test;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;
import page.HomePage;
import page.CalculatorPage;
import page.OrderCardPage;

import static com.codeborne.selenide.Selenide.open;
import static data.DataHelper.getAmount;
import static data.DataHelper.userInfo;

@Test(testName = "Тестовые задания")
public class RenCreditTest {

    @BeforeSuite
    void setUpAll() {
        Configuration.downloadsFolder = "./downloads/";
    }

    @BeforeMethod
    void setUp() {
        open("https://rencredit.ru/");
        new HomePage().openHomePage();
    }

    @Test(description = "Первое тестовое задание")
    void testRenCreditFirst() {
        openCalculatorPage()
                .profitCalculator(getAmount())
                .openServicePage()
                .downloadPrintedForm();
    }

    @Test(description = "Второе тестовое задание")
    void testRenCreditSecond() {
        openOrderCardPage()
                .validOrderCard(userInfo())
                .openPassportVerifyPage();
    }

    // Helper methods

    private CalculatorPage openCalculatorPage() {
        new HomePage().goProfitCalculatorPage().openCalculatorPage();
        return new CalculatorPage();
    }

    private OrderCardPage openOrderCardPage() {
        new HomePage().goOrderCardPage().openOrderCardPage();
        return new OrderCardPage();
    }
}