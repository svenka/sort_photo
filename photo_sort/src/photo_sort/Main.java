package photo_sort;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

	public static void showlistfiles(String s[])
	{
		if(s.length==0)
		{
			System.out.println("These files do not exist");
			System.exit(0);
		}
		else
			
	    System.out.println("All Amout="+s.length);
		for (int i=0; i < s.length; i++) 
		{ 
		System.out.println(s[i]); 
		} 	
	}
	
	
		
	public static void copy(File source, File dest) throws IOException {
	       Files.copy(source.toPath(), dest.toPath());
	   }
	
	
	
	public static void working(String s[],String dirname) throws IOException
	{
		
		for (int i=0; i < s.length; i++) { 
			String way=dirname+"/"+s[i];
			File source = new File(way);
		    Path p = source.toPath();
		    BasicFileAttributes attr = Files.readAttributes(p, BasicFileAttributes.class);
		    String t=attr.lastModifiedTime().toString();
		    String date=(String) t.subSequence(0, 10);
		    String c=way.substring(0, way.length()-13)+"/"+date;
		    File datepath=new File(c);
		        
		    try
		    {
		    File dest = new File(dirname+"/"+date+"/"+s[i]);
		    dest.getParentFile().mkdir();
		    
		    if (dest.exists())
		    {
			System.out.println("File has been created");
			
			}
			else
			System.out.println("File won't created");
		    datepath.mkdir();
		    datepath.mkdirs();
		    copy(source, dest);
		    }
		        
		   catch(FileAlreadyExistsException e)
		    {
		    System.out.println("File has already been created ="+e);
		    }
		    }
		 System.exit(0);
		
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		
		Gui m=new Gui();
		String dirname=m.getway();
		File f1 = new File(dirname); 
		FilenameFilter only = new JpgExtension("JPG"); 
		String s[] = f1.list(only); 
		showlistfiles(s);
		working(s,dirname);
		
	/*	for (int i=0; i < s.length; i++) { 
		String way=dirname+"/"+s[i];
		File source = new File(way);
	    Path p = source.toPath();
	    System.out.println("Dir="+p);
	    BasicFileAttributes attr = Files.readAttributes(p, BasicFileAttributes.class);
	    String t=attr.lastModifiedTime().toString();
	    String date=(String) t.subSequence(0, 10);
	    System.out.println(date);
	    String c=way.substring(0, way.length()-13)+"/"+date;
	    System.out.println(c);
	    File datepath=new File(c);
	        
	    try
	    {
	    File dest = new File(dirname+"/"+date+"/"+s[i]);
	    dest.getParentFile().mkdir();
	    
	    if (dest.exists())
		{System.out.println("файл создан");}
	    
	    else
		System.out.println("файл не создан");
	
	    datepath.mkdir();
	    datepath.mkdirs();
	 
        copy(source, dest);
      
	    }
	        
	    catch(FileAlreadyExistsException e)
	    {
	    System.out.println("файл уже создан="+e);
	    }
	 
	   
	    
			
		}*/
	
	}
	
	}
