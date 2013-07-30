package edu.rogers.criminalintent;

import java.util.UUID;

public class Crime
{
	//Unique ID assigned to each crime
	private UUID mID;
	
	//title of the crime (supplied by the user)
	private String mTitle;
	
	public Crime()
	{
		//randomly generate a unique identifier
		mID = UUID.randomUUID();
	}

	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public UUID getmID() {
		return mID;
	}
}
