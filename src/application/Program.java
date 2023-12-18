package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String name = sc.nextLine();
			System.out.print("Initial balance: ");
			Double initialBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double withdrawLimit = sc.nextDouble();
			
			Account account = new Account(number, name, initialBalance, withdrawLimit);
			
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			Double withdraw = sc.nextDouble();
			account.withdraw(withdraw);
		}
		catch(DomainExceptions e){
			System.out.println("Withdraw error: "+ e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Error ");
		}
		
		
		sc.close();
	}

}
