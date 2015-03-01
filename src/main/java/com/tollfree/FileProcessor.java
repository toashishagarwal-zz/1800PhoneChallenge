package com.tollfree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.tollfree.model.PhoneNumber;

public class FileProcessor extends Processor implements Strategy {
    
    public void process(String[] fileNames) throws FileNotFoundException {
       
        for (int i = 0; i < fileNames.length; i++) {
            phoneNumbers.clear();
            System.out.println(" ** Processing " + fileNames[i]);
            ClassLoader loader = PhoneChallengeRunner.class.getClassLoader();
            File file = new File(loader.getResource(fileNames[i]).getFile());
            Scanner scanner = new Scanner(file);
            String line;
            PhoneNumber phone = null;
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                phone = new PhoneNumber();
                phone.setDigits(line);
                phoneNumbers.add(phone);
            }
            scanner.close();

            convertAndPrintPhoneNumber();
        }
    }
}
