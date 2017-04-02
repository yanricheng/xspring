package com.wenjie;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlogPage {
    @FindBy(xpath = "//*[@id=\"Content\"]/p/a")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"SidebarContent\"]/a[1]")
    private WebElement searchButton1;

    @FindBy(xpath = "/html/body/div[1]/div/input")
    private WebElement searchInput;

    @FindBy(xpath = "/html/body/div[1]/div/ul/li[1]/article/a")
    private WebElement searchResultFirst;

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickSearchButton1() {
        searchButton1.click();
    }

    public void inputSearchWording(String wantedStr) {
        searchInput.sendKeys(wantedStr);
    }

    public void clickFirstResultOfSearch() {
        searchResultFirst.click();
    }
}
