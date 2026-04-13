package com.TaskTea.Task.controller;


import com.TaskTea.Task.dto.EventRequest;
import com.TaskTea.Task.entity.Event;
import com.TaskTea.Task.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventService eventService;
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createEvent(@RequestBody EventRequest eventRequest) {
        eventService.createEvent(eventRequest);
        String result = eventService.createEvent(eventRequest);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getAllEvent(@PathVariable Long userId) {
        eventService.getAllEvents(userId);
        List<Event> result = eventService.getAllEvents(userId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<?> getEvent(@PathVariable("eventId") Long eventId) {
        Event event = eventService.getEventsById(eventId);
        return ResponseEntity.ok(event);
    }

    @PatchMapping("/event/{eventId}")
    public  ResponseEntity<?> updateEvent(@PathVariable("eventId") Long eventId, @RequestBody EventRequest eventRequest) {
        Event event = eventService.updateEvent(eventId, eventRequest);
        return ResponseEntity.ok(event);
    }

    @DeleteMapping("/event/{eventId}")
    public ResponseEntity<?> deleteEvent(@PathVariable("eventId") Long eventId) {
        eventService.deleteEvent(eventId);
        return ResponseEntity.ok("Event has been deleted");
    }
}
