package fencingCalculator;

import java.util.Scanner;

public class FenceCalc {

	public static void main(String[] args) {
		double width = 0.0;
		double length = 0.0;
		int chainLinkFence = 16;

		int woodenFence = 25;
		int fencingCost= 0;
		int gateCount = 0;
		double materialCost = 0.0;
		double materialTax=0.0;
		double tax = 0.06;
		int buildingPermit = 50;
		int gateCost = 150;
		double totalPrice = 0.0;

		String material= null;

		Scanner scan = new Scanner(System.in);

		//figure out the size of the yard
		System.out.println("Enter the dimentions of your yard.  Length and width must be greater than 0");
		do{
			System.out.println("What is the width of the yard?");
			width = scan.nextDouble();
		}while (width<=0);
		do{
			System.out.println("What is the length of the yard?");
			length = scan.nextDouble();
		}while (length <=0);
		double perimeter = 2*length + 2*width;

		//figure out how many fences are needed
		boolean tempBool=false;
		do{
			System.out.println("How many gates would you like? Minimum of 1 Maximum of 3");
			gateCount = scan.nextInt();

			if (gateCount <= 3 && gateCount > 1){
				tempBool = true;
			}else if(gateCount <1){
				System.out.println("Sorry but you need to have more gates");
			}else if(gateCount > 3){
				System.out.println("Sorry but you cannot have more than 3 gates");
			}
		}while (tempBool == false);

		//get fencing type and assign a cost 
		boolean tempBool2 = false;
		do{
			System.out.println("would you like a wooden fencing (w) or a chain link fence(c)?");
			String fencing = scan.next();
			if(fencing.equalsIgnoreCase("w")){
				material = "wooden fencing";
				fencingCost = woodenFence;
				tempBool2 = true;
			}else if(fencing.equalsIgnoreCase("c")){
				material = "chain Link Fence";
				fencingCost = chainLinkFence;
				tempBool2=true;
			}else{
				System.out.println("you didnt enter a correct response.  try again.");
			}

		}while(tempBool2 = false);

		double totalFenceCost = perimeter*fencingCost;
		double totalGateCost = gateCount * gateCost;
		materialCost = totalFenceCost+totalGateCost;
		materialTax = materialCost*tax;

		totalPrice = materialCost + materialTax + buildingPermit;


		System.out.println("Your fence will be " + perimeter + " feet long and will be made of "+ material + " with " + gateCount + " gates");
		System.out.println("The materials will cost "+ materialCost+ " and the tax will be "+materialTax);
		System.out.println("The fence will cost "+ totalPrice+ " to build.");

	}


}
