package com.sg.flooringmastery;

// import com.sg.flooringmastery.dao.OrderDao;
import com.sg.flooringmastery.ops.FlooringMasteryController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class App {

    public static void main(String[] args) {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        FlooringMasteryController fmc = 
//                (FlooringMasteryController) ctx.getBean("flooringMasteryControllerInMem");
        FlooringMasteryController fmc = 
                (FlooringMasteryController) ctx.getBean("flooringMasteryControllerFileIO");
        fmc.run();
    }
}