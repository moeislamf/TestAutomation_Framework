package coreClasses;

import java.io.IOException;
import java.util.Properties;

public class textingProperties extends Properties{

	private static textingProperties props = null;

	private textingProperties() throws IOException
	{
		load(getClass().getResourceAsStream("/textingPro.properties"));
	}

	public static synchronized textingProperties getInstance() throws IOException
	{
		if (props == null)
		{
			props = new textingProperties();
		}
		return props;
	}
	
	
}
