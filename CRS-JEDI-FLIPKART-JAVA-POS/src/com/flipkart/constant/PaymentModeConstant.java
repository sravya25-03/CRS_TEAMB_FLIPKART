package com.flipkart.constant;

/**
 * Enum class to represent payment mode constants.
 */
public enum PaymentModeConstant {
    CARD_PAYMENT,
    NET_BANKING,
    OFFLINE;

    /**
     * Method to get the payment mode based on the integer value provided.
     *
     * @param value Integer value representing the payment mode
     * @return PaymentModeConstant corresponding to the provided value, or null if value is invalid
     */
    public static PaymentModeConstant getPaymentMode(int value) {
        switch (value) {
            case 1:
                return PaymentModeConstant.CARD_PAYMENT;
            case 2:
                return PaymentModeConstant.NET_BANKING;
            case 3:
                return PaymentModeConstant.OFFLINE;
            default:
                return null;
        }
    }
}
