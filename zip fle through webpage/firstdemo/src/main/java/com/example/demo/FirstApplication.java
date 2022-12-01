package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import java.io.BufferedInputStream;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.util.zip.ZipEntry;  
import java.util.zip.ZipOutputStream;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstApplication implements CommandLineRunner{
	static final int BUFFER = 1024;  
	public static void main(String[] args) {
		SpringApplication.run(FirstApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("main class running......");
		zipFile();  
	}
	private static void zipFile()  
	  {  
	    ZipOutputStream zos = null;  
	    BufferedInputStream bis = null;  
	    try  
	    {  
	      //path of the file that we want to compress  
	      String fileName = "C:\\Users\\swetha_ketha\\Desktop\\zip folder\\taskfile.txt";  
	      File file = new File(fileName);  
	      FileInputStream fis = new FileInputStream(file);  
	      bis = new BufferedInputStream(fis, BUFFER);        
	      //creating ZipOutputStream  
	      //creates a zip file with the specified name  
	      FileOutputStream fos = new FileOutputStream("C:\\Users\\swetha_ketha\\Desktop\\zip folder\\30-11-22.zip");  
	//ZipOutputStream writes data to an output stream in zip format  
	      zos = new ZipOutputStream(fos);                       
	      // ZipEntry, here file name can be created using the source file  
	      ZipEntry ze = new ZipEntry(file.getName());  
	      //putting zipentry in zipoutputstream  
	      zos.putNextEntry(ze);  
	      byte data[] = new byte[BUFFER];  
	      int count;  
	      while((count = bis.read(data, 0, BUFFER)) != -1)   
	      {  
	        zos.write(data, 0, count);  
	      }  
	    }  
	    catch(IOException ioExp)  
	    {  
	      System.out.println("Error while zipping " + ioExp.getMessage());  
	    }
	    try  
		{  
		//constructor of file class having file as argument  
		File file=new File("C:\\Users\\swetha_ketha\\Desktop\\zip folder\\taskfile.txt");   
		FileInputStream fis=new FileInputStream(file);     //opens a connection to an actual file  
		System.out.println("file content: ");  
		int r=0;  
		while((r=fis.read())!=-1)  
		{  
		System.out.print((char)r);      //prints the content of the file  
		}  
		}  
		catch(Exception e)  
		{  
		e.printStackTrace();  
		}
	    
	    finally  
	    {  
	      if(zos != null)  
	      {  
	        try   
	        {  
	            //closing output stream  
	          zos.close();  
	        }   
	        catch (IOException e)   
	        {  
	          e.printStackTrace();  
	        }  
	      }  
	      if(bis != null)  
	      {  
	        try   
	        {  
	            //closing buffered input stream  
	          bis.close();  
	        }   
	        catch (IOException e)   
	        {  
	        //prints exception  
	          e.printStackTrace();  
	        }  
	      }  
	    }
	  }
}
