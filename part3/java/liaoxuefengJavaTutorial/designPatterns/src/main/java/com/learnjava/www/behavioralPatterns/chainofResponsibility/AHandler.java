package com.learnjava.www.behavioralPatterns.chainofResponsibility;

public class AHandler implements Handler {
    private Handler next;

    public void process2(Request request) {
        if (!canProcess(request)) {
            // 手动交给下一个Handler处理:
            next.process(request);
        } else {
        }
    }

    private boolean canProcess(Request request) {
        return false;
    }

    @Override
    public Boolean process(Request request) {
        return null;
    }
}
