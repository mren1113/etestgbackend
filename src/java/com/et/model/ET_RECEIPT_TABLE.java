/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author awong
 */
public class ET_RECEIPT_TABLE {

    Database db;

    public ET_RECEIPT_TABLE(Database db) {
        this.db = db;
    }

    public ET_RECEIPT setAltmodel(Map<String, Object> row) {

        if (row != null) {
            ET_RECEIPT getRow = ET_RECEIPT.builder()
                    .FISCAL_YEAR((String) row.get("FISCAL_YEAR"))
                    .RECEIPT_NO((String) row.get("RECEIPT_NO"))
                    .STD_CODE((String) row.get("STD_CODE"))
                    .RECEIPT_YEAR((String) row.get("RECEIPT_YEAR"))
                    .RECEIPT_SEMESTER((String) row.get("RECEIPT_SEMESTER"))
                    .RECEIPT_DATE((String) row.get("CRRECEIPT_DATEEDIT"))
                    .RECEIPT_TIME((String) row.get("RECEIPT_TIME"))
                    .RECEIPT_PERIOD((String) row.get("RECEIPT_PERIOD"))
                    .TOTAL_AMOUNT((String) row.get("TOTAL_AMOUNT"))
                    .RECEIPT_TYPE((String) row.get("RECEIPT_TYPE"))
                    .RECEIPT_STATUS((String) row.get("RECEIPT_STATUS"))
                    .REGIONAL_NO((BigDecimal) row.get("REGIONAL_NO"))
                    .CASH_AMOUNT((BigDecimal) row.get("CASH_AMOUNT"))
                    .CHEQUE_AMOUNT((BigDecimal) row.get("CHEQUE_AMOUNT"))
                    .CREDIT_AMOUNT((BigDecimal) row.get("CREDIT_AMOUNT"))
                    .REGIS_METHOD((BigDecimal) row.get("REGIS_METHOD"))
                    .REGIS_CK((BigDecimal) row.get("REGIS_CK"))
                    .NEAR_GRADUATE((String) row.get("NEAR_GRADUATE"))
                    .PAYMENT_CODE((String) row.get("PAYMENT_CODE"))
                    .ACCOUNT_NUMBER((String) row.get("ACCOUNT_NUMBER"))
                    .BANK_FEE((BigDecimal) row.get("BANK_FEE"))
                    .RECEIPT_PAY_STATUS((String) row.get("RECEIPT_PAY_STATUS"))
                    .REGIS_GROUP_NO((BigDecimal) row.get("REGIS_GROUP_NO"))
                    .REGIS_DATE((String) row.get("REGIS_DATE"))
                    .TOTAL_AMOUNT_BANK((BigDecimal) row.get("TOTAL_AMOUNT_BANK"))
                    .BANK_VAT((BigDecimal) row.get("BANK_VAT"))
                    .BANK_TOTAL((BigDecimal) row.get("BANK_TOTAL"))
                    .NOMATCH_MONEY((BigDecimal) row.get("NOMATCH_MONEY"))
                    .BANK_DATE((String) row.get("BANK_DATE"))
                    .ADD_PAY((BigDecimal) row.get("ADD_PAY"))
                    .ADD_BANK_DATE((String) row.get("ADD_BANK_DATE"))
                    .EXAM_LOCATION_NO((BigDecimal) row.get("EXAM_LOCATION_NO"))
                    .WAIVED_NO((String) row.get("WAIVED_NO"))
                    .WAIVED_CR((BigDecimal) row.get("WAIVED_CR"))
                    .CASHIER_NO((String) row.get("CASHIER_NO"))
                    .USERID((String) row.get("USERID"))
                    .UPDATE_DATE((String) row.get("UPDATE_DATE"))
                    .USERNAME((String) row.get("USERNAME"))
                    .CREDITCARD_TYPE((BigDecimal) row.get("CREDITCARD_TYPE"))
                    .CREDITCARD_FEE((BigDecimal) row.get("CREDITCARD_FEE"))
                    .POSTAL_AMOUNT((BigDecimal) row.get("POSTAL_AMOUNT"))
                    .PAYMENT_TYPE((BigDecimal) row.get("PAYMENT_TYPE"))
                    .TIME_NO((BigDecimal) row.get("TIME_NO"))
                    .CHK_GRADUATE_STATUS((String) row.get("CHK_GRADUATE_STATUS"))
                    .SAVE_STATUS((String) row.get("SAVE_STATUS"))
                    .STATUS_B_UPDATE_DATE((String) row.get("STATUS_B_UPDATE_DATE"))
                    .FACULTY_NO((String) row.get("FACULTY_NO"))
                    .REF_KEY((String) row.get("REF_KEY"))
                    .REGIS_STATUS((String) row.get("REGIS_STATUS"))
                    .EXPIRE_DATE((String) row.get("EXPIRE_DATE"))
                    .build();

            return getRow;
        } else {
            return null;
        }
    }

