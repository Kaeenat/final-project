package User_profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Scenario1 {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //navigate to the site
        driver.get("https://dev.insurance.tekschool-students.com/");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/a[2]"));
        loginButton.click();
        String username = "supervisor";
        String password = "tek_supervisor";

        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);

        WebElement loginForm = driver.findElement(By.tagName("form"));
        loginForm.submit();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement profileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[1]/div/button")));

// Click on the profile button to open the Profile Side Drawer
        profileButton.click();

// Wait for the Profile Side Drawer to appear
        String expectedProfileInfo = "STATUS:\nActive\n\nUSER TYPE:\nCSR\n\nFULL NAME:\nSupervisor\n\nUSERNAME:\nsupervisor\n\nAUTHORITIES\nadmin";

        if (expectedProfileInfo.equals(expectedProfileInfo)) {
            System.out.println("Profile information is correct.");
        } else {
            System.out.println("Profile information is incorrect.");
        }

}}
