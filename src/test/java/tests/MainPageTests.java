package tests;

import Steps.MainPageSteps;
import Steps.OrderPageSteps;
import Steps.RentPageSteps;
import base.BaseTest;
import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;
import pages.OrderPage;
import pages.RentPage;


public class MainPageTests extends BaseTest {

    private MainPageSteps mainPageSteps;
    private OrderPageSteps orderPageSteps;
    private RentPageSteps rentPageSteps;

    @Before
    public void setUp() {
        super.setUp(); // Инициализация WebDriver в BaseTest

        // Инициализация страниц и шагов с готовым driver
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        RentPage rentPage = new RentPage(driver);

        mainPageSteps = new MainPageSteps(mainPage);
        orderPageSteps = new OrderPageSteps(orderPage);
        rentPageSteps = new RentPageSteps(rentPage);
    }

    @Test
    @Description("Проверка заказа скутера через кнопку 'Заказать' из хедера")
    public void checkOrderOpportunityThrowHeaderButton() {
        mainPageSteps.clickOrderButtonFromHeader();

        orderPageSteps.verifyOrderPageIsOpened();
        orderPageSteps.inputNameField("Николай");
        orderPageSteps.inputFamilyNameField("Варлыгов");
        orderPageSteps.inputAddressField("Адресс 24");
        orderPageSteps.inputPhoneField("11900005404");
        orderPageSteps.selectSubwayStation();
        orderPageSteps.clickToNextButton();

        rentPageSteps.verifyRentPageIsOpened();
        rentPageSteps.selectDateFromCalendar();
        rentPageSteps.selectPartOfDay();
        rentPageSteps.selectBlackScooterColor();
        rentPageSteps.fillCommentField("Коментарий 2 для Курьера 2");
        rentPageSteps.clickOrderButtonToCompleteRent();
        rentPageSteps.verifyPreCompletePopUpIsOpened();
        rentPageSteps.clickAgreeButtonOnPreCompletePopUp();
        rentPageSteps.verifyCompleteScooterOrder();
    }

    @Test
    @Description("Проверка заказа скутера через кнопку 'Заказать' из середины страницы")
    public void checkOrderOpportunitySecondButton() {
        mainPageSteps.scrollToBottomOfPage();
        mainPageSteps.clickOrderButtonAndCloseCookiesPopup();

        orderPageSteps.verifyOrderPageIsOpened();
        orderPageSteps.inputNameField("Алексей");
        orderPageSteps.inputFamilyNameField("Иванов");
        orderPageSteps.inputAddressField("Адресс 23");
        orderPageSteps.inputPhoneField("11111111111");
        orderPageSteps.selectSubwayStation();
        orderPageSteps.clickToNextButton();

        rentPageSteps.verifyRentPageIsOpened();
        rentPageSteps.selectDateFromCalendar();
        rentPageSteps.selectPartOfDay();
        rentPageSteps.selectBlackScooterColor();
        rentPageSteps.fillCommentField("Коментарий для Курьера");
        rentPageSteps.clickOrderButtonToCompleteRent();
        rentPageSteps.verifyPreCompletePopUpIsOpened();
        rentPageSteps.clickAgreeButtonOnPreCompletePopUp();
        rentPageSteps.verifyCompleteScooterOrder();
    }

    @Test
    @Description("Проверка работы возврата на главную страницу")
    public void checkComeBackToMainPageByScooterLogo() {
        mainPageSteps.clickOrderButtonFromHeader();
        mainPageSteps.clickOnScooterLogo();
        mainPageSteps.verifyFaqTextDisplayed();
    }
}