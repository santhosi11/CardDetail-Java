package com.acc.training.service;

import java.util.List;

import com.acc.training.bean.CustomerDetailBean;
import com.acc.training.dao.CreditCardDetailsDAOImpl;

public class CreditCardDetailsValidator {
	CustomerDetailBean cusBean = new CustomerDetailBean();
	public boolean validateCreditCardLength(CustomerDetailBean cusBean)
	{
		String cardNum=cusBean.getCardNumber();
		int cardNumLength=cardNum.length();
		if(cardNumLength>=13 && cardNumLength<=16)
			return true;
		else
			return false;
	}
	
	public String determineCreditCardType(CustomerDetailBean cusBean)
	{
		String type= cusBean.getCardNumber().substring(0, 1);
		if("4".equals(type))
			return "Visa Card";
		else if("5".equals(type))
			return "Master Card";
		else
			return "Invalid Number";
	}
	
	public boolean creditCardPresentInJsonfile(List<String> cardData,CustomerDetailBean cusBean)
	{
		if(cardData.contains(cusBean.getCardNumber()))
			return false;
		else
			//cardData.add(cusBean.getCardNumber());
			return true;
	}

}
