package com.cleanCode.domain.enums;

/**
 * Created with IntelliJ IDEA. User: robin Date: 1/15/13 Time: 3:40 PM To change
 * this template use File | Settings | File Templates.
 */
public enum ProgramType {
    INSANITY("Insanity"), P90X("P90X");

    private ProgramType(String displayName) {
        this.displayName = displayName;

    }

    private String displayName;

    public String getDisplayName() {
        return displayName;
    }
}
