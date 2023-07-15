package steps;

import pages.AddEmployeesDependents;
import pages.LoginPage;
import pages.UpdatePersonalInfo;

public class PageInitializer {

    //methods in which we will add in the future all our
    // object of the POM classes

    public static LoginPage loginPage;
    public static UpdatePersonalInfo updatePersonalInfo;
    public static AddEmployeesDependents addEmployeesDependents;

    public static void initializePageObjects() {
        loginPage = new LoginPage();
        updatePersonalInfo = new UpdatePersonalInfo();
        addEmployeesDependents = new AddEmployeesDependents();

    }


}
