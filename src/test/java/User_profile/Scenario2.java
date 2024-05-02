package User_profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Scenario2 {
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
        profileButton.click();

        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"chakra-modal-:r3:\"]/footer/div/button[1]"));
        logoutButton.click();

        // Verify if user navigates to the home page
        String currentURL = driver.getCurrentUrl();
        if (currentURL.equals("https://dev.insurance.tekschool-students.com/")) {
            System.out.println("User successfully navigated to the home page after logout.");
        } else {
            System.out.println("User failed to navigate to the home page after logout.");

    }}}
