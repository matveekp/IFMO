package com.example.fxserver.repositories;

import com.example.fxserver.entity.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Integer> {


}
