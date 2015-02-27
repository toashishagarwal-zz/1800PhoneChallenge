package com.tollfree.model;

import java.util.List;

public class PhoneNumber {
	private String digits;
	private List<String> words;

	public String getDigits() {
		return digits;
	}

	public void setDigits(final String digits) {
		this.digits = digits;
	}

	public List<String> getWords() {
		return words;
	}
	
	public void setWords(final List<String> result) {
		this.words = result;
	}
}
