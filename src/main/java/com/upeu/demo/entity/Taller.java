/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "taller")
public class Taller implements Serializable{
    @Id
    @Column(name = "tall_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tallId;

    @Column(name = "tall_tema")
    String tallTema;

    @Column(name = "tall_fecha_inicio")
    String tallFechaInicio;

    @Column(name = "tall_fecha_fin")
    String tallFechaFin;

    @Column(name = "tall_horario")
    String tallHorario;

    //de taller a programa
    @ManyToOne //De muchos a uno
    @JoinColumn(name = "prog_id")
    private Programa programa;

//    // tabla  personaTaller se relaciona a taller
//    //          carga de tipo pereza              cascada a todo
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //De muchos a muchos
//    private List<PersonaTaller> personaTaller;

    @OneToOne(cascade = CascadeType.ALL) //De muchos a uno
    @JoinColumn(name = "mate_id", referencedColumnName = "mate_id")
    private Material material;
}
