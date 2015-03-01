package com.tollfree;

public class PhoneChallengeRunner {
    public static void main(String[] args) throws Exception {
        final Context context;
        if(args.length > 0) {
            System.out.println("Found [" + args.length + "] files. Processing files ...");
            context = new Context(new FileProcessor());
        } else {
            System.out.println("Did not find any files. Lets try inputting from console. Press 'q' for quitting.");
            context = new Context(new ConsoleProcessor());
        }
        context.executeStrategy(args);
    }
}