    public List<ET_RECEIPT> findAll() {
        List<ET_RECEIPT> list = new ArrayList<ET_RECEIPT>();
        String sql = "SELECT FISCAL_YEAR,COUNTER_NO,RECEIPT_NO,STD_CODE,RECEIPT_YEAR,RECEIPT_SEMESTER,TO_CHAR(RECEIPT_DATE, 'mm/dd/yyyy')RECEIPT_DATE,RECEIPT_TIME,RECEIPT_PERIOD,"
                + " TOTAL_AMOUNT,RECEIPT_TYPE,RECEIPT_STATUS,REGIONAL_NO,CASH_AMOUNT,CHEQUE_AMOUNT,CREDIT_AMOUNT,REGIS_METHOD,REGIS_CK,"
                + " NEAR_GRADUATE,PAYMENT_CODE,ACCOUNT_NUMBER,BANK_FEE,RECEIPT_PAY_STATUS,REGIS_GROUP_NO,TO_CHAR(REGIS_DATE, 'mm/dd/yyyy')REGIS_DATE,TOTAL_AMOUNT_BANK,"
                + " BANK_VAT,BANK_TOTAL,NOMATCH_MONEY,TO_CHAR(BANK_DATE, 'mm/dd/yyyy')BANK_DATE,ADD_PAY,TO_CHAR(ADD_BANK_DATE, 'mm/dd/yyyy')ADD_BANK_DATE,EXAM_LOCATION_NO,WAIVED_NO,WAIVED_CR,CASHIER_NO,USERID,"
                + " TO_CHAR(UPDATE_DATE, 'mm/dd/yyyy')UPDATE_DATE,USERNAME,CREDITCARD_TYPE,CREDITCARD_FEE,POSTAL_AMOUNT,PAYMENT_TYPE,TIME_NO,CHK_GRADUATE_STATUS,SAVE_STATUS,"
                + " TO_CHAR(STATUS_B_UPDATE_DATE, 'mm/dd/yyyy')STATUS_B_UPDATE_DATE,FACULTY_NO,REF_KEY,REGIS_STATUS,TO_CHAR(EXPIRE_DATE, 'mm/dd/yyyy')EXPIRE_DATE FROM ET_RECEIPT";
        List<Map<String, Object>> result = db.queryList(sql);

        for (Map<String, Object> row : result) {

            list.add(setAltmodel(row));
        }
        return list;
    }
    //end find 

    public List<ET_RECEIPT> findAllExamDate() {
        List<ET_RECEIPT> list = new ArrayList<ET_RECEIPT>();
        String sql = "YEAR, SEMESTER, STD_CODE, TIME_NO, COURSE_NO, CREDIT, SECTION_NO, "
                + "TO_CHAR(EXAM_DATE, 'dd/mm/yyyy', 'NLS_CALENDAR=''THAI BUDDHA'' NLS_DATE_LANGUAGE=THAI')EXAM_DATE,"
                + " PERIOD, BUILD_NO, ROW_EXAM, SEAT_EXAM, STATUS_REGIS, GRADE, SCORE_TOTAL, SCORE_MIDTERM, SCORE_FINAL,"
                + " CKREGIS, TO_CHAR(INSERT_DATE, 'dd/mm/yyyy HH24:MI:SS', 'NLS_CALENDAR=''THAI BUDDHA'' NLS_DATE_LANGUAGE=THAI')INSERT_DATE, "
                + " INSERT_USER, REF_KEY, REGIS_STATUS  FROM ET_RECEIPT ";
        List<Map<String, Object>> result = db.queryList(sql);

        for (Map<String, Object> row : result) {

            list.add(setAltmodel(row));
        }
        return list;
    }
    //end find 

