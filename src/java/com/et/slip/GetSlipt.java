/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.slip;

import java.util.Arrays;

import com.et.model.*;
import com.sun.javafx.fxml.expression.BinaryExpression;
import static com.sun.javafx.fxml.expression.Expression.add;
import java.awt.AWTEventMulticaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ru-com7
 */
public class GetSlipt extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

     /*   String stdcode = "6290508511";
        String refkey = "DRKEE200917235900231";
        String sem = "3";
        String year = "2562";*/

        String stdcode = request.getParameter("stdcode");
        String refkey = request.getParameter("refkey");
        String sem = request.getParameter("sem");
        String year = request.getParameter("year");
        //tmp stmt
        String tmpSem = "";
        String tmpYear = "";
        String subYear = "";
        String subrefkey = "";
        int sumCredit = 0;
        int cntCourse = 0;
        String total = "";
        String slipNo = "";
        String strTotalThai = "";
        String tmpTotal = "";
        String[] tempSplitTotal = null;
        int noColAmount = 12;
        ArrayList<String> arrAmount = new ArrayList<String>();
       // ArrayList<String> arrRepSlip = new ArrayList<String>();

        //call db
        Database db = new Database();
        ET_COUNTER_ADMIN_TABLE getEtCounterTable = new ET_COUNTER_ADMIN_TABLE(db);
        ET_PROFILE_TABLE getProfileTable = new ET_PROFILE_TABLE(db);
        ET_REP_SLIP_TABLE getSlipTable = new ET_REP_SLIP_TABLE(db);

        ET_PROFILE getProfile = null;
        List<ET_REP_SLIP> getRepSlip = null;
        ET_REP_SLIP getHeaderRepSlip = null;
        ET_REP_SLIP getMockSlip = null;

        List<ET_COUNTER_ADMIN> getEtCounter = getEtCounterTable.findAll();
        if (getEtCounter != null) {
            for (ET_COUNTER_ADMIN i : getEtCounter) {
                tmpSem = i.getSTUDY_SEMESTER();
                tmpYear = i.getSTUDY_YEAR();
            }
            if (tmpSem.equals(sem) && tmpYear.equals(year) && !stdcode.equals("") && !refkey.equals("")) {
                //getMockSlip = getSlipTable.mockSlip();
                getProfile = getProfileTable.findByStdProfile(stdcode);
                getHeaderRepSlip = getSlipTable.findByHeaderSlip(stdcode, sem, year, refkey);
                getRepSlip = getSlipTable.findListRegisSlip(stdcode, sem, year, refkey);
                subYear = year.substring(2);
                subrefkey = refkey.substring(15);

          //      HashMap<String, String> tmparr = new HashMap<String, String>();
                if (getRepSlip != null && getHeaderRepSlip != null) {
                    for (ET_REP_SLIP j : getRepSlip) {
                        arrAmount.add(j.getTOTAL_AMOUNT());
                        sumCredit = sumCredit + Integer.parseInt(j.getCREDIT().toString());
                        total = j.getTOTAL_AMOUNT();
                        tmpTotal = j.getAMOUNT();
                        cntCourse++;

                        //arrRepSlip.addAll();
                    }

                    int chkColAmount = 0; 
                    chkColAmount = (noColAmount - cntCourse);
                    int chkRowSlip = 0;
                    if (cntCourse > 0) {
                       
                        for (int i = 0; i <= chkColAmount; i++) {
                            arrAmount.add("&nbsp;");
                        }
                       // chkRowSlip = chkColAmount -1;
                       /* for (int i = 0; i < chkColAmount; i++) {
                            getRepSlip.add(getMockSlip);
                        }*/
                    }

                    strTotalThai = ThaiBaht(tmpTotal);
                    slipNo = refkey.substring(15);
                    tempSplitTotal = total.split("[.]");
                    String tmp = tempSplitTotal[0];

                    request.setAttribute("getProfile", getProfile);
                    request.setAttribute("getRepSlip", getRepSlip);
                    request.setAttribute("getHeaderRepSlip", getHeaderRepSlip);
                    request.setAttribute("slipNo", slipNo);
                    request.setAttribute("sem", sem);
                    request.setAttribute("year", year);
                    request.setAttribute("subYear", subYear);
                    request.setAttribute("subrefkey", subrefkey);
                    request.setAttribute("arrAmount", arrAmount);
                    request.setAttribute("tmpTotal", tmp);
                    request.setAttribute("sumCredit", sumCredit);
                    request.setAttribute("cntCourse", cntCourse);
                    request.setAttribute("sumCredit", sumCredit);
                    request.setAttribute("strTotalThai", strTotalThai);
                    request.setAttribute("noColAmount", noColAmount);
                    request.setAttribute("chkColAmount", chkColAmount);
                    RequestDispatcher rs = request.getRequestDispatcher("repSlipt.jsp");
                    rs.forward(request, response);
                } else {
                    RequestDispatcher rs = request.getRequestDispatcher("err.jsp");
                    rs.forward(request, response);
                }

            } else {
                RequestDispatcher rs = request.getRequestDispatcher("err.jsp");
                rs.forward(request, response);
            }
        } else {
            RequestDispatcher rs = request.getRequestDispatcher("err.jsp");
            rs.forward(request, response);
        }

        // String getToken = generateNewToken(); 
        /* if (stdcode != "") {
            RequestDispatcher rs = request.getRequestDispatcher("repSlipt.jsp");
                            rs.forward(request, response);
            
        } else {
        }
         */
 /* PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetSlipt</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>  " + strTotalThai + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }*/
    }

    private static String ThaiBaht(String total) {
        String bathTxt, n;
        String bathTH = "";

        // bathTxt = "1201.01";
        String[] num = {"ศูนย์", "หนึ่ง", "สอง", "สาม", "สี่", "ห้า", "หก", "เจ็ด", "แปด", "เก้า", "สิบ"};
        String[] rank = {"", "สิบ", "ร้อย", "พัน", "หมื่น", "แสน", "ล้าน"};
        String[] temp = total.split("[.]");
        String intVal = temp[0];
        String deciVal = temp[1];
        if (Double.parseDouble(total) == 0) {
            bathTH = "ศูนย์บาทถ้วน";
        } else {
            for (int i = 0; i < intVal.length(); i++) {
                n = intVal.substring(i, i + 1);
                if (Integer.parseInt(n) != 0) {
                    if ((i == (intVal.length() - 1)) && (n.indexOf("1") > -1) && intVal.charAt(intVal.length() - 2) != '0') {
                        bathTH += "เอ็ด";
                    } else if ((i == (intVal.length() - 2)) && (n.indexOf("2") > -1)) {
                        bathTH += "ยี่";
                    } else if ((i == (intVal.length() - 2)) && (n.indexOf("1") > -1)) {
                        bathTH += "";
                    } else {
                        bathTH += num[Integer.parseInt(n)];
                    }
                    bathTH += rank[(intVal.length() - i) - 1];
                } else if (i == 0) {
                    bathTH += num[Integer.parseInt(n)];
                }
            }
        }
        bathTH += "บาทถ้วน";
        return bathTH;
        /*  for (int i = 0; i < deciVal.length(); i++) {
                if (deciVal.indexOf("00") > -1) {
                    bathTH += "ถ้วน";
                    break;
                } else {
                    n = deciVal.substring(i, i + 1);
                    if (n.indexOf("0") == -1) {
                        if ((i == deciVal.length() - 1) && n.indexOf("1") > -1 && deciVal.charAt(0) != '0') {
                            bathTH += "เอ็ด";
                        } else if ((i == (deciVal.length() - 2)) && (n.indexOf("2") > -1)) {
                            bathTH += "ยี่";
                        } else if ((i == (deciVal.length() - 2)) && (n.indexOf("1") > -1)) {
                            bathTH += "";
                        } else {
                            bathTH += num[Integer.parseInt(n)];
                        }
                        bathTH += rank[(deciVal.length() - i) - 1];

                    }
                }
                if (i == deciVal.length() - 1) {
                    bathTH += "สตางค์";
                }
            }

        }*/

    }

    public static Object[] add(Object[] arr, Object... elements) {
        Object[] tempArr = new Object[arr.length + elements.length];
        System.arraycopy(arr, 0, tempArr, 0, arr.length);

        for (int i = 0; i < elements.length; i++) {
            tempArr[arr.length + i] = elements[i];
        }
        return tempArr;

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
