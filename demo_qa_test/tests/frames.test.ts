import { test, Page, expect, Browser } from "@playwright/test";
import { FramePO } from "../pageObjectModel/framePO";
let page: Page;
let context: any;
let framePo: FramePO;
let browser: Browser;

test.beforeAll(async ({ browser }) => {

    context = await browser.newContext();
    page = await context.newPage();
    framePo = new FramePO(page);
});
test('frames', async () => {
   await framePo.baseURL();
   await framePo.clickframes_frame_window_Particularly_Frames();
    await framePo.operationInFrame1();
    await framePo.operationsInFrame2();
});

test.afterAll(async ({browser}) => {
    await browser.close();
});
