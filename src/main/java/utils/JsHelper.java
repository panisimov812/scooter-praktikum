package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JsHelper {
    public JsHelper(WebDriver driver) {
        this.driver = driver;
    }
    private final WebDriver driver;

    /**
     * Удаляет элемент с помощью JavaScript по переданному селектору.
     *
     * @param cssSelector CSS-селектор элемента, который нужно удалить.
     */
    public void removeElementByCssSelector(String cssSelector) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String script = "var element = document.querySelector(arguments[0]);" +
                    "if (element) { element.remove(); }";
            js.executeScript(script, cssSelector);
            System.out.println("Элемент с селектором '" + cssSelector + "' успешно удален.");
        } catch (Exception e) {
            System.err.println("Не удалось удалить элемент: " + e.getMessage());
        }
    }
}
