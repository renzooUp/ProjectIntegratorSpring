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
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "carrera")
public class Carrera implements Serializable{
      
    @Id
    @Column(name = "carr_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carrId;

    @Column(name = "carr_nombre")
    private String carrNombre;

    @Column(name = "carr_ciclo")
    private String carrCiclo;

}
