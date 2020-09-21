/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.model;

import java.math.BigDecimal;
import java.util.Map;

/**
 *
 * @author awong
 */
public class QR_PAYMENT_CONFIRM_TABLE {
    Database db;

    public QR_PAYMENT_CONFIRM_TABLE(Database db) {
        this.db = db;
    }
    
    public QR_PAYMENT_CONFIRM setAltmodel(Map<String, Object> row) {

        if (row != null) {
            QR_PAYMENT_CONFIRM getRow = QR_PAYMENT_CONFIRM.builder()
                    .BANKREF((String) row.get("BANKREF"))
                    .BILLERNO((String) row.get("BILLERNO"))
                    .REF1((String) row.get("REF1"))
                    .REF2((String) row.get("REF2"))
                    .QRID((String) row.get("QRID"))
                    .PAYERNAME((String) row.get("PAYERNAME"))
                    .PAYERBANK((String) row.get("PAYERBANK"))
                    .FILLER((String) row.get("FILLER"))
                    .AMOUNT((String) row.get("AMOUNT"))
                    .RESULTCODE((String) row.get("RESULTCODE"))
                    .RESULTDESC((String) row.get("RESULTDESC"))
                    .TRANSDATE((String) row.get("TRANSDATE"))
                    .INSERT_DATE((String) row.get("INSERT_DATE"))
                    .UAT_STATUS((String) row.get("UAT_STATUS"))
                    .STD_CODE((String) row.get("STD_CODE"))
                    .SYSTEM_ID((String) row.get("SYSTEM_ID"))
                    .YEAR((String) row.get("YEAR"))
                    .SEMESTER((String) row.get("SEMESTER"))
                    .build();
            /* user.setXxtthh((Integer) row.get("USERID"));
             user.setUsersname((String) row.get("USERNAME"));
             user.setPassword((String) row.get("PASSWORD"));
             user.setPeRoid((Integer) row.get("PEROID"));
             user.setDateRep((String) row.get("DATE_REP"));*/
            return getRow;
        } else {
            return null;
        }
    }
    
}
