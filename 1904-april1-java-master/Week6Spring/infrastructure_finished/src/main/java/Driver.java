import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.residences.Cabin;
import beans.residences.ComponentScannedCabin;
import beans.residences.House;
import beans.residences.HouseWithAutoByName;
import beans.residences.HouseWithAutoByType;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		//another option, but frowned upon
		//ApplicationContext ac = new FileSystemXmlApplicationContext()
		
//		House adamsHouse = (House) ac.getBean("house");
//		adamsHouse.setName("Adam's House");
//		House mansion = (House) ac.getBean("house");
//		mansion.setName("The Mansion");
//		
//		adamsHouse.printStatus();
//		mansion.printStatus();
//		
//		Cabin adamsCabin = (Cabin) ac.getBean("cabin");
//		adamsCabin.setName("Adam's Cabin");
//		Cabin williamsCabin = (Cabin) ac.getBean("cabin");
//		williamsCabin.setName("William's Cabin");
//		
//		adamsCabin.printStatus();
//		williamsCabin.printStatus();
//		
		House nonBeanHouse = new House();
		nonBeanHouse.setName("Non-Bean House");
		
		nonBeanHouse.printStatus();
		
		HouseWithAutoByName autoNameHouse = (HouseWithAutoByName) ac.getBean("autoNameHouse");
		HouseWithAutoByType autoTypeHouse = (HouseWithAutoByType) ac.getBean("autoTypeHouse");
		
		autoNameHouse.setName("Auto Name House");
		autoNameHouse.printStatus();
		
		autoTypeHouse.setName("Auto Type House");
		autoTypeHouse.printStatus();
		
		ComponentScannedCabin csc = (ComponentScannedCabin) ac.getBean("componentScannedCabin");
		csc.setName("Component Scanned Cabin");
		csc.printStatus();

	}

}
