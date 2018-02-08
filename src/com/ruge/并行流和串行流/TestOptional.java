package com.ruge.并行流和串行流;

import com.ruge.lambda表达式.User;
import org.junit.Test;

import java.util.Optional;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 武健
 * \* Date: 2018/2/7
 * \* Time: 22:00
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class TestOptional {
     /**
     * 一、Optional 容器类：用于尽量避免空指针异常
     *  Optional.of(T t) : 创建一个 Optional 实例
     *  Optional.empty() : 创建一个空的 Optional 实例
     *  Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
     *  isPresent() : 判断是否包含值
     *  orElse(T t) :  如果调用对象包含值，返回该值，否则返回t
     *  orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
     *  map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
     *  flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
     */
     @Test
     public void test1(){
         Optional<User> user = Optional.of(new User());
         User user1 = user.get();
         System.out.println(user1);
     }

}