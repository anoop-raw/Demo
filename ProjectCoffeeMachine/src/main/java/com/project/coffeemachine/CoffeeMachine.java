package com.project.coffeemachine;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CoffeeMachine {
	
	static long numberOfOutlets;
	static List<String> beverageList = new ArrayList<String>();

	public static void main(String[] args) {
		System.out.println("Input file name want to use (Ex - input1.json)");
		Scanner scanner = new Scanner(System. in);
        String subpath = scanner. nextLine();
		String path = System.getProperty("user.dir");
		String filepath = path + "/src/test/resources/" + subpath ;
		initialiseMachine(filepath);
		
		int noOfThread = (int) (numberOfOutlets +3);
		ExecutorService threadPool = Executors.newFixedThreadPool(noOfThread);

		System.out.println("Enter beverage for all " + numberOfOutlets + " outlets you want to brew in new line (Ex - hot_tea)");
     
        for (int i = 0; i < numberOfOutlets; i++) {
        	String beverage = scanner. nextLine();
        	beverageList.add(beverage);
        }
      
		for (int i = 0; i < numberOfOutlets; i++) {
			int k = i;
		    threadPool.submit(new Runnable() {
		        public void run() {
		        	BaseBaverage baverage = BeverageFactory.getBeverage(beverageList.get(k));
		        	if (baverage != null) {
		        		System.out.println(baverage.canServed()); 
		        	}
		        }
		    });
		        
		}
		
	}
	
	public static void initialiseMachine(String filepath) {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(filepath));
			JSONObject jsonObject = (JSONObject) obj;
			JSONObject machine = (JSONObject) jsonObject.get("machine");
			JSONObject outlets = (JSONObject) machine.get("outlets");
			
			setNumberOfOutlets((Long) outlets.get("count_n"));
			
			setIngredients((JSONObject) machine.get("total_items_quantity"));
			
			setBeveragesRecipe((JSONObject) machine.get("beverages"));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void setNumberOfOutlets(Long numberOfOutletsParam) {
		numberOfOutlets = numberOfOutletsParam; 
	}
	
	private static void setIngredients(JSONObject totalItemsQuantity) {
		Ingredients ingredients = Ingredients.getInstance();
		ingredients.fillHotWater((Long) totalItemsQuantity.get("hot_water"));
		ingredients.fillHotMilk((Long) totalItemsQuantity.get("hot_milk"));
		ingredients.fillGingerSyrup((Long) totalItemsQuantity.get("ginger_syrup"));
		ingredients.fillSugarSyrup((Long) totalItemsQuantity.get("sugar_syrup"));
		ingredients.fillTeaLeavesSyrup((Long) totalItemsQuantity.get("tea_leaves_syrup"));
		
	}
	
	private static void setBeveragesRecipe(JSONObject beverages) {
		setHotTeaRecipe((JSONObject) beverages.get("hot_tea"));
		setHotCoffeeRecipe((JSONObject) beverages.get("hot_coffee"));
		setBlackTeaRecipe((JSONObject) beverages.get("black_tea"));
		setGreenTeaRecipe((JSONObject) beverages.get("green_tea"));
	}
	
	private static void setHotTeaRecipe(JSONObject hotTeaRecipe) {
		HotTea hotTea = HotTea.getInstance();
		hotTea.setHotWater((Long) hotTeaRecipe.get("hot_water"));
		hotTea.setHotMilk((Long) hotTeaRecipe.get("hot_milk"));
		hotTea.setGingerSyrup((Long) hotTeaRecipe.get("ginger_syrup"));
		hotTea.setSugarSyrup((Long) hotTeaRecipe.get("sugar_syrup"));
		hotTea.setTeaLeavesSyrup((Long) hotTeaRecipe.get("tea_leaves_syrup"));
	}
	
	private static void setHotCoffeeRecipe(JSONObject hotCoffeeRecipe) {
		HotCoffee hotCoffee = HotCoffee.getInstance();
		hotCoffee.setHotWater((Long) hotCoffeeRecipe.get("hot_water"));
		hotCoffee.setHotMilk((Long) hotCoffeeRecipe.get("hot_milk"));
		hotCoffee.setGingerSyrup((Long) hotCoffeeRecipe.get("ginger_syrup"));
		hotCoffee.setSugarSyrup((Long) hotCoffeeRecipe.get("sugar_syrup"));
		hotCoffee.setTeaLeavesSyrup((Long) hotCoffeeRecipe.get("tea_leaves_syrup"));
	}
	
	private static void setBlackTeaRecipe(JSONObject hotBlackTeaRecipe) {
		BlackTea blackTea = BlackTea.getInstance();
		blackTea.setHotWater((Long) hotBlackTeaRecipe.get("hot_water"));
		blackTea.setGingerSyrup((Long) hotBlackTeaRecipe.get("ginger_syrup"));
		blackTea.setSugarSyrup((Long) hotBlackTeaRecipe.get("sugar_syrup"));
		blackTea.setTeaLeavesSyrup((Long) hotBlackTeaRecipe.get("tea_leaves_syrup"));
	}
	
	private static void setGreenTeaRecipe(JSONObject hotGreenTeaRecipe) {
		GreenTea greenTea = GreenTea.getInstance();
		greenTea.setHotWater((Long) hotGreenTeaRecipe.get("hot_water"));
		greenTea.setGingerSyrup((Long) hotGreenTeaRecipe.get("ginger_syrup"));
		greenTea.setSugarSyrup((Long) hotGreenTeaRecipe.get("sugar_syrup"));
		greenTea.setGreenMixture((Long) hotGreenTeaRecipe.get("green_mixture"));
	}
	

}
