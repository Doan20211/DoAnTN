package com.DoAn.DoAnTotNghiep.Service.Impl;

import com.DoAn.DoAnTotNghiep.DTO.Response.Complie;
import com.DoAn.DoAnTotNghiep.Service.ComplieService;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ComplieServiceImpl implements ComplieService {
    @Override
    public Complie complie() {
        String uri = "https://codexweb.netlify.app/.netlify/functions/enforceCode";
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        GsonJsonParser gson = new GsonJsonParser();
        Complie result = rest.postForObject(uri,null, Complie.class);
        return result;
    }
}
