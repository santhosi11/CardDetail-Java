package com.acc.training.ui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import com.acc.training.bean.CustomerDetailBean;
import com.acc.training.dao.CreditCardDetailsDAOImpl;
import com.acc.training.service.CreditCardDetailsServiceImpl;
public class CreditCardDetails {
	public static void main(String[] args) throws IOException {
		FileWriter cardFile = new FileWriter("C:\\Users\\santhosa.l.nagarajan\\OneDrive - Accenture\\Desktop\\JavaTraining\\CreditCardDetail\\cardFile.txt");
		BufferedWriter bfCardFile = new BufferedWriter(cardFile);
		CreditCardDetailsServiceImpl cardSer = new CreditCardDetailsServiceImpl();
		Scanner sc = new Scanner(System.in);
		char ch='N';
		do
		{
			try {
			System.out.println("Enter the Customer Name:");
			String name=sc.nextLine();
			System.out.println("Enter the Card Number (Numbers Only):");
			String cardNumber=sc.nextLine();
			CustomerDetailBean cusBean = new CustomerDetailBean();
			cusBean.setCustomerName(name);
			cusBean.setCardNumber(cardNumber);
			boolean res =cardSer.isValid(cusBean);
			if(res){
				cardSer.writeData(cusBean,bfCardFile);
				System.out.println("Details Inserted Sucessfully "+name+" XX"+cardNumber.substring(cardNumber.length()-4));
			}
			else
				System.out.println("Invalid CreditCard Details "+name+" XX"+cardNumber.substring(cardNumber.length()-4));
			System.out.println("Do you want to continue (press'Y') else (press 'N')");
			ch=sc.next().charAt(0);	
			sc.nextLine();
			} 
			catch (Exception e) {
				e.printStackTrace();}		
		}while(ch=='Y');
		bfCardFile.close();
		cardFile.close();
	}		
}

