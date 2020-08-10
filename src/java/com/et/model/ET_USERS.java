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
public class ET_USERS {
    private String USER_NAME;
    private String USER_PASSWORD;
    private String INSERT_DATE;
    private String UPDATE_DATE;
    private String PERIOD;
}
