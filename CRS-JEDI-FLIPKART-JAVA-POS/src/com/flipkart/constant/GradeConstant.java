package com.flipkart.constant;

/**
 * Enum class to represent grade constants.
 */
public enum GradeConstant {
    A(10),
    A_MINUS(9),
    B(8),
    B_MINUS(7),
    C(6),
    C_MINUS(5),
    D(4),
    E(3),
    NOT_GRADED(0);

    final private int value;

    /**
     * Constructor to initialize grade constant with its value.
     *
     * @param value Grade value
     */
    private GradeConstant(int value) {
        this.value = value;
    }

    /**
     * Method to get the integer value associated with the grade.
     *
     * @return Integer value of the grade
     */
    public int hasValue() {
        return this.value;
    }

    /**
     * Overridden toString method to return the name of the enum constant.
     * For grades with "MINUS", returns the grade without "MINUS".
     *
     * @return Name of the enum constant, or grade without "MINUS"
     */
    @Override
    public String toString() {
        final String name = name();
        if (name.contains("MINUS"))
            return name.charAt(0) + "-";
        else
            return name;
    }
}
