package com.example.expensemanager;

import java.io.Serializable;

public class ExpenseModel implements Serializable {
    private String expenseId;
    private String note;
    private String category;
    private String type;
    private long amount ;
    private long time;
    private String uid;

    public ExpenseModel(){

    }

    public ExpenseModel(String expenseId, String note, String category, String type, long amount, long time, String uid) {
        this.expenseId = expenseId;
        this.note = note;
        this.category = category;
        this.type = type;
        this.amount = amount;
        this.time = time;
        this.uid = uid;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public String getNote() {
        return note;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public long getAmount() {
        return amount;
    }

    public long getTime() {
        return time;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
