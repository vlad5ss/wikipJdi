package main.tests;


import android.steps.WikiS;
import android.steps.WikiSteps;
import com.epam.jdi.light.mobile.elements.common.MobileDevice;
import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import com.jdiai.tools.Timer;
import main.WikiTestInit;
import org.openqa.selenium.ScreenOrientation;
import org.testng.Assert;
import org.testng.annotations.Test;

import static android.wiki.WikiApp.firstPage;
import static org.assertj.core.api.Assertions.assertThat;

public class MainTests extends WikiTestInit implements WikiS {

    private final String JAVA = "Java";
    private final String APPIUM = "Appium";
    private final String LINKIN_PARK = "Linkin Park Discography";
    private final String LEARNING_PROGRAMM = "Learning programming";
    private final String SEARCH_WIKIPEDIA = "Search Wikipedia";
    private final String JAVA_LANGUAGE = "Java (programming language)";

    @Test
    public void searchTest() {
        wikiSteps.searchText(JAVA);
        assertThat(firstPage.searchJavaItem.getText()).as("Java object").contains("Object-oriented programming language");
    }

    @Test
    public void testCancelSearchTest() {
        wikiSteps.searchText(JAVA);
        firstPage.clearSearch.clear();
        firstPage.closeBtn.click();
        assertThat(firstPage.closeBtn.isDisplayed()).as("Close button displayed").isFalse();
    }

    @Test
    public void testCompareArticleTitleTest() {
        wikiSteps.searchText(JAVA);
        firstPage.searchJavaItem.click();
        assertThat(firstPage.titleText.getText()).as("Java object").contains(JAVA_LANGUAGE);
    }

    @Test
    public void testScrollArticleTest() {
        wikiSteps.searchText(APPIUM);
        firstPage.searchAppiumItem.click();
        firstPage.titleText.isDisplayed();
        MobileScreen.scrollDown(300);
    }

    @Test
    public void testComparePlaceholderWikiTest() {
        assertThat(firstPage.searchField.getText()).as("Search Wikipedia").isEqualTo(SEARCH_WIKIPEDIA);
    }

    @Test
    public void testClearSearchTest() {
        wikiSteps.searchText(JAVA);
        firstPage.listResult.get(1).isDisplayed();
        firstPage.closeBtn.click();
        assertThat(firstPage.listResult.get(1).isDisplayed()).isFalse();
    }

    @Test
    public void saveFirstArticleToMyListTest() {
        wikiSteps.searchText(JAVA);
        wikiSteps.saveArticleWiki(LEARNING_PROGRAMM);
        assertThat(firstPage.learningItemText.getText()).isEqualTo(JAVA_LANGUAGE);
    }

    @Test
    public void testAmountOfNotEmptySearchTest() {
        wikiSteps.searchText(LINKIN_PARK);
        firstPage.listResult.get(1).isDisplayed();
        assertThat(firstPage.listResult.size() > 0).isTrue();
    }

    @Test
    public void testChangeScreenOrientationOnSearchResults() {
        wikiSteps.searchText(JAVA);
        firstPage.searchJavaItem.click();
        String title_before_rotation = WikiSteps.getTitleText();
        MobileDevice.rotate(ScreenOrientation.LANDSCAPE);
        new Timer(5000L).wait(() -> firstPage.titleText.isDisplayed());
        String title_after_rotation = WikiSteps.getTitleText();
        Assert.assertEquals("Article title have been changed after screen rotation", title_before_rotation, title_after_rotation);
        MobileDevice.rotate(ScreenOrientation.PORTRAIT);
        new Timer(5000L).wait(() -> firstPage.titleText.isDisplayed());
        String second_after_rotation = WikiSteps.getTitleText();
        Assert.assertEquals("Article title have been changed after screen rotation", title_after_rotation, second_after_rotation);
    }

}


