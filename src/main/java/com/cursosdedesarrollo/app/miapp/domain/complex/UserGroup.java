package com.cursosdedesarrollo.app.miapp.domain.complex;

import lombok.ToString;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "USERS_GROUPS")
@ToString
public class UserGroup {
    private Long id;
    private User user;
    private Group group;

    // additional fields
    private boolean activated;
    private Date registeredDate;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "USER_GROUP_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "GROUP_ID")
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    @Column(name = "REGISTERED_DATE")
    @Temporal(TemporalType.DATE)
    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }
}
