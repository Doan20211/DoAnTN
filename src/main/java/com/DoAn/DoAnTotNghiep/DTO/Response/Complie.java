package com.DoAn.DoAnTotNghiep.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Complie {

    private String sourceCode;
    private boolean status;
    private boolean errorCode;
    private String error;
    private boolean outputType;
    private String output;
    private String outputStyle;
    private Date date;
    private String language;
    private String input;
    private Long id;

}
