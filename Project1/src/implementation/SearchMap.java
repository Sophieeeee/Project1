package implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
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
		output.println("Output test");
		output.println(originCity);
		
		while(scanner.hasNextLine()){
			String routeCost = removeWhiteSpace(scanner.nextLine());
			if(routeCost.length() != 0){
				routeCostList.add(routeCost.toUpperCase());
			}
		}
		
		output.println("before: " + routeCostList);
		
		FlightMap flightmap = new FlightMap(originCity, routeCostList);
		flightmap.setUpMap();
		Map<String, Integer> testMap = flightmap.getPriceMap();
		
		
		
		
		output.println("after: " + routeCostList);
		for (String key : testMap.keySet()) {
			   
			   output.println("key: " + key + " value: " + testMap.get(key));
			}
		for (String key : flightmap.getRouteMap().keySet()) {
			   
			   output.println("key: " + key + " value: " + flightmap.getRouteMap().get(key));
			}
		output.close();
	}
}

