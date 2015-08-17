/****************************************************************************
 * Copyright (C) 2014 GGA Software Services LLC
 *
 * This file may be distributed and/or modified under the terms of the
 * GNU General Public License version 3 as published by the Free Software
 * Foundation.
 *
 * This file is provided AS IS with NO WARRANTY OF ANY KIND, INCLUDING THE
 * WARRANTY OF DESIGN, MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses>.
 ***************************************************************************/
package com.ggasoftware.jdi_ui_tests.core.elements.common;

import com.ggasoftware.jdi_ui_tests.core.elements.interfaces.common.ITextArea;

import static java.lang.String.join;

/**
 * AText Field control implementation
 *
 * @author Alexeenko Yan
 * @author Shubin Konstantin
 * @author Zharov Alexandr
 */
public abstract class ATextArea extends ATextField implements ITextArea {
    // Methods
    public final void inputLines(String... textLines) {
        doJAction("Input several lines of text in textarea", () -> {clearAction(); inputAction(join("\n", textLines));});
    }
    public final void addNewLine(String textLine) {
        doJAction("Add text from new line in textarea", () -> inputAction("\n" + textLine));
    }
    public final String[] getLines() {
        return doJActionResult("Get text as lines", () -> getTextAction().split("\\n"));
    }
}