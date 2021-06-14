package aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class AppConfig {
	
	@Bean
	@Scope("singleton")
	public VirtualPet getPet() {
		VirtualPet vp = new VirtualPet();
		vp.setType("Computer Horse");
		return vp;
	}
}
