package com.TaskTea.Task.service;

import com.TaskTea.Task.dto.EventRequest;
import com.TaskTea.Task.entity.Event;
import com.TaskTea.Task.entity.User;
import com.TaskTea.Task.repository.EventRepository;
import com.TaskTea.Task.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private UserRepository userRepository;

    private EventRepository eventRepository;

    public EventService(UserRepository userRepository, EventRepository eventRepository) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    public String createEvent(EventRequest eventRequest) {
        User user = userRepository.findById(eventRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Event event = new Event();
        event.setUser(user);
        event.setEventName(eventRequest.getEventName());
        event.setDescription(eventRequest.getDescription());
        event.setEventDate(eventRequest.getEventDate());
        eventRepository.save(event);
        return "Event assigned successfully";
    }

    public List<Event> getAllEvents(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return eventRepository.findAllByUser(user);
    }

    public Event getEventsById(long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        return event;
    }

    public Event updateEvent(long eventId, EventRequest eventRequest) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        event.setEventName(eventRequest.getEventName());
        event.setDescription(eventRequest.getDescription());
        event.setEventDate(eventRequest.getEventDate());
        eventRepository.save(event);

        return event;
    }

    public String deleteEvent(long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        eventRepository.delete(event);

        return "Event deleted successfully";
    }
}
