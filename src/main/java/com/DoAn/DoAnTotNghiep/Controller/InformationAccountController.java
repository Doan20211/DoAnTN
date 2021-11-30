package com.DoAn.DoAnTotNghiep.Controller;

import com.DoAn.DoAnTotNghiep.DTO.Response.InfomationUserDTO;
import com.DoAn.DoAnTotNghiep.Entity.Account;
import com.DoAn.DoAnTotNghiep.Security.service.MyUserDetails;
import com.DoAn.DoAnTotNghiep.Service.InfoAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipal;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/api/information")
public class InformationAccountController {

    @Autowired
    InfoAccountService infoAccountService;

    @GetMapping("")
    public ResponseEntity<?> getInfomation(){
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        InfomationUserDTO infomationUserDTO = this.infoAccountService.getInfomationAccount(userName);
        return new ResponseEntity<>(infomationUserDTO, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> updateInformation(@RequestBody Account account){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        boolean status = this.infoAccountService.updateInfo(account,email);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }

}
