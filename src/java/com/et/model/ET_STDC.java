package com.et.model;

import lombok.*;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ET_STDC {

    private String stdc_year;//2562(ปี)
    private String stdc_std_semester;//2(เทอม)
    private String stdc_std_code;//5404005745(รหัส นศ.)
    private String stdc_std_course_code;//ECO1101(รหัสวิชา)
    private String stdc_credit;//03(หน่วยกิต)
    private String stdc_section;//02(คาบ2)
    private String app_date_etest_dd;//วว(วัน)
    private String app_date_etest_mm;//dd(เดือน)
    private String app_date_etest_yy;//yy(ปี)
    private String app_period_etest;//yy(ระยะเวลา-ยังไม่รู้คืออะไร)
    private String app_bld;//SKB802(ตึก)
    private String app_row;//F(แถว)
    private String app_seat;//01(ที่นั่งสอบ)
    private String etest_status;//e-(สถานของการสอบ etesting)
    private String stdc_grade;//000(เกรด)
    private String stdc_score_tot;//000(คะแนนอะไรสักอย่าง)    
    private String stdc_score_M;//000(คะแนน ชาย อะไรสักอย่าง)
    private String stdc_score_F;//000(คะแนน หญิง อะไรสักอย่าง)
    private String stdc_score_chsum;//000(คะแนน ตรวจผลรสม อะไรสักอย่าง)
//2562(ปี) 2(เทอม) 5404005745(รหัส นศ.) ECO1101(รหัสวิชา)(เว้นวรรค3)   03(หน่วยกิต)(เว้นวรรค1) 02(คาบ2)(เว้นวรรค1) 0401631(วว/ดด/ปป/?)(เว้นวรรค1) SKB802F01(ตึก/แถว/ที่นั่งสอบ) e-(เว้นวรรค2)  000(เว้นวรรค1) 000(เว้นวรรค1) 000(เว้นวรรค1) 0000 

}
