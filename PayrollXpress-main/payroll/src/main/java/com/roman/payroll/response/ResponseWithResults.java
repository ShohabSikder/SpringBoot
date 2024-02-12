package com.roman.payroll.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ResponseWithResults<d> {
    private Integer status;
    private String message;
    private d res;
}
