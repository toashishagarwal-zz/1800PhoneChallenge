package com.tollfree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputStreamWrapper {
    protected List<String> numbers = new ArrayList<String>();

    public void read(final InputStream input) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        StringBuilder out = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            numbers.add(line.trim());
            out.append(line);
        }
        reader.close();
    }
}
