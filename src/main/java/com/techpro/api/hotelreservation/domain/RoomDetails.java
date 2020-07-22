package com.techpro.api.hotelreservation.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

/**
 * Created by manoj on 1/12/2020.
 */
@DynamoDBDocument
public class RoomDetails {
    private String room_id;
    private String room_name;
    private String room_desc;
    private String notes;

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getRoom_desc() {
        return room_desc;
    }

    public void setRoom_desc(String room_desc) {
        this.room_desc = room_desc;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
