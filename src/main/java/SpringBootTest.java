
import com.datababy.enity.Customer;
import com.datababy.enity.Test;
import com.datababy.service.CustomerRepository;
import com.datababy.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Created by yongma on 2017/1/23.
 */
@RestController
@ComponentScan({"com.datababy.*"})
@EnableMongoRepositories
@EnableAutoConfiguration
public class SpringBootTest {

    @Autowired
    private TestService services;
    @Autowired
    private CustomerRepository customerRepository;
    @ResponseBody
    @RequestMapping(value = "/")
    public String location() {
        return "北京";
    }

    @ResponseBody
    @RequestMapping(value="/get")
    public List<Test> getTest(){
       return services.getTest();
    }


     @RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
     public Customer addCustomer(){
        return customerRepository.save(new Customer("test1","test1"));
     }




    public static void main(String[] args) {

        SpringApplication.run(SpringBootTest.class, args);

    }


}
