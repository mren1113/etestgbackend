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
public class ET_ROW_SEAT_ORDER {

    private String YEAR;
    private String SEMESTER;
    private String INSERT_DATE;
    private String ROW_SEAT;
    private String STD_CODE;
    private String EXAM_DATE;
    private String SECTION_NO;
    private BigDecimal CREDIT;
    private String COURSE_NO;
    private String STATUS_COURSE;
}
