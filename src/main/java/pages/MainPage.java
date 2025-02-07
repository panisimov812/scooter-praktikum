package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.JsHelper;
import java.time.Duration;

public class MainPage {
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    private final WebDriver driver;

    // Локатор
    private final By faqTextLocator = By.xpath("//div[@class='Home_SubHeader__zwi_E' and text()='Вопросы о важном']");
    private final By headerOrderButton = By.xpath("//div[@class='Header_Nav__AGCXC']//button[text()='Заказать']");
    private final By orderButton = By.xpath("//div[@class='Home_FinishButton__1_cWm']//button[text()='Заказать']");
    private final By scooterLogo = By.xpath("//a[contains(@class, 'Header_LogoScooter')]");

    /**
     * Метод для нажатия на кнопку "Заказать" на хедере
     */
    public void clickOrderButton() {
        driver.findElement(headerOrderButton).click();
    }

    /**
     * Метод для нажатия на кнопку "Заказать"
     * В методе используется метод из класса JsHelper, он удаляет куки (по желанию можешь вынести его в отдельный метод)
     * И в дальнейшем в отдельный шаг
     */
    public void clickToSecondOrderButton() {
        JsHelper jsHelper = new JsHelper(driver);
        jsHelper.removeElementByCssSelector(".App_CookieConsent__1yUIN"); // Удаляем баннер cookie
        driver.findElement(orderButton).click();
    }

    /**
     * Метод прокрутки страницы вниз
     */
    public void scrollDown() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
    }

    /**
     * Метод для проверки наличия текста "Вопросы о важном"
     */
    public boolean isFaqTextDisplayed() {
        WebElement element = driver.findElement(faqTextLocator);
        return element.isDisplayed();
    }

    /**
     * Метод проверки списков
     * @param questionLocator
     * @param expectedAnswerText
     * @return
     */
    public boolean verifyFaqAnswer(String questionLocator, String expectedAnswerText) {
        JsHelper jsHelper = new JsHelper(driver);
        jsHelper.removeElementByCssSelector(".App_CookieConsent__1yUIN"); // Удаляем баннер cookie
        // Находим элемент вопроса
        By questionBy = By.xpath(questionLocator);
        WebElement questionElement = driver.findElement(questionBy);

        // Кликаем по вопросу, чтобы раскрыть ответ
        questionElement.click();

        // Ждём, пока ответ станет видимым (если он скрыт)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By answerLocator = By.xpath(questionLocator + "/parent::div/following-sibling::div[@data-accordion-component='AccordionItemPanel']");
        wait.until(ExpectedConditions.elementToBeClickable(questionBy)).click();
        WebElement answerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(answerLocator));

        // Проверяем текст ответа
        return answerElement.isDisplayed() && answerElement.getText().trim().equals(expectedAnswerText);
    }

    public void clickToScooterLogo() {
        driver.findElement(scooterLogo).click();
    }
}