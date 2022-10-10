/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pers_taller")
public class PersonaTaller implements Serializable{

    @Id
    @Column(name = "peta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petaId;

    @Column(name = "peta_carrera")
    String petaCarrera;

    @Column(name = "peta_ciclo")
    String petaCiclo;

    @ManyToOne //De muchos a uno
    @JoinColumn(name = "tall_id")
    private Taller taller;

    //Foreig Key - tablas unidas de uno a uno a tabla persona
    @Column(name = "pers_id")
    String persId;
}
