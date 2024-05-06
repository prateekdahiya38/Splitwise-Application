package com.project.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "groups")
public class Group extends BaseModule{
    private String name;
    private String description;
    @ManyToMany
    private List<User> members;
    @ManyToOne
    private User createdBy;
}
