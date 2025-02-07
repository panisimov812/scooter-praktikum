package Steps;

import pages.RentPage;

public class RentPageSteps {
    RentPage rentPage;

    public RentPageSteps(RentPage rentPage) {
        this.rentPage = rentPage;
    }

    public void checkThatOrderPageIsOpened() {
        rentPage.isMainTitleDisplayed();
    }

    public void selectCalendarDate() {
        rentPage.selectDate();
    }

    public void selectPartOfDay() {
        rentPage.selectPartOfDay();
    }

    public void selectBlackScooterColor() {
        rentPage.selectColor();
    }

    public void fillCommentField(String comment) {
        rentPage.fillCommentField(comment);
    }

    public void clickToOrderButtonForCompleteRent() {
        rentPage.clickToOrderButton();
    }

    public void checkThatPreCompletePopUpIsOpened() {
        rentPage.isPreCompletePopUpTitleDisplayed();
    }

    public void clickToAgreeButtonOnPreCompletePopUp(){
        rentPage.clickToAgreeButtonOnPreCompletePopUp();
    }

   public void checkCompleteScooterOrder(){
        rentPage.checkCompleteTitleFormSuccessPopUp();
   }
}
