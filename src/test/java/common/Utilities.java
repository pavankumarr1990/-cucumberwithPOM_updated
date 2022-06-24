//package common;
//
//import com.google.common.collect.Table;
//import common.SeleniumDriver;
//
//import org.apache.commons.lang3.StringUtils;
//import org.apache.poi.ss.usermodel.Sheet;
//
//import jxl.Cell;
//import jxl.Workbook;
//import jxl.WorkbookSettings;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.openqa.selenium.*;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.Reader;
//import java.text.SimpleDateFormat;
//import java.time.Duration;
//import java.util.*;
//
//
//import static common.SeleniumDriver.TIMEOUT;
//import static common.SeleniumDriver.getDriver;
//
//public class Utilities{
//
//    WebDriver driver;
//    public Utilities(WebDriver driver)
//    {
//       this.driver=getDriver();
//    }
//
//
//    JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//    public static Map<Object, Object> sharedData = new HashMap<Object, Object>();
//    public static Map<String, Object> data = new HashMap<>();
//    public int normalWaitTime = 120;
//
//
//    public int getColumnIndex(String columnName, By allColumnLocator) {
//        List<WebElement> allColumns = getDriver().findElements(allColumnLocator);
//        int index = 0;
//        for (WebElement column : allColumns) {
//            //                  String text = allColumns.get(index).getText();
//            try {
//                String text = column.getText();
//                if (text.contains(columnName)) {
//                    index++;
//                    return index;
//                }
//            } catch (Exception e) {
//                return 0;
//            }
//        }
//        return index;
//    }
//
////    public void waitUntilElementNotPresence(WebElement webElement, int timeOutInSeconds) {
////        webElement.waitForNotPresent(timeOutInSeconds*1000);
////
////    }
////
////    public void waitUntilElementPresence(WebElement webElement, int timeOutInSeconds) {
////        webElement.waitForPresent(timeOutInSeconds*1000);
////    }
//
//
//    public void waitUntilElementPresence(By locator, int timeOutInSeconds) {
//        new WebDriverWait(getDriver(), Duration.ofSeconds(timeOutInSeconds)).until(ExpectedConditions.presenceOfElementLocated(locator));
//        //getDriver().findElement(locator).waitForPresent(timeOutInSeconds*1000);
//    }
//
//    public void waitUntilElementPresence(String xpath, int timeOutInSeconds) {
//        By locator = By.xpath(xpath);
////           webElement.waitForPresent(timeOutInSeconds*1000);
//        new WebDriverWait(getDriver(), Duration.ofSeconds(timeOutInSeconds)).until(ExpectedConditions.presenceOfElementLocated(locator));
//    }
//
////    public void waitUntilElementVisible(WebElement webElement, int timeOutInSeconds) {
////        webElement.waitForVisible(timeOutInSeconds * 1000);
////    }
//
//
//    public void waitUntilElementVisible(By locator, int timeOutInSeconds) {
//        new WebDriverWait(getDriver(), Duration.ofSeconds(timeOutInSeconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
//        //getDriver().findElement(locator).waitForVisible(timeOutInSeconds*1000);
//    }
//
//    public void waitUntilElementVisible_iPad(By locator, int timeOutInSeconds) {
//        new WebDriverWait(getDriver(), Duration.ofSeconds(timeOutInSeconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
//        //getDriver().findElement(locator).waitForVisible(timeOutInSeconds*1000);
//    }
//
//    public void clickElement(WebElement webElement) throws InterruptedException {
//        webElement.wait(normalWaitTime * 1000);
//        if (!driverClick(webElement)) {
//            executor.executeScript("arguments[0].click();", webElement);
//        }
//    }
//
//    public void clickElement(By locator) {
//        waitUntilElementPresence(locator, normalWaitTime);
//        if (!driverClick(locator)) {
//            executor.executeScript("arguments[0].click();", getDriver().findElement(locator));
//        }
//    }
//
//    public Boolean driverClick(WebElement webElement) {
//
//        try {
//            webElement.click();
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public Boolean driverClick(By locator) {
//
//        try {
//            getDriver().findElement(locator).click();
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//
//    public boolean checkVisibility(WebElement webElement) {
//        try {
//            webElement.wait(2000);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public boolean checkVisibility(By locator) {
//        try {
//            new WebDriverWait(getDriver(), Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOfElementLocated(locator));
//            getDriver().findElement(locator).wait(6000);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public boolean checkVisibilityWithWait(WebElement webElement, int timeOutInSeconds) {
//        try {
//            webElement.wait(timeOutInSeconds * 1000);
//            webElement.wait();
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public boolean checkVisibilityWithWait(By locator, int timeOutInSeconds) {
//        try {
//            waitUntilElementVisible(locator, timeOutInSeconds);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public boolean checkVisibilityWithWait_iPad(By locator, int timeOutInSeconds) {
//        try {
//            waitUntilElementVisible_iPad(locator, timeOutInSeconds);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//
//    public boolean checkPresence(WebElement webElement) {
//        try {
//            webElement.wait(5000);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//
//    public boolean checkPresence(By locator) {
//        try {
//            new WebDriverWait(getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(locator));
//            //getDriver().findElement(locator).waitForPresent(2000);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    /**
//     * @param webElement
//     * @return
//     */
//    public String getTextValue(WebElement webElement) throws InterruptedException {
//
//        webElement.wait(normalWaitTime * 1000);
//
//        String text = webElement.getAttribute("value");
//        if (text != "" && text != null) {
//            return text;
//        }
//        text = webElement.getText();
//        if (text != "" && text != null) {
//            return text;
//        }
//        text = javaExGetValue(webElement);
//        if (text != "" && text != null) {
//            return text;
//        }
//        return null;
//    }
//
//    public String getTextValue(By locator) {
//
//        waitUntilElementPresence(locator, normalWaitTime);
//
//        String text = getDriver().findElement(locator).getAttribute("value");
//        if (text != "" && text != null) {
//            return text;
//        }
//        text = getDriver().findElement(locator).getText();
//        if (text != "" && text != null) {
//            return text;
//        }
//        text = javaExGetValue(locator);
//        if (text != "" && text != null) {
//            return text;
//        }
//        return null;
//    }
//
//
//    /**
//     * Method javaExGetValue is used to get the text value from an element using
//     * JavaScript
//     *
//     * @param webElement
//     * @return Returns the text from the specified object
//     */
//    public String javaExGetValue(WebElement webElement) {
//        String value = (String) executor.executeScript("return arguments[0].value", webElement);
//        return value;
//    }
//
//    public String javaExGetValue(By locator) {
//        String value = (String) executor.executeScript("return arguments[0].value", getDriver().findElement(locator));
//        return value;
//    }
//
//    public By getVisibleLocator(By locator) {
//
//        String locatorType = locator.toString().split(":\\s")[0].split("[.]")[1];
//        if (!(locatorType.equalsIgnoreCase("xpath"))) {
//            return locator;
//        }
//        //           String locatorType[] =locator.toString().split("://s");
//        String locatorString = locator.toString().split(":\\s")[1];
//        if (!(locatorString.charAt(0) == '(')) {
//            locatorString = "(" + locatorString + ")";
//        }
//
//
//        locatorString = locatorString + "[" + getVisibleElementIndex(locator) + "]";
//        switch (locatorType) {
//            case "xpath":
//                return By.xpath(locatorString);
//
//            case "id":
//                return By.id(locatorString);
//
//        }
//
//        return null;
//    }
//
//    /**
//     * @param controlLocator
//     * @return WebElement
//     */
//    public int getVisibleElementIndex(By controlLocator) {
//        List<WebElement> allElement;
//        int index = 1;
//        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(120));
//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(controlLocator));
//        allElement = getDriver().findElements(controlLocator);
//        for (WebElement eachElmt : allElement) {
//            WebElement WebElement = (WebElement) eachElmt;
//            if (checkVisibilityWithWait(WebElement, 1))
////                  if(eachElmt.isDisplayed())
//                return index;
//            index++;
//        }
//        return index;
//    }
//
//    public boolean checkDropDownEditable(WebElement webElement) {
//        if (!(checkVisibility(webElement))) {
//            return false;
//        }
//        try {
//            Select select = new Select(webElement);
//            List<WebElement> selectOptions = select.getOptions();
//            for (WebElement element : selectOptions) {
//                select.selectByVisibleText(element.getText());
//                Thread.sleep(2000);
//                if (!(select.getFirstSelectedOption().getText().equals(element.getText()))) {
//                    return false;
//                }
//            }
//        } catch (Exception e) {
//            return false;
//        }
//        return true;
//    }
//
//
//    public boolean checkDropDownEditable(By locator) {
//        if (!(checkVisibility(locator))) {
//            return false;
//        }
//        try {
//            Select select = new Select(getDriver().findElement(locator));
//            List<WebElement> selectOptions = select.getOptions();
//            for (WebElement element : selectOptions) {
//                select.selectByVisibleText(element.getText());
//                Thread.sleep(2000);
//                if (!(select.getFirstSelectedOption().getText().equals(element.getText()))) {
//                    return false;
//                }
//            }
//        } catch (Exception e) {
//            return false;
//        }
//        return true;
//    }
//
////    public boolean selectFromDropDown(By locator, String value) {
////        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(120));
////        try {
////            waitUntilElementPresence(locator, normalWaitTime);
////            waitUntilElementVisible(locator, normalWaitTime);
////            Select select = new Select(getDriver().findElement(locator));
////            select.selectByVisibleText(value);
////            ExpectedCondition<WebDriver, Boolean> dropDownContainsValue =
////                    new ExpectedCondition<WebDriver, Boolean>() {
////                        @Override
////                        public Boolean apply(WebDriver driver) {
////                            if (getSelectedDropDownValue(locator).equalsIgnoreCase(value))
////                                return true;
////                            else return false;
////                        }
////                    };
////            wait.until(dropDownContainsValue);
////            return true;
////        } catch (Exception e) {
////            return false;
////        }
////    }
//
//    /**
//     * Method getSelectedDropDownValue returns the first selected options from
//     * dropdown
//     *
//     * @param webElement
//     * @return String that corresponds to the selected value if no exception has
//     * occurred.<br>
//     * If Exception is thrown, returns null
//     */
//    public String getSelectedDropDownValue(WebElement webElement) {
//
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(120));
//        try {
//
//            waitUntilElementVisible((By) webElement, normalWaitTime);
//            Select select = new Select(webElement);
//            return select.getFirstSelectedOption().getText();
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public String getSelectedDropDownValue(By locator) {
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(120));
//        try {
//            waitUntilElementVisible(locator, normalWaitTime);
//            Select select = new Select(getDriver().findElement(locator));
//            return select.getFirstSelectedOption().getText();
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public String generateRandomName(String startString) {
//        return startString + new Random().nextInt(10000);
//    }
//
//
//    public boolean typeStrValue(WebElement webElement, String value) {
//        try {
//            waitUntilElementPresence((By) webElement, normalWaitTime);
//            webElement.clear();
//            Thread.sleep(200);
//            webElement.sendKeys(value);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public boolean typeStrValue(By locator, String value) {
//        try {
//            waitUntilElementPresence(locator, normalWaitTime);
//            getDriver().findElement(locator).clear();
//            Thread.sleep(200);
//            getDriver().findElement(locator).sendKeys(value);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//
//    /**
//     * Method to get the current date in MM/DD/YYYY format
//     *
//     * @return String representation of current date in MM/DD/YYYY
//     */
//    public String getCurrentDate() {
//        Calendar cal = Calendar.getInstance();
//        Date date = cal.getTime();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
//        return dateFormat.format(date).replace("-", "/");
//    }
//
////    @Override
////    protected void openPage(PageLocator pageLocator, Object... objects) {
////
////    }
//
//
//    public String addDaysToDate(String mmDDYYYY, int numberOfDays) throws Exception {
//        Calendar cal = Calendar.getInstance();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//        Date date = dateFormat.parse(mmDDYYYY);
//        cal.setTime(date);
//        cal.add(Calendar.DATE, numberOfDays);
//        date = cal.getTime();
//        return dateFormat.format(date);
//    }
//
//
//    /**
//     * Method to get the current date in MM/DD/YYYY format
//     *
//     * @return String representation of current date in MM/DD/YYYY
//     */
//    public String getCurrentDateFormat(String dateFormatStr) {
//        Calendar cal = Calendar.getInstance();
//        Date date = cal.getTime();
//        SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatStr);
//        return dateFormat.format(date);
//    }
//
//    /**
//     * Method to add days to a Date
//     **/
//
//    public String addDaysToDateFormat(String dateStr, int numberOfDays, String dateFormatStr) throws Exception {
//        Calendar cal = Calendar.getInstance();
//        SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatStr);
//        Date date = dateFormat.parse(dateStr);
//
//        cal.setTime(date);
//        cal.add(Calendar.DATE, numberOfDays);
//        date = cal.getTime();
//        return dateFormat.format(date);
//
//    }
//
//    public Boolean compareDateEqual(String dateOneStr, String dateTwoStr, String dateFormatStr) throws Exception {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormatStr);
//        Date dateOne = simpleDateFormat.parse(dateOneStr);
//        Date dateTwo = simpleDateFormat.parse(dateTwoStr);
//        return dateOne.equals(dateTwo);
//
//    }
//
//    public void switchToFrame(WebElement frameElement) {
//        new WebDriverWait(getDriver(), Duration.ofSeconds(120)).
//                until(ExpectedConditions.
//                        frameToBeAvailableAndSwitchToIt(frameElement));
//    }
//
//    public Boolean scrollToView(WebElement elementParam) {
//        try {
//            // JavaSript function to make the element visible by auto scrolling to the
//            // element
//            executor.executeScript("arguments[0].scrollIntoView(true);", (elementParam));
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public void scrollToUp() {
//        //JavascriptExecutor obj_JSE = getDriver();
//        // JavaSript function to make the element visible by auto scrolling to up
////                  obj_JSE.executeScript("scroll(0, -250);");
//        executor.executeScript("document.documentElement.scrollTop = 0;");
//
//    }
//
//    public void scrollToDown() {
//        //JavascriptExecutor obj_JSE = getDriver();
//        // JavaSript function to make the element visible by auto scrolling to up
////                  obj_JSE.executeScript("scroll(0, -250);");
//        executor.executeScript("document.documentElement.scrollTop=4000;");
//
//    }
//
//    public void clearField(WebElement element) {
//        Actions action = new Actions(getDriver());
//        action.moveToElement(element).click().sendKeys(Keys.HOME).keyDown(Keys.SHIFT).sendKeys(Keys.END)
//                .keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).build().perform();
//
//    }
//
//
//    public void clickOnElementWithWait(By object, long wait) throws InterruptedException {
//        getDriver().findElement(object).wait(wait);
//        getDriver().findElement(object).click();
//    }
//
//    public void clickOnElementWithWait(String object, int wait) throws InterruptedException {
//        getDriver().findElement(By.xpath(object)).wait(wait);
//        getDriver().findElement(By.xpath(object)).click();
//    }
//
//
//    public void writeJson(String key, String value) {
//
//        String folderSep = System.getProperty("file.separator");
//        String filePath = System.getProperty("user.dir") + folderSep + "src" + folderSep + "main" +
//                folderSep + "resources" + folderSep + "data" + folderSep + "testData.json";
//        try {
//            Reader reader = new FileReader(filePath);
//
//            JSONParser parser = new JSONParser();
//            JSONObject jsonObject = (JSONObject) parser.parse(reader);
//
//            reader.close();
//
//            jsonObject.put(key, value);
//
//            FileWriter jsonFile = new FileWriter(filePath);
//            jsonFile.write(jsonObject.toJSONString());
//            jsonFile.flush();
//            jsonFile.close();
//        } catch (Exception e) {
////            Validator.assertTrue(false,"Unable to write the data to the Json file:"+filePath,"");
//        }
//    }
//
//    Assert Validator;
//
//    public String readJson(String key) {
//
//        JSONParser parser = new JSONParser();
//        String folderSep = System.getProperty("file.separator");
//        String filePath = System.getProperty("user.dir") + folderSep + "src" + folderSep + "main" +
//                folderSep + "resources" + folderSep + "data" + folderSep + "testData.json";
//
//        try {
//            Reader reader = new FileReader(filePath);
//            JSONObject jsonObject = (JSONObject) parser.parse(reader);
//            reader.close();
//            return jsonObject.get(key).toString().trim();
//        } catch (Exception e) {
//            e.printStackTrace();
//            Validator.assertTrue(false, "Unable to read from JSON file" + filePath);
//        }
//        return "";
//    }
//
////    public void setDataExcel(String countryKey) {
////        data = null;
////        String[] sheetName;
////        Map<String, Object> tempMap;
////
////        String folderSep = System.getProperty("file.separator");
////        String filePath = System.getProperty("user.dir") + folderSep + "src" + folderSep + "main" +
////                folderSep + "resources" + folderSep + "data" + folderSep + "testData.xls";
////        sheetName = getSheetNames();
////        if (sheetName != null) {
////            for (String singleSheet : sheetName) {
////                tempMap = getTableDataAsMap(filePath, countryKey, singleSheet);
////                if (tempMap != null) {
////                    if (data == null)
////                        data = tempMap;
////                    else
////                        data.putAll(tempMap);
////                }
////            }
////        }
////
////    }
//
//    public String[] getSheetNames() {
//        String[] sheetName = null;
//        Workbook workbook = null;
//        String folderSep = System.getProperty("file.separator");
//        String filePath = System.getProperty("user.dir") + folderSep + "src" + folderSep + "main" +
//                folderSep + "resources" + folderSep + "data" + folderSep + "testData.xls";
//        try {
//            File f = new File(filePath);
//            if (f.exists() && f.canRead()) {
//                workbook = Workbook.getWorkbook(f);
//                sheetName = workbook.getSheetNames();
//
//            }
//            return sheetName;
//        } catch (Exception e) {
//            System.out.println("Opening Excel Data file is not successful");
//            return sheetName;
//        } finally {
//            if (workbook != null)
//                workbook.close();
//        }
//
//    }
////    public static Map<String, Object> getTableDataAsMap(String xlFilePath, String tableName, String sheetName) {
////        Workbook workbook = null;
////        Map<String, Object> map = null;
////        WorkbookSettings ws = new WorkbookSettings();
////        ws.setEncoding("Cp1252");
////
////        try {
////            File f = new File(xlFilePath);
////            if (f.exists() && f.canRead()) {
////                workbook = Workbook.getWorkbook(f, ws);
////                Sheet sheet = StringUtils.isNotBlank(sheetName) ? workbook.getSheet(sheetName) : workbook.getSheet(0);
////                if (sheet == null) {
////                    throw new RuntimeException("Worksheet " + sheetName + " not found in " + f.getAbsolutePath());
////                }
////
////                Table.Cell tableStart = sheet.findCell(tableName);
////                if (tableStart != null) {
////                    int startRow = tableStart.getRow();
////                    int startCol = tableStart.getColumn();
////                    Cell tableEnd = sheet.findCell(tableName, startCol + 1, startRow + 1, 100, 64000, false);
////                    if (tableEnd == null) {
////                        throw new RuntimeException("Table " + tableName + " for ending data range not found in sheet " + sheet.getName());
////                    }
////
////                    int endRow = tableEnd.getRow();
////                    int endCol = tableEnd.getColumn();
////                    String[] colNames = new String[endCol - startCol - 1];
////
////                    for (int i = startRow; i <= endRow; ++i) {
////                        int cj = 0;
////                        if (i == startRow) {
////                            for (int j = startCol + 1; j < endCol; ++cj) {
////                                colNames[cj] = sheet.getCell(j, i).getContents().trim();
////                                ++j;
////                            }
////                        } else {
////                            map = new HashMap<>();
////
////                            for (int j = startCol + 1; j < endCol; ++cj) {
////                                map.put(colNames[cj], StringUtil.toObject(sheet.getCell(j, i).getContents().trim()));
////                                ++j;
////                            }
////                        }
////                    }
////                }
////                return map;
////            }
////        } catch (Exception var27) {
////            throw new DataProviderException("Error while fetching data from " + xlFilePath, var27);
////        } finally {
////            try {
////                if (workbook != null)
////                    workbook.close();
////            } catch (Exception var26) {
////                System.out.println("Unable to close the Excel Workbook");
////            }
////            return map;
////        }
////    }
//
//}
