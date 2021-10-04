package com.techelevator.dao;

import com.techelevator.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAccountDao implements AccountDao{
    private JdbcTemplate jdbcTemplate;
    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Account> findAllAccount() {
        List<Account> account = new ArrayList<>();
        String sql = "SELECT user_name, password, user_type, email FROM account ";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Account accounts = mapRowToAccount(results);
            account.add(accounts);
        }
        return account;
    }

    @Override
    public Account getAccountById(long accountId) {
        String sql = "SELECT user_name, password, user_type, email FROM account WHERE account_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId);
        if(results.next()) {
            return mapRowToAccount(results);
        } else {
            throw new RuntimeException("Account id "+accountId+" was not found.");
        }
    }

    @Override
    public Account getAccountByUsername(String username) {
       return null;
    }



// *** Account Map ***
    private Account mapRowToAccount(SqlRowSet results){
        Account account = new Account();
        account.setAccountId(results.getLong("account_id"));
        account.setUsername(results.getString("user_name"));
        account.setPassword(results.getString("password"));
        account.setUserType(results.getInt("user_type"));
        account.setEmail(results.getString("email"));
        account.setUserId(results.getLong("user_id"));

        return account;
    }
}
