package com.example.lab05_q3.Controller;

import com.example.lab05_q3.ApiResponse.ApiResponse;
import com.example.lab05_q3.Model.Event;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;

import java.time.LocalDateTime;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {

    ArrayList<Event> events = new ArrayList<>();

    //• Display all event
    @GetMapping("/display")
    public ArrayList<Event> display() {
        return events;
    }

    //• Create a new event (ID , description , capacity, startDate , endDate)
    @PostMapping("/create")
    @JsonFormat(pattern = "yyyy-MM-dd")
    public ApiResponse createEvent(@RequestBody Event event) {
        events.add(event);
        return new ApiResponse("created!!");
    }

    //• Update a event
    @PutMapping("/update/{id}")
    public ApiResponse updateEvent(@PathVariable int id, @RequestBody Event event) {
        for (int index = 0; index < events.size(); index++) {
            if (events.get(index).getId() == id) {
                events.set(index, event);
                return new ApiResponse("updated!!");
            }
        }
        return new ApiResponse("Not found!!");
    }

    //• Delete a event
    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteEvent(@PathVariable int id){
        for (Event e:events){
            if (e.getId()==id){
                events.remove(e);
                return new ApiResponse("deleted!!!");
            }
        }
        return new ApiResponse("Not found");
    }

    //• Change capacity
    @PutMapping("/change-capacity/{id},{capacity}")
    public ApiResponse changeCapacity(@PathVariable int id,@PathVariable int capacity){
        for (Event e: events){
            if (e.getId()==id){
                e.setCapacity(capacity);
                return new ApiResponse("Capacity changed!!");
            }
        }
        return new ApiResponse("Not found");
    }

    //• Search for a event by given id
    @GetMapping("/search/{id}")
    public Event searchEvent(@PathVariable int id){
        for (Event e: events){
            if (e.getId()==id){
                return e;
            }
        }
        return null;
    }

    //Hint ( use @JsonFormat(pattern="yyyy-MM-dd") and LocalDateTime )
}
