package CreateAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scenario1 {

    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //navigate to the site
        driver.get("https://dev.insurance.tekschool-students.com/");

        //click on Create Primary Account
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/a")).click();


        // Find the form title element using XPath
        WebElement formTitle = driver.findElement(By.xpath("//h2[contains(text(),'Create Primary Account Holder')]"));

        // Get the text of the form title
        String actualTitle = formTitle.getText();

        // Define the expected title
        String expectedTitle = "Create Primary Account Holder";

        // Validate the form title
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Form title validation passed.");
        } else {
            System.out.println("Form title validation failed. Expected: " + expectedTitle + ", Actual: " + actualTitle);
        }

    }}
