package src.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ValidDestinations {
	
	private String name;
	private double miles;
	
	// This class creates a basic valid destination class that has getter methods for distance and the name of the destination
	// as well as a simple constructor to make it
	public ValidDestinations(String name, double miles)
	{
		this.name = name;
		this.miles = miles;
	}
	
	public String getDest() {
		return name;
	}
	
	public double getDist() {
		return miles;
	}

	/**
     * This constructor creates an ArrayList of ValidDestinations objects and populates it with the entries present in destinations.txt
     */ 
	public ArrayList<ValidDestinations> ValidDestList() {
			// Creates a new ArrayList<ValidDestinations> object
		ArrayList<ValidDestinations> entries = new ArrayList<ValidDestinations>();
			// Creates a buffered reader to read a file, and a String[] object to split the inputlines into its proper fields
			BufferedReader buff = null;
			String data [] = new String[2];
			try {
				// The buffered reader reads the destinations.txt file
				buff = new BufferedReader(new FileReader("destinations.txt"));
		    	String inputLine = buff.readLine();  //read first line
		    	while(inputLine != null && inputLine.isEmpty() != true){  
		    		// Splits the input line at every ";" character, replaces the second half of the string (which is fomatted
		    		// as "31.0 miles") with nothing so it can be parsed as a double and passed to a new valid destinations object
		    		data = inputLine.split(";");
		    		String milesraw = data[1].replaceAll("miles", "");
		    		double miles = Double.parseDouble(milesraw.trim());
		    		ValidDestinations d = new ValidDestinations(data[0],miles);
		    		// Adds the new ValidDestinations object to the ArrayList
		            entries.add(d);
		            // Reads next line
		            inputLine = buff.readLine();
		    	}
		    }
			// Catches any erros that could come from reading files
			catch(FileNotFoundException e) {
		        	System.out.println(e.getMessage());
		            System.exit(1);
		        }
		    catch (IOException e) {
		        	e.printStackTrace();
		            System.exit(1);        	
		        }
			// Tries to close all files
			finally  {
	        	try{
	        		buff.close();
	        	}
	        	catch (IOException ioe) {
	        		//don't do anything
	        	}
			}
			return entries;
		}
	
	/**
	 * This main method acts as a tester for ValidDestReader and is not meant to be run by the final product
	 */
	public static void main(String arg[])
	{
		ValidDestinations test = new ValidDestinations("Tester", 1.0);
		ArrayList<ValidDestinations> catcher = test.ValidDestList();
		for (int i = 0; i < catcher.size(); i++){
			System.out.println(catcher.get(i).getDest() + " ; " + catcher.get(i).getDist());
		}
		
	}
}