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
@Table(name = "meditacion")
public class Meditacion implements Serializable{

    @Id
    @Column(name = "medi_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mediId;

    @Column(name = "medi_oracion")
    private String mediOracion;

    @Column(name = "medi_versiculo")
    private String mediVersiculo;

    @Column(name = "medi_reflexion")
    private String mediReflexion;

}
