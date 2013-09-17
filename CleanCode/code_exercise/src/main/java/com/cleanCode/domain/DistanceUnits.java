package com.cleanCode.domain;

/**
 * Created with IntelliJ IDEA.
 * User: robin
 * Date: 18/8/13
 * Time: 3:58 PM
 * To change this template use File | Settings | File Templates.
 */
public enum DistanceUnits {
    KILOMETERS("km"), MILES("mi");

    private static final double KMS_TO_MILES_FACTOR = 1.609344;

    public static double convertToMilesFromKms(double distance) {
        return distance/ KMS_TO_MILES_FACTOR;
    }

    private DistanceUnits(String symbol) {
        this.symbol = symbol;
    }

    private String symbol;

    public String getSymbol() {
        return symbol;
    }
}
