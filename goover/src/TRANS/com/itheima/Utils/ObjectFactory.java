package TRANS.com.itheima.Utils;

import TRANS.com.itheima.Service.AccountService;
import TRANS.com.itheima.Service.impl.AccountServiceImpl;
import TRANS.com.itheima.domain.Account;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ObjectFactory {
    public static AccountService getAccountService() {
        final AccountService as = new AccountServiceImpl();

        AccountService proxy = (AccountService) Proxy.newProxyInstance(as.getClass().getClassLoader(), as.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object invoke=null;
                try {
                    ManagerThreadLocal.startTransaction();//开启事务
                    invoke=method.invoke(as, args);
                    ManagerThreadLocal.commitTransaction();//事务执行完成后就提交
                } catch (Exception e) {
                    try {
                        ManagerThreadLocal.rollbackTransaction();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    e.printStackTrace();
                } finally {
                    try {
                        ManagerThreadLocal.close();//将conn放回池中，并将tl对象中的conn移除
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                return invoke;
            }
        });
        return proxy;
    }
}
