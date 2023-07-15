package steps;

import pages.DashBoardPage;
import pages.JobEmployeePage;
import pages.LoginPage;
import pages.MyInfoPage;

public class PageInitializer {

    //methods in which we will add in the future all our
    // object of the POM classes

    public static LoginPage loginPage;
    public static JobEmployeePage jobEmployeePage;
    public static DashBoardPage dashBoardPage;
    public static MyInfoPage myInfoPage;

    public static void initializePageObjects() {
        loginPage = new LoginPage();
        jobEmployeePage =new JobEmployeePage();
        dashBoardPage=new DashBoardPage();
        myInfoPage=new MyInfoPage();
    }


}
