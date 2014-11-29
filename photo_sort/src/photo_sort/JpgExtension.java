package photo_sort;

import java.io.File;
import java.io.FilenameFilter;

public class JpgExtension implements FilenameFilter  {

	String extension;
	
	JpgExtension(String ext)
	{
	this.extension="."+ext;
	}
	
	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(extension); 
	}

}


