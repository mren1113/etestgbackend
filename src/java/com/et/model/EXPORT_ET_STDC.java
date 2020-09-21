package com.et.model;

import java.math.BigDecimal;
import lombok.*;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EXPORT_ET_STDC {

    private String YEAR;
    private String SEMESTER;
    private String STD_CODE;
    private String COURSE_NO;
    private BigDecimal CREDIT;
    private String SECTION_NO;
    private String EXAM_DATE;
    private String ROW_SEAT;
}
