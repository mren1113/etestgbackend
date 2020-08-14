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
public class ET_BUILE_ROW {
     private String YEAR;
    private String SEMESTER;
    private String BUILD_NO;
    private String ROW_EXAM;
    private BigDecimal SEAT_EXAM;
    private String INSERT_DATE;
    private String INSERT_USER;
    private String UPDATE_DATE;
    private String UPDATE_USER;
}
