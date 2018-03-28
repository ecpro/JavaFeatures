package com.piyush.annotations.database;

/**
 * Created by eccspro on 28/03/18.
 */
public enum Constraint {
    NOT_NULL("Not Null"), UNIQUE("Unique"), PRIMARY_KEY("primary_key");
    private String constraint;
    Constraint(String constraint) {
        this.constraint = constraint;
    }
    public String value() {
        return this.constraint;
    }
}
