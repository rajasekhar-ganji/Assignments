import { Browser, expect, Locator, Page } from '@playwright/test';
export class WindowPO {
  readonly page: Page;
readonly windowsLocators:any

constructor(page: Page) {
    this.page = page;
    this.windowsLocators = {
        elementButton: "//h5[text()='Elements']",
        alertandframeswindowsButton: "//div[text()='Alerts, Frame & Windows']",
        browsersButton: "//span[text()='Browser Windows']",
        newtabButton: "#tabButton",
        sampleHeading: "#sampleHeading",
        newwindowButton   : "#windowButton",
        newmessageButton: "#messageWindowButton"
    }
}
async baseURL() {
    await this.page.goto('/');
}
async clickAlertsbrowserswindows_Windows(){
    await this.page.click(this.windowsLocators.elementButton)
    await this.page.click(this.windowsLocators.alertandframeswindowsButton);
    await this.page.click(this.windowsLocators.browsersButton);

}
async newTabOperations(){
    await this.page.locator(this.windowsLocators.newtabButton).click();
    const tabone =await this.page.waitForEvent('popup')
    await this.page.waitForLoadState('load');
    const tabwindow=await tabone;
    await tabwindow.bringToFront();
    let tabverificationone=await tabwindow.locator(this.windowsLocators.sampleHeading).textContent();
    console.log(tabverificationone);
    expect(tabverificationone).toBe(`This is a sample page`);
    await tabwindow.close();
}
async windowButtonOperation(){
    await this.page.locator(this.windowsLocators.newwindowButton).click();
    const tabtwo=await this.page.waitForEvent('popup');
    await this.page.waitForLoadState('load');
    const tabwindowtwo=await tabtwo;
     await tabwindowtwo.bringToFront();
     let tabverification=await tabwindowtwo.locator(this.windowsLocators.sampleHeading).textContent();
     console.log(tabverification);
     expect(tabverification).toBe(`This is a sample page`);
     await tabwindowtwo.close();
}
async newwindowmsgOperation(){
    const newWindowMsg = this.page.waitForEvent('popup');
    await this.page.locator(this.windowsLocators.newmessageButton).click();
    const windowMsg = await newWindowMsg;
    await windowMsg.bringToFront();
    await this.page.waitForTimeout(3000)
    console.log("test successfull");
    windowMsg.close();
}
}