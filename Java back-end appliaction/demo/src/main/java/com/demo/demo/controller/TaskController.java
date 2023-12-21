package com.demo.demo.controller;

import com.demo.demo.persistance.entity.TaskEntity;
import com.demo.demo.persistance.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/v1/tasks")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/test")
    public String test(){
        return "task service running";
    }

    @GetMapping
    public ResponseEntity<List<TaskEntity>> getAllTasks() {
         List<TaskEntity> taskEntityList = taskRepository.findAll();
         if(taskEntityList.isEmpty()){
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
         return new ResponseEntity<>(taskEntityList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody TaskEntity task) {
        Long taskId = null;
        try{
            taskId = taskRepository.save(task).getId();
        }catch (Exception e){
            return new ResponseEntity<>("SomeThing Went wrong", HttpStatus.EXPECTATION_FAILED);
        };
        return new ResponseEntity<>(taskId,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable Long id) {
        TaskEntity taskEntity = taskRepository.findById(id).get();
        if(taskEntity == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(taskEntity, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody TaskEntity updatedTask) {
        // Add validation for existence
        if (!taskRepository.existsById(id)) {
            return new ResponseEntity<>("No recorde found",HttpStatus.NOT_FOUND);
        }
        updatedTask.setId(id);
        TaskEntity savedTask = taskRepository.save(updatedTask);
        return new ResponseEntity<>(savedTask, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        if (!taskRepository.existsById(id)) {
            return new ResponseEntity<>("Recorde not found for delete",HttpStatus.NOT_FOUND);
        }
        taskRepository.deleteById(id);
        return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
    }
}
