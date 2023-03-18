package com.kraft.pages;

import com.kraft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddEducationPage extends BasePage{

    @FindBy(xpath = "//li//button[text()='Add Education']")
    public WebElement addEducationPageSubTitle;

  public void addEducation(String schoolName, String degree,String  study, String fromDate, String toDate,String programDescription){

      Actions actions=new Actions(Driver.get());
      WebElement school = Driver.get().findElement(By.id("school"));
      actions.click(school)
              .sendKeys(schoolName+ Keys.TAB)
              .sendKeys(degree+ Keys.TAB)
              .sendKeys(study+ Keys.TAB)
              .sendKeys(fromDate+ Keys.TAB)
              .sendKeys(toDate+ Keys.TAB)
              .sendKeys(programDescription+ Keys.TAB+Keys.ENTER).perform();

  }
}
