package com.project.coffeemachine;

import java.util.List;

public class HotCoffee extends BaseBaverage {
	private static HotCoffee hotCoffee = null; 
	
	private double hotWater;
	private double hotMilk;
	private double gingerSyrup;
	private double sugarSyrup;
	private double teaLeavesSyrup;
	
	public static HotCoffee getInstance() { 
        if (hotCoffee == null) 
        	hotCoffee = new HotCoffee(); 
  
        return hotCoffee; 
    }
	
	public void setTeaLeavesSyrup(double teaLeavesSyrup) {
		this.teaLeavesSyrup = teaLeavesSyrup;
	}
	public void setHotWater(double hotWater) {
		this.hotWater = hotWater;
	}
	public void setHotMilk(double hotMilk) {
		this.hotMilk = hotMilk;
	}
	public void setGingerSyrup(double gingerSyrup) {
		this.gingerSyrup = gingerSyrup;
	}
	public void setSugarSyrup(double sugarSyrup) {
		this.sugarSyrup = sugarSyrup;
	}

	@Override
	protected String canServed() {
		Ingredients ingredients = Ingredients.getInstance();
		List<String> notSufficient = ingredients.checkIngredientsAvailable(
				new String[]{"hot_water", "hot_milk", "ginger_syrup", "sugar_syrup", "tea_leaves_syrup"},
				new Double[]{this.hotWater, this.hotMilk, this.gingerSyrup, this.sugarSyrup, this.teaLeavesSyrup }
		);
		if (notSufficient.isEmpty()) {
			return "hot_coffee is prepared";
		} {
			String result = String.join(", ", notSufficient);
			return "hot_coffee cannot be prepared because " + result + " are not available";
		}
	}
}
