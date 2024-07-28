package com.jay.ToDo.controller;

import com.jay.ToDo.dto.TodoDto;
import com.jay.ToDo.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/todo")
@RequiredArgsConstructor
public class ToDoController {

    private final TodoService todoService;

    @PostMapping("/additem")
    public ResponseEntity<List<TodoDto>> AddItemTolist(@Valid @RequestBody TodoDto todo) {
        return ResponseEntity.ok(todoService.AddItemToThelist(todo));
    }

    @PutMapping("/updateitem/{updateTodoId}")
    public ResponseEntity<List<TodoDto>> UpdateItem(@PathVariable Long updateTodoId, @Valid @RequestBody TodoDto todo) {
        return ResponseEntity.ok(todoService.UpdateItem(updateTodoId, todo));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<TodoDto>> GetAllItems() {
        return ResponseEntity.ok(todoService.GetAllItems());
    }

    @DeleteMapping("/deleteitem/{deleteTodoId}")
    public ResponseEntity<List<TodoDto>> DeleteItem(@PathVariable Long deleteTodoId) {
        return ResponseEntity.ok(todoService.DeleteItem(deleteTodoId));
    }

    @GetMapping("/getitem/{todoId}")
    public ResponseEntity<TodoDto> GetItem(@PathVariable Long todoId) {
        return ResponseEntity.ok(todoService.GetItem(todoId));
    }

    @GetMapping("getCount")
    public ResponseEntity<Long> GetCount() {
        return ResponseEntity.ok(todoService.GetCount());
    }
}
