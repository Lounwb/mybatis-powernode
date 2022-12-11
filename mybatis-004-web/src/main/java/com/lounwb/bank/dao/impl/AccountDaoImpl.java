package com.lounwb.bank.dao.impl;

import com.lounwb.bank.dao.AccountDao;
import com.lounwb.bank.pojo.Account;
import com.lounwb.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountDaoImpl implements AccountDao {
    @Override
    public Account selectByActno(String actno) {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        Account account = (Account) sqlSession.selectOne("account.selectByActno", actno);
        return account;
    }

    @Override
    public int updateByActno(Account account) {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        int count = sqlSession.update("account.updateByActno", account);
        return count;
    }
}
