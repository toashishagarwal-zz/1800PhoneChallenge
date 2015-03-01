package com.tollfree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tollfree.model.PhoneNumber;

public class ConsoleProcessor implements Strategy {
    
    public void process(final String[] number) {
        final List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
        final PhoneNumberToAlphabetsConverter converter = new PhoneNumberToAlphabetsConverterImpl();
        
        Scanner stdin = new Scanner(System.in);
        String line;
        PhoneNumber phone = null; 
        while(stdin.hasNext()) {
            line = stdin.nextLine();
            if(line.equalsIgnoreCase("q"))
                break;
            phone = new PhoneNumber();
            phone.setDigits(line);
            phoneNumbers.add(phone);
        }
        stdin.close();
        for (PhoneNumber p : phoneNumbers) {
            converter.convert(p);
            System.out.println(p);
        }
    }
}
