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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "material")
public class Material implements Serializable{

    @Id
    @Column(name = "mate_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mateId;

    @Column(name = "mate_nombre")
    private String mateNombre;

    @Column(name = "mate_descripcion")
    private String mateDescripcion;

    @OneToOne(mappedBy = "material")
    private Taller taller;

}
