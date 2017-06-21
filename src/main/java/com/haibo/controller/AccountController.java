package com.haibo.controller;

import com.haibo.model.Account;
import com.haibo.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/6/20 0020.
 */
@RestController
@CrossOrigin
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountServiceImpl service;
    @RequestMapping(value="/login",method= RequestMethod.POST)
    public ResponseEntity<Account> login(@RequestBody Account account) {
        Account a = service.login(account.getUsername(), account.getPassword());
        if (a != null) {
            return new ResponseEntity<Account>(a, HttpStatus.OK);

        } else {
            return new ResponseEntity<Account>(a, HttpStatus.CONFLICT);
        }


    }
}
