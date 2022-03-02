package com.DoAn.DoAnTotNghiep.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestComplie {

    String code;
    String language;
    String input;

}
