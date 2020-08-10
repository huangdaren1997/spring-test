package hdr.spring.test.config;

import hdr.spring.test.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProxyBeanMethodConfigTest {

	@Autowired
	private ApplicationContext ctx;

	@Test
	void name() {
		Object n1 = ctx.getBean("user");
		Object n2 = ctx.getBean("user");
		System.out.println(n1 == n2);

		ProxyBeanMethodConfig config = ctx.getBean(ProxyBeanMethodConfig.class);

		UserEntity n3 = config.user();
		UserEntity n4 = config.user();
		System.out.println(n3 == n4);
	}
}