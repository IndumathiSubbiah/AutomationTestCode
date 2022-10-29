package pageObjects;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static java.lang.String.format;

public class AddNewTodoAndFilterActions  {

    static By NEW_TODO_FIELD = By.cssSelector(".new-todo");
    static By EDIT = By.xpath("//input[@class='edit']");
    static By SELECT_ALL = By.xpath("//label[@for='toggle-all']");
    static By CLEAR = By.xpath("//button[@class='clear-completed']");
    static By NUMBER_OF_ITEMS_LEFT_MESSAGE = By.cssSelector(".todo-count");
    static By TODO_ITEMS = By.xpath("//div//label");
    static By EDIT_MESSAGE = By.xpath("//footer//p[1]");

    static  WebDriver driver;
    static boolean driverLaunch = false;
    static JavascriptExecutor js;

    static Actions act;


    public void launchApplication() throws IOException {
        if(!driverLaunch) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/windows/chromedriver.exe");
            driver = new ChromeDriver();
            js = (JavascriptExecutor) driver;
            act = new Actions(driver);
            driver.manage().window().maximize();
            driverLaunch=true;

            Properties prop = new Properties();
            prop.load(new FileInputStream("src/test/resources/Properties/mvc.properties"));
            driver.get(prop.getProperty("URL"));
        }
    }

    public String prompt() {
        return driver.findElement(NEW_TODO_FIELD).getAttribute("placeholder");
    }

    public void verifyEditText() {
        System.out.println(driver.findElement(EDIT_MESSAGE).getText());
    }

    public void editItem(String item1, String item2) {
        WebElement itemName = driver.findElement(By.xpath(format("//ul[@class='todo-list']//li[contains(.,'%s')]", item1)));
        act.doubleClick(itemName).perform();
        driver.findElement(EDIT).sendKeys(item2);
    }

    public String verifyFooter() {
        return driver.findElement(By.xpath("//a[@href='http://evanyou.me']")).getText();
    }

    public String footer() {
        return driver.findElement(By.xpath("//a[@href='http://todomvc.com']")).getText();
    }

    public void selectAll() {
        driver.findElement(SELECT_ALL).click();
    }

    public void clear() {
        driver.findElement(CLEAR).click();
    }

    public void listCleared() {
        System.out.println(driver.findElement(NUMBER_OF_ITEMS_LEFT_MESSAGE).getText());
    }

    public List<WebElement> currentItems() {
        List<WebElement> currentItems = driver.findElements(TODO_ITEMS);
        return currentItems;
    }

    public String numberOfItemsLeftMessage() {
        return driver.findElement(NUMBER_OF_ITEMS_LEFT_MESSAGE).getText();
    }

    public void itemAdded(String Item) {
        driver.findElement(NEW_TODO_FIELD).sendKeys(Item);
        driver.findElement(NEW_TODO_FIELD).sendKeys(Keys.ENTER);
    }

    public void itemCalled(String completedTodo) {
        By.xpath(format("//ul[@class='todo-list']//li[contains(.,'%s')]//input[@type='checkbox']", completedTodo));
        driver.findElement(By.linkText(completedTodo)).click();
    }

    public void by(String filter) {
        driver.findElement(By.linkText(filter)).click();
    }

    public void quit() {
        driver.close();
    }

    public boolean verifyList(List<String> expectedItems) {
        String[] Verify1 = expectedItems.toArray(new String[0]);
        List<WebElement> options = driver.findElements(TODO_ITEMS);
        boolean isOK = true;

        for (WebElement ele : options) {
            int i = Arrays.asList(Verify1).indexOf("string "+ele.getText());
        }
        return isOK;
    }
}
