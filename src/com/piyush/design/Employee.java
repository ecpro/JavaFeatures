package com.piyush.design;

public class Employee {

    protected Rank rank;

    private Call currentCall;

    private CallHandler handler;
    public Employee(CallHandler handler) {
        this.handler = handler;
    }

    public void attendCall(Call call) {
        if(currentCall != null) {
            this.currentCall = call;
        }
        else {
            handler.reassignRespondant(call);
        }
    }

    public void disconnectCall() {
        this.currentCall = null;
    }

    public Call getCurrentCall() {
        return currentCall;
    }

    public void escalateCall() {

    }


}
