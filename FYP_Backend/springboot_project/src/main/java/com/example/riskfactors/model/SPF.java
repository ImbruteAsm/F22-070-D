package com.example.riskfactors.model;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class SPF {
    private boolean isSpfRecordMissing = true;
    private boolean isSpfRecordMalformed = true;
    private boolean doesSpfRecordContainsWildcard = false;
    private boolean doesspfRecordContainsaSoftfail = false;
    private String target;
}
