package com.et.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VM_STUDENT_MOBILE_TABLE {

    Database db;

    public VM_STUDENT_MOBILE_TABLE(Database db) {
        this.db = db;
    }

    public VM_STUDENT_MOBILE setAltmodel(Map<String, Object> row) {

        if (row != null) {
            VM_STUDENT_MOBILE getRow = VM_STUDENT_MOBILE.builder()
                    .STD_CODE((String) row.get("STD_CODE"))
                    .NAME_THAI((String) row.get("NAME_THAI"))
                    .CITIZEN_NO((String) row.get("CITIZEN_NO"))
                    .BIRTH_DATE((String) row.get("BIRTH_DATE"))
                    .STD_STATUS_CURRENT((String) row.get("STD_STATUS_CURRENT"))
                    .STD_STATUS_DESC_THAI((String) row.get("STD_STATUS_DESC_THAI"))
                    .ENROLL_YEAR((String) row.get("ENROLL_YEAR"))
                    .ENROLL_SEMESTER((String) row.get("ENROLL_SEMESTER"))
                    .ENROLL_CURR((String) row.get("ENROLL_CURR"))
                    .CUMM_CREDIT((BigDecimal) row.get("CUMM_CREDIT"))
                    .STD_TYPE((BigDecimal) row.get("STD_TYPE"))
                    .STD_TYPE_DESC_THAI((String) row.get("STD_TYPE_DESC_THAI"))
                    .CAMPUS_NO((BigDecimal) row.get("CAMPUS_NO"))
                    .CAMPUS_NAME_THAI((String) row.get("CAMPUS_NAME_THAI"))
                    .FACULTY_NO((String) row.get("FACULTY_NO"))
                    .FACULTY_NAME_THAI((String) row.get("FACULTY_NAME_THAI"))
                    .CURR_NO((BigDecimal) row.get("CURR_NO"))
                    .CURR_NAME_THAI((String) row.get("CURR_NAME_THAI"))
                    .MAJOR_NO((String) row.get("MAJOR_NO"))
                    .MAJOR_NAME_THAI((String) row.get("MAJOR_NAME_THAI"))
                    .PENAL_NO((String) row.get("PENAL_NO"))
                    .PENAL_NAME_THAI((String) row.get("PENAL_NAME_THAI"))
                    .LIBRARY_LOCK((String) row.get("LIBRARY_LOCK"))
                    .CERT_LOCK((String) row.get("CERT_LOCK"))
                    .CHK_CERT_NO((String) row.get("CHK_CERT_NO"))
                    .CHK_CERT_NAME_THAI((String) row.get("CHK_CERT_NAME_THAI"))
                    .SUBSIDY_NO((BigDecimal) row.get("SUBSIDY_NO"))
                    .SUBSIDY_NAME_THAI((String) row.get("SUBSIDY_NAME_THAI"))
                    .FLAG_SEMESTER((String) row.get("FLAG_SEMESTER"))
                    .REGIS_OK((BigDecimal) row.get("REGIS_OK"))
                    .ENROLLMENT_NO((String) row.get("ENROLLMENT_NO"))
                    .ID_LOCK((String) row.get("ID_LOCK"))
                    .MOBILE_TELEPHONE((String) row.get("MOBILE_TELEPHONE"))
                    .WAIVED_NO((String) row.get("WAIVED_NO"))
                    .FIRST_NAME_ENG((String) row.get("FIRST_NAME_ENG"))
                    .MIDDLE_NAME_ENG((String) row.get("MIDDLE_NAME_ENG"))
                    .LAST_NAME_ENG((String) row.get("LAST_NAME_ENG"))
                    .build();

            return getRow;
        } else {
            return null;
        }
    }

    public List<VM_STUDENT_MOBILE> findAll() {
        List<VM_STUDENT_MOBILE> list = new ArrayList<VM_STUDENT_MOBILE>();
        String sql = " SELECT  STD_CODE, NAME_THAI, CITIZEN_NO, TO_CHAR(BIRTH_DATE, 'dd/mm/yyyy', 'NLS_CALENDAR=''THAI BUDDHA'' NLS_DATE_LANGUAGE=THAI')BIRTH_DATE,"
                   + "  STD_STATUS_CURRENT, STD_STATUS_DESC_THAI, ENROLL_YEAR, ENROLL_SEMESTER, ENROLL_CURR, CUMM_CREDIT, STD_TYPE, STD_TYPE_DESC_THAI, CAMPUS_NO,"
                   + " CAMPUS_NAME_THAI, FACULTY_NO, FACULTY_NAME_THAI, CURR_NO, CURR_NAME_THAI, MAJOR_NO, MAJOR_NAME_THAI, "
                   + " PENAL_NO, PENAL_NAME_THAI, LIBRARY_LOCK, CERT_LOCK, CHK_CERT_NO, CHK_CERT_NAME_THAI, SUBSIDY_NO,"
                   + " SUBSIDY_NAME_THAI, FLAG_SEMESTER, REGIS_OK, ENROLLMENT_NO, ID_LOCK, MOBILE_TELEPHONE, WAIVED_NO, FIRST_NAME_ENG, MIDDLE_NAME_ENG, LAST_NAME_ENG"
                   + " FROM    DBBACH00.VM_STUDENT_MOBILE";
        List<Map<String, Object>> result = db.queryList(sql);

        for (Map<String, Object> row : result) {

            list.add(setAltmodel(row));
        }
        return list;
    }
    //end find 

    public List<VM_STUDENT_MOBILE> findBylist(String x) {
        List<VM_STUDENT_MOBILE> list = new ArrayList<VM_STUDENT_MOBILE>();
        String sql = "SELECT select FISCAL_YEAR,STUDY_YEAR,STUDY_SEMESTER,TYPE_COUNTER FROM VM_STUDENT_MOBILE ";
        List<Map<String, Object>> result = db.queryList(sql, x);

        for (Map<String, Object> row : result) {

            list.add(setAltmodel(row));
        }
        return list;
    }
    //end find 

}
