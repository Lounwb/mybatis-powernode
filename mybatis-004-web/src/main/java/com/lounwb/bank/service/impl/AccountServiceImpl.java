package com.lounwb.bank.service.impl;

import com.lounwb.bank.dao.AccountDao;
import com.lounwb.bank.dao.impl.AccountDaoImpl;
import com.lounwb.bank.exceptions.MoneyNotEnoughException;
import com.lounwb.bank.exceptions.TransferException;
import com.lounwb.bank.pojo.Account;
import com.lounwb.bank.service.AccountService;
import com.lounwb.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao = new AccountDaoImpl();
    @Override
    public void transfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, TransferException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        //1.判断转出账户余额是否充足
        Account fromAct = accountDao.selectByActno(fromActno);
        //2.不充足抛余额不足异常
        if (fromAct.getBalance() < money) {
            throw new MoneyNotEnoughException("对不起，账户余额不足");
        }
        //3.转账，更新转出账户余额
        Account toAct = accountDao.selectByActno(toActno);
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);
        //4.转账，更新转入账户余额
        int cnt = accountDao.updateByActno(fromAct);

        //模拟异常
//        String s = null;
//        s.toString();

        cnt += accountDao.updateByActno(toAct);

        if(cnt !=2 ){
            throw new TransferException("转账异常，未知原因");
        }

        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }
}
