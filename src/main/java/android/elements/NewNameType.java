package android.elements;

import com.epam.jdi.light.elements.composite.Section;

public class NewNameType extends Section {

    private static final String NAME_VALUE = "//*[@text='%s')]";

    public void select(NameType value) {
        click(NAME_VALUE, value.value);
    }

    private void click(String locator, String value) {
        this.find(String.format(locator, value)).click();
    }
}
