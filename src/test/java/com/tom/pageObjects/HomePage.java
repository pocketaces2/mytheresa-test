package com.tom.pageObjects;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

  private final Locator myAccountLink;
  private final Locator departmentHRefLinks;

  public HomePage(Page page) {
    super(page);
    myAccountLink = page.locator("id=myaccount");
    departmentHRefLinks = page.locator("[class=\"meta-list-department\"] [href]");
  }

  public List<String> getDepartmentHyperLinks(){

    List<ElementHandle> pageElementHandles = departmentHRefLinks.elementHandles();
    List<String> pageHyperLinks = new ArrayList<>();

    for (ElementHandle elementHandle : pageElementHandles){
      pageHyperLinks.add(elementHandle.getAttribute("href"));
    }

    return pageHyperLinks;
  }

  public MyAccountLoginPage clickMyAccountPageLinkExpectingLoginCredentials() {
    myAccountLink.click();
    return new MyAccountLoginPage(page);
  }

  public MyAccountLoginPage clickMyAccountPageLinkAsLoggedInUser() {
    myAccountLink.click();
    return new MyAccountLoginPage(page);
  }

}
