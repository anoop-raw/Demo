package com.project.coffeemachine;

public class BeverageFactory {
	
	public static BaseBaverage getBeverage(String beverage) {
		BaseBaverage beverageObj = null;
		switch(beverage) {
		  case "hot_tea":
			  beverageObj = HotTea.getInstance(); 
		    break;
		  case "hot_coffee":
			  beverageObj = HotCoffee.getInstance(); 
		    break;
		  case "black_tea":
			  beverageObj = BlackTea.getInstance(); 
		    break;
		  case "green_tea":
			  beverageObj = GreenTea.getInstance(); 
		    break;
		}
		
		return beverageObj;
	}

}
