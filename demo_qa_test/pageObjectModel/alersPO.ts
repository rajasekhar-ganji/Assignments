import { expect, Locator, Page } from "@playwright/test";
export class AlertPO {

    readonly page: Page;
    readonly alertsLocators: any;

    constructor(page: Page) {
        this.page = page;
        this.alertsLocators = {
            elementButton: "//h5[text()='Elements']",
            alertandframeswindowsButton: "//div[text()='Alerts, Frame & Windows']",
            alertsButton: "//span[text()='Alerts']",
            alertclickButton: "#alertButton",
            timerclickButton: "#timerAlertButton",
            confirmclickButton: "#confirmButton",
            promptclickButton: "#promtButton",
            promptResult:"#promptResult",
            confirmResult:"#confirmResult"
        }
    }
    async baseURL() {
        await this.page.goto('/');
    }


    async clickElement() {
        await (await this.page.waitForSelector(this.alertsLocators.elementButton)).waitForElementState('visible');
        await this.page.locator(this.alertsLocators.elementButton).click();
        await this.page.waitForLoadState('load');
        await expect(this.page).toHaveURL(/.*elements/);
    }

    async clickAlertsandFrames() {
        await (await this.page.waitForSelector(this.alertsLocators.alertandframeswindowsButton)).waitForElementState('visible');
        await this.page.locator(this.alertsLocators.alertandframeswindowsButton).click();
        await this.page.waitForLoadState('load');
        await expect(this.page).toHaveURL(/.*elements/);
    }

    async clickAlerts() {
        await (await this.page.waitForSelector(this.alertsLocators.alertsButton)).waitForElementState('visible');
        await this.page.locator(this.alertsLocators.alertsButton).click();
        await this.page.waitForLoadState('load');
        await expect(this.page).toHaveURL(/.*alerts/);
    }

    async clicknormalAlert() {
        this.page.once('dialog', dialog => {
            console.log(`Dialog message: ${dialog.message()}`);
            expect(dialog.message()).toEqual("You clicked a button");
            dialog.accept();
        });
        await this.page.locator(this.alertsLocators.alertclickButton).click();
    } 

    async clickOnTimerAlert() {
        await this.page.click(this.alertsLocators.timerclickButton);
        const alert = await this.page.waitForEvent("dialog");
        await this.page.waitForLoadState('load');
        await new Promise(resolve => setTimeout(resolve, 5000));
         expect(alert.message()).toEqual("This alert appeared after 5 seconds");
        await alert.dismiss();
    }

    async clickOnConfirmAlerts() {
        this.page.once("dialog", dailog => {
            console.log(`dailog message:${dailog.message()}`);
            dailog.accept();
        })
        await this.page.click(this.alertsLocators.confirmclickButton);
        const visibletextButton = await this.page.locator(this.alertsLocators.confirmResult).textContent();
        expect(visibletextButton).toBe('You selected Ok');
           console.log(visibletextButton);
        
    }

    async clickOnPromptAlert() {
        this.page.once('dialog', dialog => {
            console.log(`dialog message: ${dialog.message()}`);
            dialog.accept('Rajasekhar');

        });
        await this.page.click(this.alertsLocators.promptclickButton);
        const passingtext = await this.page.locator(this.alertsLocators.promptResult).textContent();
        expect(passingtext).toBe('You entered Rajasekhar');
        console.log(passingtext);

    }

}