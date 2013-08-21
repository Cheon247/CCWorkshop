/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Simple class to retrieve the right numberformat for files.
 * example: smd files need specific numberformat
 * @author Chingo
 */
public final class CCNumberFormatter {
    /** Number length for smd files. **/
    private static final int SMD_FILE_NUMBER_LENGTH = 6;
    /**
     * Constructor.
     */
    private CCNumberFormatter() {
    }
    /**
     * Formats the number for smd files.
     * @param number the number to format
     * @return the formatted number for smd files
     */
    public static String smdformat(final Number number) {
        NumberFormat format = DecimalFormat.getInstance();
        format.setRoundingMode(RoundingMode.FLOOR);
        format.setMinimumFractionDigits(SMD_FILE_NUMBER_LENGTH);
        format.setMaximumFractionDigits(SMD_FILE_NUMBER_LENGTH);
        String s;
        s = format.format(number);
        return s.replaceAll(",", ".");
    }
}
