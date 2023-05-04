import { Browser, expect, Locator, Page } from '@playwright/test';
export class RadioPO {
readonly page: Page;
readonly elementButton:string;
readonly radiobutton:string;
readonly yesbutton:string;
readonly impressradio:string;
readonly nobutton:string;
readonly resultStatus;
readonly visibleYes:string;
readonly visibleImpressive:string;
readonly nobuttonstatus:string
  constructor(page: Page) {
    this.page = page;
    this.elementButton="//h5[text()='Elements']",
    this.radiobutton ="//span[text()='Radio Button']";
    this.yesbutton ="input#yesRadio";
    this.impressradio ="#impressiveRadio" ;
    this.nobutton ="#noRadio";
    this.resultStatus="//p[@class='mt-3']";
    this.visibleYes="//label[text()='Yes']";
    this.visibleImpressive="//label[text()='Impressive']";
    this.nobuttonstatus="//label[@for='noRadio']";
}

async baseURL() {
    await this.page.goto('/');
}

async clickElement() {
    await (await this.page.waitForSelector(this.elementButton)).waitForElementState('visible');
    await this.page.locator(this.elementButton).click();
    await this.page.waitForLoadState();
    await expect(this.page).toHaveURL(/.*elements/);
}
async clickradioButton() {
    await (await this.page.waitForSelector(this.radiobutton)).waitForElementState('visible');
    await this.page.locator(this.radiobutton).click();
    await this.page.waitForLoadState("load");
   await expect(this.page).toHaveURL(/.*radio-button/);
   
}
async clickYesButton(){
const buttonstatus=await this.page.locator(this.visibleYes).textContent();
expect(buttonstatus).toBe('Yes');
await this.page.waitForLoadState('networkidle')
await this.page.locator(this.yesbutton).click({force:true});
console.log(await this.page.locator(this.resultStatus).textContent());
await this.page.waitForLoadState('networkidle')
//await new Promise(() => { });

}

async clickimpressiveButton(){
    const buttonstatus=await this.page.locator(this.visibleImpressive).textContent();
    expect(buttonstatus).toBe('Impressive');
    await this.page.waitForLoadState('networkidle')
    await this.page.locator(this.impressradio).click({force:true});
    console.log(await this.page.locator(this.resultStatus).textContent());
    }
    async verifydiableButton(){
        const buttonstatus=await this.page.locator(this.nobuttonstatus).textContent();
        expect(buttonstatus).toBe('No');
        await this.page.waitForLoadState('networkidle');
        const isDisable=await this.page.locator(this.nobutton).isDisabled()
        console.log(buttonstatus);
        expect(isDisable).toBeTruthy();
        }

}