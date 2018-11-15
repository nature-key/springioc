spring概念介绍
1.spring是一个开源轻量级框架
2.核心技术
  ioc
    控制反转：以前创建对象是new,现在直接把这个工作交给spring
  aop
   面向切面：修改部分业务，不用改源代码
3.一站式
  提供了三层技术，每一层都有提供不同技术
4.spring4.x

IOC
 使用技术
  xml配置
  dom4j解析xml
  工厂设计模式
  反射

原理
 1.以前是在一个类型直接new对象，获取对应的方法
 2.耦合度太高
 3.演变一种，工厂模式，
 4.直接调用工厂模式，获取对象
 5.但是和工厂类耦合度也高


1.当我们要创建一个对象的时候
2.调用工厂类
3.工厂类使用dom4j以及反射机制
  首先，配置xml
  <bean id=userServer class="com.itserver.userServer">
  使用dom4j解析xml，获取路径
  利用反射机制，获取对象
  返回给方法
4.调用的地方直接使用工厂类获取
5.修改类的代码，不影响其他代码

bean实例化配置三种方式
 1.无参构造
    user
 2.静态工厂
 user2Factory
 3.工厂  
 user3Factory
后两种不常用


bean常用属性
1，id
2.name
3.class
4.scope
   single 单例 同一个实例
        com.itserver.User@462d5aee
        com.itserver.User@462d5aee
   prototype  多实例 scope="prototype"
       com.itserver.User@1060b431
       com.itserver.User@612679d6
   request 创建的对象放到request域
   session 创建的对象放到session域
   gloablsesion 全局的一个session
 

属性注入
 1.set注入
 2.构造参数注入
 3.接口注入
 
   public  interface dao{
   
     public void delete(String name)
   }
   
   public class daoimp implement dao{
    private  string name
    public void delete(String name){
      this.name =name
    }
   }
 
 spring只支持两种方式
  1.构造参数
    propertyDome
  2.set注入
   字符串注入
   <!--<bean id="book" class="com.itserver.Book">-->
       <!--<property name="name" value="nicai"></property>-->
   <!--</bean>-->
   对象注入
   <bean id="userDao" class="com.itserver.UserDao"></bean>
   <bean id="userService" class="com.itserver.UserService">
       <property name="userDao" ref="userDao"></property>
   </bean>
   
   14














