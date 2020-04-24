package TRANS.com.itheima.Test;

import TRANS.com.itheima.Service.AccountService;
import TRANS.com.itheima.Service.impl.AccountServiceImpl;
import TRANS.com.itheima.Utils.ObjectFactory;

public class testTransfer {

    public static void main(String[] args) throws Exception {
        AccountService as=ObjectFactory.getAccountService();
        as.transfer("aaa","bbb",100);
    }
}
