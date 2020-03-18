package Test_Functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Subscribe_Here {
    private WebDriver driver;
    public Subscribe_Here(WebDriver driver)
    {
        this.driver=driver;
    }
    @FindBy(xpath = "//span[@class='menu-item-text'][contains(.,'Contact')]")
    WebElement Contact;

    @FindBy (xpath = "//input[contains(@value,'@')]")
    WebElement Subscribe_Email;

    @FindBy (xpath = "(//button[contains(.,'Submit')])[1]")
    WebElement Submit;

    public void Click_Contact_Menu()
    {
        WebDriverWait reason_for_insurance=new WebDriverWait(driver,10);
        reason_for_insurance.until(ExpectedConditions.visibilityOf(Contact));
        Contact.click();
    }
    public void Enter_Email_Address(String _email)
    {
        WebDriverWait reason_for_insurance=new WebDriverWait(driver,10);
        reason_for_insurance.until(ExpectedConditions.visibilityOf(Subscribe_Email));
        Subscribe_Email.clear();
        Subscribe_Email.sendKeys(_email);
    }
    public void Click_Submit()
    {
        WebDriverWait reason_for_insurance=new WebDriverWait(driver,10);
        reason_for_insurance.until(ExpectedConditions.visibilityOf(Submit));
        Submit.click();
    }
    public void Verify_Error_Message() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(.,'Please submit a valid email addres')])[13]")).isDisplayed());
    }
}
