package steps;

import pages.*;

public class PageInitializer {
    //methods in which we will add in the future all our
    // object of the POM classes

    public static LoginPage loginPage;
    public static UpdatePersonalInfo updatePersonalInfo;

    public static DashboardPage dashBoardPage;

    public static AddEmployeesDependents addEmployeesDependents;

    public static EmployeeWorkExperiancePage emp;
    public static JobEmployeePage jobEmployeePage;

    public static MyInfoPage myInfoPage;

    public static DashboardPage dashboardPage;
    public static AddEmployeePage addEmployeePage;

    public static SearchEmployeePage searchEmployeePage;




    public static void initializePageObjects() {
        loginPage = new LoginPage();
        updatePersonalInfo = new UpdatePersonalInfo();
        dashBoardPage=new DashboardPage();
        addEmployeesDependents=new AddEmployeesDependents();
        emp=new EmployeeWorkExperiancePage();
        jobEmployeePage=new JobEmployeePage();
        myInfoPage=new MyInfoPage();
        dashboardPage=new DashboardPage();
        addEmployeePage=new AddEmployeePage();
        searchEmployeePage = new SearchEmployeePage();


    }
}
