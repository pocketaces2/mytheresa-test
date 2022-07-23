package com.tom.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MyAccountLoginPage {

  private final Page page;

  private final Locator emailAddressField;
  private final Locator passwordField;
  private final Locator accountLoginButton;


  public MyAccountLoginPage(Page page){
    this.page = page;
    this.emailAddressField = page.locator("[id=\"login-form\"]  [id=\"email\"]");
    this.passwordField = page.locator("[id=\"login-form\"]  [id=\"pass\"]");;
    this.accountLoginButton = page.locator("#qa-login-button  button");
  }

  public void enterAccountLoginDetails(String username, String password){
    emailAddressField.fill(username);
    passwordField.fill(password);
  }

  public void clickAccountLoginButton(){
    accountLoginButton.click();
  }


}
