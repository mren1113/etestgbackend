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
import lombok.Data;

/**
 *
 * @author RU-COM7
 */
@Data
public class XINT_STD_REGIS_EXAM_TABLE {

    Database db;

    public XINT_STD_REGIS_EXAM_TABLE(Database db) {
        this.db = db;
    }

    public XINT_STD_REGIS_EXAM setAltmodel(Map<String, Object> row) {

        if (row != null) {
            XINT_STD_REGIS_EXAM getRow = XINT_STD_REGIS_EXAM.builder()
                    .YEAR((String) row.get("YEAR"))
                    .SEMESTER((String) row.get("USERNAME"))
                    .STD_CODE((String) row.get("STD_CODE"))
                    .EXAM_TYPE((String) row.get("EXAM_TYPE"))
                    .TIME_NO((BigDecimal) row.get("TIME_NO"))
                    .COURSE_NO((String) row.get("COURSE_NO"))
                    .ORDER_NO((BigDecimal) row.get("ORDER_NO"))
                    .EXAM_DATE((String) row.get("EXAM_DATE"))
                    .EXAM_PERIOD((String) row.get("EXAM_PERIOD"))
                    .WEIGH_NO((BigDecimal) row.get("TIME_NO"))
                    .ROW_NO((BigDecimal) row.get("ROW_NO"))
                    .SEAT_NO((BigDecimal) row.get("SEAT_NO"))
                    .INSERT_DATE((String) row.get("INSERT_DATE"))
                    .INSERT_USER((String) row.get("INSERT_USER"))
                    .UPDATE_DATE((String) row.get("UPDATE_DATE"))
                    .UPDATE_USER((String) row.get("UPDATE_USER"))
                    .APPROVE_OK((String) row.get("APPROVE_OK"))
                    .COURSE_COMMENT((String) row.get("COURSE_COMMENT"))
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

    public List<XINT_STD_REGIS_EXAM> findAll() {
        List<XINT_STD_REGIS_EXAM> list = new ArrayList<XINT_STD_REGIS_EXAM>();
        String sql = "SELECT * FROM XINT_STD_REGIS_EXAM ";
        List<Map<String, Object>> result = db.queryList(sql);

        for (Map<String, Object> row : result) {

            list.add(setAltmodel(row));
        }
        return list;
    }
    //end find 

    public List<XINT_STD_REGIS_EXAM> findListRegisApproov(String year, String sem, String stdid) {
        List<XINT_STD_REGIS_EXAM> list = new ArrayList<XINT_STD_REGIS_EXAM>();
        String sql = "SELECT COURSE_NO,to_char(EXAM_DATE, 'DD/MM/YYYY', 'NLS_CALENDAR=''THAI BUDDHA'' NLS_DATE_LANGUAGE=THAI')EXAM_DATE,"
                + "EXAM_PERIOD,APPROVE_OK,COURSE_COMMENT FROM XINT_STD_REGIS_EXAM WHERE "
                + " YEAR = ? and SEMESTER = ? and STD_CODE = ?";
        List<Map<String, Object>> result = db.queryList(sql, year, sem, stdid);

        for (Map<String, Object> row : result) {

            list.add(setAltmodel(row));
        }
        return list;
    }
    //end find 
    
    public List<XINT_STD_REGIS_EXAM> findListFoRegisApproovTable(String year, String sem, String stdid) {
        List<XINT_STD_REGIS_EXAM> list = new ArrayList<XINT_STD_REGIS_EXAM>();
        String sql = "SELECT COURSE_NO,STD_CODE,YEAR,SEMESTER,EXAM_TYPE,APPROVE_OK,"
                + "to_char(EXAM_DATE, 'DD/MM/YYYY', 'NLS_CALENDAR=''THAI BUDDHA'' NLS_DATE_LANGUAGE=THAI')EXAM_DATE,"
                + " EXAM_PERIOD FROM XINT_STD_REGIS_EXAM WHERE "
                + " YEAR = ? and SEMESTER = ? and STD_CODE = ?  order by INSERT_DATE asc";
        List<Map<String, Object>> result = db.queryList(sql, year, sem, stdid);

        for (Map<String, Object> row : result) {

            list.add(setAltmodel(row));
        }
        return list;
    }
    //end find 
    
     public List<XINT_STD_REGIS_EXAM> findListStudentApproved(String facNo,String year, String sem) {
        List<XINT_STD_REGIS_EXAM> list = new ArrayList<XINT_STD_REGIS_EXAM>();
        String sql = "select distinct(C.STD_CODE)STD_CODE,A.NAME_THAI,A.NAME_ENG,A.MAJOR_NAME_THAI,A.FACULTY_NAME_THAI,"
                + "to_char(c.INSERT_DATE, 'DD/MM/YYYY', 'NLS_CALENDAR=''THAI BUDDHA'' NLS_DATE_LANGUAGE=THAI')INSERT_DATE,"
                + "to_char(c.UPDATE_DATE, 'DD/MM/YYYY', 'NLS_CALENDAR=''THAI BUDDHA'' NLS_DATE_LANGUAGE=THAI')UPDATE_DATE "
                + " from dbbach00.VM_STUDENT_REGIS a,XINT_STD_REGIS_EXAM c "
                + " where a.STD_CODE = C.STD_CODE and c.APPROVE_OK = '1' and A.FACULTY_NO = ? "
                + " and c.YEAR = ? and c.SEMESTER =  ?  order by INSERT_DATE asc";
        List<Map<String, Object>> result = db.queryList(sql, facNo, year, sem);

        for (Map<String, Object> row : result) {

            list.add(setAltmodel(row));
        }
        return list;
    }
    //end find 
     
     public List<XINT_STD_REGIS_EXAM> findListByAdminStudentApproved(String year, String sem) {
        List<XINT_STD_REGIS_EXAM> list = new ArrayList<XINT_STD_REGIS_EXAM>();
        String sql = "select distinct(C.STD_CODE)STD_CODE,A.NAME_THAI,A.NAME_ENG,A.MAJOR_NAME_THAI,A.FACULTY_NAME_THAI,"
                + "to_char(c.INSERT_DATE, 'DD/MM/YYYY', 'NLS_CALENDAR=''THAI BUDDHA'' NLS_DATE_LANGUAGE=THAI')INSERT_DATE,"
                + "to_char(c.UPDATE_DATE, 'DD/MM/YYYY', 'NLS_CALENDAR=''THAI BUDDHA'' NLS_DATE_LANGUAGE=THAI')UPDATE_DATE "
                + " from dbbach00.VM_STUDENT_REGIS a,XINT_STD_REGIS_EXAM c "
                + " where a.STD_CODE = C.STD_CODE and c.APPROVE_OK = '1' "
                + " and c.YEAR = ? and c.SEMESTER =  ? order by INSERT_DATE asc";
        List<Map<String, Object>> result = db.queryList(sql, year, sem);

        for (Map<String, Object> row : result) {

            list.add(setAltmodel(row));
        }
        return list;
    }
    //end find 

     public List<XINT_STD_REGIS_EXAM> findListStudentNotApproved(String facNo,String year, String sem) {
        List<XINT_STD_REGIS_EXAM> list = new ArrayList<XINT_STD_REGIS_EXAM>();
        String sql = "select distinct(C.STD_CODE)STD_CODE,A.NAME_THAI,A.NAME_ENG,A.MAJOR_NAME_THAI,A.FACULTY_NAME_THAI,"
                + "to_char(c.INSERT_DATE, 'DD/MM/YYYY', 'NLS_CALENDAR=''THAI BUDDHA'' NLS_DATE_LANGUAGE=THAI')INSERT_DATE,"
                + "to_char(c.UPDATE_DATE, 'DD/MM/YYYY', 'NLS_CALENDAR=''THAI BUDDHA'' NLS_DATE_LANGUAGE=THAI')UPDATE_DATE "
                + " from dbbach00.VM_STUDENT_REGIS a,XINT_STD_REGIS_EXAM c "
                + " where a.STD_CODE = C.STD_CODE and c.APPROVE_OK is null and A.FACULTY_NO = ? "
                + " and c.YEAR = ? and c.SEMESTER =  ?  order by INSERT_DATE asc";
        List<Map<String, Object>> result = db.queryList(sql, facNo, year, sem);

        for (Map<String, Object> row : result) {

            list.add(setAltmodel(row));
        }
        return list;
    }
    //end find 
       public List<XINT_STD_REGIS_EXAM> findListByAdminStudentNotApproved(String year, String sem) {
        List<XINT_STD_REGIS_EXAM> list = new ArrayList<XINT_STD_REGIS_EXAM>();
        String sql = "select distinct(C.STD_CODE)STD_CODE,A.NAME_THAI,A.NAME_ENG,A.MAJOR_NAME_THAI,A.FACULTY_NAME_THAI,"
                + "to_char(c.INSERT_DATE, 'DD/MM/YYYY', 'NLS_CALENDAR=''THAI BUDDHA'' NLS_DATE_LANGUAGE=THAI')INSERT_DATE,"
                + "to_char(c.UPDATE_DATE, 'DD/MM/YYYY', 'NLS_CALENDAR=''THAI BUDDHA'' NLS_DATE_LANGUAGE=THAI')UPDATE_DATE "
                + " from dbbach00.VM_STUDENT_REGIS a,XINT_STD_REGIS_EXAM c "
                + " where a.STD_CODE = C.STD_CODE and c.APPROVE_OK is null "
                + " and c.YEAR = ? and c.SEMESTER =  ?  order by INSERT_DATE asc";
        List<Map<String, Object>> result = db.queryList(sql, year, sem);

        for (Map<String, Object> row : result) {

            list.add(setAltmodel(row));
        }
        return list;
    }
    //end find 

    public XINT_STD_REGIS_EXAM findByUserName(String x) {
        String sql = "SELECT * FROM XINT_STD_REGIS_EXAM WHERE STD_CODE = ?";
        Map<String, Object> row = db.querySingle(sql, x);

        return setAltmodel(row);

    }

    public XINT_STD_REGIS_EXAM findApproovStatus(String year, String sem, String stdcode) {
        String sql = "SELECT APPROVE_OK FROM XINT_STD_REGIS_EXAM WHERE YEAR = ? and SEMESTER = ? and STD_CODE = ?";
        Map<String, Object> row = db.querySingle(sql, year, sem, stdcode);

        return setAltmodel(row);

    }

    public boolean insert(XINT_STD_REGIS_EXAM objval) {
        // int colorNo = getColorNo();
        String sql = "insert into XINT_STD_REGIS_EXAM(STD_CODE,YEAR,SEMESTER,COURSE_NO,EXAM_DATE,EXAM_PERIOD,EXAM_TYPE,INSERT_DATE) "
                + "values(?,?,?,?,TO_DATE(?, 'dd/mm/yyyy', 'NLS_CALENDAR=''THAI BUDDHA'' NLS_DATE_LANGUAGE=THAI'),?,?,SYSDATE)";

        String[] genCol = {"STD_CODE"};
        int chk = db.insertRc(genCol, sql, objval.getSTD_CODE(), objval.getYEAR(), objval.getSEMESTER(), objval.getCOURSE_NO(),
                objval.getEXAM_DATE(), objval.getEXAM_PERIOD(), objval.getEXAM_TYPE());

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

    public Boolean update(XINT_STD_REGIS_EXAM objval) {
        String sql = "update XINT_STD_REGIS_EXAM set UPDATE_DATE = SYSDATE, APPROVE_OK = ? ,COURSE_COMMENT = ? "
                + " where COURSE_NO =? and YEAR = ? and SEMESTER = ? and STD_CODE = ?";
        int chkUpdate = db.update(sql, objval.getAPPROVE_OK(),objval.getCOURSE_COMMENT(),objval.getCOURSE_NO(),objval.getYEAR(),objval.getSEMESTER(),objval.getSTD_CODE());
        try {
            return chkUpdate > 0;

        } catch (Exception e) {
            return false;
        }

    }

    //end of update
    public Boolean delete(String objval) {
        String sql = "delete from XINT_STD_REGIS_EXAM where STD_CODE = ?";
        int chkDelete = db.remove(sql, objval);
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

    public int countCheckRegisExam(String stdid) {
        int maxusr = 0;
        String sql = "select to_char(count(to_number(STD_CODE)))STD_CODE from XINT_STD_REGIS_EXAM where STD_CODE =?  ";
        Map<String, Object> row = db.querySingle(sql,stdid);

        if (row != null) {
            maxusr = Integer.parseInt((String) row.get("STD_CODE"));
            return maxusr;
        } else {
            return 0;
        }
    }//end get max no

    public int countCourseRegisStudent(String year, String sem, String stdcode) {
        int maxusr = 0;
        String sql = "select to_char(count(to_number(STD_CODE)))STD_CODE from XINT_STD_REGIS_EXAM where YEAR = ? and SEMESTER = ? and STD_CODE = ?  ";
        Map<String, Object> row = db.querySingle(sql, year, sem, stdcode);

        if (row != null) {
            maxusr = Integer.parseInt((String) row.get("STD_CODE"));
            return maxusr;
        } else {
            return 0;
        }
    }//end get max no
}
