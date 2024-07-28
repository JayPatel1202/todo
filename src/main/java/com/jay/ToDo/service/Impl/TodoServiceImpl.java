package com.jay.ToDo.service.Impl;

import com.jay.ToDo.dto.TodoDto;
import com.jay.ToDo.entity.ToDo;
import com.jay.ToDo.repository.ToDoRepository;
import com.jay.ToDo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {


    private final ToDoRepository toDoRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<TodoDto> AddItemToThelist(TodoDto todo) {
        ToDo toDo = modelMapper.map(todo, ToDo.class);
        toDoRepository.save(toDo);
        List<ToDo> toDoList = toDoRepository.findAll();
        return toDoList.stream().map(t -> modelMapper.map(t, TodoDto.class)).toList();
    }

    @Override
    public List<TodoDto> UpdateItem(Long updateTodoId, TodoDto toDoDto) {
        ToDo toDo = modelMapper.map(toDoDto, ToDo.class);
        toDo.setTodoId(updateTodoId);
        toDoRepository.save(toDo);
        List<ToDo> toDoList = toDoRepository.findAll();
        return toDoList.stream().map(t -> modelMapper.map(t, TodoDto.class)).toList();
    }

    @Override
    public List<TodoDto> GetAllItems() {
        return toDoRepository.findAll().stream().map(t -> modelMapper.map(t, TodoDto.class)).toList();
    }

    @Override
    public List<TodoDto> DeleteItem(Long deleteTodoId) {
        toDoRepository.deleteById(deleteTodoId);
        List<ToDo> toDoList = toDoRepository.findAll();
        return toDoList.stream().map(t -> modelMapper.map(t, TodoDto.class)).toList();
    }

    @Override
    public TodoDto GetItem(Long todoId) {
        ToDo toDo = toDoRepository.findById(todoId).orElseThrow(() -> new RuntimeException("Todo not found"));
        return modelMapper.map(toDo, TodoDto.class);
    }

    @Override
    public Long GetCount() {
        return toDoRepository.count();
    }
}
