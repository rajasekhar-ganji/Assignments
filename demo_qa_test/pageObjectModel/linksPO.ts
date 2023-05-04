import { expect, Locator, Page } from "@playwright/test";
export class LinksPO {

    readonly page: Page;
    readonly linksLocators: any;

    constructor(page: Page) {
        this.page = page;
        this.linksLocators = {
            elementButton: "//h5[text()='Elements']",
            linksButton: "//span[text()='Links']",
            simplelink: "#simpleLink",
            dynamiclink: "#dynamicLink",
            checkvisible1:"div#app>header>a>img",
            checkvisible2:"div#app>header>a>img",
            createlink:"#created",
            linkresponse:"#linkResponse",
            nocontent:"#no-content",
            moved:"#moved",
           badrequest: "#bad-request",
           unauthorized:"#unauthorized",
           forbiden:"#forbidden",
           invalidurl:"#invalid-url"
        }
    }
    async baseURL() {
        await this.page.goto('/');
    }

    async clickElement() {
        await (await this.page.waitForSelector(this.linksLocators.elementButton)).waitForElementState('visible');
        await this.page.locator(this.linksLocators.elementButton).click();
        await this.page.waitForLoadState('networkidle');
        await expect(this.page).toHaveURL(/.*elements/);
    }
    async clicklinks() {
        await (await this.page.waitForSelector(this.linksLocators.linksButton)).waitForElementState('visible');
        await this.page.locator(this.linksLocators.linksButton).click();
        await this.page.waitForLoadState('networkidle');
        await expect(this.page).toHaveURL(/.*links/);
    }
async clicksimplelink(){
    await this.page.click (this.linksLocators.simplelink);
const visible=await this.page.locator(this.linksLocators.checkvisible1).isVisible();
await this.page.waitForLoadState('networkidle')
await expect(visible).toBeTruthy();
}
async clickdynamiclink(){
    await this.page.click (this.linksLocators.dynamiclink);
const visible1=await this.page.locator(this.linksLocators.checkvisible2).isVisible();
await expect(visible1).toBeTruthy();
}
async clickOnCreatedLink(){
    await this.page.locator(this.linksLocators.createlink).click();
let link=await this.page.locator(this.linksLocators.linkresponse).textContent();
console.log('link is clicked successfully and response is==', link);
await expect(link).toBe("Link has responded with staus 201 and status text Created");
}

async clickOnNoContentLink(){
    await this.page.locator(this.linksLocators.nocontent).click();
    await new Promise(resolve => setTimeout(resolve, 5000));
const link=await this.page.locator(this.linksLocators.linkresponse).textContent();
console.log('link is clicked successfully and response is==', link);
await expect(link).toBe("Link has responded with staus 204 and status text No Content");
}
async clickonMovedLink(){
await this.page.click(this.linksLocators.moved);
await new Promise(resolve => setTimeout(resolve, 5000));
const link=await this.page.locator(this.linksLocators.linkresponse).textContent();
console.log('link is clicked successfully and response is==', link);
expect(link).toBe("Link has responded with staus 301 and status text Moved Permanently");
}
async clickonBadRequestLink(){
    await this.page.click(this.linksLocators.badrequest);
    await new Promise(resolve => setTimeout(resolve, 5000));
    const link=await this.page.locator(this.linksLocators.linkresponse).textContent();
    console.log('link is clicked successfully and response is==', link);
expect(link).toBe("Link has responded with staus 400 and status text Bad Request");
 }
 async clickonUnAutherizedLink(){
    await this.page.click(this.linksLocators.unauthorized);
    await new Promise(resolve => setTimeout(resolve, 5000));
    const link=await this.page.locator(this.linksLocators.linkresponse).textContent();
    console.log('link is clicked successfully and response is==', link);
 expect(link).toBe("Link has responded with staus 401 and status text Unauthorized");
}
async clickonForbiddenLink(){
    await this.page.click(this.linksLocators.forbiden);
    await new Promise(resolve => setTimeout(resolve, 5000));
    const link=await this.page.locator(this.linksLocators.linkresponse).textContent();
    console.log('link is clicked successfully and response is==', link);
expect(link).toBe("Link has responded with staus 403 and status text Forbidden");
}
async clickonInvalidUrlLink(){
   const check= await this.page.locator(this.linksLocators.invalidurl).click();
   await new Promise(resolve => setTimeout(resolve, 5000));
    const link=await this.page.locator(this.linksLocators.linkresponse).textContent();
    console.log('link is clicked successfully and response is==', link);
expect(link).toBe("Link has responded with staus 404 and status text Not Found");
}
}
