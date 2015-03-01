package com.tollfree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tollfree.model.PhoneNumber;

public class PhoneNumberToAlphabetsConverterImpl implements PhoneNumberToAlphabetsConverter {

	private final static Map<Character, String> dictionary = new HashMap<Character, String>();

	static {
		dictionary.put('2',"abc");
		dictionary.put('3',"def");
		dictionary.put('4',"ghi");
		dictionary.put('5',"jkl");
		dictionary.put('6',"mno");
		dictionary.put('7',"pqrs");
		dictionary.put('8',"tuv");
		dictionary.put('9',"wxyz");
	}
	
	public void convert(final PhoneNumber phone) {
		String digits = phone.getDigits();
		
		digits = cleanseDigits(digits);
		if(digits.isEmpty()) {
			return;
		}
		List<String> result = new ArrayList<String>();
		final List<String> rawResult  = new ArrayList<String>();
		result.add("");
		
		for(int i = 0 ; i < digits.length() ; i++) {
			for (String temp : result) {
					if(isNoMatchFoundForDigit(digits, i)) {
						rawResult.add(temp + digits.charAt(i));
					} else{
						String alphabets = removeNonAlphabets(dictionary.get(digits.charAt(i)));
						if(null == alphabets)
							break;
						for(int j = 0; j < alphabets.length(); j++) 
							rawResult.add(temp + alphabets.charAt(j));
					}
					
			}
			result.clear();
			result.addAll(rawResult);
			rawResult.clear();
		}
		phone.setWords(result);
	}

	private String cleanseDigits(final String digits) {
		String temp = removeNonAlphabets(digits);
		if(areDigitsToBeSkipped(digits)) {
			temp = temp.replaceAll("00", "");
			temp = temp.replaceAll("01", "");
			temp = temp.replaceAll("10", "");
			temp = temp.replaceAll("11", "");
		} 
		return temp;
	}

	private boolean areDigitsToBeSkipped(final String digits) {
		return digits.indexOf("00") > -1 
				|| digits.indexOf("01") > -1 
				|| digits.indexOf("10") > -1 
				|| digits.indexOf("11") > -1;
	}

	private boolean isNoMatchFoundForDigit(final String digits, final int i) {
		return digits.charAt(i) == '0' || digits.charAt(i) == '1';
	}
	
	private String removeNonAlphabets(final String digits) {
		return digits.replaceAll("\\W", "");
	}
}
