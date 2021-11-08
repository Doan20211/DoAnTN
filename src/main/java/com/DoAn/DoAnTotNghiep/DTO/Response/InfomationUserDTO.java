package com.DoAn.DoAnTotNghiep.DTO.Response;

import com.DoAn.DoAnTotNghiep.Entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfomationUserDTO {


    private String email;
    private String fullName;
    private String address;
    private String phone;
    private String position;
    private String code;
    private String role;

    public InfomationUserDTO(Account account){
        this.address = account.getAddress();
        this.code = account.getCode();
        this.email = account.getEmail();
        this.fullName = account.getFullName();
        this.position = account.getPosition();
        this.role = account.getRole();
        this.phone = account.getPhone();
    }


}
