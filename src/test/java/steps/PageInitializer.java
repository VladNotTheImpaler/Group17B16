package steps;

import pages.LoginPage;

public class PageInitializer {

    //methods in which we will add in the future all our
    // object of the POM classes

    public static LoginPage loginPage;

    public static void initializePageObjects() {
        loginPage = new LoginPage();

    }


}
