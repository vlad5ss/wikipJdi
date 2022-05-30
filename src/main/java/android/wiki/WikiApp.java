package android.wiki;

import android.elements.NewNameType;
import android.pages.FirstPage;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.JApp;


@JApp(appPackage = "org.wikipedia", appActivity = ".main.MainActivity")
public class WikiApp {

    public static FirstPage firstPage;

    public static NewNameType newNameType;

}
