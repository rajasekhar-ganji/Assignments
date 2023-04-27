import { test, Page, expect, Browser } from "@playwright/test";
import { WindowPO } from "../pageObjectModel/browserWindowsPO";
let page: Page;
let context: any;
let windowPo: WindowPO;
let browser: Browser;

test.beforeAll(async ({ browser }) => {

    context = await browser.newContext();
    page = await context.newPage();
    windowPo = new WindowPO(page);
});
test('alerts', async () => {
   await windowPo.baseURL();
   await windowPo.clickAlertsbrowserswindows_Windows();
    await windowPo.newTabOperations();
    await windowPo.windowButtonOperation();
    await windowPo.newwindowmsgOperation();
});
 
test.afterAll(async ({browser}) => {
   await browser.close();
});