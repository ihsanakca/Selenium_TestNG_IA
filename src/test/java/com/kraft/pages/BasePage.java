package com.kraft.pages;

import com.kraft.utilities.BrowserUtils;
import com.kraft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

   @FindBy(css = "nav>ul>li")
   public List<WebElement> tabNames;

    public void navigateTabAndModule(String tabName, String moduleName){
        WebElement tab = Driver.get().findElement(By.xpath("//span[text()='"+tabName+"']"));
        tab.click();
        WebElement module = Driver.get().findElement(By.xpath("//span[text()='" + moduleName + "']"));
        BrowserUtils.clickWithJS(module);
    }

    public void navigateTab(String tabName){
        WebElement tab = Driver.get().findElement(By.xpath("//span[text()='"+tabName+"']"));
        tab.click();
    }
}
