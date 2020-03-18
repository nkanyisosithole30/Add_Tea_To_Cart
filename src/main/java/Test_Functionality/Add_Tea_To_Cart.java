package Test_Functionality;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Add_Tea_To_Cart{

    private WebDriver driver;
    public Add_Tea_To_Cart(WebDriver driver)
    {
        this.driver=driver;
    }
    @FindBy (linkText = "Store")
    WebElement Store;
    @FindBy (linkText = "TEAS")
    WebElement Teas;
    @FindBy (name = "send")
    WebElement Add_To_Cart;
    @FindBy(id="wnd_ThumbnailBlock_7j32vp")
    WebElement TAIWAN_HAND_PICKED_OOLONG_TEA;
    @FindBy(id = "wnd_ThumbnailBlock_301j91")
    WebElement INDIA_PREMIUM_ASAM_BLACK_TEA;
    @FindBy(id="wnd_ThumbnailBlock_25t4b4")
    WebElement YUNNAN_PU_ERH_FERMENTED_TEA;
    @FindBy(id="wnd_ThumbnailBlock_6qshsk")
    WebElement CHINA_GREEN_GUNPOWDER_TEA;
    @FindBy(id="wnd_ThumbnailBlock_3meeor")
    WebElement CHINA_ANHUI_YELLOW_TEA;
    @FindBy(id="wnd_ThumbnailBlock_1rr11k")
    WebElement YUNNAN_GREEN_BLOOMING_TEA;
    @FindBy(id="wnd_ThumbnailBlock_7mv18c")
    WebElement BRAZIL_YERBA_MATE_DETOX_MIX;
    @FindBy(id="wnd_ThumbnailBlock_3ml7ck")
    WebElement SOUTH_AFRICA_HERBAL_ROOIBOS;

    @FindBy(xpath = "//div[@class='cart-text'][contains(.,'Cart')]")
    WebElement Cart;
    @FindBy(xpath = "//input[contains(@min,'1')]")
    WebElement Increase;

    public void Click_Store_From_Menu()
    {
        WebDriverWait reason_for_insurance=new WebDriverWait(driver,40);
        reason_for_insurance.until(ExpectedConditions.visibilityOf(Store));
        Store.click();
    }
    public void Click_Teas_SubMenu()
    {
        WebDriverWait reason_for_insurance=new WebDriverWait(driver,40);
        reason_for_insurance.until(ExpectedConditions.visibilityOf(Teas));
        Teas.click();
    }
    public void Add_To_Cart()
    {
        WebDriverWait reason_for_insurance=new WebDriverWait(driver,40);
        reason_for_insurance.until(ExpectedConditions.visibilityOf(Add_To_Cart));
        Add_To_Cart.click();
    }
    public void Click_Cart()
    {
        WebDriverWait reason_for_insurance=new WebDriverWait(driver,40);
        reason_for_insurance.until(ExpectedConditions.visibilityOf(Cart));
        Cart.click();
    }
    public void Go_Back_To_Shopping()
    {
        //After adding item to the card - go back to the list to add more
        driver.navigate().back();
    }
    public void Increase_Number_Of_Orders() throws InterruptedException {
       //refreshing the page every time we changing quantity so that it will update
        TimeUnit.SECONDS.sleep(1);
        driver.navigate().refresh();
        TimeUnit.SECONDS.sleep(1);
        Increase.clear();
        Increase.sendKeys("30");
        TimeUnit.SECONDS.sleep(1);
        driver.navigate().refresh();
    }
    public void Add_TAIWAN_HAND_PICKED_OOLONG_TEA()
    {
        WebDriverWait reason_for_insurance=new WebDriverWait(driver,40);
        reason_for_insurance.until(ExpectedConditions.visibilityOf(TAIWAN_HAND_PICKED_OOLONG_TEA));
        TAIWAN_HAND_PICKED_OOLONG_TEA.click();
    }
    public void Add_INDIA_PREMIUM_ASAM_BLACK_TEA()
    {
        WebDriverWait reason_for_insurance=new WebDriverWait(driver,40);
        reason_for_insurance.until(ExpectedConditions.visibilityOf(INDIA_PREMIUM_ASAM_BLACK_TEA));
        INDIA_PREMIUM_ASAM_BLACK_TEA.click();
    }
    public void Add_YUNNAN_PU_ERH_FERMENTED_TEA()
    {
        WebDriverWait reason_for_insurance=new WebDriverWait(driver,40);
        reason_for_insurance.until(ExpectedConditions.visibilityOf(YUNNAN_PU_ERH_FERMENTED_TEA));
        YUNNAN_PU_ERH_FERMENTED_TEA.click();
    }
    public void Add_CHINA_GREEN_GUNPOWDER_TEA()
    {
        WebDriverWait reason_for_insurance=new WebDriverWait(driver,40);
        reason_for_insurance.until(ExpectedConditions.visibilityOf(CHINA_GREEN_GUNPOWDER_TEA));
        CHINA_GREEN_GUNPOWDER_TEA.click();
    }
    public void Add_CHINA_ANHUI_YELLOW_TEA()
    {
        WebDriverWait reason_for_insurance=new WebDriverWait(driver,40);
        reason_for_insurance.until(ExpectedConditions.visibilityOf(CHINA_ANHUI_YELLOW_TEA));
        CHINA_ANHUI_YELLOW_TEA.click();
    }
    public void Add_YUNNAN_GREEN_BLOOMING_TEA()
    {
        WebDriverWait reason_for_insurance=new WebDriverWait(driver,40);
        reason_for_insurance.until(ExpectedConditions.visibilityOf(YUNNAN_GREEN_BLOOMING_TEA));
        YUNNAN_GREEN_BLOOMING_TEA.click();
    }
    public void Add_BRAZIL_YERBA_MATE_DETOX_MIX()
    {
        WebDriverWait reason_for_insurance=new WebDriverWait(driver,40);
        reason_for_insurance.until(ExpectedConditions.visibilityOf(BRAZIL_YERBA_MATE_DETOX_MIX));
        BRAZIL_YERBA_MATE_DETOX_MIX.click();
    }
    public void Add_SOUTH_AFRICA_HERBAL_ROOIBOS()
    {
        WebDriverWait reason_for_insurance=new WebDriverWait(driver,40);
        reason_for_insurance.until(ExpectedConditions.visibilityOf(SOUTH_AFRICA_HERBAL_ROOIBOS));
        SOUTH_AFRICA_HERBAL_ROOIBOS.click();
    }
}
