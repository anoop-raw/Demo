package com.project.coffeemachine;

import java.util.List;

public class GreenTea extends BaseBaverage {
	private static GreenTea greenTea = null; 
	
	private double hotWater;
	private double gingerSyrup;
	private double sugarSyrup;
	private double greenMixture;
	
	public static GreenTea getInstance() { 
        if (greenTea == null) 
        	greenTea = new GreenTea(); 
  
        return greenTea; 
    }
	
	public void setGreenMixture(double greenMixture) {
		this.greenMixture = greenMixture;
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
				new String[]{"hot_water", "ginger_syrup", "sugar_syrup", "green_mixture"},
				new Double[]{this.hotWater, this.gingerSyrup, this.sugarSyrup, this.greenMixture }
		);
		if (notSufficient.isEmpty()) {
			return "green_tea is prepared";
		} {
			String result = String.join(", ", notSufficient);
			return "green_tea cannot be prepared because " + result + " are not available";
		}
	}
}
