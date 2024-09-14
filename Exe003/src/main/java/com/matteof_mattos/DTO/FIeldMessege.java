package com.matteof_mattos.DTO;

public class FIeldMessege {

    private String field;
    private String messege;

    public FIeldMessege(String field, String messege) {
        this.field = field;
        this.messege = messege;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessege() {
        return messege;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }
}
