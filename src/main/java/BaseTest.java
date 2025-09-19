package main.java;

public class BaseTest {

    WebDriver driver;

    @Before
    public void setup() {
        System.out.println("BaseTest setup");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://google.com");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @After
    public void teardown() {
        System.out.println("BaseTest teardown");
        if (driver != null) {
            driver.quit();
        }
    }
}
