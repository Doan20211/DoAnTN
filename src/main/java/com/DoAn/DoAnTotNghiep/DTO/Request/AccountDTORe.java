package com.DoAn.DoAnTotNghiep.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTORe {

    private Long id;
    private String email;
    private String fullName;
    private String address;
    private String phone;
    private String position;
    private String code;
    private String role;

}
