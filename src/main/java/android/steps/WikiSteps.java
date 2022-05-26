package android.steps;

import static android.wiki.WikiApp.firstPage;

public class WikiSteps {
    public WikiSteps searchText(String name) {
        firstPage.searchField.click();
        firstPage.searchText.input(name);
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
//        newNameType.select(NameType.BY_NAME);
        firstPage.learningItemContainer.click();
        return this;
    }

    public static String  getTitleText() {
         return firstPage.titleText.getText();
    }
}
