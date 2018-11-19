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
  
  p名称空间
  xmlns:p="http://www.springframework.org/schema/p"
  <bean id="person" class="com.itserver.Person" p:pname="lucy">
  
   
  复杂对象的注入
     list
     map
     arr
     properties
<bean id="person" class="com.itserver.Person">
       <property name="arrs">
           <list>
               <value>小李</value>
               <value>小王</value>
               <value>校长</value>
           </list>
       </property>

       <property name="list">
           <list>
               <value>网易</value>
               <value>王二</value>
               <value>网三</value>
           </list>
       </property>

       <property name="map">
           <map>
               <entry key="one" value="mapone"></entry>
               <entry key="two" value="mapotwo"></entry>
               <entry key="three" value="mapthree"></entry>
           </map>
       </property>

       <property name="properties">
           <props>
               <prop key="drive">com.mysql.jdbc.Driver</prop>
               <prop key="username">root</prop>
           </props>
       </property>
   </bean>  
 
 IOC和DI
 
 IOC 控制反转 ，把创建对象让spring创建
 DI 依赖注入 给属性设置值
 
 区别 依赖注入不能单独存在，是建立在IOC基础之上
 
 
    
spring web原理

1.加载spring核心配置文件
  ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
          new 一个独享效率很低
          
 实现原理
 
  1.servletContext对象
  2。监听器
  
  3具体实现
  服务器启动的时候，会为每一个项目建立一个servetcotent
  在servletcontext对象创建的时候，使用监听器可以具体servletcontext什么时候创建
  在创建servletcontext时候，加载spring配置文件，把配置的对象放到servletcontext
  获取对象的时候直接在serlvercontext得到 getAttribute


注解方式IOC
 导入包
 约束
<context:component-scan base-package="com.itserver.day1"></context:component-scan>

四种创建对象
 1.Component
 2.controller  web
 3.service  业务
 4.reportity  持久层

scope 设置单例 多实例

注入属性

 使用注解@Autowired注入 不需要set
 也可以使用@Resource注入

AOP
面向切面 不修改源码扩展功能

1.
 public class user{
   public void add(){
     //添加日志
   }
 }

  修改代码
2.纵向抽象编程

  抽象一个类
  继承这个类
  使用这个父类方法
  完成扩展功能
  但是父类变化，子类也要相应的改变，
    
 实现原理
 
  1.有接口
   jdk动态代理
   
   实现一个和要扩展的功能的是实现接口的类一个代理对象，实现相同的功能，在代理对象上功能增强
   
   
  2.无接口
  cglib动态代理
  
   继承类的子类实现代理对像，子类调用父类的方法实现增强
    
AOP概念

 连接点 joinpoint  每一个类中有好多方法。每一个方法都可进行增强，把这些方法称为链接点
 切入点 pointcut 在实际上增强了的方法，如只给add和delete方法增强功能，把这些叫做切入点
 增强/通知 增强的逻辑称为增强，如日志的功能
  前置通知
  后置通知
  异常通知
  环绕通知
  最终通知
 切面 advice 把增强应用到切入点的过程叫做切面，把日志功能放到add的过程
 引介 在不修改代码下，给类添加属性和方法
 目标 就是你增强方法的的类
 织入 把增强应用到目标对象的过程
 代理 jdk cglib代理
 
 
使用表达式配置切入点
切入点 实际增强的的方法

ececution(<>)
execation(* com.itying.Book.add(..))  
execation(* com.itying.Book.*(..))  
execation(* *.*(..))  
execation(* save*(..))

配置aop
<aop:config>
    <!-- 切点-->
    <aop:pointcut id="pointcut" expression="execution(* com.itserver.aop.*.*(..))"></aop:pointcut>
    <!-- 切面
      把增强mybook类的方法 before 应用到pointcut中
    -->
    <aop:aspect ref="mybook">
        <aop:before method="before" pointcut-ref="pointcut"></aop:before>
    </aop:aspect>

</aop:config>

注解

1.开启代理
 <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
 
@Aspect
public class MyBook {
  @Before(value = "execution(* com.aop.Book.*(..))")
  public void before(){
      System.out.println("before.....");
  }
}

41