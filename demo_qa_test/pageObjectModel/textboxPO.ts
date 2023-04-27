import { Browser, expect, Locator, Page } from '@playwright/test';
export class TextBoxPO {
  readonly page: Page;
  inputUsername:string
  currentAddress:string
  userEmail:string
  submit_Button:string
  permanentAddress:string
  constructor(page: Page) {
    this.page = page;
    this.inputUsername = `input#userName`;
    this.userEmail =`input#userEmail`;
    this.currentAddress =`textarea#currentAddress`;
    this.permanentAddress = `textarea#permanentAddress`;
    this.submit_Button =`button#submit`;

  
  }
  async baseurllink() {
    await this.page.goto('/text-box');
    await this.page.waitForLoadState('load')
  }

  async fillText(fullname,email,address,permAddress) {
    await this.page.locator(this.inputUsername).type(fullname);
    await this.page.locator(this.userEmail).type(email);
    await this.page.locator(this.currentAddress).type(address);
    await this.page.locator(this.permanentAddress).type(permAddress);
  }
  async submitButton() {
    await this.page.locator(this.submit_Button).click();
  }
  
}

