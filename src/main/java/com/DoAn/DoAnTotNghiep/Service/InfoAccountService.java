package com.DoAn.DoAnTotNghiep.Service;


import com.DoAn.DoAnTotNghiep.DTO.Response.InfomationUserDTO;
import com.DoAn.DoAnTotNghiep.Entity.Account;

public interface InfoAccountService {

    InfomationUserDTO getInfomationAccount(String userName);
    boolean updateInfo(Account account, String email);

}
