import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LessonsTest {

    //TC_1_1  - Тест кейс:
    //1. Открыть страницу https://openweathermap.org/
    //2. Набрать в строке поиска город Paris
    //3. Нажать пункт меню Search
    //4. Из выпадающего списка выбрать Paris, FR
    //5. Подтвердить, что заголовок изменился на "Paris, FR"


    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/nataliaghibner/ga_tools/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String cityName = " Paris";
        String expectedResult ="Paris, FR";

        driver.get(url);
        Thread.sleep(5000);


        WebElement searchCityField = driver.findElement(
                By.xpath("//input[@ placeholder='Search city']")
        );
        searchCityField.click();
        searchCityField.sendKeys(cityName);
       WebElement searchButton = driver.findElement(
               By.xpath("//button[@type='submit']")
       );
        searchButton.click();
        Thread.sleep(2000);


        WebElement parisFRChoiceInDropdownMenu = driver.findElement(
                By.xpath("//span[text()='Paris, FR ']")
        );
        parisFRChoiceInDropdownMenu.click();
        Thread.sleep(5000);


        WebElement h2CityCountryHeader  = driver.findElement(
                By.xpath("//div[@id='weather-widget']//h2")
        );
        h2CityCountryHeader.click();


        String actualResult = h2CityCountryHeader.getText();

        Assert.assertEquals(actualResult,expectedResult);




        //Thread.sleep(1000);

        driver.quit();




    }

    @Test
    public void test_name() {
        System.setProperty("webdriver.chrome.driver", "/Users/nataliaghibner/ga_tools/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.quit();
        driver.close();
    }

    /*C_11_01
        1.  Открыть базовую ссылку
        2.  Нажать на пункт меню Guide
        3.  Подтвердить, что вы перешли
    на страницу со ссылкой https://openweathermap.org/guide
    и что title этой страницы OpenWeatherMap API guide - OpenWeatherMap*/

    @ Test
    public void test() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "/Users/nataliaghibner/ga_tools/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String menuTextGuide = "Guide";
        String expectedResult1 = "https://openweathermap.org/guide";
        String expectedResult2 = "OpenWeatherMap API guide - OpenWeatherMap";

        driver.get(url);
        Thread.sleep(5000);
        WebElement menuGuide = driver.findElement(By.linkText(menuTextGuide));
        menuGuide.click();

        String actualResult1 = driver.getCurrentUrl();
        String actualResult2 = driver.getTitle();

        Assert.assertEquals(actualResult1,expectedResult1);
        Assert.assertEquals(actualResult2,expectedResult2);

        driver.quit();
    }

    /*
     * TC_11_02
     * 1.  Открыть базовую ссылку
     * 2.  Нажать на единицы измерения Imperial: °F, mph
     * 3.  Подтвердить, что температура для города показана в Фарингейтах
     */

    @Test
            public void testReference()throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/nataliaghibner/ga_tools/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        driver.get(url);
        String expectedResult = "°F";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement menuImperial = driver.findElement(
                By.xpath("//div[@class='switch-container']/div[@class='option']/following-sibling::div"));

        menuImperial.click();

        WebElement tempF = driver.findElement(
                By.xpath("//div[@class='current-temp']/span"));


        driver.quit();


    }
}
