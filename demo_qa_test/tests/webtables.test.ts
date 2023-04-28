import { test, Page, expect, Browser } from "@playwright/test";
import { WebTablePO } from "../pageObjectModel/webTablesPO";
import Webtabletexts from "../Utils/webTable.json";
let page: Page;
let context: any;
let webtablePo: WebTablePO;
let browser: Browser;

test.beforeAll(async ({ browser }) => {

    //context = await browser.newContext();
    page = await browser.newPage();
    webtablePo = new WebTablePO(page);
});
test('webtable', async () => {
    await webtablePo.baseURL();
    await webtablePo.clickElement();
    await webtablePo.webtableButton();
    await webtablePo.clickNewRecordButton();
    await webtablePo.passingWebtableData(Webtabletexts.WebTableData.FirstName,Webtabletexts.WebTableData.LastName,Webtabletexts.WebTableData.Email,Webtabletexts.WebTableData.Age,Webtabletexts.WebTableData.Salary,Webtabletexts.WebTableData.department);
    await webtablePo.clickSubmitButton()
    await webtablePo.clickSearchbox(Webtabletexts.WebTableData.searchDummyName);
    await webtablePo.clickEditButtonModifyData(Webtabletexts.WebTableData.modifyname);
    await webtablePo.clickDeleteButton(Webtabletexts.WebTableData.modifyname);
});
test.afterAll(async ({browser}) => {
    await browser.close();
});