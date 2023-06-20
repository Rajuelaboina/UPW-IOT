package com.thingspeak.thingspeak.model;

public class Channel {
    String created_at;
    String field1;
    int id;
    int last_entry_id;
    String latitude;
    String longitude;
    String name;
    String updated_at;

    public Channel(String created_at, String field1, int id, int last_entry_id, String latitude, String longitude, String name, String updated_at) {
        this.created_at = created_at;
        this.field1 = field1;
        this.id = id;
        this.last_entry_id = last_entry_id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLast_entry_id() {
        return last_entry_id;
    }

    public void setLast_entry_id(int last_entry_id) {
        this.last_entry_id = last_entry_id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
