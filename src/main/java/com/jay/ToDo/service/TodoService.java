package com.jay.ToDo.service;

import com.jay.ToDo.dto.TodoDto;

import java.util.List;

public interface TodoService {
    public List<TodoDto> AddItemToThelist(TodoDto todo) ;

    List<TodoDto> UpdateItem(Long updateTodoId, TodoDto todo);

    List<TodoDto> GetAllItems();

    List<TodoDto> DeleteItem(Long deleteTodoId);

    TodoDto GetItem(Long todoId);

    Long GetCount();
}
