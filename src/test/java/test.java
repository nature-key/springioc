import com.itserver.User;
import com.itserver.User2;
import com.itserver.User3;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    @Test
    public void usertest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User3 user = (User3) context.getBean("user3");
        System.out.println(user);
        user.add();
    }

}
