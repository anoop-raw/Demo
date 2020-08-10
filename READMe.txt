Here I have created a factory to make Any beverages(HotTea, Hot Coffee, Black Tea).  Each Beverage Class( ex HotTea) has a fun canServed(), which checks whether a beverage can be made or not using Ingredients Class. Inside ingredient class having a method checkIngredientsAvailable, which is thread-safe and provide ingredients for a beverage.
 
Code execution start with main method inside CoffeeMachine. In this function, I am taking the file name as input to configure the coffee machine. After this taking desired beverage input as the available number of outlets. 
 
Some test cases are shown below -

Test 1:
      Input:

Input file name want to use (Ex - input1.json)
input1.json
Enter beverage for all 3 outlets you want to brew in new line (Ex - hot_tea)
hot_tea
hot_coffee
black_tea

Output :

black_tea is prepared
hot_coffee is prepared
hot_tea cannot be prepared because hot_water, sugar_syrup are not available 
Test 2:
       Input :

       Input file name want to use (Ex - input1.json)
input1.json
Enter beverage for all 3 outlets you want to brew in new line (Ex - hot_tea)
green_tea
black_tea
hot_coffee

Output:

black_tea is prepared
hot_coffee is prepared
green_tea cannot be prepared because sugar_syrup, green_mixture are not available




Test 3:
       Input :

       Input file name want to use (Ex - input1.json)
input2.json
Enter beverage for all 5 outlets you want to brew in new line (Ex - hot_tea)
black_tea
black_tea
hot_tea
green_tea
hot_coffee

Output :
hot_coffee cannot be prepared because hot_milk are not available
black_tea cannot be prepared because hot_water are not available
black_tea cannot be prepared because hot_water, ginger_syrup are not available
green_tea cannot be prepared because green_mixture are not available
hot_tea cannot be prepared because sugar_syrup, tea_leaves_syrup are not available


Test 4 :

       Input :

       Input file name want to use (Ex - input1.json)
input3.json
Enter beverage for all 4 outlets you want to brew in new line (Ex - hot_tea)
hot_coffee
hot_tea
green_tea
black_tea


Output :

hot_tea is prepared
hot_coffee is prepared
green_tea cannot be prepared because sugar_syrup, green_mixture are not available
black_tea cannot be prepared because hot_water, sugar_syrup are not available
