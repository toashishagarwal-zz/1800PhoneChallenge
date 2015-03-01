package com.tollfree;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tollfree.impl.PhoneNumberToAlphabetsConverterImpl;
import com.tollfree.interfaces.PhoneNumberToAlphabetsConverter;
import com.tollfree.model.PhoneNumber;

public class PhoneNumberToAlphabetsConverterTest {
	
	private PhoneNumber phone;
	private PhoneNumberToAlphabetsConverter converter;
	
	@Before
	public void setUp() {
		phone = new PhoneNumber();
		converter = new PhoneNumberToAlphabetsConverterImpl();
	}
	
	@Test
	public void testWordsFor2Digits() throws Exception {
		// setup
		phone.setDigits("23");
		
		List<String> expectedWords = new ArrayList<String>() ;
		expectedWords.add("ad");
		expectedWords.add("ae");
		expectedWords.add("af");
		expectedWords.add("bd");
		expectedWords.add("be");
		expectedWords.add("bf");
		expectedWords.add("cd");
		expectedWords.add("ce");
		expectedWords.add("cf");
		
		// execute
		converter.convert(phone);
		
		// verify
		List<String> actualWords = phone.getWords();
		Assert.assertEquals(expectedWords.size(), actualWords.size());
		verify(expectedWords, actualWords);
	}
	
	@Test
	public void testWordsFor3Digits() {
		// setup
		phone.setDigits("234");
		
		List<String> expectedWords = new ArrayList<String>();
		expectedWords.add("adg"); 
		expectedWords.add("adh"); 
		expectedWords.add("adi"); 
		expectedWords.add("aeg"); 
		expectedWords.add("aeh"); 
		expectedWords.add("aei"); 
		expectedWords.add("afg"); 
		expectedWords.add("afh"); 
		expectedWords.add("afi"); 
		expectedWords.add("bdg"); 
		expectedWords.add("bdh"); 
		expectedWords.add("bdi"); 
		expectedWords.add("beg"); 
		expectedWords.add("beh"); 
		expectedWords.add("bei"); 
		expectedWords.add("bfg"); 
		expectedWords.add("bfh"); 
		expectedWords.add("bfi"); 
		expectedWords.add("cdg"); 
		expectedWords.add("cdh"); 
		expectedWords.add("cdi"); 
		expectedWords.add("ceg"); 
		expectedWords.add("ceh"); 
		expectedWords.add("cei"); 
		expectedWords.add("cfg"); 
		expectedWords.add("cfh"); 
		expectedWords.add("cfi");
		
		// execute
		converter.convert(phone);
		
		// verify
		List<String> actualWords = phone.getWords();
		Assert.assertEquals(expectedWords.size(), actualWords.size());
		verify(expectedWords, actualWords);
	}
	
	@Test
	public void testWordsForEmptyDigits() {
		// setup
		phone.setDigits("");
		
		// execute
		converter.convert(phone);
		
		// verify
		List<String> actualWords = phone.getWords();
		Assert.assertNull(actualWords);
	}
	
	@Test
	public void testWordsForSpaces() {
		// setup
		phone.setDigits("    ");
		
		// execute
		converter.convert(phone);
		
		// verify
		List<String> actualWords = phone.getWords();
		Assert.assertNull(actualWords);
	}
	
	@Test
	public void testWordsForOne() {
		// setup
		phone.setDigits("1");
		
		List<String> expectedWords = new ArrayList<String>();
		expectedWords.add("1");
		
		// execute
		converter.convert(phone);
		
		// verify
		List<String> actualWords = phone.getWords();
		Assert.assertEquals(expectedWords.size(), actualWords.size());
		verify(expectedWords, actualWords);
	}
	
	@Test
	public void testWordsFor21() {
		// setup
		phone.setDigits("21");
		
		List<String> expectedWords = new ArrayList<String>();
		expectedWords.add("a1");
		expectedWords.add("b1");
		expectedWords.add("c1");
		
		// execute
		converter.convert(phone);
		
		// verify
		List<String> actualWords = phone.getWords();
		Assert.assertEquals(expectedWords.size(), actualWords.size());
		verify(expectedWords, actualWords);
	}
	
	@Test
	public void testWordsFor211() {
		// setup
		phone.setDigits("211");
		
		List<String> expectedWords = new ArrayList<String>();
		expectedWords.add("a");
		expectedWords.add("b");
		expectedWords.add("c");
		
		// execute
		converter.convert(phone);
		
		// verify
		List<String> actualWords = phone.getWords();
		Assert.assertEquals(expectedWords.size(), actualWords.size());
		verify(expectedWords, actualWords);
	}
	
	@Test
	public void testWordsForAllSkippingDigits() {
		// setup
		phone.setDigits("110001");
		
		// execute
		converter.convert(phone);
		
		// verify
		List<String> actualWords = phone.getWords();
		Assert.assertNull(actualWords);
	}
	
	private void verify(final List<String> expectedWords, final List<String> actualWords) {
		Assert.assertTrue(expectedWords.toString().equalsIgnoreCase(actualWords.toString()));
	}
}
