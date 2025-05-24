package tests;

import org.testng.annotations.*;
import pages.LoginPage;
import pages.HomePage;
import driver.DriverManager;
import utils.ExcelReader;
import utils.JsonReader;
import utils.VideoRecorder;
import utils.LoggerUtil;
import reports.ExtentReportManager;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LoginTest {
    private ExtentTest test;
    private VideoRecorder videoRecorder;

    @BeforeMethod
    public void setUp() throws Exception {
        test = ExtentReportManager.getInstance().createTest("Login Test");
        videoRecorder = new VideoRecorder();
        videoRecorder.startRecording("login_test_" + System.currentTimeMillis());
    }

    @DataProvider(name = "excelData")
    public Object[][] getExcelData() throws Exception {
        List<String[]> data = ExcelReader.readExcel("src/test/resources/testdata.xlsx", "Sheet1");
        return data.toArray(new Object[0][]);
    }

    @DataProvider(name = "jsonData")
    public Object[][] getJsonData() throws Exception {
        List<String[]> data = JsonReader.readJson("src/test/resources/testdata.json");
        return data.toArray(new Object[0][]);
    }

    @Test(dataProvider = "excelData", retryAnalyzer = listeners.RetryAnalyzer.class)
    public void testLogin(String username, String password) {
        LoggerUtil.info("Running login test with username: " + username);
        test.log(Status.INFO, "Testing login with username: " + username);
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        HomePage homePage = loginPage.clickLoginButton();
        String welcomeMessage = homePage.getWelcomeMessage();
        test.log(Status.PASS, "Login successful, welcome message: " + welcomeMessage);
        assert welcomeMessage.contains("Welcome");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        videoRecorder.stopRecording();
        DriverManager.quitDriver();
    }

    @AfterSuite
    public void sendReport() {
        ExtentReportManager.getInstance().flush();
        email.EmailUtil.sendEmail("reports/ExtentReport.html");
    }
}