package Test_Helpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Extent_Report_Class {

    private ExtentHtmlReporter htmlReporter;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void reportSetup()
    {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Online Tea Reports/Online Tea Report.html");
        htmlReporter.config().setDocumentTitle("Life Quote");
        htmlReporter.config().setReportName("Life Quote");
        htmlReporter.config().setTheme(Theme.STANDARD);
        extent= new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Hostname","Localhost");
        extent.setSystemInfo("OS","Windows");
        extent.setSystemInfo("Environment","Test_Env");
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Case Failed Is " + result.getName());
            test.log(Status.FAIL, "Test Case Failed Is " + result.getThrowable());

        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Case Skipped Is " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Case Passed Is " + result.getName());
        }

    }
    @AfterSuite
    public void reportTeardown()
    {
        extent.flush();
    }
    protected String captureScreen(WebDriver driver) throws IOException
    {
        TakesScreenshot screen =(TakesScreenshot) driver;
        File src=screen.getScreenshotAs(OutputType.FILE);
        String dest=System.getProperty("user.dir")+"/Life_Quote_ScreenShots/ScreenShots" + GetCurrentSystemTime() +".png";
        File target=new File(dest);
        FileUtils.copyFile(src,target);
        return dest;
    }
    private String GetCurrentSystemTime(){
        String str = null;
        try{
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
            Date date = new Date();
            str= dateFormat.format(date);
            str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
        }
        catch(Exception ignored){
        }
        return str;
    }
}