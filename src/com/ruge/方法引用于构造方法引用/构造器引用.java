package com.ruge.方法引用于构造方法引用;

import com.ruge.lambda表达式.User;
import org.junit.Test;

import java.util.function.Supplier;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 武健
 * \* Date: 2018/2/5
 * \* Time: 21:42
 * \* To change this template use File | Settings | File Templates.
 * \* Description:构造器引用
 *      格式:ClassName::new
 * \
 */
public class 构造器引用 {
    @Test
    public void test1() {
        Supplier<User> userSupplier = () -> new User();
        User user = userSupplier.get();
        System.out.println(user);
        Supplier<User> userSupplier1 = User::new;
        User user1 = userSupplier1.get();
        System.out.println(user1);
    }
}