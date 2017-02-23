package src.main;

import java.io.*;

public class OutputPrintManager {
		//manager class that creates the text files with required outputs
	
public static void main(String[] args) throws IOException {
	
		Places testlist = new Places();
		testlist.Places2016Reader();
		testlist.Places2017Reader();
		testlist.SetupHelperSets();
		testlist.writePlacesToFile("DestinationList.txt",testlist.compareDestinationsBoth()+"\n"+
				testlist.compareDestinations2016()+"\n"+testlist.compareDestinations2017());

		
		JourneyList test = new JourneyList();
		test.writeToFileTopLeast("MostLeastExpensiveJourneys.txt");
		test.writeToFileDriversVisit("DriverHistory.txt");
		
	}
	
}
