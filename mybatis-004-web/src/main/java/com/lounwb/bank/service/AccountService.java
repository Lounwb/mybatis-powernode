package com.lounwb.bank.service;

import com.lounwb.bank.exceptions.MoneyNotEnoughException;
import com.lounwb.bank.exceptions.TransferException;

/**
 * 账户业务类
 * @author Lounwb
 * @version 1.0
 * @since 1.0
 */
public interface AccountService {
    /**
     * 账户转账业务
     * @param fromActno
     * @param toActno
     * @param money
     */
    void transfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, TransferException;
}
