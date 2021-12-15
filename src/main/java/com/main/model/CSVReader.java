package com.main.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * @author ACER
 *	class to read CSV file , takes file path and returns string array with rows and columns data
 */
public class CSVReader implements FileReaderInterface {
	
	private String[][] elements;
	private String filePath;
	private static final String delimeter = ",";
	
	
	/**
	 * default constructor 
	 */
	public CSVReader() {
	}

	/**
	 * @param in filePath constructor creating csv reader object
	 */
	public CSVReader(String filePath) {
		super();
		this.filePath = filePath;
	}

	/**
	 * @return it returns string array containing column and row data of csv file
	 */
	public String[][] getElements() {
		if(filePath.isEmpty()) {
			return null;
		}
		else {
			readFileDataToArray();
		}
		return elements;
	}

	/**
	 * @param in elements sets the string array caontaining column and row data of csv file
	 */
	public void setElements(String[][] elements) {
		this.elements = elements;
	}

	/**
	 * @return it return file path
	 */
	public String getFilePath() {
		return filePath;
	}
	
	
	/**
	 * @param in filePath takes the file path as a input and assign to property
	 */
	@Override
	public void setFilePath(String filePath) {
		this.filePath = filePath;
		
	}

	/**
	 * reads the CSV file and updates value in string array elements
	 */
	private void readFileDataToArray() {		
		try   
		{  
			BufferedReader br = new BufferedReader(new FileReader(this.filePath));  
			String line;
			ArrayList<String> s1 = new ArrayList<>();
			int count =0;
			while ((line = br.readLine()) != null)  
			{  
				s1.add(line.toLowerCase());
			}
			elements = new String[s1.get(0).length()][s1.size()];
			for (String string : s1) {
				elements[count] = string.split(delimeter);				 
				count++;
			}
			br.close();
		}   
		catch (IOException e)   
		{  
			System.out.println("File not found");
		} 		
	}

}
