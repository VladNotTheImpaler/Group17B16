package utils;

public class Constants {

    //add the path to the config.properties file
    public static final String CONFIG_READER_PATH = System.getProperty("user.dir") +
            "/src/test/resources/config/config.properties";



    public static final String SCREENSHOT_FOLDER_PATH = System.getProperty("user.dir") +
            "/screenshots/";
    public static final String EXCEL_READER_PATH =System.getProperty("user.dir")+"src/test/resources/testdata/workexp.xlsx";

    public static final String EXCEL_READER_PATH_OLEKSII = System.getProperty("user.dir") +
            "/src/test/resources/testDataOleksii/UpdateEmployeeInfoBatch16G17.xlsx";

    public static final String EXCEL_READER_PATH_OLEKSII_2 = System.getProperty("user.dir") +
            "/src/test/resources/testDataOleksii/UpdateEmployeeInfoBatch16G17.xlsx";

    //Please use this Excel reader path and create your own variable with the name of your own Excel file after testdata/
    public static final String EXCEL_READER_PATH_Nat=System.getProperty("user.dir")+"/src/test/resources/testdata/JobDetails.xlsx";

}