    public List<ET_RECEIPT> findBylist(String x) {
        List<ET_RECEIPT> list = new ArrayList<ET_RECEIPT>();
        String sql = "SELECT FISCAL_YEAR,COUNTER_NO,RECEIPT_NO,STD_CODE,RECEIPT_YEAR,RECEIPT_SEMESTER,RECEIPT_DATE,RECEIPT_TIME,RECEIPT_PERIOD,"
                + " TOTAL_AMOUNT,RECEIPT_TYPE,RECEIPT_STATUS,REGIONAL_NO,CASH_AMOUNT,CHEQUE_AMOUNT,CREDIT_AMOUNT,REGIS_METHOD,REGIS_CK,"
                + " NEAR_GRADUATE,PAYMENT_CODE,ACCOUNT_NUMBER,BANK_FEE,RECEIPT_PAY_STATUS,REGIS_GROUP_NO,REGIS_DATE,TOTAL_AMOUNT_BANK,"
                + " BANK_VAT,BANK_TOTAL,NOMATCH_MONEY,BANK_DATE,ADD_PAY,ADD_BANK_DATE,EXAM_LOCATION_NO,WAIVED_NO,WAIVED_CR,CASHIER_NO,USERID,"
                + " UPDATE_DATE,USERNAME,CREDITCARD_TYPE,CREDITCARD_FEE,POSTAL_AMOUNT,PAYMENT_TYPE,TIME_NO,CHK_GRADUATE_STATUS,SAVE_STATUS,"
                + " STATUS_B_UPDATE_DATE,FACULTY_NO,REF_KEY,REGIS_STATUS,EXPIRE_DATE FROM ET_RECEIPT ";
        List<Map<String, Object>> result = db.queryList(sql, x);

        for (Map<String, Object> row : result) {

            list.add(setAltmodel(row));
        }
        return list;
    }
    //end find 

    public ET_RECEIPT findRu24ByStudent(String x) {
        String sql = "SELECT FISCAL_YEAR,COUNTER_NO,RECEIPT_NO,STD_CODE,RECEIPT_YEAR,RECEIPT_SEMESTER,RECEIPT_DATE,RECEIPT_TIME,RECEIPT_PERIOD,"
                + " TOTAL_AMOUNT,RECEIPT_TYPE,RECEIPT_STATUS,REGIONAL_NO,CASH_AMOUNT,CHEQUE_AMOUNT,CREDIT_AMOUNT,REGIS_METHOD,REGIS_CK,"
                + " NEAR_GRADUATE,PAYMENT_CODE,ACCOUNT_NUMBER,BANK_FEE,RECEIPT_PAY_STATUS,REGIS_GROUP_NO,REGIS_DATE,TOTAL_AMOUNT_BANK,"
                + " BANK_VAT,BANK_TOTAL,NOMATCH_MONEY,BANK_DATE,ADD_PAY,ADD_BANK_DATE,EXAM_LOCATION_NO,WAIVED_NO,WAIVED_CR,CASHIER_NO,USERID,"
                + " UPDATE_DATE,USERNAME,CREDITCARD_TYPE,CREDITCARD_FEE,POSTAL_AMOUNT,PAYMENT_TYPE,TIME_NO,CHK_GRADUATE_STATUS,SAVE_STATUS,"
                + " STATUS_B_UPDATE_DATE,FACULTY_NO,REF_KEY,REGIS_STATUS,EXPIRE_DATE FROM ET_RECEIPT where STD_CODE = ?";
        Map<String, Object> row = db.querySingle(sql, x);

        return setAltmodel(row);

    }

