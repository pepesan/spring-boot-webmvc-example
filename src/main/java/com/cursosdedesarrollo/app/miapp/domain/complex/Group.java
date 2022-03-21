package com.cursosdedesarrollo.app.miapp.domain.complex;

import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "GROUPS")
@ToString
public class Group {
    private Long id;
    private String name;

    private Set<UserGroup> userGroups = new HashSet<UserGroup>();

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "GROUP_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    public Set<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(Set<UserGroup> groups) {
        this.userGroups = groups;
    }

    public void addUserGroup(UserGroup userGroup) {
        this.userGroups.add(userGroup);
    }

}
