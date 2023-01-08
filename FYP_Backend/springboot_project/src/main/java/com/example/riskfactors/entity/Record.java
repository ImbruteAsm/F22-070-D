package com.example.riskfactors.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Setter
@Getter
@Entity // This tells Hibernate to make a table out of this class
public class Record {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;
  @Column(unique = true)
  private String target;
  private Date firstScan;
  private Date lastScan;

}