    public ET_RECEIPT findRefKey(String receiptStdCode, String receiptYear, String receiptSemester, String receiptPayStatus, String refKey) {
        String sql = "SELECT FISCAL_YEAR,COUNTER_NO,RECEIPT_NO,STD_CODE,RECEIPT_YEAR,RECEIPT_SEMESTER,TO_CHAR(RECEIPT_DATE, 'mm/dd/yyyy')RECEIPT_DATE,RECEIPT_TIME,RECEIPT_PERIOD,"
                + " TOTAL_AMOUNT,RECEIPT_TYPE,RECEIPT_STATUS,REGIONAL_NO,CASH_AMOUNT,CHEQUE_AMOUNT,CREDIT_AMOUNT,REGIS_METHOD,REGIS_CK,"
                + " NEAR_GRADUATE,PAYMENT_CODE,ACCOUNT_NUMBER,BANK_FEE,RECEIPT_PAY_STATUS,REGIS_GROUP_NO,TO_CHAR(REGIS_DATE, 'mm/dd/yyyy')REGIS_DATE,TOTAL_AMOUNT_BANK,"
                + " BANK_VAT,BANK_TOTAL,NOMATCH_MONEY,TO_CHAR(BANK_DATE, 'mm/dd/yyyy')BANK_DATE,ADD_PAY,TO_CHAR(ADD_BANK_DATE, 'mm/dd/yyyy')ADD_BANK_DATE,EXAM_LOCATION_NO,WAIVED_NO,WAIVED_CR,CASHIER_NO,USERID,"
                + " TO_CHAR(UPDATE_DATE, 'mm/dd/yyyy')UPDATE_DATE,USERNAME,CREDITCARD_TYPE,CREDITCARD_FEE,POSTAL_AMOUNT,PAYMENT_TYPE,TIME_NO,CHK_GRADUATE_STATUS,SAVE_STATUS,"
                + " TO_CHAR(STATUS_B_UPDATE_DATE, 'mm/dd/yyyy')STATUS_B_UPDATE_DATE,FACULTY_NO,REF_KEY,REGIS_STATUS,TO_CHAR(EXPIRE_DATE, 'mm/dd/yyyy')EXPIRE_DATE FROM ET_RECEIPT"
                + " WHERE STD_CODE=? AND RECEIPT_YEAR=? AND RECEIPT_SEMESTER=? AND RECEIPT_PAY_STATUS=? AND REF_KEY = ?";
        Map<String, Object> row = db.querySingle(sql, receiptStdCode, receiptYear, receiptSemester, receiptPayStatus, refKey);

        return setAltmodel(row);

    }

