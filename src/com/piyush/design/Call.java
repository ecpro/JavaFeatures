package com.piyush.design;

public class Call {

    private Rank rank = Rank.RESPONDANT; // default rank;

    private Caller caller;

    public Call(Caller caller) {
        this.caller = caller;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

}
