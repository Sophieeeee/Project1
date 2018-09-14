package implementation;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FlightMap {
	String originCity;
	ArrayList priceList = new ArrayList<String>();
	Map<String, String> routeMap = new HashMap<String, String>();
	Map<String, Integer> priceMap = new HashMap<String, Integer>();
	
	
	public FlightMap(String origin, ArrayList prices){
		this.originCity = origin;
		this.priceList = prices;
	}
	
	/**
	 * Returns origin city
	 * <p>
	 * @return      the origin city string
	 */
	public String getOrigin(){
		return originCity;
	}
	
	/**
	 * Returns price list which reads from text file
	 * <p>
	 * @return      the price array list
	 */
	public ArrayList getPrice(){
		return priceList;
	}
	
	/**
	 * Returns route map which lists possible routes
	 * <p>
	 * @return      a map with possible routes from origin city
	 */
	public Map<String, String> getRouteMap(){
		return routeMap;
	}
	
	/**
	 * Returns price map
	 * <p>
	 * @return      a map with possible prices from origin city
	 */
	public Map<String, Integer> getPriceMap(){
		return priceMap;
	}
	
	/**
	 * This map stores destination cities and associated prices
	 * <p>
	 * @param		list which has prices from origin city
	 */
	public void setUpPriceMap(ArrayList list){
		
		priceMap.put(originCity, 0);
		routeMap.put(originCity, originCity);
		for(int i = 0; i < list.size(); i++){
			String start = list.get(i).toString().substring(0, 1);
			String end = list.get(i).toString().substring(1, 2);
			int price = Integer.parseInt(list.get(i).toString().substring(2));
		
			if(priceMap.containsKey(start) && !priceMap.containsKey(end)){
				int newPrice = priceMap.get(start) + price;
				priceMap.put(end, newPrice);
				String flightRoute = routeMap.get(start).concat(", " + end);
				routeMap.put(end, flightRoute);
				list.remove(i);
				i--;
			}
		}
	}
	
	/**
	 * Wrap up the map
	 */
	public void setUpMap(){
		setUpPriceMap(priceList);
		
		if(priceList.size() != 0){
			setUpPriceMap(priceList);
		}
		priceMap.remove("P");
		routeMap.remove("P");
	}
	

	
	

}
