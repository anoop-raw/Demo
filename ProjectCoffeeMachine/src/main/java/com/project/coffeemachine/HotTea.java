package com.project.coffeemachine;

import java.util.List;

public class HotTea extends BaseBaverage {
	private static HotTea hotTea = null; 
	
	private double hotWater;
	private double hotMilk;
	private double gingerSyrup;
	private double sugarSyrup;
	private double teaLeavesSyrup;
	
	public static HotTea getInstance() { 
        if (hotTea == null) 
        	hotTea = new HotTea(); 
  
        return hotTea; 
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
			return "hot_tea is prepared";
		} {
			String result = String.join(", ", notSufficient);
			return "hot_tea cannot be prepared because " + result + " are not available";
		}
	}
}
