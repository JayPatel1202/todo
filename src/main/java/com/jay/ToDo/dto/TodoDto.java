package com.jay.ToDo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TodoDto {
    private Long TodoId;
    private String todoTitle;
    private String todoDescription;
    private boolean isComplete;
    private Date todoDate;
    private Date creationDate;
    private Date updateDate;
}
