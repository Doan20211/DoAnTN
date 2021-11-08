package com.DoAn.DoAnTotNghiep.Service;

import com.DoAn.DoAnTotNghiep.DTO.Request.AccountDTORe;
import com.DoAn.DoAnTotNghiep.DTO.Response.AccountDTO;
import com.DoAn.DoAnTotNghiep.Entity.Account;

import java.util.List;

public interface AdminService {

    boolean createAccount(Account account);
    boolean deleteAccount(Long id);
    List<AccountDTO> getAllAccount();
    AccountDTO getAccountById(Long id);
    boolean updateAccount(AccountDTORe accountDTORe, Long id);
}
