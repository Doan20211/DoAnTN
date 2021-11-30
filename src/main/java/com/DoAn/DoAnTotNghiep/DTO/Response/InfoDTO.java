package com.DoAn.DoAnTotNghiep.DTO.Response;

import com.DoAn.DoAnTotNghiep.Entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoDTO {

    private String email;
    private String fullName;
    private String address;
    private String phone;
    private String code;

    public InfoDTO(Account account){
        this.address = account.getAddress();
        this.code = account.getCode();
        this.email = account.getEmail();
        this.fullName = account.getFullName();
        this.phone = account.getPhone();
    }

}
