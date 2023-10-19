package com.codingblackfemales;

import java.awt.GraphicsEnvironment;
import java.util.Arrays;

public class SystemFonts {
    // get the names of the avaliable font on the system
    public String getFontNames() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontFamilies = ge.getAvailableFontFamilyNames();
        return Arrays.toString(fontFamilies);
    }

    public static void main(String[] args) {

        SystemFonts g = new SystemFonts();
        System.out.println(g.getFontNames());
    }
}
