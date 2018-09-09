package implementation;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FlightMap {
	String originCity;
	ArrayList priceList = new ArrayList<String>();
	Map<String, String> routeMap = new HashMap<String, String>();
	
	public FlightMap(String origin, ArrayList prices){
		this.originCity = origin;
		this.priceList = prices;
	}
	public Map<String, Integer> setUpMap(){
		Map<String, Integer> priceMap = new HashMap<String, Integer>();
		
		routeMap.put(originCity, originCity);
		priceMap.put(originCity, 0);
		
		for(int i = 0; i < priceList.size(); i++){
			String start = priceList.get(i).toString().substring(0, 1);
			String end = priceList.get(i).toString().substring(1, 2);
			int price = Integer.parseInt(priceList.get(i).toString().substring(2));
		
			if(priceMap.containsKey(start) && !priceMap.containsKey(end)){
				int newPrice = priceMap.get(start) + price;
				priceMap.put(end, newPrice);
				String flightRoute = routeMap.get(start).concat(", " + end);
				routeMap.put(end, flightRoute);
			}
		}
		return priceMap;
	}
	

	
	

}
