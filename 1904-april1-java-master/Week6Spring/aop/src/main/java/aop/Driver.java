package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		
		VirtualPet vp1 = (VirtualPet) ac.getBean(VirtualPet.class);
		VirtualPet vp2 = (VirtualPet) ac.getBean(VirtualPet.class);
		
		System.out.println(vp1.getType());
		System.out.println(vp1.equals(vp2));

	}

}
