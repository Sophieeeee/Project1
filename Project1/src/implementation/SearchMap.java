package implementation;

import java.io.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;



public class SearchMap {
	/**
	 * Returns string without white spaces
	 * <p>
	 * @param  str  a string that you want to remove white spaces
	 * @return      the input string without white spaces
	 */
	public static String removeWhiteSpace(String str){
		str = str.replaceAll("\\s","");
        return str;
	}
	
	public static void main(String[] args) throws FileNotFoundException{

		File file = new File(args[0]);
		File outputFile = new File(args[1]);
		ArrayList<String> routeCostList = new ArrayList<String>();
		
		Scanner scanner = new Scanner(file);
		String originCity = scanner.nextLine();
		
		PrintWriter output = new PrintWriter(outputFile);
		
		while(scanner.hasNextLine()){
			String routeCost = removeWhiteSpace(scanner.nextLine());
			if(routeCost.length() != 0){
				routeCostList.add(routeCost.toUpperCase());
			}
		}
		
		
		FlightMap flightmap = new FlightMap(originCity, routeCostList);
		flightmap.setUpMap();
		Map<String, Integer> testMap = flightmap.getPriceMap();
		
		
		output.println("Destination		Flight Route from " + originCity + "		Total Cost");
		
		
			Iterator<Entry<String, Integer>> it1 = testMap.entrySet().iterator();
			Iterator<Entry<String, String>> it2 = flightmap.getRouteMap().entrySet().iterator();
			while(it1.hasNext() || it2.hasNext()){
				Map.Entry pair1 = (Map.Entry)it1.next();
				Map.Entry pair2 = (Map.Entry)it2.next();
				
				
		        output.println(pair1.getKey() + "			" + pair2.getValue() + "				" + pair1.getValue());
			}
		
		output.close();
	}
}

