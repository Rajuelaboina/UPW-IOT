package com.thingspeak.thingspeak.model;

import com.google.gson.annotations.SerializedName;

public class Feed_Temp {
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("entry_id")
    private Integer entryId;
    @SerializedName("field1")
    private String field1;
    @SerializedName("field2")
    private String field2;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getEntryId() {
        return entryId;
    }

    public void setEntryId(Integer entryId) {
        this.entryId = entryId;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }
}
