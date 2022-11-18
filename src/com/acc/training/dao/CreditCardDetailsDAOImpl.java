package com.acc.training.dao;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.acc.training.bean.CustomerDetailBean;

@SuppressWarnings("deprecation")
public class CreditCardDetailsDAOImpl {
	public Object getCreditCardDetailsFromJsonFile()
	{
		JSONObject finalObject = null;
		try
		{
		JSONParser jsonParser = new JSONParser();
		Object object = jsonParser.parse(new FileReader("CreditCardDetail.json"));
		JSONObject jsonObject = (JSONObject) object;
		
		finalObject = (JSONObject) jsonObject.get("CreditCard");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return finalObject;
	}
	public void enterValidCreditCardDetailsIntoFile(CustomerDetailBean cusBean,String type, BufferedWriter bfCardFile)
	{
		try 
		{
			//FileWriter cardFile = new FileWriter("C:\\Users\\santhosa.l.nagarajan\\OneDrive - Accenture\\Desktop\\JavaTraining\\CreditCardDetail\\cardFile.txt",true);
			//BufferedWriter bfCardFile = new BufferedWriter(cardFile);
			String text=cusBean.getCustomerName()+"-"+cusBean.getCardNumber()+"-"+type;
			bfCardFile.write(text);
			bfCardFile.newLine();
			//bfCardFile.close();
			//cardFile.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
}
