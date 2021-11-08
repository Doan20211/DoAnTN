package com.DoAn.DoAnTotNghiep.Service.Impl;

import com.DoAn.DoAnTotNghiep.DTO.Request.AccountDTORe;
import com.DoAn.DoAnTotNghiep.DTO.Response.AccountDTO;
import com.DoAn.DoAnTotNghiep.Entity.Account;
import com.DoAn.DoAnTotNghiep.Repository.AccountRepository;
import com.DoAn.DoAnTotNghiep.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean createAccount(Account account) {
        account.setPassword(passwordEncoder.encode("111111"));
        accountRepository.save(account);
        return true;
    }

    @Override
    public boolean deleteAccount(Long id) {
        accountRepository.deleteById(id);
        return true;
    }

    @Override
    public List<AccountDTO> getAllAccount() {
        List<Account> list = accountRepository.findAll();
        return list.stream()
                .map(account -> new AccountDTO(account))
                .collect(Collectors.toList());
    }

    @Override
    public AccountDTO getAccountById(Long id) {
        Account account = accountRepository.getById(id);
        return new AccountDTO(account);
    }

    @Override
    public boolean updateAccount(AccountDTORe accountDTORe, Long id) {
        return false;
    }
}
