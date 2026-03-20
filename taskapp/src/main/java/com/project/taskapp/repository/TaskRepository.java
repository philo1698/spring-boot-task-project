package com.project.taskapp.repository;

import com.project.taskapp.models.DAO.Status;
import com.project.taskapp.models.DAO.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Task entity
 */
@Repository // Marks this as Spring repository bean
public interface TaskRepository extends JpaRepository<Task, Long> { //long is id data type (here id is called "id" and its data type is long

    //JpaRepository<Task, Long> gives you :
    // save() (create a row)
    // findById() (find row by primary key of data)
    // findAll() (get all rows)
    // deleteById() (delete a certain row by its primary key)
    // etc. (no need to implement manually)

    /**
     * Find tasks by assigned person
     * Spring automatically generates query
     */
    List<Task> findByAssignedTo(String assignedTo);

    /**
     * Find tasks by status
     */
    List<Task> findByStatus(Status status);

    /**
     * Find tasks by list of IDs
     * (Used for your requirement #10)
     */
    List<Task> findByIdIn(List<Long> ids);
}
