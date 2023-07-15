package steps;


import pages.EmployeeWorkExperiancePage;

import pages.AddEmployeesDependents;

import pages.LoginPage;
import pages.UpdatePersonalInfo;


import pages.DashBoardPage;
import pages.JobEmployeePage;
import pages.LoginPage;
import pages.MyInfoPage;


public class PageInitializer {

    public static EmployeeWorkExperiancePage emp;
    public static LoginPage loginPage;
    public static UpdatePersonalInfo updatePersonalInfo;
    public static AddEmployeesDependents addEmployeesDependents;
    public static JobEmployeePage jobEmployeePage;
    public static DashBoardPage dashBoardPage;
    public static MyInfoPage myInfoPage;


    public static void initializePageObjects() {
           emp=new EmployeeWorkExperiancePage();
           loginPage=new LoginPage();
        updatePersonalInfo = new UpdatePersonalInfo();
        addEmployeesDependents = new AddEmployeesDependents();
        jobEmployeePage =new JobEmployeePage();
        dashBoardPage=new DashBoardPage();
        myInfoPage=new MyInfoPage();


    }


}
