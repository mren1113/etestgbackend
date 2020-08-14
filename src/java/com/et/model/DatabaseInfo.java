/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.model;

import lombok.Data;

/**
 *
 * @author RUCOM-7
 */
@Data
public class DatabaseInfo {
    
    public static final String URL = "jdbc:oracle:thin:@10.2.1.98:1521:rubram";
    public static final String  USER = "tr100";
    public static final String PASSWORD = "txt6r9r3";
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private DatabaseInfo(){
    
    }
}
