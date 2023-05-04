import { expect, Locator, Page } from "@playwright/test";
export class ButtonsPO {

    readonly page: Page;
    readonly buttonsLocators: any;

    constructor(page: Page) {
        this.page = page;
        this.buttonsLocators = {
            elementButton: "//h5[text()='Elements']",
            buttonselement:"//span[text()='Buttons']",
            doubleclick:"#doubleClickBtn",
            doubleclickmessage:"#doubleClickMessage",
            rightclick:"#rightClickBtn",
            rightclickmessgae:"#rightClickMessage",
            click:"//button[text()='Click Me']",
            clickmessage:"#dynamicClickMessage"
        }
    }
    async baseURL() {
        await this.page.goto('/');
    }

    async clickElement() {
        await (await this.page.waitForSelector(this.buttonsLocators.elementButton)).waitForElementState('visible');
        await this.page.locator(this.buttonsLocators.elementButton).click();
        await this.page.waitForLoadState();
        await expect(this.page).toHaveURL(/.*elements/);
    }
    async clickButtons() {
        await (await this.page.waitForSelector(this.buttonsLocators.buttonselement)).waitForElementState('visible');
        await this.page.locator(this.buttonsLocators.buttonselement).click();
        await this.page.waitForLoadState("load");
        await expect(this.page).toHaveURL(/.*buttons/);
    }
    async clickOnDoubleclick(){
        await this.page.dblclick(this.buttonsLocators.doubleclick);
        await this.page.waitForLoadState('load')
        const doublelink=await this.page.locator(this.buttonsLocators.doubleclickmessage).textContent();
    console.log("double link clicked and display message is=",doublelink);
        await expect(doublelink).toBe("You have done a double click");
    }
        async clickOnRightClick(){
        await this.page.click(this.buttonsLocators.rightclick,{ button: 'right' });
        await this.page.waitForLoadState('load')
        const rightclick=await this.page.locator(this.buttonsLocators.rightclickmessgae).textContent();
       console.log("double link clicked and display message is=",rightclick);
        await expect(rightclick).toBe("You have done a right click");
}
async clickOnClick(){
    await this.page.click(this.buttonsLocators.click);
    await this.page.waitForLoadState('load')
    const click=await this.page.locator(this.buttonsLocators.clickmessage).textContent();
 console.log("double link clicked and display message is=",click);
    await expect(click).toBe("You have done a dynamic click");

}

    }
