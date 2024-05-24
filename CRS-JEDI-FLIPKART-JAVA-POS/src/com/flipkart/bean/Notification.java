/**
 * 
 */
package com.flipkart.bean;



import com.flipkart.constant.NotificationTypeConstant;


//GLOBAL VAR

public class Notification 
{
	private int notiID;
	private int stdID;
	private NotificationTypeConstant type;
	private String referID;
	

	public int getNotiID() 
	{
		return notiID;
	}

	public void setNotiID(int notiID) 
	{
		this.notiID = notiID;
	}

	public int getStdID() 
	{
		return stdID;
	}

	public void setStdID(int stdID)
	{
		this.stdID = stdID;
	}

	public NotificationTypeConstant getType() 
	{
		return type;
	}

	public void setType(NotificationTypeConstant type) 
	{
		this.type = type;
	}

	public String getReferID() 
	{
		return referID;
	}

	public void setReferID(String referID) 
	{
		this.referID = referID;
	}
	
	
}
