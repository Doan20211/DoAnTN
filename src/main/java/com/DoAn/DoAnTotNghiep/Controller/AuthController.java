package com.DoAn.DoAnTotNghiep.Controller;

import com.DoAn.DoAnTotNghiep.DTO.Request.AccountRequest;
import com.DoAn.DoAnTotNghiep.DTO.Response.AccountDTORes;
import com.DoAn.DoAnTotNghiep.Entity.Account;
import com.DoAn.DoAnTotNghiep.Repository.AccountRepository;
import com.DoAn.DoAnTotNghiep.Security.jwt.JwtUtils;
import com.DoAn.DoAnTotNghiep.Security.service.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    AccountRepository accountRepository;

    @PostMapping("/login")
    public ResponseEntity<?> authencateUser(@RequestBody AccountRequest accountRequest ){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(accountRequest.getUsername(), accountRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.genarateJwtToken(authentication);

        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        String role = roles.get(0);
        String name = userDetails.getName();

        return ResponseEntity.ok(new AccountDTORes(jwt, userDetails.getId(), userDetails.getUsername(), role, name));
    }

}
