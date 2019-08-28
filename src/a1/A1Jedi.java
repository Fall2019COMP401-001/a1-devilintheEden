package a1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int how_many_products = scan.nextInt();
		String[] all_products_names= new String[how_many_products];
		for(int i = 0; i < how_many_products;i++) {
			all_products_names[i] = scan.next();
			scan.nextDouble();
		}
		
		int how_many_customers = scan.nextInt();
		//how many people get this product
		Map<String, Integer> products_people = new HashMap<>();
		for(int k = 0; k < how_many_products;k++) {
			products_people.put(all_products_names[k],0);
			}
		
		//how many products are bought
		Map<String, Integer> products_bought_number = new HashMap<>();
		for(int k = 0; k < how_many_products;k++) {
			products_bought_number.put(all_products_names[k],0);
			}
		
		for(int i = 0; i < how_many_customers;i++) {
			//if one had bought it or not
			Map<String, Boolean> products_individual = new HashMap<>();
			for(int k = 0; k < how_many_products;k++) {
				products_individual.put(all_products_names[k],false);
				}
			scan.next();
			scan.next();
			int different_products_buy = scan.nextInt();
			for(int j = 0; j < different_products_buy;j++) {
				int same_product_buy = scan.nextInt();
				String name_of_product = scan.next();
				products_bought_number.put(name_of_product,
						products_bought_number.get(name_of_product)+same_product_buy);
				if(!products_individual.get(name_of_product)) {
					products_people.put(name_of_product,
						products_people.get(name_of_product)+1);
					products_individual.put(name_of_product,true);
				}
			}
		}
		scan.close();
		
		//print the result in NUMBER customers bought TOTAL ITEM format
		for(int i=0; i < how_many_products;i++) {
			int people = products_people.get(all_products_names[i]);
			if(people == 0) {
				System.out.println("No customers bought "+all_products_names[i]);
			}
			else {
				System.out.println(people + " customers bought "+
			products_bought_number.get(all_products_names[i])+" "+all_products_names[i]);
			}
		}
	}
}
