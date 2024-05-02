package Accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
        WebElement accountsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/a[1]")));
        accountsLink.click();

        WebElement accountsTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("chakra-table")));

        WebElement showPerPageDropdown = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div/div[2]/div/div/div[3]/select"));

        // Create a Select object for the dropdown
        Select dropdown = new Select(showPerPageDropdown);

        // Get all the options in the dropdown
        java.util.List<WebElement> options = dropdown.getOptions();

        // Iterate over each option, click on it, and validate
        for (WebElement option : options) {
            // Click on the option
            option.click();

            // Wait for the table to reload
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("chakra-table")));

            // Get the number of rows displayed
            java.util.List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));

            // Print the number of rows for the selected option
            System.out.println("Rows displayed for option " + option.getText() + ": " + rows.size());
        }}}
