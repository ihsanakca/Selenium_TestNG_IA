package com.kraft.pages;

import com.kraft.utilities.BrowserUtils;
import com.kraft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends BasePage{

    @FindBy(xpath = "//button[text()='Overview']")
    public WebElement overviewPageSubTitle;

    public void navigateUserProfileTabs(String tabName){
        WebElement profileTab = Driver.get().findElement(By.xpath("//li//button[text()='"+tabName+"']"));
        BrowserUtils.clickWithJS(profileTab);
    }

}
