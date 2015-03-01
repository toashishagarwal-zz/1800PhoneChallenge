package com.tollfree;

import java.util.Scanner;

import com.tollfree.model.PhoneNumber;

public class ConsoleProcessor extends Processor implements Strategy {
    
    public void process(final String[] number) {
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
        convertAndPrintPhoneNumber();
    }
}
