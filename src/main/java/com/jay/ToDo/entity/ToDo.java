package com.jay.ToDo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "todo")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_item_id", updatable = false, nullable = false)
    private Long TodoId;

    @NotBlank
    @Size(min = 5, message = "A Description should have at least 5 characters")
    @Column(name = "todo_title")
    private String todoTitle;

    @NotBlank
    @Size(min = 5, message = "A Description should have at least 5 characters")
    @Column(name = "todo_description")
    private String todoDescription;


    @Column(name = "is_complete")
    private boolean isComplete;

    @FutureOrPresent
    @Column(name = "todo_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date todoDate;

    @Column(name = "creation_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd hh:mm:ss" )
    @CreationTimestamp
    private Date creationDate;

    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd hh:mm:ss" )
    @UpdateTimestamp
    private Date updateDate;
}
