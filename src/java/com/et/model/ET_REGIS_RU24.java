/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.model;

import java.math.BigDecimal;

import lombok.*;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ET_REGIS_RU24 {

    private String YEAR;
    private String SEMESTER;
    private String STD_CODE;
    private BigDecimal TIME_NO;
    private String COURSE_NO;
    private BigDecimal CREDIT;
    private BigDecimal SECTION_NO;
    private String EXAM_DATE;
    private String PERIOD;
    private String BUILD_NO;
    private String ROW_EXAM;
    private BigDecimal SEAT_EXAM;
    private String STATUS_REGIS;
    private String GRADE;
    private BigDecimal SCORE_TOTAL;
    private BigDecimal SCORE_MIDTERM;
    private BigDecimal SCORE_FINAL;
    private String CKREGIS;
    private String INSERT_DATE;
    private String INSERT_USER;
    private String REF_KEY;
    private String REGIS_STATUS;
}
