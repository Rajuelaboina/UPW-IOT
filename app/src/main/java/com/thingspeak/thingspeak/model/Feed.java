package com.thingspeak.thingspeak.model;

public class Feed {
    String created_at ;
    String  entry_id ;
    String field1;

    public Feed(String created_at, String entry_id, String field1) {
        this.created_at = created_at;
        this.entry_id = entry_id;
        this.field1 = field1;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getEntry_id() {
        return entry_id;
    }

    public void setEntry_id(String entry_id) {
        this.entry_id = entry_id;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }
}
