package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RentPage {
    public RentPage(WebDriver driver) {
        this.driver = driver;
    }

    private final WebDriver driver;

    private final By mainRentTitle = By.xpath("//div[@class='Order_Header__BZXOb' and text()='Про аренду']");
    private final By dateSelectorPlaceholder = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By dateValue = By.xpath("//div[@class='react-datepicker__month']//div[text()='10']");
    private final By rentalPeriodPlaceHolder = By.xpath("//div[@class='Dropdown-placeholder' and text()='* Срок аренды']");
    private final By rentalPeriod = By.xpath("//div[@class='Dropdown-menu']//div[text()='сутки']");
    private final By commentFieldPlaceholder = By.xpath("//input[@placeholder='Комментарий для курьера']");
    private final By colorBlackCheckBox = By.xpath("//*[@id='black']");
    private final By orderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']//button[text()='Заказать']");
    private final By preCompletePopUpTitle = By.xpath("//div[@class='Order_ModalHeader__3FDaJ' and text()='Хотите оформить заказ?']");
    private final By preCompletePopUpAgreeButton = By.xpath("//div[@class='Order_Modal__YZ-d3'] //button[text()='Да']");
    private final By successMessageFromCompletePopUp = By.xpath("//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");


    /**
     * Метод для проверки тайтла страницы
     */
    public void isMainTitleDisplayed() {
        driver.findElement(mainRentTitle).isDisplayed();
    }

    /**
     * Метод для выбора даты из календаря
     */
    public void selectDate() {
        // Открыть календарь
        WebElement calendarInput = driver.findElement(dateSelectorPlaceholder);
        calendarInput.click();

        // Выбрать дату "10"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dateValue));
        dateElement.click();
    }

    /**
     * Метод для выбра времени суток
     */
    public void selectPartOfDay() {
        WebElement calendarInput = driver.findElement(rentalPeriodPlaceHolder);
        calendarInput.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dayElement = wait.until(ExpectedConditions.visibilityOfElementLocated(rentalPeriod));
        dayElement.click();
    }

    /**
     * Метод для выбора цвета
     */
    public void selectColor() {
        driver.findElement(colorBlackCheckBox).click();
    }

    /**
     * Метод для  заполнения поля комментария
     *
     * @param commentValue аргумент для передачи коментария
     */
    public void fillCommentField(String commentValue) {
        driver.findElement(commentFieldPlaceholder).sendKeys(commentValue);
    }

    /**
     * Метод для нажатия кнопк "Заказать"
     */
    public void clickToOrderButton() {
        driver.findElement(orderButton).click();
    }

    /**
     * Метод для проверки тайтла поп-апа
     */
    public void isPreCompletePopUpTitleDisplayed() {
        driver.findElement(preCompletePopUpTitle).isDisplayed();
    }

    /**
     * Метод для нажатия кнопки "Да" на поп-апе
     */
    public void clickToAgreeButtonOnPreCompletePopUp() {
        driver.findElement(preCompletePopUpAgreeButton).click();
    }

    /**
     * Метод для проверки подтверждения заказ самоката
     */
    public void checkCompleteTitleFormSuccessPopUp(){
        driver.findElement(successMessageFromCompletePopUp).isDisplayed();
    }
}
