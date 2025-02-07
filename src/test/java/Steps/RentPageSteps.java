package Steps;

import pages.RentPage;

public class RentPageSteps {
    RentPage rentPage;

    public RentPageSteps(RentPage rentPage) {
        this.rentPage = rentPage;
    }

    public void verifyRentPageIsOpened() {
        rentPage.isMainTitleDisplayed();
    }

    public void selectDateFromCalendar() {
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

    public void clickOrderButtonToCompleteRent() {
        rentPage.clickToOrderButton();
    }

    public void verifyPreCompletePopUpIsOpened() {
        rentPage.isPreCompletePopUpTitleDisplayed();
    }

    public void clickAgreeButtonOnPreCompletePopUp(){
        rentPage.clickToAgreeButtonOnPreCompletePopUp();
    }

   public void verifyCompleteScooterOrder(){
        rentPage.checkCompleteTitleFormSuccessPopUp();
   }
}
