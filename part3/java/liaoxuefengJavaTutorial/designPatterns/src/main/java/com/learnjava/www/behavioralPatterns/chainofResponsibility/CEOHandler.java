package com.learnjava.www.behavioralPatterns.chainofResponsibility;

public class CEOHandler implements Handler{
    @Override
    public Boolean process(Request request) {
        return true;
    }
}
