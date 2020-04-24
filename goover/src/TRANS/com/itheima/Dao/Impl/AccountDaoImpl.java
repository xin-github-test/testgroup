package TRANS.com.itheima.Dao.Impl;

import C3P0.c3p0;
import TRANS.com.itheima.Dao.AccountDao;
import TRANS.com.itheima.Utils.ManagerThreadLocal;
import TRANS.com.itheima.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;

public class AccountDaoImpl implements AccountDao {
//    private Connection conn=null;
//    public AccountDaoImpl(Connection conn)
//    {
//        this.conn=conn;
//    }
    @Override
    public void updateAccount(String fromname, String toname, Double money) throws Exception {
        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
        qr.update("update account set money=money-? where name=?",money,fromname);
        qr.update("update account set money=money+? where name=?",money,toname);//转账的操作
    }

    @Override
    public void updateAccount(Account account) throws Exception {
        QueryRunner qr=new QueryRunner();
        //在下面传一个connection可以控制事务
        qr.update(ManagerThreadLocal.getConnection(),"update account set money=? where name=?",account.getMoney(),account.getName());//在业务层就将钱算好，此处直接读取修改后的表
    }

    @Override
    public Account findAcountByName(String name) throws Exception {
        QueryRunner qr=new QueryRunner();
        return  qr.query(ManagerThreadLocal.getConnection(),"select * from account where name=?",new BeanHandler<Account>(Account.class),name);

    }
}
