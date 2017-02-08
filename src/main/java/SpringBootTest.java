import com.datababy.enity.Customer;
import com.datababy.enity.Test;
import com.datababy.rabbitmq.enity.ContractRabbitmq;
import com.datababy.rabbitmq.enity.TenantRabbitmq;
import com.datababy.rabbitmq.service.ContractRabbitmqService;
import com.datababy.service.CustomerRepository;
import com.datababy.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    private ContractRabbitmqService contractRabbitmqService;
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


    @RequestMapping(value = "/contract/direct", method = RequestMethod.GET)
    public void contractDirect(String content) {
        ContractRabbitmq contract = new ContractRabbitmq();
        contract.setDateCreated(new Date());
        contract.setId(12L);
        contract.setName("liuhan");
        List<String> strList = new ArrayList<>();
        strList.add("liu");
        strList.add("test str");
        contract.setTestStrList(strList);
        contractRabbitmqService.sendContractRabbitmqDirect(contract);
    }

    @RequestMapping(value = "/contract/topic", method = RequestMethod.GET)
    public void contractTopic() {
        ContractRabbitmq contract = new ContractRabbitmq();
        contract.setDateCreated(new Date());
        contract.setId(12L);
        contract.setName("liuhan");
        List<String> strList = new ArrayList<>();
        strList.add("liu");
        strList.add("test str");
        contract.setTestStrList(strList);
        contractRabbitmqService.sendContractRabbitmqTopic(contract);
    }

    @RequestMapping(value = "/tenant/direct", method = RequestMethod.GET)
    public void tenantDirect() {
        TenantRabbitmq tenant = new TenantRabbitmq();
        tenant.setId(12L);
        tenant.setName("liuhan");
        contractRabbitmqService.sendTenantRabbitmqDirect(tenant);
    }

    @RequestMapping(value = "/tenant/topic", method = RequestMethod.GET)
    public void tenantTopic() {
        TenantRabbitmq tenant = new TenantRabbitmq();
        tenant.setId(12L);
        tenant.setName("liuhan");
        contractRabbitmqService.sendTenantRabbitmqTopic(tenant);
    }



    public static void main(String[] args) {

        SpringApplication.run(SpringBootTest.class, args);

    }


}
