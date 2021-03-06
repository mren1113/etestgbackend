package com.et.control.mangement;

import com.et.model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SeatManagementUpdate extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Database db = new Database();

        // ----- Query วัน/เดือน/ปี และภาคการศึกษา เพื่อไปแสดง ------------------------- 
        ET_COUNTER_ADMIN_TABLE getAdminTable = new ET_COUNTER_ADMIN_TABLE(db);
        ET_COUNTER_ADMIN getCounterData = getAdminTable.findCounterData();

        // ----- Query วัน/เดือน/ปี ที่ทำการเปิดสอบ เพื่อแสดงในเมนู -----------------------
        ET_EXAM_DATE_TABLE getExamDateTable = new ET_EXAM_DATE_TABLE(db);
        List<ET_EXAM_DATE> getExamDate = getExamDateTable.findAllExamDate();

        // ----- Query ข้อมูล ปี/ภาค/ตึกสอบ/แถว/จำนวนที่นั่งต่อแถว -----------------------
        ET_BUILE_ROW_TABLE getBuildRowTable = new ET_BUILE_ROW_TABLE(db);
        List<ET_BUILE_ROW> getBuildRow = getBuildRowTable.findAll();

        // ---- ผลรวมของจำนวนที่นั่งทั้งหมด -------------------------------------------
        int sumSeat = 0;
        for (int i = 0; i < getBuildRow.size(); i++) {
            sumSeat += getBuildRow.get(i).getSEAT_EXAM().intValue();
        }
        request.setAttribute("sumSeat", sumSeat);

        // ----- วัน/เดือน/ปี และภาคการศึกษา เพื่อไปแสดง ------------------------------- 
        request.setAttribute("getCounterData", getCounterData);

        // ----- วัน/เดือน/ปี ที่ทำการเปิดสอบ เพื่อแสดงในเมนู -----------------------------
        request.setAttribute("getExamDate", getExamDate);

        // ------ เลือกเพิ่ม แถว และที่นั่งสอบ -----------------------------------------
        if (request.getParameter("Year") != null
                && request.getParameter("Semester") != null
                && request.getParameter("RowExam") != null) {

            String Year = request.getParameter("Year");
            String Semester = request.getParameter("Semester");
            String RowExam = request.getParameter("RowExam");

            //------- ข้อมูล ปี/ภาค/ตึกสอบ/แถว/จำนวนที่นั่งต่อแถว ------------------------
            ET_BUILE_ROW BuildRow = getBuildRowTable.findBylist(Year, Semester, RowExam);
            request.setAttribute("BuildRow", BuildRow);

            RequestDispatcher rs = request.getRequestDispatcher("admin/Seat-Management-Edit.jsp");
            rs.forward(request, response);

        } else if (request.getParameter("submit") != null) { // --- แก้ไข --------

            // ------ เมื่อมีการ submit เพื่อแก้ไข แถว และที่นั่งสอบ  หลังกรอกข้อมูลแล้ว -----
            String YEAR = request.getParameter("year");
            String SEMESTER = request.getParameter("semester");
            String BUILD_NO = request.getParameter("build_no").toUpperCase();
            String ROW_EXAM = request.getParameter("row_exam");
            String SEAT_EXAM = request.getParameter("seat_exam");
            String SUM_SEAT_EXAM = request.getParameter("sumSeat");

            //--- ค้นหาข้อมูลเดิมที่ไม่ด้ แก้ไขมาใส่ไว้เหมือนเดิม -----------------------------
            ET_BUILE_ROW getBuildRowUpdate = getBuildRowTable.findBylist(YEAR, SEMESTER, ROW_EXAM);

            // --- SUM SEAT_EXAM เพิ่มทำการแก้ไขที่ตาราง ET_EXAM ทุกครั้ง ---------------
            BigDecimal NOW_SEAT = getBuildRowUpdate.getSEAT_EXAM();
            int TEMP_SUM_SEAT_EXAM = Integer.parseInt(SUM_SEAT_EXAM) - NOW_SEAT.intValue();
            int SumSeat = TEMP_SUM_SEAT_EXAM + Integer.parseInt(SEAT_EXAM);

            // ----- Query วัน/เดือน/ปี และภาคการศึกษา จำนวนที่นั่ง เพื่อไปแสดง ------------
            ET_EXAM_SEAT_TABLE getExamSeatTable = new ET_EXAM_SEAT_TABLE(db);

            //--- สร้าง object เพื่อส่งไปแก้ไข ----------------------------------------
            ET_BUILE_ROW updateRowBuild = new ET_BUILE_ROW();
            updateRowBuild.setYEAR(YEAR);
            updateRowBuild.setSEMESTER(SEMESTER);
            updateRowBuild.setBUILD_NO(BUILD_NO);
            updateRowBuild.setROW_EXAM(ROW_EXAM);
            updateRowBuild.setSEAT_EXAM(BigDecimal.valueOf(Integer.valueOf(SEAT_EXAM)));
            updateRowBuild.setINSERT_DATE(getBuildRowUpdate.getINSERT_DATE());
            updateRowBuild.setINSERT_USER(getBuildRowUpdate.getINSERT_USER());
            updateRowBuild.setUPDATE_USER(getBuildRowUpdate.getUPDATE_USER());

            boolean checkRowBuild = getBuildRowTable.update(updateRowBuild);
            PrintWriter out = response.getWriter();

            boolean checkUpdateSumSeat = getExamSeatTable.updateSumSeat(String.valueOf(SumSeat));
            if (checkUpdateSumSeat) {
                System.out.println("แก้ไขข้อมูลเรียบร้อย checkUpdateSumSeat");
            } else {
                System.out.println("แก้ไขมีบางอย่างผิดพลาด checkUpdateSumSeat");
            }
            
            if (checkRowBuild) {
                System.out.println("แก้ไขสำเร็จ");
                out.println("<script type=\"text/javascript\">");
                out.println("alert('แก้ไขข้อมูลเรียบร้อย');");
                out.println("location='SeatManagement';");
                out.println("</script>");
            } else {
                System.out.println("แก้ไขไม่สำเร็จ");
                out.println("<script type=\"text/javascript\">");
                out.println("alert('มีบางอย่างผิดพลาด แก้ไขข้อมูลไม่สำเร็จ');");
                out.println("location='SeatManagement';");
                out.println("</script>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
