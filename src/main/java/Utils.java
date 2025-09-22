package main.java;

public class Utils {

    WebDriver driver;

    public static void printMessage(String message) {
        System.out.println("Message: " + message);
    }

    public boolean isDisplayed(WebElement element){
        driver.findElement(element).isDisplayed();
        return true;
    }

    public boolean isEnabled(WebElement element){
        driver.findElement(element).isEnabled();
        return true;
    }

    public boolean isSelected(WebElement element){
        driver.findElement(element).isSelected();
        return true;
    }

    public String getTitle(){
        String title = driver.getTitle();
        return title;
    }

    public String getCurrentUrl(){
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }

    public String getPageSource(){
        String pageSource = driver.getPageSource();
        return pageSource;
    }

    public void navigateToUrl(String url){
        driver.navigate().to(url);
    }

    public void navigateBack(){
        driver.navigate().back();
    }

    public void navigateForward(){
        driver.navigate().forward();
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void declineAlert(){
        driver.switchTo().alert().dismiss();
    }   

    public void sendKeysToAlert(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    public void switchToFrameByIndex(int index){
        driver.switchTo().frame(index);
    }   

    public void switchToFrameByNameOrId(String nameOrId){
        driver.switchTo().frame(nameOrId);
    }

    public void switchToFrameByElement(WebElement element){
        driver.switchTo().frame(element);
    }

    public void switchToDefaultContent(){
        driver.switchTo().defaultContent();
    }   

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    public void closeCurrentWindow(){
        driver.close();
    }

    public void quitDriver(){
        driver.quit();
    }   

    public void takeScreenshot(String filePath){
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File(filePath);
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();    
        }
    }

    public void setExplicitWait(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));
    }

    public void setImplicitWait(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void setPageLoadTimeout(){
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public void maximizeWindow(){
        driver.manage().window().maximize();
    }

    public void deleteAllCookies(){
        driver.manage().deleteAllCookies();
    }

    public void addCookie(Cookie cookie){
        driver.manage().addCookie(cookie);
    }

    public void selectValueFromDropdownByValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void selectValueFromDropdownByVisibleText(WebElement element, String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }   

    public void selectValueFromDropdownByIndex(WebElement element, int index){
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public void deselectAllOptionsFromDropdown(WebElement element){
        Select select = new Select(element);
        select.deselectAll();
    }

    public void deselectOptionFromDropdownByValue(WebElement element, String value){
        Select select = new Select(element);
        select.deselectByValue(value);
    }

    public void deselectOptionFromDropdownByVisibleText(WebElement element, String text){
        Select select = new Select(element);
        select.deselectByVisibleText(text);
    }

    public void deselectOptionFromDropdownByIndex(WebElement element, int index){
        Select select = new Select(element);
        select.deselectByIndex(index);
    }

    public List<WebElement> getAllOptionsFromDropdown(WebElement element){
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        return options;
    }

    public void hoverOverElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void dragAndDropElement(WebElement source, WebElement target){
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }   

    public void doubleClickElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    public void rightClickElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    public void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollByPixels(int x, int y){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    public void executeJavaScript(String script){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);
    }

    public void clickUsingJavaScript(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }   

    public void sendKeysUsingJavaScript(WebElement element, String text){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + text + "';", element);
    }

    public void clearUsingJavaScript(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='';", element);
    }

    public void highlightElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    public void removeHighlightFromElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border=''", element);
    }

    public void waitForElementToBeClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeInvisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForTextToBePresentInElement(WebElement element, String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void waitForTitleToBe(String title){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs(title));
    }

    public void waitForUrlToBe(String url){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public void waitForAlertToBePresent(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void clearCookiesAndCache(){
        driver.manage().deleteAllCookies();
        // Note: Clearing cache programmatically is not directly supported in Selenium WebDriver.
        // This can be achieved using browser-specific options or extensions.
    }

    public void widnwoHandleExample(){
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                // Perform actions on the new window
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
    }

    public void iframeExample(WebElement iframeElement){
        driver.switchTo().frame(iframeElement);
        // Perform actions inside the iframe
        driver.switchTo().defaultContent();
    }   

    public void fileUploadExample(WebElement uploadElement, String filePath){
        uploadElement.sendKeys(filePath);
    }   

    public void fileDownloadExample(String downloadUrl){
        driver.get(downloadUrl);
        // Note: Handling file downloads may require browser-specific settings.
    }

    public void handleMultipleTabsExample(){
        String originalTab = driver.getWindowHandle();
        // Open a new tab using JavaScript
        ((JavascriptExecutor) driver).executeScript("window.open()");
        Set<String> allTabs = driver.getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(originalTab)) {
                driver.switchTo().window(tab);
                // Perform actions on the new tab
                driver.close();
            }
        }
        driver.switchTo().window(originalTab);
    }

    public void waitForElementToBePresent(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void fluentWaitExample(WebElement element){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void jsClickExample(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

}
