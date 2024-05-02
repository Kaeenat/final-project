package CreateAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario2 {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //navigate to the site
        driver.get("https://dev.insurance.tekschool-students.com/");

        //click on Create Primary Account
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/a")).click();


       WebElement firstNameInput = driver.findElement(By.name("firstName"));
       firstNameInput.sendKeys("Kaeenat");

        WebElement lastNameInput = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        lastNameInput.sendKeys("Kawsar");

        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailInput.sendKeys("kainat.1400@gmail.com");
        WebElement optionMrs = driver.findElement(By.xpath("//*[@id='title']//option[contains(text(),'Mrs.')]"));
        optionMrs.click();

        WebElement genderDropdown = driver.findElement(By.xpath("//*[@id='gender']"));
        genderDropdown.click();

        WebElement femaleOption = driver.findElement(By.xpath("//*[@id='gender']//option[contains(text(),'Female')]"));
        femaleOption.click();

        WebElement maritalStatusDropdown = driver.findElement(By.xpath("//*[@id='maritalStatus']"));
        maritalStatusDropdown.click();

        WebElement marriedOption = driver.findElement(By.xpath("//*[@id='maritalStatus']//option[contains(text(),'Married')]"));
        marriedOption.click();

        WebElement dobInput = driver.findElement(By.xpath("//*[@id='dateOfBirth']"));
        dobInput.sendKeys("12/20/2003");

        WebElement createAccountButton = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/form/div/div[2]/button[1]"));
        createAccountButton.click();



        // Validate the first title: "Sign up your account"
        WebElement signUpTitle = driver.findElement(By.xpath("//h2[contains(text(),'Sign up your account')]"));
        String actualSignUpTitle = signUpTitle.getText();
        String expectedSignUpTitle = "Sign up your account";
        validateTitle(actualSignUpTitle, expectedSignUpTitle);

        // Validate the second title: "Kaeenat Kawsar"
        WebElement nameTitle = driver.findElement(By.xpath("//h2[contains(text(),'Kaeenat Kawsar')]"));
        String actualNameTitle = nameTitle.getText();
        String expectedNameTitle = "Kaeenat Kawsar";
        validateTitle(actualNameTitle, expectedNameTitle);

        // Validate the third title: "kainat.1400@gmail.com"
        WebElement emailTitle = driver.findElement(By.xpath("//h2[contains(text(),'kainat.1400@gmail.com')]"));
        String actualEmailTitle = emailTitle.getText();
        String expectedEmailTitle = "kainat.1400@gmail.com";
        validateTitle(actualEmailTitle, expectedEmailTitle);

        // Close the browser
        driver.quit();
    }

    private static void validateTitle(String actualTitle, String expectedTitle) {
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title validation passed: " + expectedTitle);
        } else {
            System.out.println("Title validation failed. Expected: " + expectedTitle + ", Actual: " + actualTitle);
        }
    }

}










