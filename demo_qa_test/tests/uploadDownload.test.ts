import { test, Page, expect, Browser } from "@playwright/test";
import { uploadDownPO} from "../pageObjectModel/uploadDownloadPO";
let page: Page;
let context: any;
let uploadPo: uploadDownPO;
let browser: Browser;

test.beforeAll(async ({ browser }) => {

   // context = await browser.newContext();
    page = await browser.newPage();
    uploadPo = new uploadDownPO(page);
});

test('uploadDownload', async () => {
   await uploadPo.baseURL();
   await uploadPo.clickElement();
    await uploadPo.clickuploadDownloadButton();
    await uploadPo.verifyDownload();
    await uploadPo.verifyUpload();
});

test.afterAll(async ({browser}) => {
    await browser.close();
});
