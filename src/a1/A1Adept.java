package a1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int how_many_products = scan.nextInt();
		//store the pair of all products and values 
		Map<String, Double> all_products = new HashMap<>();
		for(int i = 0; i < how_many_products;i++) {
		all_products.put(scan.next(),scan.nextDouble());
		}
		
		int how_many_customers = scan.nextInt();
		
		//store the pair how much they spent and each customers full name
		Map<Double, String> how_much_they_spent_and_names = new HashMap<>();
		
		//store how much each customers spent
		double[] customers_spent = new double[how_many_customers];
		
		for(int i = 0; i < customers_spent.length;i++) {
			//whole name
			String this_customer_name = scan.next() + " "+ scan.next();
			int different_products_buy = scan.nextInt();
			double this_customer_spent = 0.0;
			for(int j = 0; j < different_products_buy;j++) {
				int same_product_buy = scan.nextInt();
				String name_of_product = scan.next();
				//add all the value of products this customer bought together
				this_customer_spent += same_product_buy * all_products.get(name_of_product);
			}
			how_much_they_spent_and_names.put(this_customer_spent,this_customer_name);
			customers_spent[i] = this_customer_spent;
			
		}
		scan.close();
		
		//Use helper functions to calculate average, min, and max
		double average = calculateValueAverage(customers_spent);
		double min = findValueMin(customers_spent);
		double max = findValueMax(customers_spent);
		
		/*print the result in specific format
		Biggest: FIRST LAST (AMOUNT)
		Smallest: FIRST LAST (AMOUNT)
		Average: AVERAGE*/
		System.out.println("Biggest: "+how_much_they_spent_and_names.get(max)+" ("+
		String.format("%.2f", max)+")");
		System.out.println("Smallest: "+how_much_they_spent_and_names.get(min)+" ("+
				String.format("%.2f", min)+")");
		System.out.println("Average: "+String.format("%.2f", average));
		
	}
	
	// calculate average
	static double calculateValueAverage(double[] vals) {
		
		double sum = 0;
		
		for (int i=0; i<vals.length; i++) {
			sum += vals[i];
		}
		
		double average = sum/vals.length;
		return average;
	}
	
	// find min
	static double findValueMin(double[] vals) {
		
		double cur_min = vals[0];
			
		for (int i=1; i < vals.length; i++) {
			if (vals[i] < cur_min) {
				cur_min = vals[i];
			}
		}
		
		return cur_min;
	}

	// find max
	static double findValueMax(double[] vals) {
		
		double cur_max = vals[0];
		
		for (int i=1; i < vals.length; i++) {
			if (vals[i] > cur_max) {
				cur_max = vals[i];
			}
		}
		
		return cur_max;
	}


}