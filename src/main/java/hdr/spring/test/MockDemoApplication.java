package hdr.spring.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(basePackages = "hdr.demo.mock")
@SpringBootApplication
@EnableTransactionManagement
public class MockDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MockDemoApplication.class, args);
    }

}