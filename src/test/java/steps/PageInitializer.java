package steps;

<<<<<<< HEAD
import pages.EmployeeWorkExperiancePage;
=======
import pages.AddEmployeesDependents;
>>>>>>> feature/add-employees-dependents
import pages.LoginPage;
import pages.UpdatePersonalInfo;


public class PageInitializer {

    public static EmployeeWorkExperiancePage emp;
    public static LoginPage loginPage;
<<<<<<< HEAD
    public static void initializePageObjects() {
           emp=new EmployeeWorkExperiancePage();
           loginPage=new LoginPage();
=======
    public static UpdatePersonalInfo updatePersonalInfo;
    public static AddEmployeesDependents addEmployeesDependents;

    public static void initializePageObjects() {
        loginPage = new LoginPage();
        updatePersonalInfo = new UpdatePersonalInfo();
        addEmployeesDependents = new AddEmployeesDependents();

>>>>>>> feature/add-employees-dependents
    }


}
