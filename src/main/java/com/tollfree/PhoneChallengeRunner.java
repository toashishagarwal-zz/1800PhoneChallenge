package com.tollfree;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tollfree.model.PhoneNumber;

public class PhoneChallengeRunner {
    private static List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
    
    public static void main(String[] args) throws Exception {
        PhoneNumberToAlphabetsConverter converter = new PhoneNumberToAlphabetsConverterImpl();
        if(args.length > 0) {
            System.out.println("Found [" + args.length + "] files. Processing files ...");
            for(int i = 0 ; i< args.length; i++) {
                phoneNumbers.clear();
                System.out.println(" ** Processing " + args[i] );
                ClassLoader loader = PhoneChallengeRunner.class.getClassLoader();
                File file = new File(loader.getResource(args[i]).getFile());
                Scanner scanner = new Scanner(file);
                String line;
                PhoneNumber phone = null;
                while(scanner.hasNext()) {
                    line = scanner.nextLine();
                    phone = new PhoneNumber();
                    phone.setDigits(line);
                    phoneNumbers.add(phone);
                }
                scanner.close();
                
                for (PhoneNumber p : phoneNumbers) {
                    converter.convert(p);
                    System.out.println(p);
                }
            }
        } else {
            System.out.println("Did not find any files. Lets try inputting from console. Press 'q' for quitting.");
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
}
