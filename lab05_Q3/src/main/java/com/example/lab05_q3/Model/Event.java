package com.example.lab05_q3.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@Data
@AllArgsConstructor
public class Event {

    //event Class : ID , description , capacity, startDate , endDate

    private int id;
    private String description;
    private int capacity;
    private Date startDate;
    private Date endDate;

}
