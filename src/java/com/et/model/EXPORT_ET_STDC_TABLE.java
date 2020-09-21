package com.et.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EXPORT_ET_STDC_TABLE {

    Database db;

    public EXPORT_ET_STDC_TABLE(Database db) {
        this.db = db;
    }

    public EXPORT_ET_STDC setAltmodel(Map<String, Object> row) {

        if (row != null) {
            EXPORT_ET_STDC getRow = EXPORT_ET_STDC.builder()
                    .YEAR((String) row.get("YEAR"))
                    .SEMESTER((String) row.get("SEMESTER"))
                    .STD_CODE((String) row.get("STD_CODE"))
                    .COURSE_NO((String) row.get("COURSE_NO"))
                    .CREDIT((BigDecimal) row.get("CREDIT"))
                    .SECTION_NO((String) row.get("SECTION_NO"))
                    .EXAM_DATE((String) row.get("EXAM_DATE"))
                    .ROW_SEAT((String) row.get("ROW_SEAT"))
                    .build();

            return getRow;
        } else {
            return null;
        }
    }

    public List<EXPORT_ET_STDC> findExportEtSTDC(String examDate, String section) {
        List<EXPORT_ET_STDC> list = new ArrayList<EXPORT_ET_STDC>();
        String sql  = " SELECT A.YEAR, A.SEMESTER,  A.STD_CODE,  A.COURSE_NO, A.CREDIT, A.SECTION_NO, TO_CHAR(A.EXAM_DATE, 'dd/mm/yyyy', 'NLS_CALENDAR=''THAI BUDDHA'' NLS_DATE_LANGUAGE=THAI')EXAM_DATE, A.ROW_SEAT"
                    + " FROM ET_ROW_SEAT_ORDER A"
                    + " LEFT JOIN ET_RECEIPT B"
                    + " ON A.STD_CODE = B.STD_CODE"
                    + " WHERE B.RECEIPT_PAY_STATUS = '1' AND A.SECTION_NO = '" + section + "' AND  A.EXAM_DATE = TO_DATE('"+ examDate +"', 'dd/mm/yyyy')";
        List<Map<String, Object>> result = db.queryList(sql);

        for (Map<String, Object> row : result) {

            list.add(setAltmodel(row));
        }
        return list;
    }
    //end find 
    
    public List<EXPORT_ET_STDC> findExportEtSTDCAllSection(String examDate) {
        List<EXPORT_ET_STDC> list = new ArrayList<EXPORT_ET_STDC>();
        String sql  = " SELECT A.YEAR, A.SEMESTER,  A.STD_CODE,  A.COURSE_NO, A.CREDIT, A.SECTION_NO, TO_CHAR(A.EXAM_DATE, 'dd/mm/yyyy', 'NLS_CALENDAR=''THAI BUDDHA'' NLS_DATE_LANGUAGE=THAI')EXAM_DATE, A.ROW_SEAT"
                    + " FROM ET_ROW_SEAT_ORDER A"
                    + " LEFT JOIN ET_RECEIPT B"
                    + " ON A.STD_CODE = B.STD_CODE"
                    + " WHERE B.RECEIPT_PAY_STATUS = '1' AND  A.EXAM_DATE = TO_DATE('"+ examDate +"', 'dd/mm/yyyy')";
        List<Map<String, Object>> result = db.queryList(sql);

        for (Map<String, Object> row : result) {

            list.add(setAltmodel(row));
        }
        return list;
    }
    //end find 

}
