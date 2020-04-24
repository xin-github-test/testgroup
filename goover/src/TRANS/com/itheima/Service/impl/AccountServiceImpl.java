package TRANS.com.itheima.Service.impl;

import C3P0.c3p0;
import TRANS.com.itheima.Dao.AccountDao;
import TRANS.com.itheima.Dao.Impl.AccountDaoImpl;
import TRANS.com.itheima.Service.AccountService;
import TRANS.com.itheima.Utils.ManagerThreadLocal;
import TRANS.com.itheima.domain.Account;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountServiceImpl implements AccountService {
   // Connection conn= c3p0.getConnection();//设置一个conn保证接下来操作都是同一个conn，以便开启事务，但是业务层不应出现conn
    AccountDao ad=new AccountDaoImpl();
    @Override
    public void transfer(String fromname, String toname, double money) throws Exception {

       // ad.updateAccount(fromname,toname,money);
        //分别得到转出和转入账户
        //try {//此处不能try catch不然到时候就直接在这里捕获了异常，回滚不了事务
            Account fromAccount = ad.findAcountByName(fromname);
            Account toAccount = ad.findAcountByName(toname);
            //修改各自金额
            fromAccount.setMoney(fromAccount.getMoney()-money);
            toAccount.setMoney(toAccount.getMoney()+money);
            //完成转账工作
            ad.updateAccount(fromAccount);
            ad.updateAccount(toAccount);
       /* } catch (Exception e) {
            e.printStackTrace();
        }*/


    }
}
