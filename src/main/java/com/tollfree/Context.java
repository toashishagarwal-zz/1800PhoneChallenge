package com.tollfree;

import com.tollfree.interfaces.Strategy;


public class Context {
    private Strategy strategy;
    
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(String[] str) throws Exception {
        this.strategy.process(str);
    }
}
