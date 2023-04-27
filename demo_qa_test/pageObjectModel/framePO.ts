import { Browser, expect, Locator, Page } from '@playwright/test';
export class FramePO {
  readonly page: Page;
readonly alertframewindowbutton:string;
readonly framesbutton:string;
readonly frame1:string;
readonly headingtext:string;
readonly frame2:string;

  constructor(page: Page) {
    this.page = page;
    this.alertframewindowbutton = `//h5[text()='Alerts, Frame & Windows']`;
    this.framesbutton =`//span[text()='Frames']`;
    this.frame1 =`#frame1`;
    this.headingtext = `#sampleHeading`;
    this.frame2 =`#frame2`;
}
async baseURL() {
    await this.page.goto('/');
}
async clickframes_frame_window_Particularly_Frames(){
    await this.page.click(this.alertframewindowbutton);
    await this.page.click(this.framesbutton);
}
async operationInFrame1(){
const frameone= this.page.frameLocator(this.frame1);
let frameonetitle=frameone.locator(this.headingtext);
expect(await frameonetitle.textContent()).toBe('This is a sample page');  
console.log(await frameonetitle.textContent());
}
async operationsInFrame2(){
const frametwo=this.page.frameLocator(this.frame2);
let frametwotitle=frametwo.locator(this.headingtext);
expect(await frametwotitle.textContent()).toBe('This is a sample page');  
console.log(await frametwotitle.textContent());
}
}