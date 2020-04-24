package TRANS.com.itheima.Dao;

import TRANS.com.itheima.domain.Account;

public interface AccountDao {
    @Deprecated//不合适，不能在Dao里面完成业务层的工作
    public void updateAccount(String fromname,String toname,Double money)throws Exception;
    //根据账户信息修改金额
    public void updateAccount(Account account)throws Exception;
    //根据用户名查找账户信息
    public Account findAcountByName(String name)throws Exception;
}
