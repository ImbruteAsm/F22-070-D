package com.example.riskfactors.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.Map;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceFactors {
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
    private Map<String, Boolean> serviceDict;
    private List<Port> ports;

}
