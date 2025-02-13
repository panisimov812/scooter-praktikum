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
    public void clickOrderButtonFromHeader() {
        mainPage.clickOrderButton();
    }

    /**
     * Нажатие на кнопку "Заказать"
     */
    public void clickOrderButtonAndCloseCookiesPopup() {
        mainPage.clickToSecondOrderButton();
    }

    /**
     * Прокрутка страницы до конца
     */
    public void scrollToBottomOfPage() {
        mainPage.scrollDownToBottom();
    }

    /**
     * Проверка вопросов и ответов
     * @param questionLocator - получает список из которого заберает вопрос
     * @param expectedAnswerText - получает список из которого заберает ответ
     * @return true или false
     */
    public boolean checkFaqAnswerPar(String questionLocator, String expectedAnswerText) {
        return mainPage.verifyFaqAnswer(questionLocator, expectedAnswerText);
    }

    /**
     * Метод для клика на лого
     */
    public void clickOnScooterLogo(){
        mainPage.clickToScooterLogo();
    }

    /**
     * Провека тайтал из FAQ
     */
    public void verifyFaqTextDisplayed(){
        mainPage.isFaqTextDisplayed();
    }

}

