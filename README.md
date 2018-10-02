# Vending-Machine
We have a vending machine, that serves drinks using some ingredients. When any/all of the ingredients run low in the vending machine, we need to show an alert on the machine.  
We also require the facilty to re-fill the ingredients in the machine. 
If suficient ingredients are not avalable, then the drink should not be served.  
The vending machlne is used by 2 types of users  
  a. Employees who are thirsty or sleepy and want drinks  
  b. Staff to ensure that there are suficient ingredients in the machine.  
Keep in mind both these types of users see the vending machine in a different way and use it for different purposes.  
Note that the vending machlne should be generic and extensible, and the requírements of the vending machine keep changing. These changes should be possibie with minimum or no code change in the core machine logic.  
Take care of boundary cases- should throw relevant exceptions.  
Consequenly, the exceptions need to be delailed and the exception hierarchy also needs to be modeled.  
Also ensure that the ingredients are increased or decreased atomically, i.e. 
Either the ingredients are reduced and the drink is served, or else the ingredients state is not changed/restored to the state before the drinks were served
For a better idea, refer to the use case given below. This is close to the real life vending machine in any office.  
Sample Use Case  
The Vending machine serves Tea, Coffee and Tomato soup  
To make tea, i use -Tea power, sugar, milk, waler  
To make coffee, i use - Coffee powder, sugar, milk, water  
To make Soup, i use - Soup mix, water  

I need to be able to run the vending machine to serve all these drinks, sustainably for a long time.  
I also might want to add/remove a type of drink the machine serves, (Eg- Black coffee
Cold Drink etc..)  
