package android.steps;

import com.jdiai.tools.Timer;
import io.qameta.allure.Step;

import static android.wiki.WikiApp.firstPage;

public class WikiSteps {
    public WikiSteps searchText(String name) {
        firstPage.searchField.click();
        firstPage.searchText.input(name);
        new Timer(5000L).wait(() -> firstPage.linearLayout.isDisplayed());
        return this;
    }

    public WikiSteps saveArticleWiki(String name) {
        firstPage.searchJavaItem.click();
        firstPage.titleText.isDisplayed();
        firstPage.imageViewBtn.click();
        firstPage.addToReading.click();
        firstPage.onboardingBtn.click();
        firstPage.txtInput.clear();
        firstPage.txtInput.input(name);
        firstPage.okButton.click();
        firstPage.navigateUp.click();
        firstPage.myLists.click();
        firstPage.learningItemContainer.click();
        return this;
    }

    public static String getTitleText() {
        return firstPage.titleText.getText();
    }

    @Step("Clear and close button")
    public void clearAndCloseBtn() {
        firstPage.clearSearch.clear();
        firstPage.closeBtn.click();
    }

    @Step("SearchJava item click")
    public void searchJavaItemClick() {
        firstPage.searchJavaItem.click();
    }

    @Step("SearchAppium item click")
    public void searchAppiumItemClick() {
        firstPage.searchAppiumItem.click();
        new Timer(5000L).wait(() -> firstPage.titleText.isDisplayed());
    }

    @Step("Close btn")
    public void closeBtnclose() {
        new Timer(5000L).wait(() -> firstPage.listResult.get(1).isDisplayed());
        firstPage.closeBtn.click();
    }

    @Step("timer for display results")
    public void timerDispalyResults() {
        new Timer(5000L).wait(() -> firstPage.listResult.get(1).isDisplayed());
    }

    @Step("Timer for display title")
    public void timerDispalyTitle() {
        new Timer(5000L).wait(() -> firstPage.titleText.isDisplayed());
    }
}
