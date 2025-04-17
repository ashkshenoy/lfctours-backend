package com.okta.developer.lfcfanclub;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.okta.developer.lfcfanclub.dao.GroupRepository;
import com.okta.developer.lfcfanclub.model.Event;
import com.okta.developer.lfcfanclub.model.Group;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

@Component
class Initializer implements CommandLineRunner {

    private final GroupRepository repository;

    public Initializer(GroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        Stream.of("Bangalore OLSC", "Pune OLSC", "Mumbai OLSC",
                "London OLSC").forEach(name ->
                repository.save(new Group(name))
        );

        Group djug = repository.findByName("Bangalore OLSC");
        Event e = Event.builder().title("Screening 9/13")
                .description("Liverpool vs Manchester United")
                .date("2022-09-13T17:00:00.000Z")
                .build();
        djug.setEvents(Collections.singleton(e));
        repository.save(djug);

        repository.findAll().forEach(System.out::println);
    }
}