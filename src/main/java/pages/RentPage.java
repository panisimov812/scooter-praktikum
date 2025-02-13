package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RentPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Локаторы
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

    // Конструктор класса
    public RentPage(WebDriver driver) {
        this.driver = driver;
        // Инициализируем WebDriverWait с таймаутом для всех элементов
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Метод для проверки тайтла страницы
     */
    public boolean isMainTitleDisplayed() {
        return driver.findElement(mainRentTitle).isDisplayed();
    }

    /**
     * Метод для выбора даты из календаря
     */
    public void selectDate() {
        // Открыть календарь и выбрать дату
        WebElement calendarInput = driver.findElement(dateSelectorPlaceholder);
        calendarInput.click();
        WebElement dateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dateValue));
        dateElement.click();
    }

    /**
     * Метод для выбора времени суток
     */
    public void selectPartOfDay() {
        WebElement calendarInput = driver.findElement(rentalPeriodPlaceHolder);
        calendarInput.click();
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
     * Метод для заполнения поля комментария
     *
     * @param commentValue аргумент для передачи комментария
     */
    public void fillCommentField(String commentValue) {
        driver.findElement(commentFieldPlaceholder).sendKeys(commentValue);
    }

    /**
     * Метод для нажатия кнопки "Заказать"
     */
    public void clickToOrderButton() {
        driver.findElement(orderButton).click();
    }

    /**
     * Метод для проверки тайтла поп-апа
     */
    public boolean isPreCompletePopUpTitleDisplayed() {
        return driver.findElement(preCompletePopUpTitle).isDisplayed();
    }

    /**
     * Метод для нажатия кнопки "Да" на поп-апе
     */
    public void clickToAgreeButtonOnPreCompletePopUp() {
        driver.findElement(preCompletePopUpAgreeButton).click();
    }

    /**
     * Метод для проверки подтверждения заказа самоката
     */
    public boolean checkCompleteTitleFormSuccessPopUp() {
        return driver.findElement(successMessageFromCompletePopUp).isDisplayed();
    }
}