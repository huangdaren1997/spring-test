package hdr.spring.test.config;

import hdr.spring.test.entity.UserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 测试 proxyBeanMethod属性的作用
 * proxyBeanMethod = true
 *      Spring通过cglib的方式创建该配置类，每次从该配置类中调用@Bean方法，会得到同一个对象
 * proxyBeanMethod = false
 *      Spring不会为该配置类生成代理对象，每次从该配置类中调用@Bean方法，会得到一个新的对象
 *
 * @author hyc
 * @since 2020/8/10
 */
@Configuration(proxyBeanMethods = true)
public class ProxyBeanMethodConfig {


	@Bean
	public UserEntity user(){
		return UserEntity.builder()
				.name("hyc")
				.age(23)
				.build();
	}

}
