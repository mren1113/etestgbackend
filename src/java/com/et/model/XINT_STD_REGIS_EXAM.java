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
public class XINT_STD_REGIS_EXAM {

    private String YEAR;
    private String SEMESTER;
    private String STD_CODE;
    private String EXAM_TYPE;
    private BigDecimal TIME_NO;
    private String COURSE_NO;
    private BigDecimal ORDER_NO;
    private String EXAM_DATE;
    private String EXAM_PERIOD;
    private BigDecimal WEIGH_NO;
    private BigDecimal ROW_NO;
    private BigDecimal SEAT_NO;
    private String INSERT_DATE;
    private String INSERT_USER;
    private String UPDATE_DATE;
    private String UPDATE_USER;
    private String APPROVE_OK;
    private String COURSE_COMMENT;
}
