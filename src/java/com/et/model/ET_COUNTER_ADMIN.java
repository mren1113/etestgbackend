/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.model;

import lombok.*;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ET_COUNTER_ADMIN {

    private String FISCAL_YEAR;
    private String STUDY_YEAR;
    private String STUDY_SEMESTER;
    private String START_DATE;
    private String END_DATE;
    private String COUNTER_NO;
    private String START_TIME;
    private String END_TIME;
    private String UPDATE_DATE;
}
