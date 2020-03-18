package Tests;

import Startup.Setup_Class;
import Test_Functionality.Add_Tea_To_Cart;
import Test_Functionality.Checkout_Online_Order;
import Test_Functionality.Submit_Query;
import Test_Functionality.Subscribe_Here;
import Test_Helpers.Extent_Report_Class;
import com.aventstack.extentreports.Status;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class Tea_Online_Store_Tests extends Extent_Report_Class {

    private WebDriver driver = Setup_Class.startBrowserOfChoice("https://wheres-waldlo.webnode.com/", "chrome");
    private static String dir = System.getProperty("user.dir");
    private static final String excel = dir + "/src/main/java/TestData/Tea_Data.xlsx";
    private FileInputStream fis = new FileInputStream(excel);
    private XSSFWorkbook workbook = new XSSFWorkbook(fis);

    private XSSFSheet sheet = workbook.getSheetAt(0);
    String FirstName = sheet.getRow(1).getCell(0).getStringCellValue();
    String Address = sheet.getRow(1).getCell(1).getStringCellValue();
    String City = sheet.getRow(1).getCell(2).getStringCellValue();
    String ZipCode = sheet.getRow(1).getCell(3).getStringCellValue();
    String Email = sheet.getRow(1).getCell(4).getStringCellValue();
    String PhoneNumber = sheet.getRow(1).getCell(5).getStringCellValue();

    String Query = sheet.getRow(1).getCell(6).getStringCellValue();

    public Tea_Online_Store_Tests() throws IOException, InterruptedException {
    }
    @Test
    public void Add_Product_From_Store() throws InterruptedException {
        Add_Tea_To_Cart add_tea_to_cart = PageFactory.initElements(driver, Add_Tea_To_Cart.class);
        test = extent.createTest("Launch The Online Tea Store And Add Tea To The Order");
        test.log(Status.PASS, "Preparing To Order Online");
        test.log(Status.PASS, "Select Store From Menu");
        add_tea_to_cart.Click_Store_From_Menu();
        test.log(Status.PASS, "Select Teas From SubMenu");
        add_tea_to_cart.Click_Teas_SubMenu();
        test.log(Status.PASS, "Add TAIWAN_HAND_PICKED_OOLONG_TEA To Cart");
        add_tea_to_cart.Add_TAIWAN_HAND_PICKED_OOLONG_TEA();
        add_tea_to_cart.Add_To_Cart();
        add_tea_to_cart.Go_Back_To_Shopping();
        test.log(Status.PASS, "Add INDIA_PREMIUM_ASAM_BLACK_TEA To Cart");
        add_tea_to_cart.Add_INDIA_PREMIUM_ASAM_BLACK_TEA();
        add_tea_to_cart.Add_To_Cart();
        add_tea_to_cart.Go_Back_To_Shopping();
        test.log(Status.PASS, "Add YUNNAN_PU_ERH_FERMENTED_TEA To Cart");
        add_tea_to_cart.Add_YUNNAN_PU_ERH_FERMENTED_TEA();
        add_tea_to_cart.Add_To_Cart();
        add_tea_to_cart.Go_Back_To_Shopping();
        test.log(Status.PASS, "Add CHINA_GREEN_GUNPOWDER_TEA To Cart");
        add_tea_to_cart.Add_CHINA_GREEN_GUNPOWDER_TEA();
        add_tea_to_cart.Add_To_Cart();
        add_tea_to_cart.Go_Back_To_Shopping();
        test.log(Status.PASS, "Add CHINA_ANHUI_YELLOW_TEA To Cart");
        add_tea_to_cart.Add_CHINA_ANHUI_YELLOW_TEA();
        add_tea_to_cart.Add_To_Cart();
        add_tea_to_cart.Go_Back_To_Shopping();
        test.log(Status.PASS, "Add YUNNAN_GREEN_BLOOMING_TEA To Cart");
        add_tea_to_cart.Add_YUNNAN_GREEN_BLOOMING_TEA();
        add_tea_to_cart.Add_To_Cart();
        add_tea_to_cart.Go_Back_To_Shopping();
        test.log(Status.PASS, "Add BRAZIL_YERBA_MATE_DETOX_MIX To Cart");
        add_tea_to_cart.Add_BRAZIL_YERBA_MATE_DETOX_MIX();
        add_tea_to_cart.Add_To_Cart();
        add_tea_to_cart.Go_Back_To_Shopping();
        test.log(Status.PASS, "Add SOUTH_AFRICA_HERBAL_ROOIBOS To Cart");
        add_tea_to_cart.Add_SOUTH_AFRICA_HERBAL_ROOIBOS();
        add_tea_to_cart.Add_To_Cart();
        add_tea_to_cart.Go_Back_To_Shopping();
        add_tea_to_cart.Click_Cart();
        //Increase order numbers
        // 8 = number of items added on the cart
        for(int i=0;i<=8;i++)
        {
            add_tea_to_cart.Increase_Number_Of_Orders();
        }
    }
    @Test(priority = 1)
    public void CheckOut_Order_Test() throws InterruptedException {
        Checkout_Online_Order checkout_online_order = PageFactory.initElements(driver, Checkout_Online_Order.class);
        Checkout_Online_Order check_out=new Checkout_Online_Order(driver);
        test = extent.createTest("Check Out Online Order");
        test.log(Status.PASS, "Click Checkout Button");

        checkout_online_order.CheckOut_Order();
        test.log(Status.PASS, "Enter First Name And Last Name");
        checkout_online_order.Enter_First_Name(FirstName);
        test.log(Status.PASS, "Enter Address");
        checkout_online_order.Enter_Address(Address);
        test.log(Status.PASS, "Enter City");
        checkout_online_order.Enter_City(City);
        test.log(Status.PASS, "Enter Zip Code");
        checkout_online_order.Enter_ZipCode(ZipCode);
        test.log(Status.PASS, "Enter Email");
        checkout_online_order.Enter_Email(Email);
        test.log(Status.PASS, "Enter Phone Number");
        checkout_online_order.Enter_PhoneNumber(PhoneNumber);
        test.log(Status.PASS, "Click Continue");
        check_out.Click_Continue();
        test.log(Status.PASS, "Select Delivery Method And Click Continue");
        check_out.Capture_Delivery_Method_And_Continue();
        test.log(Status.PASS, "Click Continue On The Payments Page");
        check_out.Payment_Continue();
        test.log(Status.PASS, "Agree To Terms And Conditions");
        check_out.TermsNConditions();
        test.log(Status.PASS, "Click Complete Order");
        check_out.Complete_Order();
        test.log(Status.PASS, "Verify Successful Message");
        check_out.Verify_Successfull_Order();
    }
    @Test (priority = 2)
    public void Subscribe() throws InterruptedException {
        Subscribe_Here subscribe_here = PageFactory.initElements(driver,Subscribe_Here.class);
        test = extent.createTest("Subscribe To Online Tea");
        test.log(Status.PASS, "Click Contact Menu");
        subscribe_here.Click_Contact_Menu();
        test.log(Status.PASS, "Enter Email Address");
        subscribe_here.Enter_Email_Address(Email);
        test.log(Status.PASS, "Click Submit");
        subscribe_here.Click_Submit();
        test.log(Status.PASS, "Verify That Message Is Displayed");
        subscribe_here.Verify_Error_Message();
    }
    @Test(priority = 3)
    public void Submit_Query() throws InterruptedException {
        Subscribe_Here subscribe_here = PageFactory.initElements(driver,Subscribe_Here.class);
        Submit_Query query=PageFactory.initElements(driver,Submit_Query.class);
        test = extent.createTest("Submit Query");
        test.log(Status.PASS, "Click Contact Menu");
        subscribe_here.Click_Contact_Menu();
        test.log(Status.PASS, "Type In Query");
        query.Enter_Query(Query);
        test.log(Status.PASS, "Click Submit Query");
        query.Submit_Query();
        test.log(Status.PASS, "Verify Successful Submission");
        query.Verify_successful_Query();
    }
    @AfterSuite
    public void Quit_Test() {
        driver.quit();
    }
}
