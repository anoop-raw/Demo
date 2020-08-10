package com.project.coffeemachine;

import java.util.List;

public class BlackTea extends BaseBaverage {
	private static BlackTea blackTea = null; 
	
	private double hotWater;
	private double gingerSyrup;
	private double sugarSyrup;
	private double teaLeavesSyrup;
	
	public static BlackTea getInstance() { 
        if (blackTea == null) 
        	blackTea = new BlackTea(); 
  
        return blackTea; 
    }
	
	public void setTeaLeavesSyrup(double teaLeavesSyrup) {
		this.teaLeavesSyrup = teaLeavesSyrup;
	}
	public void setHotWater(double hotWater) {
		this.hotWater = hotWater;
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
				new String[]{"hot_water", "ginger_syrup", "sugar_syrup", "tea_leaves_syrup"},
				new Double[]{this.hotWater, this.gingerSyrup, this.sugarSyrup, this.teaLeavesSyrup }
		);
		if (notSufficient.isEmpty()) {
			return "black_tea is prepared";
		} {
			String result = String.join(", ", notSufficient);
			return "black_tea cannot be prepared because " + result + " are not available";
		}
	}
}
