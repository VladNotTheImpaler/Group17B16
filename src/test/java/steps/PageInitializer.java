package steps;

import pages.EmployeeWorkExperiancePage;
import pages.LoginPage;


public class PageInitializer {

    public static EmployeeWorkExperiancePage emp;
    public static LoginPage loginPage;
    public static void initializePageObjects() {
           emp=new EmployeeWorkExperiancePage();
           loginPage=new LoginPage();
    }


}
