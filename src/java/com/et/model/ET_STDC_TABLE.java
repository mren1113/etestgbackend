package com.et.model;

import java.util.Map;
import lombok.*;

@Data
public class ET_STDC_TABLE {
    
    Database db;

    public ET_STDC_TABLE(Database db) {
        this.db = db;
    }

    public ET_STDC setAltmodel(Map<String, Object> row) {

        if (row != null) {
            ET_STDC getRow = ET_STDC.builder()
                    .stdc_year((String) row.get(""))
                    .stdc_std_semester((String) row.get(""))
                    .stdc_std_code((String) row.get(""))
                    .stdc_std_course_code((String) row.get(""))
                    .stdc_credit((String) row.get(""))
                    .stdc_section((String) row.get(""))
                    .app_date_etest_dd((String) row.get(""))
                    .app_date_etest_mm((String) row.get(""))
                    .app_date_etest_yy((String) row.get(""))
                    .app_period_etest((String) row.get(""))
                    .app_bld((String) row.get(""))
                    .app_row((String) row.get(""))
                    .app_seat((String) row.get(""))
                    .etest_status((String) row.get(""))
                    .stdc_grade((String) row.get(""))
                    .stdc_score_tot((String) row.get(""))
                    .stdc_score_M((String) row.get(""))
                    .stdc_score_F((String) row.get(""))
                    .stdc_score_chsum((String) row.get(""))
                    .build();

            return getRow;
        } else {
            return null;
        }
    }
    
}
