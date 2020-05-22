package com.vasovski.todolist;

import com.vasovski.todolist.repositories.TaskRepository;
import com.vasovski.todolist.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

	@Autowired
	TaskRepository repository;
	private final AtomicLong counter = new AtomicLong();
	@GetMapping("/task")
	public Task greeting(@RequestParam(value = "title", defaultValue = "title") String title) {
		Task t = repository.save(new Task(counter.incrementAndGet(), title));
		return t;
	}
}