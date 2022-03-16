package com.cursosdedesarrollo.app.miapp.domain.onetoone.entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Phone")
@Data
public class Phone {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`number`")
    private String number;

    @OneToOne
    @JoinColumn(name = "details_id")
    private PhoneDetails details;

    //Se omiten los getter y setters por brevedad

}
