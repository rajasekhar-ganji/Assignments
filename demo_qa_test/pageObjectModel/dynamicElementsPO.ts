import { expect, Locator, Page } from "@playwright/test";
export class DynamicElementsPO {
    readonly page: Page;
    readonly dynamicElementsLocators: any;

    constructor(page: Page) {
        this.page = page;
        this.dynamicElementsLocators = {
            elementButton: "//h5[text()='Elements']",
            dynamicElementButton: "//span[text()='Dynamic Properties']",
            enableCheckButton: "#enableAfter",
            visibleCheckButton: "#visibleAfter",
            colourChangeButton:"#colorChange"
        }
    }
    async baseURL() {
        await this.page.goto('/');
    }
    async clickElement() {
        await (await this.page.waitForSelector(this.dynamicElementsLocators.elementButton)).waitForElementState('visible');
        await this.page.locator(this.dynamicElementsLocators.elementButton).click();
        await this.page.waitForLoadState('load');
        await expect(this.page).toHaveURL(/.*elements/);
    }
    async clickDynamicElements() {
        await (await this.page.waitForSelector(this.dynamicElementsLocators.dynamicElementButton)).waitForElementState('visible');
        await this.page.locator(this.dynamicElementsLocators.dynamicElementButton).click();
        await this.page.waitForLoadState('load');
        await expect(this.page).toHaveURL(/.*dynamic-properties/);
    }
async verifyButtonIsEnabled(){
    const notenabble=await this.page.locator(this.dynamicElementsLocators.enableCheckButton).isDisabled();
    expect(notenabble).toBeTruthy();
    console.log("the button is not enabled");
}
async verifyButtonIsVisibled(){
    const notvisible= await this.page.locator(this.dynamicElementsLocators.visibleCheckButton).isHidden();
expect(notvisible).toBeTruthy();
console.log("the button is not visibled");
}
async verifyAftercolourChange(){
    const colourElement = await this.page.$(this.dynamicElementsLocators.colourChangeButton);
const beforecolour = await colourElement?.evaluate((e1)=>getComputedStyle(e1).color);
console.log(beforecolour);
await new Promise(resolve => setTimeout(resolve, 6000));
const colourElementafter = await this.page.$(this.dynamicElementsLocators.colourChangeButton);
const updatecolour = await colourElementafter?.evaluate((e1)=>getComputedStyle(e1).color);
console.log(updatecolour);
console.log(beforecolour)
await expect(updatecolour).not.toEqual(beforecolour);
console.log("The colour changed now ");
}


async verifyAfter5seconsButtonIsEnabled(){
    const notenabble=await this.page.locator(this.dynamicElementsLocators.enableCheckButton).isEnabled();
    expect(notenabble).toBeTruthy();
    console.log("the button is enabled");
}
async verifyAfter5seconsButtonIsVisibled(){
    const notvisible= await this.page.locator(this.dynamicElementsLocators.visibleCheckButton).isVisible();
expect(notvisible).toBeTruthy();
console.log("the button is visibled");
}
}