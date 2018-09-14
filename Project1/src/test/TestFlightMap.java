package test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import implementation.FlightMap;

import org.junit.Test;

public class TestFlightMap {
	
	@Test
	public void testSetUpPirceMap(){
		ArrayList priceList = new ArrayList<String>();
		priceList.add("PW200");
		priceList.add("PR300");
		priceList.add("RX200");
		priceList.add("WS250");
		priceList.add("QW375");
		
		FlightMap testSetUpFM = new FlightMap("P", priceList);
		testSetUpFM.setUpPriceMap(priceList);
		
		Map<String, Integer> price = new HashMap<String, Integer>();
		price.put("P", 0);
		price.put("R", 300);
		price.put("W", 200);
		price.put("X", 500);
		price.put("S", 450);
		
		Map<String, String> route = new HashMap<String, String>();
		route.put("P", "P");
		route.put("R", "P, R");
		route.put("W", "P, W");
		route.put("X", "P, R, X");
		route.put("S", "P, W, S");
		
		assertEquals(price, testSetUpFM.getPriceMap());
		assertEquals(route, testSetUpFM.getRouteMap());
	}
	
	@Test
	public void testSetUpMap(){
		ArrayList second = new ArrayList<String>();
		second.add("PW200");
		second.add("PR300");
		second.add("RX200");
		second.add("WS250");
		second.add("QW375");
		
		FlightMap testSetUpFM = new FlightMap("P", second);
		testSetUpFM.setUpMap();
		
		Map<String, String> res = new HashMap<String, String>();
		res.put("R", "P, R");
		res.put("W", "P, W");
		res.put("X", "P, R, X");
		res.put("S", "P, W, S");
		
		Map<String, Integer> pres = new HashMap<String, Integer>();
		pres.put("R", 300);
		pres.put("W", 200);
		pres.put("X", 500);
		pres.put("S", 450);
		
		assertEquals(pres, testSetUpFM.getPriceMap());
		assertEquals(res, testSetUpFM.getRouteMap());
		
	}
	

}
