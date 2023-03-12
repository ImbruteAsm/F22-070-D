package com.example.riskfactors.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Results  {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private Boolean mongoDiscovered;
    private Boolean cassandraDiscovered;
    private Boolean msSQLDiscovered;
    private Boolean mySQLDiscovered;
    private Boolean redisDiscovered;
    private Boolean vncDiscovered;
    private Boolean rdpDiscovered;
    private Boolean rsyncDiscovered;
    private Boolean imapDiscovered;
    private Boolean ftpDiscovered;
    private Boolean smbDiscovered;
    private Boolean telnetDiscovered;
    private Boolean pop3Discovered;
}
