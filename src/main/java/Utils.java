package main.java;

public class Utils {

    WebDriver driver;

    public static void printMessage(String message) {
        System.out.println("Message: " + message);
    }

    public boolean isDisplayed(WebElement element){
        return element.isDisplayed();
    }

    public boolean isEnabled(WebElement element){
        return element.isEnabled();
    }

    public boolean isSelected(WebElement element){
        return element.isSelected();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getPageSource(){
        return driver.getPageSource();
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

    public void setExplicitWait(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
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

    public void selectValueFromDropdown(WebElement element, String value){
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
        return select.getOptions();
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

    // Consolidated scroll methods
    public void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollByPixels(int x, int y){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    public void scrollToBottom(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void scrollToTop(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }

    public void executeJavaScript(String script){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);
    }

    // Consolidated JS click method
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

    // Wait methods
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
    }

    public void windowHandleExample(){
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
    }

    public void iframeExample(WebElement iframeElement){
        driver.switchTo().frame(iframeElement);
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
        ((JavascriptExecutor) driver).executeScript("window.open()");
        Set<String> allTabs = driver.getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(originalTab)) {
                driver.switchTo().window(tab);
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

    // Consolidated element presence and interaction methods
    public void checkElementPresenceAndEnterData(WebElement element, String data){
        if(isDisplayed(element) && isEnabled(element)){
            element.clear();
            element.sendKeys(data);
            System.out.println("Data entered successfully");
        } else {
            System.out.println("Element is not interactable");
        }
    }

    public void checkElementPresenceAndClick(WebElement element){
        if(isDisplayed(element) && isEnabled(element)){
            element.click();
            System.out.println("Element clicked successfully");
        } else {
            System.out.println("Element is not clickable");
        }
    }   

    public void checkElementPresenceAndGetText(WebElement element){
        if(isDisplayed(element)){
            String text = element.getText();
            System.out.println("Element text: " + text);
        } else {
            System.out.println("Element is not visible");
        }
    }   

    public void checkElementPresenceAndGetAttribute(WebElement element, String attribute){
        if(isDisplayed(element)){
            String attrValue = element.getAttribute(attribute);
            System.out.println("Element attribute value: " + attrValue);
        } else {
            System.out.println("Element is not visible");
        }
    }

    public void handleStaleElementReference(WebElement element){
        int attempts = 0;
        while(attempts < 2) {
            try {
                element.click();
                break;
            } catch(StaleElementReferenceException e) {
                System.out.println("StaleElementReferenceException caught, retrying...");
                attempts++;
            }
        }
    }   

    public void waitForElementWithCustomTimeout(WebElement element, int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementWithCustomPolling(WebElement element, int timeoutInSeconds, int pollingInSeconds){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofSeconds(pollingInSeconds))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickableWithCustomTimeout(WebElement element, int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeVisibleWithCustomTimeout(WebElement element, int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Consolidated scroll and interact methods
    public void scrollToElementAndClick(WebElement element){
        scrollToElement(element);
        element.click();
    }

    public void scrollToElementAndSendKeys(WebElement element, String text){
        scrollToElement(element);
        element.sendKeys(text);
    }

    public void scrollToElementAndGetText(WebElement element){
        scrollToElement(element);
        String text = element.getText();
        System.out.println("Element text: " + text);
    }

    public void scrollToElementAndGetAttribute(WebElement element, String attribute){
        scrollToElement(element);
        String attrValue = element.getAttribute(attribute);
        System.out.println("Element attribute value: " + attrValue);
    }
}