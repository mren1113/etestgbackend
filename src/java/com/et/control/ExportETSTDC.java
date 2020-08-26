package com.et.control;

import com.et.model.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ExportETSTDC extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<ET_STDC> lists = new ArrayList<ET_STDC>();
        ET_STDC et_stdc = new ET_STDC();
        
        for (int i = 0; i < 10; i++) {
            et_stdc.setStdc_year("2562");
            et_stdc.setStdc_std_semester("2");
            et_stdc.setStdc_std_code("5404005745");
            et_stdc.setStdc_std_course_code("ECO1101   ");
            et_stdc.setStdc_credit("03 ");
            et_stdc.setStdc_section("02 ");
            et_stdc.setApp_date_etest_dd("04");
            et_stdc.setApp_date_etest_mm("01");
            et_stdc.setApp_date_etest_yy("63");
            et_stdc.setApp_period_etest("1 ");
            et_stdc.setApp_bld("SKB802");
            et_stdc.setApp_row("F");
            et_stdc.setApp_seat("01 ");
            et_stdc.setEtest_status("e-  ");
            et_stdc.setStdc_grade("000 ");
            et_stdc.setStdc_score_tot("000 ");
            et_stdc.setStdc_score_M("000 ");
            et_stdc.setStdc_score_F("000 ");
            et_stdc.setStdc_score_chsum("0000");
            lists.add(et_stdc);
        }

        if (request.getParameter("export") != null) {
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
                        + list.getApp_date_etest_mm()
                        + list.getApp_date_etest_yy()
                        + list.getApp_period_etest()
                        + list.getApp_bld()
                        + list.getApp_row()
                        + list.getApp_seat()
                        + list.getEtest_status()
                        + list.getStdc_grade()
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

            response.setContentType("text/html;charset=UTF-8");
     
            request.setAttribute("lists", lists);
            RequestDispatcher rs = request.getRequestDispatcher("admin/ShowETSTDC.jsp");
            rs.forward(request, response);

        }

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
