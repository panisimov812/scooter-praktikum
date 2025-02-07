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
        String name = "Николай";
        String familyName = "Варлыгов";
        String address = "Адресс 24";
        String phoneNumber = "11900005404";
        String comment = "Коментарий 2 для Курьера 2";

        mainPageSteps.clickOrderButtonFromHeader();

        orderPageSteps.verifyOrderPageIsOpened();
        orderPageSteps.inputNameField(name);
        orderPageSteps.inputFamilyNameField(familyName);
        orderPageSteps.inputAddressField(address);

        orderPageSteps.inputPhoneField(phoneNumber);
        orderPageSteps.selectSubwayStation();
        orderPageSteps.clickToNextButton();

        rentPageSteps.verifyRentPageIsOpened();
        rentPageSteps.selectDateFromCalendar();
        rentPageSteps.selectPartOfDay();
        rentPageSteps.selectBlackScooterColor();
        rentPageSteps.fillCommentField(comment);
        rentPageSteps.clickOrderButtonToCompleteRent();
        rentPageSteps.verifyPreCompletePopUpIsOpened();
        rentPageSteps.clickAgreeButtonOnPreCompletePopUp();
        rentPageSteps.verifyCompleteScooterOrder();
    }

    @Test
    @Description("Проверка заказа скутера через кнопку 'Заказать' из середины страницы")
    public void checkOrderOpportunitySecondButton() {
        String name = "Алексей";
        String familyName = "Иванов";
        String address = "Адресс 23";
        String phoneNumber = "11111111111";
        String comment = "Коментарий для Курьера";

        mainPageSteps.scrollToBottomOfPage();
        mainPageSteps.clickOrderButtonAndCloseCookiesPopup();

        orderPageSteps.verifyOrderPageIsOpened();
        orderPageSteps.inputNameField(name);
        orderPageSteps.inputFamilyNameField(familyName);
        orderPageSteps.inputAddressField(address);

        orderPageSteps.inputPhoneField(phoneNumber);
        orderPageSteps.selectSubwayStation();
        orderPageSteps.clickToNextButton();

        rentPageSteps.verifyRentPageIsOpened();
        rentPageSteps.selectDateFromCalendar();
        rentPageSteps.selectPartOfDay();
        rentPageSteps.selectBlackScooterColor();
        rentPageSteps.fillCommentField(comment);
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


