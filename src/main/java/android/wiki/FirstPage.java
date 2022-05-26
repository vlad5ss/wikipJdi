package android.wiki;

import com.epam.jdi.light.mobile.elements.common.Button;
import com.epam.jdi.light.mobile.elements.common.Text;
import com.epam.jdi.light.mobile.elements.common.app.android.TextField;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

import java.util.List;

public class FirstPage {

    @MobileFindBy(xpath = "//*[contains(@text, 'Search Wikipedia')]")
    public static Button searchField;

    @MobileFindBy(xpath = "//*[contains(@text, 'Search…')]")
    public static TextField searchText;

    @MobileFindBy(xpath = "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']")
    public static Button searchJavaItem;

    @MobileFindBy(xpath = "//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='Appium']")
    public static Button searchAppiumItem;

    @MobileFindBy(id = "org.wikipedia:id/view_page_title_text")
    public static TextField titleText;

    @MobileFindBy(id = "org.wikipedia:id/search_container")
    public static Button searchWiki;

    @MobileFindBy(id = "org.wikipedia:id/search_src_text")
    public static TextField clearSearch;

    @MobileFindBy(id = "org.wikipedia:id/search_close_btn")
    public static Button closeBtn;

    @MobileFindBy(xpath = "//android.view.View[@content-desc=\"References\"]")
    public static Text referencesText;

    @MobileFindBy(xpath = "  org.wikipedia:id/search_results_list")
    public static List<TextField> listResult;

    @MobileFindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    public static Button imageViewBtn;

    @MobileFindBy(xpath = "//*[@text='Add to reading list']")
    public static Button addToReading;

    @MobileFindBy(id = "org.wikipedia:id/onboarding_button")
    public static Button onboardingBtn;

    @MobileFindBy(id = "org.wikipedia:id/text_input")
    public static TextField txtInput;

    @MobileFindBy(xpath = "//*[@text='OK']")
    public static Button okButton;

    @MobileFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    public static Button navigateUp;

    @MobileFindBy(xpath = "//android.widget.FrameLayout[@content-desc='My lists']")
    public static Button myLists;

    @MobileFindBy(id = "org.wikipedia:id/item_title")
    public static Button learningItem;

    @MobileFindBy(id = "org.wikipedia:id/item_container")
    public static Button learningItemContainer;

    @MobileFindBy(xpath = "//*[@text='Java (programming language)']")
    public static TextField learningItemText;

}
