package com.flipkart.constant;

/**
 * Enum class to represent gender constants.
 */
public enum GenderConstant {
    MALE(1), FEMALE(2), OTHER(3);

    private final int gender;

    /**
     * Constructor to initialize gender constant.
     *
     * @param gender Gender value
     */
    private GenderConstant(int gender) {
        this.gender = gender;
    }

    /**
     * Overridden toString method to return the name of the enum constant.
     *
     * @return Name of the enum constant
     */
    @Override
    public String toString() {
        return name();
    }

    /**
     * Method to get the GenderConstant enum value based on the integer value.
     *
     * @param val Integer value representing gender
     * @return Corresponding GenderConstant enum value
     */
    public static GenderConstant getName(int val) {
        GenderConstant gender = GenderConstant.OTHER;
        switch (val) {
            case 1:
                gender = GenderConstant.MALE;
                break;
            case 2:
                gender = GenderConstant.FEMALE;
                break;
        }
        return gender;
    }

    /**
     * Method to convert a string to GenderConstant enum value.
     *
     * @param val String representing gender
     * @return Corresponding GenderConstant enum value
     */
    public static GenderConstant stringToGender(String val) {
        GenderConstant gender = GenderConstant.OTHER;
        if (val.equalsIgnoreCase("male"))
            gender = GenderConstant.MALE;
        else if (val.equalsIgnoreCase("female"))
            gender = GenderConstant.FEMALE;
        else if (val.equalsIgnoreCase("other"))
            gender = GenderConstant.OTHER;

        return gender;
    }
}
