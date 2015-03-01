package com.tollfree;

import java.util.ArrayList;
import java.util.List;

import com.tollfree.impl.PhoneNumberToAlphabetsConverterImpl;
import com.tollfree.interfaces.PhoneNumberToAlphabetsConverter;
import com.tollfree.model.PhoneNumber;

public abstract class Processor {
    protected final List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
    protected final PhoneNumberToAlphabetsConverter converter = new PhoneNumberToAlphabetsConverterImpl();
    
    public void convertAndPrintPhoneNumber() {
        for (PhoneNumber p : phoneNumbers) {
            converter.convert(p);
            System.out.println(p);
        }
    }
}
