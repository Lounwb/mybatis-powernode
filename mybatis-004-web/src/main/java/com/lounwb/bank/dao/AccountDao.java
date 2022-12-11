package com.lounwb.bank.dao;

import com.lounwb.bank.pojo.Account;

/**
 * 账户的DAO对象，负责对t_act表中数据的增删改查
 * @author Lounwb
 * @version 1.0
 * @since 1.0
 */
public interface AccountDao {
    /**
     * 根据账号查询账户信息
     * @param actno 账号
     * @return 账户信息
     */
    Account selectByActno(String actno);

    /**
     * 更新账户信息
     * @param account 账号
     * @return 更改记录条数
     */
    int updateByActno(Account account);

}
