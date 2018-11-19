import com.itserver.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class test {

    @Test
    public void usertest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user1 = (User) context.getBean("user");
        User user2 = (User) context.getBean("user");
        System.out.println(user1);
        System.out.println(user2);
//        user.add();
    }

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        PropertyDome dome = (PropertyDome) context.getBean("dome");
        dome.test();
    }

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Book book = (Book) context.getBean("book");
        book.test();
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.test();
    }

    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Person person = (Person) context.getBean("person");
        person.test();

    }

    @Test
    public void test4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        com.itserver.day1.User user = (com.itserver.day1.User) context.getBean("user");
        user.test();
    }

    @Test
    public void test5() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        com.itserver.day1.UserService userService = (com.itserver.day1.UserService) context.getBean("userService");
        userService.add();
    }

    @Test
    public void test6() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        com.itserver.day2.UserService userService = (com.itserver.day2.UserService) context.getBean("userService");
        userService.test();
    }

    @Test
    public void test7() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        com.itserver.aop.Book book = (com.itserver.aop.Book) context.getBean("book");
        book.test();
    }

    @Test
    public void test8() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
        com.aop.Book book = (com.aop.Book) context.getBean("book");
        book.add();
    }

    @Test
    public void add() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);


//        String sql ="insert into user values(?,?)";
//        String sql ="UPDATE user SET username=? WHERE  password=?";
        String sql = "delete FROM  user WHERE  password =?";
        jdbcTemplate.update(sql, "root1");
    }

    @Test
    public void find() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        String sql = "select *  from  user where username=?";
//        com.aop.User user = jdbcTemplate.queryForObject(sql, new MyRowMapper(), "lisi");
        String sql ="select *  from  user";
        List<com.aop.User> user = jdbcTemplate.query(sql,new MyRowMapper());
        System.out.println(user);
    }


}

class MyRowMapper implements RowMapper<com.aop.User> {
    public com.aop.User mapRow(ResultSet resultSet, int i) throws SQLException {
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        com.aop.User user = new com.aop.User();
        user.setUserName(username);
        user.setPassword(password);
        return user;
    }
}