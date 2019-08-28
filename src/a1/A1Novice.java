package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// the total number of customers
		int customers = scan.nextInt();
		// to record customers names
		String[] customers_names = new String[customers];
		
		// to record how much each customers spent
		double[] customers_spent = new double[customers];
		
		for(int i = 0; i < customers_names.length;i++) {
			//first name initial plus last name
			String this_customer_name = scan.next().charAt(0) + ". "+ scan.next();
			int products_number = scan.nextInt();
			double this_customer_spent = 0.0;
			for(int j = 0; j < products_number;j++) {
				int same_product_buy = scan.nextInt();
				scan.next();
				double single_product_value = scan.nextDouble();
				//add all the value of products this customer bought together
				this_customer_spent += same_product_buy * single_product_value;
			}
			customers_names[i] = this_customer_name;
			customers_spent[i] = this_customer_spent;
			
		}
		scan.close();
		//print the result in the form: F. LAST: TOTAL
		for(int i = 0;i < customers_names.length;i++) {
		System.out.println(customers_names[i]+": "+ String.format("%.2f", customers_spent[i]));
		}
	}
}
