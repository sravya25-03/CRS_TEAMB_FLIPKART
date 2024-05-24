package com.flipkart.constant;



public enum PaymentModeConstant {
	
	CARD_PAYMENT,NET_BANKING, OFFLINE;
	

	public static PaymentModeConstant getPaymentMode(int value)
	{
		switch(value)
		{
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