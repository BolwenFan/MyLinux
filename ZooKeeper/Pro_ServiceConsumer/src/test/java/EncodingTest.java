import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author unclefan
 * @create 2018-07-20 1:11
 */
public class EncodingTest {

    @Test
    public void test() throws UnsupportedEncodingException {

        String s = "consumer%3A%2F%2F192.168.27.1%2Fcom.atguigu.dubbo.service.EmployeeService%3Fapplication%3Demp_consumer%26category%3Dconsumers%26check%3Dfalse%26dubbo%3D2.5.5%26interface%3Dcom.atguigu.dubbo.service.EmployeeService%26methods%3DupdateEmp%26pid%3D15380%26revision%3D1.0-SNAPSHOT%26side%3Dconsumer%26timestamp%3D1532021866711";
        String encode = URLDecoder.decode(s, "UTF-8");
        System.out.println(encode);
    }
}
