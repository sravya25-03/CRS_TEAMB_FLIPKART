package com.flipkart.constant;

/**
 * Enum class to represent role constants.
 */
public enum RoleConstant {
    ADMIN,
    PROFESSOR,
    STUDENT;

    /**
     * Method to convert a string representation of a role to its corresponding RoleConstant.
     *
     * @param role String representation of the role
     * @return RoleConstant corresponding to the provided role string, or null if the string is not recognized
     */
    public static RoleConstant stringToName(String role) {
        RoleConstant userRole = null;

        if (role.equalsIgnoreCase("ADMIN"))
            userRole = RoleConstant.ADMIN;
        else if (role.equalsIgnoreCase("PROFESSOR"))
            userRole = RoleConstant.PROFESSOR;
        else if (role.equalsIgnoreCase("STUDENT"))
            userRole = RoleConstant.STUDENT;

        return userRole;
    }
}