    public boolean insert(ET_RECEIPT obj) {
        // int colorNo = getColorNo();
        String sql = "insert into ET_RECEIPT(YEAR,SEMESTER,EXAM_DATE,PERIOD,INSERT_DATE) "
                + " values(?,?,TO_DATE(?, 'mm/dd/yyyy hh24:mi:ss'),?,sysdate)";

        String[] genCol = {"EXAM_DATE"};
        int chk = db.insertRc(genCol, sql);

        try {
            if (chk > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

    }//end of insert

    public Boolean update(ET_RECEIPT objval) {
        String sql = "update ET_RECEIPT set"
                + "FISCAL_YEAR=?, COUNTER_NO=?, RECEIPT_NO=?, STD_CODE=?, RECEIPT_YEAR=?, RECEIPT_SEMESTER=?,"
                + "TO_DATE(RECEIPT_DATE, 'mm/dd/yyyy hh24:mi:ss')RECEIPT_DATE=?,"
                + "RECEIPT_TIME=?, RECEIPT_PERIOD=?, TOTAL_AMOUNT=?, RECEIPT_TYPE=?, RECEIPT_STATUS=?,"
                + "REGIONAL_NO=?, CASH_AMOUNT=?, CHEQUE_AMOUNT=?, CREDIT_AMOUNT=?, REGIS_METHOD=?,"
                + "REGIS_CK=?, NEAR_GRADUATE=?, PAYMENT_CODE=?, ACCOUNT_NUMBER=?, BANK_FEE=?,"
                + "RECEIPT_PAY_STATUS=?, REGIS_GROUP_NO=?, TO_DATE(REGIS_DATE, 'mm/dd/yyyy hh24:mi:ss')REGIS_DATE=?, TOTAL_AMOUNT_BANK=?, BANK_VAT=?,"
                + "BANK_TOTAL=?, NOMATCH_MONEY=?, TO_DATE(BANK_DATE, 'mm/dd/yyyy hh24:mi:ss')BANK_DATE=?, ADD_PAY=?, TO_DATE(ADD_BANK_DATE, 'mm/dd/yyyy hh24:mi:ss')ADD_BANK_DATE=?,"
                + "EXAM_LOCATION_NO=?, WAIVED_NO=?, WAIVED_CR=?, CASHIER_NO=?, USERID=?,"
                + "UPDATE_DATE=?, USERNAME=?, CREDITCARD_TYPE=?, CREDITCARD_FEE=?, POSTAL_AMOUNT=?,"
                + "PAYMENT_TYPE=?, TIME_NO=?, CHK_GRADUATE_STATUS=?, SAVE_STATUS=?, STATUS_B_UPDATE_DATE=?,"
                + "FACULTY_NO=?, REF_KEY=?, REGIS_STATUS=?, TO_DATE(EXPIRE_DATE, 'mm/dd/yyyy')EXPIRE_DATE=?"
                + "where STD_CODE=? AND RECEIPT_YEAR=? AND RECEIPT_SEMESTER=? AND RECEIPT_PAY_STATUS=? AND REF_KEY = ?";
        int chkUpdate = db.update(sql, objval.getFISCAL_YEAR(), objval.getCOUNTER_NO(), objval.getRECEIPT_NO(),
                objval.getSTD_CODE(), objval.getRECEIPT_YEAR(), objval.getRECEIPT_SEMESTER(), objval.getRECEIPT_DATE(),
                objval.getRECEIPT_TIME(), objval.getRECEIPT_PERIOD(), objval.getTOTAL_AMOUNT(), objval.getRECEIPT_TYPE(),
                objval.getRECEIPT_STATUS(), objval.getREGIONAL_NO(), objval.getCASH_AMOUNT(), objval.getCHEQUE_AMOUNT(),
                objval.getCREDIT_AMOUNT(), objval.getREGIS_METHOD(), objval.getREGIS_CK(), objval.getNEAR_GRADUATE(),
                objval.getPAYMENT_CODE(), objval.getACCOUNT_NUMBER(), objval.getBANK_FEE(), objval.getRECEIPT_PAY_STATUS(),
                objval.getREGIS_GROUP_NO(), objval.getREGIS_DATE(), objval.getTOTAL_AMOUNT_BANK(), objval.getBANK_VAT(),
                objval.getBANK_TOTAL(), objval.getNOMATCH_MONEY(), objval.getBANK_DATE(), objval.getADD_PAY(), objval.getADD_BANK_DATE(),
                objval.getEXAM_LOCATION_NO(), objval.getWAIVED_NO(), objval.getWAIVED_CR(), objval.getCASHIER_NO(), objval.getUSERID(),
                objval.getUPDATE_DATE(), objval.getUSERNAME(), objval.getCREDITCARD_TYPE(), objval.getCREDITCARD_FEE(), objval.getPOSTAL_AMOUNT(),
                objval.getPAYMENT_TYPE(), objval.getTIME_NO(), objval.getCHK_GRADUATE_STATUS(), objval.getSAVE_STATUS(), objval.getSTATUS_B_UPDATE_DATE(),
                objval.getFACULTY_NO(), objval.getREF_KEY(), objval.getREGIS_STATUS(), objval.getEXPIRE_DATE(), objval.getSTD_CODE(), objval.getRECEIPT_YEAR(),
                objval.getRECEIPT_SEMESTER(), objval.getRECEIPT_PAY_STATUS(), objval.getREF_KEY());
        try {
            return chkUpdate > 0;

        } catch (Exception e) {
            return false;
        }

    }

    public Boolean updateReceiptPayStatus(ET_RECEIPT objval, String changeReceiptPayStatus) {
        String sql = "UPDATE ET_RECEIPT SET "
                + "FISCAL_YEAR=?, COUNTER_NO=?, RECEIPT_NO=?, STD_CODE=?, RECEIPT_YEAR=?, RECEIPT_SEMESTER=?,"
                + "RECEIPT_DATE=TO_DATE(?,'mm/dd/yyyy HH24:MI:SS'),"
                + "RECEIPT_TIME=?, RECEIPT_PERIOD=?, TOTAL_AMOUNT=?, RECEIPT_TYPE=?, RECEIPT_STATUS=?,"
                + "REGIONAL_NO=?, CASH_AMOUNT=?, CHEQUE_AMOUNT=?, CREDIT_AMOUNT=?, REGIS_METHOD=?,"
                + "REGIS_CK=?, NEAR_GRADUATE=?, PAYMENT_CODE=?, ACCOUNT_NUMBER=?, BANK_FEE=?,"
                + "RECEIPT_PAY_STATUS=?, REGIS_GROUP_NO=?, REGIS_DATE=TO_DATE(?,'mm/dd/yyyy HH24:MI:SS'), TOTAL_AMOUNT_BANK=?, BANK_VAT=?,"
                + "BANK_TOTAL=?, NOMATCH_MONEY=?, BANK_DATE=TO_DATE(?,'mm/dd/yyyy HH24:MI:SS'), ADD_PAY=?, ADD_BANK_DATE=TO_DATE(?,'mm/dd/yyyy HH24:MI:SS'),"
                + "EXAM_LOCATION_NO=?, WAIVED_NO=?, WAIVED_CR=?, CASHIER_NO=?, USERID=?,"
                + "UPDATE_DATE=?, USERNAME=?, CREDITCARD_TYPE=?, CREDITCARD_FEE=?, POSTAL_AMOUNT=?,"
                + "PAYMENT_TYPE=?, TIME_NO=?, CHK_GRADUATE_STATUS=?, SAVE_STATUS=?, STATUS_B_UPDATE_DATE=TO_DATE(?,'mm/dd/yyyy HH24:MI:SS'),"
                + "FACULTY_NO=?, REF_KEY=?, REGIS_STATUS=?, EXPIRE_DATE=TO_DATE(?,'mm/dd/yyyy HH24:MI:SS')"
                + "WHERE STD_CODE=? AND RECEIPT_YEAR=? AND RECEIPT_SEMESTER=? AND RECEIPT_PAY_STATUS=? AND REF_KEY = ?";
        int chkUpdate = db.update(sql, objval.getFISCAL_YEAR(), objval.getCOUNTER_NO(), objval.getRECEIPT_NO(),
                objval.getSTD_CODE(), objval.getRECEIPT_YEAR(), objval.getRECEIPT_SEMESTER(), objval.getRECEIPT_DATE(),
                objval.getRECEIPT_TIME(), objval.getRECEIPT_PERIOD(), objval.getTOTAL_AMOUNT(), objval.getRECEIPT_TYPE(),
                objval.getRECEIPT_STATUS(), objval.getREGIONAL_NO(), objval.getCASH_AMOUNT(), objval.getCHEQUE_AMOUNT(),
                objval.getCREDIT_AMOUNT(), objval.getREGIS_METHOD(), objval.getREGIS_CK(), objval.getNEAR_GRADUATE(),
                objval.getPAYMENT_CODE(), objval.getACCOUNT_NUMBER(), objval.getBANK_FEE(), changeReceiptPayStatus,
                objval.getREGIS_GROUP_NO(), objval.getREGIS_DATE(), objval.getTOTAL_AMOUNT_BANK(), objval.getBANK_VAT(),
                objval.getBANK_TOTAL(), objval.getNOMATCH_MONEY(), objval.getBANK_DATE(), objval.getADD_PAY(), objval.getADD_BANK_DATE(),
                objval.getEXAM_LOCATION_NO(), objval.getWAIVED_NO(), objval.getWAIVED_CR(), objval.getCASHIER_NO(), objval.getUSERID(),
                objval.getUPDATE_DATE(), objval.getUSERNAME(), objval.getCREDITCARD_TYPE(), objval.getCREDITCARD_FEE(), objval.getPOSTAL_AMOUNT(),
                objval.getPAYMENT_TYPE(), objval.getTIME_NO(), objval.getCHK_GRADUATE_STATUS(), objval.getSAVE_STATUS(), objval.getSTATUS_B_UPDATE_DATE(),
                objval.getFACULTY_NO(), objval.getREF_KEY(), objval.getREGIS_STATUS(), objval.getEXPIRE_DATE(), 
                objval.getSTD_CODE(), objval.getRECEIPT_YEAR(),
                objval.getRECEIPT_SEMESTER(), objval.getRECEIPT_PAY_STATUS(), objval.getREF_KEY());
        try {
            return chkUpdate > 0;

        } catch (Exception e) {
            return false;
        }

    }

    public Boolean delete(String year, String sem) {
        String sql = "delete from ET_RECEIPT where STUDY_YEAR = ? and STUDY_SEMESTER = ?";
        int chkDelete = db.remove2Val(sql, year, sem);
        try {
            if (chkDelete > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }  //end of delete

    public int countStudent() {
        int maxusr = 0;
        String sql = "select to_char(count(to_number(STD_CODE)))STUDY_SEMESTER from ET_RECEIPT";
        Map<String, Object> row = db.querySingle(sql);

        if (row != null) {
            maxusr = Integer.parseInt((String) row.get("STUDY_SEMESTER"));
            return maxusr;
        } else {
            return 0;
        }
    }//end get max no
}
