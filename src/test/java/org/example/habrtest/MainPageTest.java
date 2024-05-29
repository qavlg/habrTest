package org.example.habrtest;

import org.checkerframework.checker.units.qual.Time;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class MainPageTest {
    private WebDriver driver;


    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://habr.com/");


    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Вход в Хабр")
    public void login() {

        String login = "Aleksei";
        String password = "12345678";


        WebElement logIn = driver.findElement(By.cssSelector("button[class=\"btn btn_solid btn_small tm-header-user-menu__login\"]"));
        logIn.click();

        WebElement LoginField = driver.findElement(By.cssSelector("#email_field"));
        LoginField.sendKeys(login);

        WebElement PasswordField = driver.findElement(By.cssSelector("#password_field"));
        PasswordField.sendKeys(password);

        WebElement logInButton = driver.findElement(By.cssSelector("#login_form > fieldset > div.form__buttons.s-buttons > button"));
        logInButton.click();

    }

    @Test
    @DisplayName("Поиск новостей")
    public void search() {

        WebElement search = driver.findElement(By.cssSelector("nav > a:nth-child(5)"));
        search.click();

        WebElement searchInfo = driver.findElement(By.cssSelector("#\\38 17939 > div.tm-article-snippet.tm-article-snippet > h2 > a > span"));
        searchInfo.click();

        List<WebElement> news = driver.findElements(By.xpath("//h2[contains(text(),'Читают сейчас')]"));
        assertFalse(news.isEmpty(),"Читают сейчас не найдено");



//         WebElement searchField = driver.findElement(By.cssSelector("input[class ='tm-search__input tm-input-text-decorated__input']"));
//          searchField.sendKeys(input);
//
//
//         WebElement searchButton = driver.findElement(By.cssSelector("span > svg[class='tm-svg-img tm-svg-icon']"));
//         searchButton.click();
//
//         WebElement DropDownListButton = driver.findElement(By.cssSelector("button[class='tm-navigation-dropdown__button tm-navigation-dropdown__button']"));
//        DropDownListButton.click();
//
//         WebElement SortByTimeButton = driver.findElement(By.cssSelector("ul>[class='tm-navigation-dropdown__option']>button:nth-of-type(1)"));
//         SortByTimeButton.click();
//
//        WebElement searchPageField = driver.findElement(By.cssSelector("input[class ='tm-search__input tm-input-text-decorated__input']"));
//        assertEquals(input, searchPageField.getAttribute("value"));





    }


}
