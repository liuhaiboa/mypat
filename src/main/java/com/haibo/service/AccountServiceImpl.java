package com.haibo.service;

import com.haibo.mapper.AccountMapper;
import com.haibo.model.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/6/20 0020.
 */
@Service
public class AccountServiceImpl {
    @Autowired
    private AccountMapper dao;

    public Account login(String username,String password){
        return dao.login(username,password);

    }
}
