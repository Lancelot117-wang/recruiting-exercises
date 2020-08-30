package test;

import org.junit.Test;

import main.InventoryAllocator;
import main.InventoryDistribution;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TestJunit {
	
	@Test
    public void test1() {
    	HashMap<String, Integer> order = new HashMap<>();
		order.put("apple", 1);
		
		List<InventoryDistribution> warehouses = new LinkedList<>();
		
		InventoryDistribution temp = new InventoryDistribution();
		temp.setName("owd");
		HashMap<String, Integer> t = new HashMap<>();
		t.put("apple", 1);
		temp.setInventory(t);
		
		warehouses.add(temp);
		
		System.out.println("Order: " + order);
		System.out.println("Inventory distribution:  " + warehouses);
		
		List<HashMap<String, HashMap<String, Integer>>> result = InventoryAllocator.Allocate(order, warehouses);
		System.out.println("Function output: " + result);
		
		List<HashMap<String, HashMap<String, Integer>>> answer = new LinkedList<>();
		HashMap<String, HashMap<String, Integer>> shipment = new HashMap<>();
		shipment.put("owd", new HashMap<String, Integer>() {
		    {
		        put("apple", 1);
		    }
		});
		answer.add(shipment);
		
		System.out.println("Expected Answer: " + answer);
		
        assertEquals(answer, result);
    }

    @Test
    public void test2() {
    	HashMap<String, Integer> order = new HashMap<>();
		order.put("apple", 10);
		
		List<InventoryDistribution> warehouses = new LinkedList<>();
		
		InventoryDistribution temp = new InventoryDistribution();
		temp.setName("owd");
		HashMap<String, Integer> t = new HashMap<>();
		t.put("apple", 5);
		temp.setInventory(t);
		
		warehouses.add(temp);
		
		temp = new InventoryDistribution();
		temp.setName("dm");
		t = new HashMap<>();
		t.put("apple", 5);
		temp.setInventory(t);
		
		warehouses.add(temp);
		
		System.out.println("Order: " + order);
		System.out.println("Inventory distribution:  " + warehouses);
		
		List<HashMap<String, HashMap<String, Integer>>> result = InventoryAllocator.Allocate(order, warehouses);
		System.out.println("Function output: " + result);
		
		List<HashMap<String, HashMap<String, Integer>>> answer = new LinkedList<>();
		HashMap<String, HashMap<String, Integer>> shipment = new HashMap<>();
		shipment.put("owd", new HashMap<String, Integer>() {
		    {
		        put("apple", 5);
		    }
		});
		answer.add(shipment);
		
		shipment = new HashMap<>();
		shipment.put("dm", new HashMap<String, Integer>() {
		    {
		        put("apple", 5);
		    }
		});
		answer.add(shipment);
		
		System.out.println("Expected Answer: " + answer);
		
		assertEquals(answer, result);
    }
    
    @Test
    public void test3() {
    	HashMap<String, Integer> order = new HashMap<>();
		order.put("apple", 1);
		
		List<InventoryDistribution> warehouses = new LinkedList<>();
		
		InventoryDistribution temp = new InventoryDistribution();
		temp.setName("owd");
		HashMap<String, Integer> t = new HashMap<>();
		t.put("apple", 0);
		temp.setInventory(t);
		
		warehouses.add(temp);
		
		System.out.println("Order: " + order);
		System.out.println("Inventory distribution:  " + warehouses);
		
		List<HashMap<String, HashMap<String, Integer>>> result = InventoryAllocator.Allocate(order, warehouses);
		System.out.println("Function output: " + result);
		
		List<HashMap<String, HashMap<String, Integer>>> answer = new LinkedList<>();
		
		System.out.println("Expected Answer: " + answer);
		
		assertEquals(answer, result);
    }
    
    @Test
    public void test4() {
    	HashMap<String, Integer> order = new HashMap<>();
		order.put("apple", 2);
		
		List<InventoryDistribution> warehouses = new LinkedList<>();
		
		InventoryDistribution temp = new InventoryDistribution();
		temp.setName("owd");
		HashMap<String, Integer> t = new HashMap<>();
		t.put("apple", 1);
		temp.setInventory(t);
		
		warehouses.add(temp);
		
		System.out.println("Order: " + order);
		System.out.println("Inventory distribution:  " + warehouses);
		
		List<HashMap<String, HashMap<String, Integer>>> result = InventoryAllocator.Allocate(order, warehouses);
		System.out.println("Function output: " + result);
		
		List<HashMap<String, HashMap<String, Integer>>> answer = new LinkedList<>();
		
		System.out.println("Expected Answer: " + answer);
		
		assertEquals(answer, result);
    }
    
    @Test
    public void test5() {
    	HashMap<String, Integer> order = new HashMap<>();
		order.put("apple", 1);
		order.put("banana", 1);
		order.put("orange", 1);
		
		List<InventoryDistribution> warehouses = new LinkedList<>();
		
		InventoryDistribution temp = new InventoryDistribution();
		temp.setName("owd");
		HashMap<String, Integer> t = new HashMap<>();
		t.put("apple", 1);
		temp.setInventory(t);
		
		warehouses.add(temp);
		
		temp = new InventoryDistribution();
		temp.setName("dm");
		t = new HashMap<>();
		t.put("banana", 1);
		temp.setInventory(t);
		
		warehouses.add(temp);
		
		System.out.println("Order: " + order);
		System.out.println("Inventory distribution:  " + warehouses);
		
		List<HashMap<String, HashMap<String, Integer>>> result = InventoryAllocator.Allocate(order, warehouses);
		System.out.println("Function output: " + result);
		
		List<HashMap<String, HashMap<String, Integer>>> answer = new LinkedList<>();
		
		System.out.println("Expected Answer: " + answer);
		
		assertEquals(answer, result);
    }
    
    @Test
    public void test6() {
    	HashMap<String, Integer> order = new HashMap<>();
		order.put("apple", 1);
		order.put("banana", 1);
		
		List<InventoryDistribution> warehouses = new LinkedList<>();
		
		InventoryDistribution temp = new InventoryDistribution();
		temp.setName("owd");
		HashMap<String, Integer> t = new HashMap<>();
		t.put("apple", 1);
		temp.setInventory(t);
		
		warehouses.add(temp);
		
		temp = new InventoryDistribution();
		temp.setName("dm");
		t = new HashMap<>();
		t.put("banana", 1);
		temp.setInventory(t);
		
		warehouses.add(temp);
		
		System.out.println("Order: " + order);
		System.out.println("Inventory distribution:  " + warehouses);
		
		List<HashMap<String, HashMap<String, Integer>>> result = InventoryAllocator.Allocate(order, warehouses);
		System.out.println("Function output: " + result);
		
		List<HashMap<String, HashMap<String, Integer>>> answer = new LinkedList<>();
		HashMap<String, HashMap<String, Integer>> shipment = new HashMap<>();
		shipment.put("owd", new HashMap<String, Integer>() {
		    {
		        put("apple", 1);
		    }
		});
		answer.add(shipment);
		
		shipment = new HashMap<>();
		shipment.put("dm", new HashMap<String, Integer>() {
		    {
		        put("banana", 1);
		    }
		});
		answer.add(shipment);
		
		System.out.println("Expected Answer: " + answer);
		
		assertEquals(answer, result);
    }
    
    @Test
    public void test7() {
    	HashMap<String, Integer> order = new HashMap<>();
		order.put("apple", 1);
		order.put("banana", 1);
		
		List<InventoryDistribution> warehouses = new LinkedList<>();
		
		InventoryDistribution temp = new InventoryDistribution();
		temp.setName("owd");
		HashMap<String, Integer> t = new HashMap<>();
		t.put("apple", 1);
		temp.setInventory(t);
		
		warehouses.add(temp);
		
		temp = new InventoryDistribution();
		temp.setName("dm");
		t = new HashMap<>();
		t.put("apple", 1);
		t.put("banana", 1);
		temp.setInventory(t);
		
		warehouses.add(temp);
		
		System.out.println("Order: " + order);
		System.out.println("Inventory distribution:  " + warehouses);
		
		List<HashMap<String, HashMap<String, Integer>>> result = InventoryAllocator.Allocate(order, warehouses);
		System.out.println("Function output: " + result);
		
		List<HashMap<String, HashMap<String, Integer>>> answer = new LinkedList<>();
		HashMap<String, HashMap<String, Integer>> shipment = new HashMap<>();
		shipment.put("dm", new HashMap<String, Integer>() {
		    {
		    	put("apple", 1);
		        put("banana", 1);
		    }
		});
		answer.add(shipment);
		
		System.out.println("Expected Answer: " + answer);
		
		assertEquals(answer, result);
    }
    
    @Test
    public void test8() {
    	HashMap<String, Integer> order = new HashMap<>();
		order.put("apple", 1);
		order.put("banana", 2);
		order.put("orange", 1);
		
		List<InventoryDistribution> warehouses = new LinkedList<>();
		
		InventoryDistribution temp = new InventoryDistribution();
		temp.setName("owd");
		HashMap<String, Integer> t = new HashMap<>();
		t.put("apple", 1);
		t.put("banana", 1);
		temp.setInventory(t);
		
		warehouses.add(temp);
		
		temp = new InventoryDistribution();
		temp.setName("dm");
		t = new HashMap<>();
		t.put("apple", 1);
		t.put("banana", 1);
		t.put("orange", 1);
		temp.setInventory(t);
		
		warehouses.add(temp);
		
		System.out.println("Order: " + order);
		System.out.println("Inventory distribution:  " + warehouses);
		
		List<HashMap<String, HashMap<String, Integer>>> result = InventoryAllocator.Allocate(order, warehouses);
		System.out.println("Function output: " + result);
		
		List<HashMap<String, HashMap<String, Integer>>> answer = new LinkedList<>();
		HashMap<String, HashMap<String, Integer>> shipment = new HashMap<>();
		shipment.put("owd", new HashMap<String, Integer>() {
		    {
		    	put("apple", 1);
		        put("banana", 1);
		    }
		});
		answer.add(shipment);
		
		shipment = new HashMap<>();
		shipment.put("dm", new HashMap<String, Integer>() {
		    {
		        put("banana", 1);
		        put("orange", 1);
		    }
		});
		answer.add(shipment);
		
		System.out.println("Expected Answer: " + answer);
		
		assertEquals(answer, result);
    }
}