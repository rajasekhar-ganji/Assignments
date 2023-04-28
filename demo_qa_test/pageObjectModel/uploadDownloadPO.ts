import { expect, Locator, Page } from "@playwright/test";

export class uploadDownPO {

    readonly page: Page;
    readonly uploadDownloadLocators: any;

    constructor(page: Page) {
        this.page = page;
        this.uploadDownloadLocators = {
            elementsTabbutton:"//h5[text()='Elements']",
            uploadDownloadButton:"//span[text()='Upload and Download']",
            downloadButton:"#downloadButton",
            setInputElement:"input[type='file']",
            filePathElement:"#uploadedFilePath",
        }
    }
    async baseURL() {
        await this.page.goto('/');
    }
    async clickElement() {
        await (await (this.page.waitForSelector(this.uploadDownloadLocators.elementsTabbutton))).waitForElementState('visible');
        await this.page.locator(this.uploadDownloadLocators.elementsTabbutton).click();
        await this.page.waitForLoadState('load');
        await expect(this.page).toHaveURL(/.*elements/);
}
async clickuploadDownloadButton(){
    await (await (this.page.waitForSelector(this.uploadDownloadLocators.uploadDownloadButton))).waitForElementState('visible');
    await this.page.locator(this.uploadDownloadLocators.uploadDownloadButton).click();
    await this.page.waitForLoadState('load');
    await expect(this.page).toHaveURL(/.*upload-download/);
}
async verifyDownload(){
    const verifyVisible=await this.page.locator(this.uploadDownloadLocators.downloadButton);
 expect(await(verifyVisible.isVisible())).toBeTruthy();
   await verifyVisible.click();
}
async verifyUpload(){
    await this.page.setInputFiles(this.uploadDownloadLocators.setInputElement, 'support/sampleFile.jpeg')
let text= await this.page.locator(this.uploadDownloadLocators.filePathElement).textContent();
console.log('file is uploaded==>', text)
expect(text).toEqual(`C:\\fakepath\\sampleFile.jpeg`);

}



}