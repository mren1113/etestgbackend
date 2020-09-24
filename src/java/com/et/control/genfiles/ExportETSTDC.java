package com.et.control.genfiles;

import com.et.model.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExportETSTDC extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");

        Database db = new Database();

        ET_COUNTER_ADMIN_TABLE getAdminTable = new ET_COUNTER_ADMIN_TABLE(db);
        ET_COUNTER_ADMIN getCounterData = getAdminTable.findCounterData();

        ET_EXAM_DATE_TABLE getExamDateTable = new ET_EXAM_DATE_TABLE(db);
        List<ET_EXAM_DATE> getExamDate = getExamDateTable.findAllExamDate();

        request.setAttribute("getCounterData", getCounterData);
        request.setAttribute("getExamDate", getExamDate);

        // Parame Export Text File
        String CheckExportText = request.getParameter("Export");

        if (getCounterData != null && CheckExportText == null) {

            RequestDispatcher rs = request.getRequestDispatcher("admin/Export-ETSTDC-Main.jsp");
            rs.forward(request, response);

        } else if (CheckExportText.equals("FindExport")) {

            String examdate = request.getParameter("examdate");
            String section = request.getParameter("section");

            EXPORT_ET_STDC_TABLE getExportET_STDC = new EXPORT_ET_STDC_TABLE(db);
            List<EXPORT_ET_STDC> ExportET_STDC = null;

            ArrayList<ET_STDC> lists = new ArrayList<ET_STDC>();

            if (section.equals("0")) { //--- ค้นข้อมูลทั้งหมด คาบสอบ

                if (examdate.equals("0")) { // --- ค้นข้อมูลทั้งหมด วัน/เดือน/ปี

                    ExportET_STDC = getExportET_STDC.findExportEtSTDCAll(); // --- ค้นข้อมูลทั้งหมด ทุก วัน/เดือน/ปี ที่สอบ และทุกคาบสอบ

                } else {
                    
                    ExportET_STDC = getExportET_STDC.findExportEtSTDCAllSection(examdate); //--- ค้นข้อมูล ทุก คาบสอบ ตาม วัน/เดือน/ปี ที่สอบ

                }

            } else {

                if (examdate.equals("0")) { // --- ค้นข้อมูลทั้งหมด วัน/เดือน/ปี
                    
                    ExportET_STDC = getExportET_STDC.findExportEtSTDCAllDateBySection(section); //--- ค้นข้อมูลทั้งหมด วัน/เดือน/ปี ตามคาบสอบที่ต้องการ

                } else {
                    
                    ExportET_STDC = getExportET_STDC.findExportEtSTDCByDateAndSection(examdate, section); //--- ค้นข้อมูล ตาม วัน/เดือน/ปี และคาบที่เลือก

                }
            }

            if (!ExportET_STDC.isEmpty()) {

                for (int i = 0; i < ExportET_STDC.size(); i++) {
                    ET_STDC et_stdc = new ET_STDC();

                    //--- เปลี่ยน พ.ศ. ให้เป็น ค.ศ. ก่อน 
                    final String TEMP_OLD_FORMAT = "dd/MM/yyyy";
                    final String TEMP_NEW_FORMAT = "yyyy-MM-dd";
                    String TEMP_OldDateString = ExportET_STDC.get(i).getEXAM_DATE();
                    String TEMP_EXAM_DATE;

                    //--- เปลี่ยน พ.ศ. ให้เป็น ค.ศ. ก่อน (เปลี่ยนรูปแบบเพื่อแปลง)
                    SimpleDateFormat temp_sdf = new SimpleDateFormat(TEMP_OLD_FORMAT, Locale.US);
                    Date temp_d = temp_sdf.parse(TEMP_OldDateString);
                    temp_sdf.applyPattern(TEMP_NEW_FORMAT);
                    TEMP_EXAM_DATE = temp_sdf.format(temp_d);
                    //--- เปลี่ยน พ.ศ. ให้เป็น ค.ศ. ก่อน (ลบ 2563-543 = 2020)
                    LocalDate TEMP_EXAM_DATEe = LocalDate.parse(TEMP_EXAM_DATE).minus(543, ChronoUnit.YEARS);

                    //--- เปลี่ยนรูปแบบเพื่อค้นหาข้อมูลที่ต้องการลบ
                    final String OLD_FORMAT = "yyyy-MM-dd";
                    final String NEW_FORMAT = "ddMMyy";
                    String oldDateString = TEMP_EXAM_DATEe.toString();
                    String NEW_EXAM_DATE;

                    SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
                    Date d = sdf.parse(oldDateString);
                    sdf.applyPattern(NEW_FORMAT);
                    NEW_EXAM_DATE = sdf.format(d);

                    String ROW_SEAT;
                    if (ExportET_STDC.get(i).getROW_SEAT().length() == 2) {
                        ROW_SEAT = ExportET_STDC.get(i).getROW_SEAT().substring(0, 1) + '0' + ExportET_STDC.get(i).getROW_SEAT().substring(1);
                    } else {
                        ROW_SEAT = ExportET_STDC.get(i).getROW_SEAT();
                    }

                    et_stdc.setStdc_year(ExportET_STDC.get(i).getYEAR());
                    et_stdc.setStdc_std_semester(ExportET_STDC.get(i).getSEMESTER());
                    et_stdc.setStdc_std_code(ExportET_STDC.get(i).getSTD_CODE());
                    et_stdc.setStdc_std_course_code(ExportET_STDC.get(i).getCOURSE_NO() + "   ");
                    et_stdc.setStdc_credit("0" + ExportET_STDC.get(i).getCREDIT() + " ");
                    et_stdc.setStdc_section("02 ");
                    et_stdc.setApp_date_etest_dd(NEW_EXAM_DATE);
                    et_stdc.setApp_period_etest(ExportET_STDC.get(i).getSECTION_NO() + " ");
                    et_stdc.setApp_bld("SKB802");
                    et_stdc.setApp_row(ROW_SEAT);
                    et_stdc.setEtest_status(" e-  ");
                    et_stdc.setStdc_score_tot("000 ");
                    et_stdc.setStdc_score_M("000 ");
                    et_stdc.setStdc_score_F("000 ");
                    et_stdc.setStdc_score_chsum("0000");

                    lists.add(et_stdc);
                }//end for

            } else {

                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('วันที่สอบ หรือ คาบสอบที่เลือกไม่มีนักศึกษาลงทะเบียน!!!');");
                out.println("location='ExportETSTDC';");
                out.println("</script>");

            }

            if (!lists.isEmpty()) {

                response.setContentType("text/plain");
                response.setHeader("Content-Disposition", "attachment; filename=\"ET_STDC.txt\"");
                try {
                    OutputStream outputStream = response.getOutputStream();
                    String outputResult = "";
                    for (ET_STDC list : lists) {

                        outputResult
                                = list.getStdc_year()
                                + list.getStdc_std_semester()
                                + list.getStdc_std_code()
                                + list.getStdc_std_course_code()
                                + list.getStdc_credit()
                                + list.getStdc_section()
                                + list.getApp_date_etest_dd()
                                + list.getApp_period_etest()
                                + list.getApp_bld()
                                + list.getApp_row()
                                + list.getEtest_status()
                                + list.getStdc_score_tot()
                                + list.getStdc_score_M()
                                + list.getStdc_score_F()
                                + list.getStdc_score_chsum() + "\n";
                        outputStream.write(outputResult.getBytes());
                    }
                    outputStream.flush();
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

                System.out.println("Lists = null");

            }

        }

        db.close();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ExportETSTDC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ExportETSTDC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
