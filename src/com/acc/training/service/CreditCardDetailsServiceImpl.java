package com.acc.training.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;

import org.json.simple.JSONObject;

import com.acc.training.bean.CustomerDetailBean;
import com.acc.training.dao.CreditCardDetailsDAOImpl;

public class CreditCardDetailsServiceImpl {
	CustomerDetailBean cusBean = new CustomerDetailBean();
	CreditCardDetailsValidator cardValid = new CreditCardDetailsValidator();
	CreditCardDetailsDAOImpl cardDao=new CreditCardDetailsDAOImpl() ;
	String type="";
	public boolean isValid(CustomerDetailBean cusBean)
	{
		CreditCardDetailsServiceImpl cardSer = new CreditCardDetailsServiceImpl();
		type= cardValid.determineCreditCardType(cusBean);
		List<String> cardData =new ArrayList<String>();
		cardData=cardSer.storeData();
		//if(cardValid.validateCreditCardLength(cusBean)) && (type.equals("Visa Card") || type.equals("Master Card")) && cardValid.creditCardPresentInJsonfile(cardData,cusBean) );
		if(cardValid.validateCreditCardLength(cusBean))
		{
			if(type.equals("Visa Card") || type.equals("Master Card"))
			{
				if(cardValid.creditCardPresentInJsonfile(cardData,cusBean))
					return true;
			}
		}
	return false;		
	}
	
	public List<String> storeData()
	{
		JSONObject resObject = (JSONObject) cardDao.getCreditCardDetailsFromJsonFile();
		List<String> cardList = new ArrayList<String>();
		Map<String,String> cardDetails = new HashMap<String,String>();
		for(Object keyString:resObject.keySet())
		{
			String valueString = (String) resObject.get(keyString);
			cardList.add(valueString);
			cardDetails.put((String)keyString, valueString);
		}
		//System.out.println(cardList);
		return cardList;
	}
	
	public void writeData(CustomerDetailBean cusBean, BufferedWriter bfCardFile)
	{
		cardDao.enterValidCreditCardDetailsIntoFile(cusBean, type, bfCardFile);
	}
}
