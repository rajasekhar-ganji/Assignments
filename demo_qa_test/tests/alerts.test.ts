import { test, Page, expect, Browser } from "@playwright/test";
import { AlertPO } from "../pageObjectModel/alersPO";
let page: Page;
let context: any;
let alertPo: AlertPO;
let browser: Browser;

test.beforeAll(async ({ browser }) => {

    context = await browser.newContext();
    page = await context.newPage();
    alertPo = new AlertPO(page);
});
test('alerts', async () => {
    await alertPo.baseURL();
    await alertPo.clickElement();
     await alertPo.clickAlertsandFrames();
     await alertPo.clickAlerts();
     await alertPo.clicknormalAlert();
     await alertPo.clickOnTimerAlert();
     await alertPo.clickOnConfirmAlerts();
 });
 
 test.afterAll(async ({browser}) => {
    
     await browser.close();
 });