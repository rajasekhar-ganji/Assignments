import { test, Page, expect, Browser } from "@playwright/test";
import { TextBoxPO } from "../pageObjectModel/textboxPO";
import constants from "../Utils/constants.json";
let page: Page;
let context: any;
let textboxpo: TextBoxPO;
let browser: Browser;

test.beforeAll(async ({ browser }) => {

    context = await browser.newContext();
    page = await context.newPage();
    textboxpo = new TextBoxPO(page);
});
test('test_box', async () => {
    await textboxpo.baseurllink();
    await textboxpo.fillText(constants.TestData.FullName,constants.TestData.Email,constants.TestData.CurrentAdress,constants.TestData.PermenantAddress);
    await textboxpo.submitButton();
});

test.afterAll(async ({browser}) => {
    await browser.close();
});