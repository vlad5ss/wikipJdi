package main.tests;

import android.steps.WikiS;
import main.WikiTestInit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static android.utils.UtilsParseJson.getCountryFromJson;
import static android.utils.UtilsRandom.getRandomNaturalInteger;
import static android.wiki.WikiApp.firstPage;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends WikiTestInit implements WikiS {

    @Test
    public void testRandomCitiesTest() {
        wikiSteps.searchText(getCountryFromJson().get(getRandomNaturalInteger(20000)));
        assertThat(firstPage.dataLayout.isDisplayed()).as("Object exist").isTrue();
    }

    @Test
    public void testAllCities() {
        SoftAssert softAssert = new SoftAssert();
        List<String> data = getCountryFromJson();
        for (int i = 0; i < data.size()-1; i++) {
            wikiSteps.searchText(getCountryFromJson().get(i));
            softAssert.assertTrue(firstPage.dataLayout.isDisplayed(), "Data Exist");
        }
        softAssert.assertAll();
    }

}
