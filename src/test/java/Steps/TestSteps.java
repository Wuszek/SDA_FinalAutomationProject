package Steps;

import Base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class TestSteps extends BaseUtil {
    private BaseUtil base;

    public TestSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("I am on main site")
    public void iAmOnMainSite() throws InterruptedException {
        //base.Driver.navigate().to("http://automationpractice.com/index.php");
        //base.Wait.until(ExpectedConditions.urlToBe("http://automationpractice.com/index.php"));

        //base.Wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#searchbox [name='search_query']")));
        //base.Driver.findElement(By.cssSelector("input#search_query_top")).sendKeys("Dress");

        //System.out.println("TEST");

        Assert.assertEquals(true, base.Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='header_logo']//img[@alt='My Store']"))).isDisplayed());
        System.out.println("I am on main site!");

    }

    @Given("I am on product site")
    public void iAmOnProductSite() {
        base.Driver.navigate().to("http://automationpractice.com/index.php?id_product=1&controller=product");
        Assert.assertTrue(base.Wait.until(ExpectedConditions.urlContains("=product")));
    }

    @When("I click on add to cart")
    public void iClickOnAddToCart() {
        // base.Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@id='add_to_cart']//span[.='Add to cart']")));
        base.Driver.findElement(By.xpath("//p[@id='add_to_cart']//span[.='Add to cart']")).click();
    }

    @Then("Product is added to cart")
    public void productIsAddedToCart() throws InterruptedException {
        //Assert.assertEquals(true, base.Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html//div[@id='layer_cart']//i[@class='icon-ok']"))).isDisplayed());
        Assert.assertEquals((base.Wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html//div[@id='layer_cart']/div[1]/div[1]/h2"),"Product successfully added to your shopping cart"))), true);
        System.out.println("Product added to cart!");
    }

    @Given("I am on SignIn page")
    public void iAmOnSignInPage() {
        base.Driver.findElement(By.xpath("/html//header[@id='header']//nav//a[@title='Log in to your customer account']")).click();
        Assert.assertEquals(true, base.Wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//form[@id='login_form']/h3[@class='page-subheading']"),"ALREADY REGISTERED?")));
        System.out.println("Login site visible");
    }

    @When("I enter my credentials")
    public void iEnterMyCredentials() {
        base.Driver.findElement(By.xpath("/html//input[@id='email']")).sendKeys("test@testowisko.pl");
        base.Driver.findElement(By.xpath("/html//input[@id='passwd']")).sendKeys("Test111");
        base.Driver.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();
    }

    @Then("I am logged on my account")
    public void iAmLoggedOnMyAccount() {
        Assert.assertEquals(true, base.Wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='center_column']/h1[@class='page-heading']"),"MY ACCOUNT")));
        System.out.println("Login succesfull");
    }

    @And("I click on checkout")
    public void iClickOnCheckout() {
        base.Driver.findElement(By.xpath("/html//div[@id='layer_cart']//a[@title='Proceed to checkout']/span")).click();
        base.Driver.findElement(By.xpath("//div[@id='center_column']//a[@title='Proceed to checkout']/span")).click();
    }

    @And("I accept my address")
    public void iAcceptMyAddress() {
        base.Driver.findElement(By.xpath("//div[@id='center_column']/form[@action='http://automationpractice.com/index.php?controller=order']//button/span")).click();
    }

    @And("I accept terms of service")
    public void iAcceptTermsOfService() {
        base.Driver.findElement(By.xpath("/html//input[@id='cgv']")).click();
        base.Driver.findElement(By.xpath("//form[@id='form']//button[@name='processCarrier']/span")).click();
    }

    @And("I choose pay by wire")
    public void iChoosePayByWire() {
        base.Driver.findElement(By.xpath("/html//div[@id='HOOK_PAYMENT']//a[@title='Pay by bank wire']/span[.='(order processing will be longer)']")).click();
    }

    @And("I confirm my order")
    public void iConfirmMyOrder() {
        base.Driver.findElement(By.xpath("//p[@id='cart_navigation']//span")).click();
    }

    @Then("I get order confirmation")
    public void iGetOrderConfirmation() {
        Assert.assertEquals(true, base.Wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html//div[@id='center_column']//strong[@class='dark']"),"Your order on My Store is complete.")));
        System.out.println("Order confirmation is visible!");
    }

    @When("I type {string} in search bar")
    public void iTypeInSearchBar(String productname) {
        base.Driver.findElement(By.xpath("/html//input[@id='search_query_top']")).sendKeys(productname);
    }

    @And("I click ENTER")
    public void iClickENTER() {
        base.Driver.findElement(By.xpath("/html//input[@id='search_query_top']")).sendKeys(Keys.ENTER);
    }

    @Then("Result found shown for {string}")
    public void resultFoundShownFor(String productname) {
        Assert.assertEquals((base.Wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[@class='lighter']\n"),productname.toUpperCase()))), true);

        System.out.println("Product " + productname + " succesfully searched!");
    }

    @When("I click on Contact Us button")
    public void iClickOnContactUsButton() {
        base.Driver.findElement(By.xpath("//div[@id='contact-link']/a[@title='Contact Us']")).click();
        Assert.assertEquals(true, base.Wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='center_column']/h1[1]"), "CUSTOMER SERVICE - CONTACT US")));
        System.out.println("I can see contact form!");
    }

    @And("I fill contact form")
    public void iFillContactForm() {
        Select SubjectDropdown = new Select(base.Driver.findElement(By.xpath("/html//select[@id='id_contact']")));

        String option_d = SubjectDropdown.getFirstSelectedOption().getAttribute("value");
        System.out.println("Check first selected option (no value selected yet): " + option_d);

        SubjectDropdown.selectByValue("1");
        String option = SubjectDropdown.getFirstSelectedOption().getAttribute("value");
        System.out.println("Check first selected option (selected value = 1): " + option);

        base.Driver.findElement(By.xpath("/html//input[@id='email']")).sendKeys("test@testowisko.pl");
        base.Driver.findElement(By.xpath("/html//input[@id='id_order']")).sendKeys("QWERTY1");
        base.Driver.findElement(By.xpath("/html//textarea[@id='message']")).sendKeys("Test message");
    }

    @And("I click Send button")
    public void iClickSendButton() {
        Select SubjectDropdown = new Select(base.Driver.findElement(By.xpath("/html//select[@id='id_contact']")));
        String option = SubjectDropdown.getFirstSelectedOption().getAttribute("value");

        System.out.println("Check first selected option: " + option);

        if( base.Driver.findElement(By.xpath("/html//input[@id='email']")).getText() != ""
       && base.Driver.findElement(By.xpath("/html//input[@id='id_order']")).getText() != ""
       && base.Driver.findElement(By.xpath("/html//textarea[@id='message']")).getText() != ""
       && "1".equals(option)
       )
       {
           System.out.println("Everything filled! Confirming...");
           base.Driver.findElement(By.xpath("//button[@id='submitMessage']/span")).click();
       } else {
           System.out.println("Something is not filled up!");
       }

    }

    @Then("Message is sent")
    public void messageIsSent() {
        Assert.assertEquals((base.Wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='center_column']/p[@class='alert alert-success']"),"Benisoida"))), true);


    }
}
