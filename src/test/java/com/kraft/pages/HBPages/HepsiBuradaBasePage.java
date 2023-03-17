package com.kraft.pages.HBPages;

import com.kraft.utilities.BrowserUtils;
import com.kraft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class HepsiBuradaBasePage {
    public HepsiBuradaBasePage() {
        PageFactory.initElements(Driver.get(), this);
    }


    //WebDriver driver=Driver.get();

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement cookiesAcceptBtn;

    public void clickCookies(){
        cookiesAcceptBtn.click();
    }

    public void navigateTabToModule(String tab,String module) {
        WebElement tabName = Driver.get().findElement(By.xpath("//*[text()='"+tab+"']"));

       BrowserUtils.hover(tabName);

        WebElement moduleName = Driver.get().findElement(By.xpath("//*[text()='"+module+"']"));
        moduleName.click();

    }

}
