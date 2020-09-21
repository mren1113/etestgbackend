package com.et.model;

import java.math.BigDecimal;
import lombok.*;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VM_STUDENT_MOBILE {

    private String STD_CODE;
    private String NAME_THAI;
    private String CITIZEN_NO;
    private String BIRTH_DATE;
    private String STD_STATUS_CURRENT;
    private String STD_STATUS_DESC_THAI;
    private String ENROLL_YEAR;
    private String ENROLL_SEMESTER;
    private String ENROLL_CURR;
    private BigDecimal CUMM_CREDIT;
    private BigDecimal STD_TYPE;
    private String STD_TYPE_DESC_THAI;
    private BigDecimal CAMPUS_NO;
    private String CAMPUS_NAME_THAI;
    private String FACULTY_NO;
    private String FACULTY_NAME_THAI;
    private BigDecimal CURR_NO;
    private String CURR_NAME_THAI;
    private String MAJOR_NO;
    private String MAJOR_NAME_THAI;
    private String PENAL_NO;
    private String PENAL_NAME_THAI;
    private String LIBRARY_LOCK;
    private String CERT_LOCK;
    private String CHK_CERT_NO;
    private String CHK_CERT_NAME_THAI;
    private BigDecimal SUBSIDY_NO;
    private String SUBSIDY_NAME_THAI;
    private String FLAG_SEMESTER;
    private BigDecimal REGIS_OK;
    private String ENROLLMENT_NO;
    private String ID_LOCK;
    private String MOBILE_TELEPHONE;
    private String WAIVED_NO;
    private String FIRST_NAME_ENG;
    private String MIDDLE_NAME_ENG;
    private String LAST_NAME_ENG;
}
