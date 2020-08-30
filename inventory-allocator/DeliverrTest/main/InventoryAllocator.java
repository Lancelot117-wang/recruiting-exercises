package main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class InventoryAllocator {
	public static List<HashMap<String, HashMap<String, Integer>>> Allocate(HashMap<String, Integer> order, List<InventoryDistribution> warehouses) {
		//return null if order or warehouses list is empty
		if(order.isEmpty() || warehouses.isEmpty()) {
			return new LinkedList<HashMap<String, HashMap<String, Integer>>>();
		}
		
		//copy order as originalOrder for later check, if the order can be shipped completely from a warehouse
		@SuppressWarnings("unchecked") 
		HashMap<String, Integer> originalOrder = (HashMap<String, Integer>)order.clone();
		
		//
		List<HashMap<String, HashMap<String, Integer>>> result = new LinkedList<>();
		
		//loop the warehouses list with iterator
		Iterator<InventoryDistribution> iter = warehouses.iterator();
		while(iter.hasNext()) {
			InventoryDistribution ID = (InventoryDistribution)iter.next();
			
			//jump to next loop if current warehouse is empty
			if(ID.getInventory().isEmpty()) {
				continue;
			}
			
			//
			int count = 0;
			int gcount = 0;
			String name = ID.getName();
			HashMap<String, Integer> shipment = new HashMap<>();
			
			//check if the order can be completely shipped from current warehouse
			for(Entry<String, Integer> entry : order.entrySet()) {
				String goodsName = entry.getKey();
				if(ID.getInventory().containsKey(goodsName)) {
					Integer existedAmount = ID.getInventory().get(goodsName);
					if(existedAmount >= originalOrder.get(goodsName)) {
						gcount++;
						if(gcount == originalOrder.size()) {
							HashMap<String, HashMap<String, Integer>> temp = new HashMap<>();
							temp.put(name, originalOrder);
							//remove former shipments which are invalid in this case
							result.clear();
							result.add(temp);
							return result;
						}
					}
				}
			}
			
			//loop the goods in order to check if current warehouse has needed goods
			for(Entry<String, Integer> entry : order.entrySet()) {
				count++;
				String goodsName = entry.getKey();
				Integer neededAmount = entry.getValue();
				
				//jump to next loop if current goods has been fulfilled
				if(neededAmount == 0) {
					//store the shipment in result at the end of the loops of needed goods
					if(count == order.size() && (!shipment.isEmpty())) {
						HashMap<String, HashMap<String, Integer>> temp = new HashMap<>();
						temp.put(name, shipment);
						result.add(temp);
					}
					continue;
				}
				
				//jump to next loop if current warehouses doesn't have the needed goods
				if(!ID.getInventory().containsKey(goodsName) || ID.getInventory().get(goodsName) == 0) {
					continue;
				}
				Integer existedAmount = ID.getInventory().get(goodsName);
				
				//compare the existedAmount and neededAmount, ship accordingly
				if(existedAmount >= neededAmount) {
					shipment.put(goodsName, neededAmount);
					order.put(goodsName, 0);
				}
				else {
					shipment.put(goodsName, existedAmount);
					order.put(goodsName, neededAmount - existedAmount);
				}
				
				//store the shipment in result at the end of the loops of needed goods
				if(count == order.size() && (!shipment.isEmpty())) {
					HashMap<String, HashMap<String, Integer>> temp = new HashMap<>();
					temp.put(name, shipment);
					result.add(temp);
				}
			}
		}
		//check if order has been completed
		for(Entry<String, Integer> entry : order.entrySet()) {
			if(entry.getValue() != 0) {
				return new LinkedList<HashMap<String, HashMap<String, Integer>>>();
			}
		}
		
		return result;
	}
}
