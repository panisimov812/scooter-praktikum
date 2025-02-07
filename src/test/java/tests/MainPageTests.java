package tests;

import Steps.MainPageSteps;
import Steps.OrderPageSteps;
import Steps.RentPageSteps;
import base.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.MainPage;
import pages.OrderPage;
import pages.RentPage;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;


public class MainPageTests extends BaseTest {

    private MainPageSteps mainPageSteps;
    private OrderPageSteps orderPageSteps;
    private RentPageSteps rentPageSteps;

    @Before
    public void setUp() {
        super.setUp(); // Вызов метода setUp() из BaseTest для инициализации WebDriver
        MainPage mainPage = new MainPage(driver); // Создание экземпляра MainPage
        mainPageSteps = new MainPageSteps(mainPage); // Инициализация MainPageSteps

        OrderPage orderPage = new OrderPage(driver);
        orderPageSteps = new OrderPageSteps(orderPage);

        RentPage rentPage = new RentPage(driver);
        rentPageSteps = new RentPageSteps(rentPage);
    }

    @Test
    public void checkOrderOpportunityThrowHeaderButton() {
        String name = "Николай";
        String familyName = "Варлыгов";
        String address = "Адресс 24";
        String phoneNumber = "11900005404";
        String comment = "Коментарий 2 для Курьера 2";

        mainPageSteps.clickToOrderButtonByHeader();

        orderPageSteps.checkThatOrderPageIsOpened();
        orderPageSteps.inputNameField(name);
        orderPageSteps.inputFamilyNameField(familyName);
        orderPageSteps.inputAddressField(address);

        orderPageSteps.inputPhoneField(phoneNumber);
        orderPageSteps.chooseSubWayStation();
        orderPageSteps.clickToNextButton();

        rentPageSteps.checkThatOrderPageIsOpened();
        rentPageSteps.selectCalendarDate();
        rentPageSteps.selectPartOfDay();
        rentPageSteps.selectBlackScooterColor();
        rentPageSteps.fillCommentField(comment);
        rentPageSteps.clickToOrderButtonForCompleteRent();
        rentPageSteps.checkThatPreCompletePopUpIsOpened();
        rentPageSteps.clickToAgreeButtonOnPreCompletePopUp();
        rentPageSteps.checkCompleteScooterOrder();
    }

    @Test
    public void checkOrderOpportunitySecondButton() {
        String name = "Алексей";
        String familyName = "Иванов";
        String address = "Адресс 23";
        String phoneNumber = "11111111111";
        String comment = "Коментарий для Курьера";

        mainPageSteps.scrollPageDown();
        mainPageSteps.clickToOrderButtonWithRemoveCookiesPopUp();

        orderPageSteps.checkThatOrderPageIsOpened();
        orderPageSteps.inputNameField(name);
        orderPageSteps.inputFamilyNameField(familyName);
        orderPageSteps.inputAddressField(address);

        orderPageSteps.inputPhoneField(phoneNumber);
        orderPageSteps.chooseSubWayStation();
        orderPageSteps.clickToNextButton();

        rentPageSteps.checkThatOrderPageIsOpened();
        rentPageSteps.selectCalendarDate();
        rentPageSteps.selectPartOfDay();
        rentPageSteps.selectBlackScooterColor();
        rentPageSteps.fillCommentField(comment);
        rentPageSteps.clickToOrderButtonForCompleteRent();
        rentPageSteps.checkThatPreCompletePopUpIsOpened();
        rentPageSteps.clickToAgreeButtonOnPreCompletePopUp();
        rentPageSteps.checkCompleteScooterOrder();
    }
}


