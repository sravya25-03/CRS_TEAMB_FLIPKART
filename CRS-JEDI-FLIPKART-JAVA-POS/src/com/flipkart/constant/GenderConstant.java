package com.flipkart.constant;


public enum GenderConstant {
	MALE(1),FEMALE(2),OTHER(3);
	private final int gender;
	

	private GenderConstant(int gender)
	{
		this.gender=gender;
	}

	@Override
	public String toString()
	{
		final String name=name();
		return name; 
	}
	
	public static GenderConstant getName(int val)
	{
		GenderConstant gender=GenderConstant.OTHER;
		switch(val)
		{
		case 1:
			gender=GenderConstant.MALE;
			break;
		case 2:
			gender=GenderConstant.FEMALE;
			break;
			
		}
		return gender;
	}

	public static GenderConstant stringToGender(String val)
	{
		GenderConstant gender=GenderConstant.OTHER;
		if(val.equalsIgnoreCase("male"))
			gender=GenderConstant.MALE;
		else if(val.equalsIgnoreCase("female"))
			gender=GenderConstant.FEMALE;
		else if(val.equalsIgnoreCase("other"))
			gender=GenderConstant.OTHER;
		
		return gender;
	}
	
}