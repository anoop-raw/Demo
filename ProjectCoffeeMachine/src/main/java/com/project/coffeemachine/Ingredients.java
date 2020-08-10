package com.project.coffeemachine;

import java.util.ArrayList;
import java.util.List;

public class Ingredients {
	
	private static Ingredients ingredients = null; 
	private double hotWater = 0.00;
	private double hotMilk = 0.00;
	private double gingerSyrup = 0.00;
	private double sugarSyrup = 0.00;
	private double teaLeavesSyrup = 0.00;
	
	public static Ingredients getInstance() { 
        if (ingredients == null) 
        	ingredients = new Ingredients(); 
  
        return ingredients; 
    }
	
	public synchronized List<String> checkIngredientsAvailable(String[] ingredientsList, Double[] quantity) {
		List<String> notSufficient = new ArrayList<String>();
		for( int i = 0; i < ingredientsList.length; i++)
		{
		    String ingredient = ingredientsList[i];
		    Double requiredQuantity =  quantity[i];
		    switch(ingredient) {
			  case "hot_water":
					if (this.hotWater < requiredQuantity) {
						notSufficient.add(ingredient);
					} else {
						this.hotWater = this.hotWater - requiredQuantity;
					}
			    break;
			  case "hot_milk":
					if (this.hotMilk < requiredQuantity) {
						notSufficient.add(ingredient);
					} else {
						this.hotMilk = this.hotMilk - requiredQuantity;
					}
			    break;
			  case "ginger_syrup":
					if (this.gingerSyrup < requiredQuantity) {
						notSufficient.add(ingredient);
					} else {
						this.gingerSyrup = this.gingerSyrup - requiredQuantity;
					} 
			    break;
			  case "sugar_syrup":
					if (this.sugarSyrup < requiredQuantity) {
						notSufficient.add(ingredient);
					} else {
						this.sugarSyrup = this.sugarSyrup - requiredQuantity;
					} 
			    break;
			  case "tea_leaves_syrup":
					if (this.teaLeavesSyrup < requiredQuantity) {
						notSufficient.add(ingredient);
					} else {
						this.teaLeavesSyrup = this.teaLeavesSyrup - requiredQuantity;
					} 
			    break;
			  default:
				  notSufficient.add(ingredient);
			}
		}
		return notSufficient;
	}

	public void fillHotWater(double hotWater) {
		this.hotWater = hotWater;
	}

	public void fillHotMilk(double hotMilk) {
		this.hotMilk = hotMilk;
	}

	public void fillGingerSyrup(double gingerSyrup) {
		this.gingerSyrup = gingerSyrup;
	}

	public void fillSugarSyrup(double sugarSyrup) {
		this.sugarSyrup = sugarSyrup;
	}

	public void fillTeaLeavesSyrup(double teaLeavesSyrup) {
		this.teaLeavesSyrup = teaLeavesSyrup;
	}
}
