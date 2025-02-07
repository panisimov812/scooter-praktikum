package Steps;

import pages.MainPage;


public class MainPageSteps {
    MainPage mainPage;

    public MainPageSteps(MainPage mainPage) {
        this.mainPage = mainPage;
    }

    /**
     * Нажатие на кнопку "Заказать" через хедер
     */
    public void clickToOrderButtonByHeader() {
        mainPage.clickOrderButton();
    }

    /**
     * Нажатие на кнопку "Заказать"
     */
    public void clickToOrderButtonWithRemoveCookiesPopUp() {
        mainPage.clickToSecondOrderButton();
    }

    /**
     * Проверка отображения текста "Вопросы о важном"
     */
    public void checkFaqTextIsDisplayed() {
        mainPage.isFaqTextDisplayed();
    }

    public void scrollPageDown() {
        mainPage.scrollDown();
    }

    public boolean checkFaqAnswerPar(String questionLocator, String expectedAnswerText) {
        return mainPage.verifyFaqAnswer(questionLocator, expectedAnswerText);
    }



}

