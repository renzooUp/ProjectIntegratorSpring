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
@Table(name = "reporte")
public class Reporte implements Serializable{
    @Id
    @Column(name = "repo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long repoId;

    @Column(name = "repo_info")
    String repoInfo;
    
    //foreig key = tabla unida
    @Column(name = "pers_id")
    String persId;
}
