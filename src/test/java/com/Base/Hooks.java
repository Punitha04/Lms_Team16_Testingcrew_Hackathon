package com.Base;

import io.cucumber.java.After;

public class Hooks extends BaseClass
{
	@After
	public void quit()
	{
		driver.quit();
	}

}

