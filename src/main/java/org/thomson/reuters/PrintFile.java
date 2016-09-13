/**
 * 
 */
package org.thomson.reuters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringWriter;

/**
 * @author Ramakrishna Gutha
 *
 */
public class PrintFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if (args.length < 1)
		{
			throw new IllegalArgumentException("Invalid input args !!!!");
		}
		
		File file = new File(args[0]);
		if (!file.exists())
		{
			throw new RuntimeException("Input file doesn't exists !!!");
		}
		
		printFileData(file);
	}
	
	public static void printFileData (File file)
	{
		try (BufferedReader reader = new BufferedReader(new FileReader(file)))
		{
			StringWriter writer = new StringWriter();
			
			String line = "";
			while ((line = reader.readLine()) != null)
			{
				writer.write(line);
				writer.write("\n");
			}
			System.out.println(writer.toString());
		}
		catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}
	
}
