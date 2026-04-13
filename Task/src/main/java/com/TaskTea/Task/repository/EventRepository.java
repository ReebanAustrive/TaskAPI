package com.TaskTea.Task.repository;

import com.TaskTea.Task.entity.Event;
import com.TaskTea.Task.entity.User;
import com.TaskTea.Task.enums.EventStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByUser(User user);
    List<Event> findAllByUserAndStatus(User user, EventStatus status);
    void deleteAllByUser(User user);
}
