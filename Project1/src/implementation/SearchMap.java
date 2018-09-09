package implementation;
import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner; 

public class SearchMap {
	public static String removeWhiteSpace(String str){
		str = str.replaceAll("\\s","");
        return str;
	}
	public static void main(String[] args) throws FileNotFoundException{
		System.out.println("Hello, ant working");
		File file = new File("test.txt");
		File outputFile = new File("output.txt");
		ArrayList<String> routeCostList = new ArrayList<String>();
		
		Scanner scanner = new Scanner(file);
		String originCity = scanner.nextLine();
			
		while(scanner.hasNextLine()){
			String routeCost = removeWhiteSpace(scanner.nextLine());
			routeCostList.add(routeCost);
		}
		
		FlightMap flightmap = new FlightMap(originCity, routeCostList);
		Map<String, Integer> testMap = flightmap.setUpMap();
		
		
		
		PrintWriter output = new PrintWriter(outputFile);
		output.println("Output test");
		output.println(originCity);
		for(int i = 0; i < routeCostList.size(); i++){
			output.println(routeCostList.get(i));
		}
		for (String key : testMap.keySet()) {
			   System.out.println("------------------------------------------------");
			   output.println("key: " + key + " value: " + testMap.get(key));
			}
		for (String key : flightmap.routeMap.keySet()) {
			   System.out.println("------------------------------------------------");
			   output.println("key: " + key + " value: " + flightmap.routeMap.get(key));
			}
		output.close();
		
		
		
		
	}
}

