package com.ggasoftware.jdi_ui_tests.core.elements.complex;

import com.ggasoftware.jdi_ui_tests.core.elements.base.ASelectElement;
import com.ggasoftware.jdi_ui_tests.core.elements.interfaces.base.ISelector;

import java.util.List;

import static com.ggasoftware.jdi_ui_tests.utils.common.EnumUtils.getEnumValue;
import static com.ggasoftware.jdi_ui_tests.utils.common.LinqUtils.first;
import static java.lang.String.format;

/**
 * Created by roman.i on 03.10.2014.
 */

public abstract class ASelector<TEnum extends Enum> extends BaseSelector<TEnum> implements ISelector<TEnum> {
    // Actions
    protected String getValueAction() { return isSelected(); }

    // Methods
    public final void select(String name) { doJAction(format("Select '%s'", name), () -> setValueRule(name, this::selectAction)); }
    public final void select(TEnum name) { select(getEnumValue(name)); }
    public final void select(int index) {
        doJAction(format("Select '%s'", index), () -> selectByIndexAction(index)); }
    public final String isSelected() {
        return doJActionResult("Is Selected", () -> {
            List<ASelectElement> elements = getElementsList();
            if (elements == null) return null;
            ASelectElement selectedElement = first(elements, ASelectElement::isSelected);
            return (selectedElement != null) ? selectedElement.getText() : null;
        });
    }
    public final boolean waitSelected(TEnum name) { return waitSelected(getEnumValue(name)); }
    public final boolean waitSelected(String name) {
        return doJActionResult(format("Wait is '%s' selected", name), () -> waitSelectedAction(name));
    }
    public final String getValue() { return doJActionResult("Get value", this::getValueAction); }
}