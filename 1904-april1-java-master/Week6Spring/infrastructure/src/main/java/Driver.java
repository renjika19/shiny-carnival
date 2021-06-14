import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.House;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		//another option, but frowned upon
		//ApplicationContext ac = new FileSystemXmlApplicationContext()
		
		House adamsHouse = (House) ac.getBean("house");
		adamsHouse.setName("Adam's House");
		House mansion = (House) ac.getBean("house");
		mansion.setName("The Mansion");
		
		adamsHouse.printStatus();
		mansion.printStatus();

	}

}
