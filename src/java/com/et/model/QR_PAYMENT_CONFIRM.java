/*
 * To change this license header; choose License Headers in Project Properties.
 * To change this template file; choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.model;

import lombok.*;
@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QR_PAYMENT_CONFIRM {

    private String BANKREF;
    private String BILLERNO;
    private String REF1;
    private String REF2;
    private String QRID;
    private String PAYERNAME;
    private String PAYERBANK;
    private String FILLER;
    private String AMOUNT;
    private String RESULTCODE;
    private String RESULTDESC;
    private String TRANSDATE;
    private String INSERT_DATE;
    private String UAT_STATUS;
    private String STD_CODE;
    private String SYSTEM_ID;
    private String YEAR;
    private String SEMESTER;     
}
