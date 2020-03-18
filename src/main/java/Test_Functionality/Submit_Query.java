package Test_Functionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Submit_Query {
    private WebDriver driver;
    public Submit_Query(WebDriver driver)
    {
        this.driver=driver;
    }
    @FindBy(xpath = "//input[contains(@id,'611991')]")
    WebElement Query;

    @FindBy(xpath = "(//button[contains(.,'Submit')])[2]")
    WebElement Submit_Query;

    @FindBy (xpath = "//div[@class='form-message wt-bold'][contains(.,'Error!\n" + "The form was submitted successfully.')]")
    WebElement Verification;

    public void Enter_Query(String _query)
    {
        WebDriverWait reason_for_insurance=new WebDriverWait(driver,10);
        reason_for_insurance.until(ExpectedConditions.visibilityOf(Query));
        Query.sendKeys(_query);
    }
    public void Submit_Query()
    {
        WebDriverWait reason_for_insurance=new WebDriverWait(driver,10);
        reason_for_insurance.until(ExpectedConditions.visibilityOf(Submit_Query));
        Submit_Query.click();
    }
    public void Verify_successful_Query() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        Assert.assertTrue(Verification.isDisplayed());
    }
}
