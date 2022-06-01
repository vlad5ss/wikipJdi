package main.tests;

import android.steps.WikiS;
import main.WikiTestInit;
import org.testng.annotations.Test;

import static android.utils.UtilsParseJson.getCountryFromJson;
import static android.utils.UtilsRandom.getRandomNaturalInteger;
import static android.wiki.WikiApp.firstPage;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends WikiTestInit implements WikiS {

    @Test
    public void testRandomCitiesTest() {
        wikiSteps.searchText(getCountryFromJson().get(getRandomNaturalInteger(20000)));
        assertThat(firstPage.linearLayout2.isDisplayed()).as("Object exist").isTrue();
    }
}
