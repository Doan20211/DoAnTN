package com.DoAn.DoAnTotNghiep.Service.Impl;

import com.DoAn.DoAnTotNghiep.DTO.Response.InfomationUserDTO;
import com.DoAn.DoAnTotNghiep.Entity.Account;
import com.DoAn.DoAnTotNghiep.Repository.AccountRepository;
import com.DoAn.DoAnTotNghiep.Service.InfoAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoAccountServiceImpl implements InfoAccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public InfomationUserDTO getInfomationAccount(String userName) {
        Account account = this.accountRepository.findByEmail(userName).get();
        return new InfomationUserDTO(account);
    }

    @Override
    public boolean updateInfo(Account acc, String email) {
        Account account = this.accountRepository.findByEmail(email).get();
        account.setPhone(acc.getPhone());
        account.setAddress(acc.getAddress());
        account.setFullName(acc.getFullName());
        this.accountRepository.save(account);
        return true;
    }
}
