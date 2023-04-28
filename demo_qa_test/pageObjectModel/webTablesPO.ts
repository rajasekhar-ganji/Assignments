import { expect, Locator, Page } from "@playwright/test";
//import webtabledata from "../Utils/webTable.json"

export class WebTablePO {

    readonly page: Page;
    readonly webtableLocators: any;

    constructor(page: Page) {
        this.page = page;
        this.webtableLocators = {
            elementsTabbutton:"//h5[text()='Elements']",
            webtablebutton:"//span[text()='Web Tables']",
            addNewrecodBtton: "#addNewRecordButton",
            firstnameElement:"#firstName",
            lastNameElement:"#lastName",
            useremailElement:"#userEmail",
            userAgeElement:"#age",
            userSalaryElement:"#salary",
            userDepartmentElement:"#department",
            submitButton:"#submit",
            resultElement:"//*[@class='rt-tbody']",
            searchbox:"#searchBox",
            editButton:"//span[@title='Edit']",
            deleteButton:"//span[@title='Delete']"
        }
    }

    async baseURL() {
        await this.page.goto('/');
    }
    async clickElement() {
        await (await (this.page.waitForSelector(this.webtableLocators.elementsTabbutton))).waitForElementState('visible');
        await this.page.locator(this.webtableLocators.elementsTabbutton).click();
        await this.page.waitForLoadState('load');
        await expect(this.page).toHaveURL(/.*elements/);

    }
async webtableButton(){
    await (await (this.page.waitForSelector(this.webtableLocators.webtablebutton))).waitForElementState('visible');
    await this.page.locator(this.webtableLocators.webtablebutton).click();
    await this.page.waitForLoadState('load');
    await expect(this.page).toHaveURL(/.*webtables/);
}
async clickNewRecordButton(){
    const newbutton= await this.page.locator(this.webtableLocators.addNewrecodBtton).textContent();
    expect(newbutton).toBe('Add');
    await this.page.click(this.webtableLocators.addNewrecodBtton);

}
 
async passingWebtableData(firstName,lastName,email,age,salary,department)
{
await this.page.locator(this.webtableLocators.firstnameElement).fill(firstName);
await this.page.locator(this.webtableLocators.lastNameElement).fill(lastName);
await this.page.locator(this.webtableLocators.useremailElement).fill(email);
await this.page.locator(this.webtableLocators.userAgeElement).fill(age);
await this.page.locator(this.webtableLocators.userSalaryElement).fill(salary);
await this.page.locator(this.webtableLocators.userDepartmentElement).fill(department);
}
async clickSubmitButton(){
    await this.page.click(this.webtableLocators.submitButton)
    const result = await this.page.locator(this.webtableLocators.resultElement).textContent();
    console.log("data is enrolled successfully",result)
}

async clickSearchbox(searchdummyName)
{
    const button=await this.page.locator(this.webtableLocators.searchbox);
    await button.clear();
    await button.fill(searchdummyName);
    
}
async clickEditButtonModifyData(modifyName){
    await this.page.click(this.webtableLocators.editButton);
    await this.page.locator(this.webtableLocators.firstnameElement).clear();
    await this.page.locator(this.webtableLocators.firstnameElement).fill(modifyName);
    await this.page.click(this.webtableLocators.submitButton);
}
async clickDeleteButton(modifyNames){
    await this.page.locator(this.webtableLocators.searchbox).fill(modifyNames);
    await this.page.click(this.webtableLocators.deleteButton);

}
}