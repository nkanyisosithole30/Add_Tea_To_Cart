package Test_Functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Checkout_Online_Order {
    private WebDriver driver;
    public Checkout_Online_Order(WebDriver driver)
    {
        this.driver=driver;
    }
    @FindBy (xpath = "//span[@class='b-btn-t'][contains(.,'Checkout')]")
    WebElement CheckOut;
    @FindBy (xpath = "(//input[@placeholder='First and last name'])[1]")
    WebElement First_And_Last_Name;
    @FindBy (xpath = "(//input[@placeholder='Address'])[1]")
    WebElement Address;
    @FindBy (xpath = "(//input[@placeholder='City'])[1]")
    WebElement City;
    @FindBy (xpath = "(//input[@placeholder='ZIP code'])[1]")
    WebElement Zip_Code;
    @FindBy (xpath = "//input[contains(@type,'email')]")
    WebElement Email;
    @FindBy (xpath = "(//input[contains(@placeholder,'Phone number')])[1]")
    WebElement Phone_Number;
    public void CheckOut_Order()
    {
        WebDriverWait reason_for_insurance=new WebDriverWait(driver,10);
        reason_for_insurance.until(ExpectedConditions.visibilityOf(CheckOut));
        CheckOut.click();
    }
    public void Enter_First_Name(String _fn)
    {
        WebDriverWait reason_for_insurance=new WebDriverWait(driver,10);
        reason_for_insurance.until(ExpectedConditions.visibilityOf(First_And_Last_Name));
        First_And_Last_Name.sendKeys(_fn);
    }

    public void Enter_Address(String _address)
    {
        WebDriverWait reason_for_insurance=new WebDriverWait(driver,10);
        reason_for_insurance.until(ExpectedConditions.visibilityOf(Address));
        Address.sendKeys(_address);
    }
    public void Enter_City(String _city)
    {
        WebDriverWait reason_for_insurance=new WebDriverWait(driver,10);
        reason_for_insurance.until(ExpectedConditions.visibilityOf(City));
        City.sendKeys(_city);
    }
    public void Enter_ZipCode(String _zipcode)
    {
        WebDriverWait reason_for_insurance=new WebDriverWait(driver,10);
        reason_for_insurance.until(ExpectedConditions.visibilityOf(Zip_Code));
        Zip_Code.sendKeys(_zipcode);
    }
    public void Enter_Email(String _email)
    {
        WebDriverWait reason_for_insurance=new WebDriverWait(driver,10);
        reason_for_insurance.until(ExpectedConditions.visibilityOf(Email));
        Email.clear();
        Email.sendKeys(_email);
    }
    public void Enter_PhoneNumber(String _phone)
    {
        WebDriverWait reason_for_insurance=new WebDriverWait(driver,10);
        reason_for_insurance.until(ExpectedConditions.visibilityOf(Phone_Number));
        Phone_Number.sendKeys(_phone);
    }
    public void Click_Continue() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        if(driver.findElements(By.xpath("(//button[contains(.,'Continue')])[1]")).size()!=0)
        {
            driver.findElement(By.xpath("(//button[contains(.,'Continue')])[1]")).click();
        }
    }
    public void Capture_Delivery_Method_And_Continue() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);

        driver.findElement(By.xpath("(//span[contains(.,'DHL')])[2]")).click();
        if(driver.findElements(By.xpath("(//button[contains(.,'Continue')])[2]")).size()!=0)
        {
            driver.findElement(By.xpath("(//button[contains(.,'Continue')])[2]")).click();
        }
    }
    public void Payment_Continue() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        if(driver.findElements(By.xpath("(//button[contains(.,'Continue')])[3]")).size()!=0)
        {
            driver.findElement(By.xpath("(//button[contains(.,'Continue')])[3]")).click();
        }
    }
    public void TermsNConditions() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        if(driver.findElements(By.id("ch-agree")).size()!=0)
        {
            driver.findElement(By.id("ch-agree")).click();
        }
    }
    public void Complete_Order() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        if(driver.findElements(By.xpath("//button[contains(.,'Complete order')]")).size()!=0)
        {
            driver.findElement(By.xpath("//button[contains(.,'Complete order')]")).click();
        }
    }
    public void Verify_Successfull_Order() throws InterruptedException {
       TimeUnit.SECONDS.sleep(3);
        Assert.assertTrue(driver.findElement(By.xpath("//strong[contains(.,'THANK YOU FOR YOUR ORDER')]")).isDisplayed());
    }
}
