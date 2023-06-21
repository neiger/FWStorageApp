package screens;

import general.BaseScreen;
import general.ErrorsManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class StorageSampleLoginScreen extends BaseScreen {
    public StorageSampleLoginScreen(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Override
    public boolean verifyLoads() {
        return waitForMobElementToBeVisible(topActionBar);// && waitForMobElementToBeVisible(loginBtn);
    }

    /*
    UI ELEMENTS
     */

    // logged out elements
    @AndroidFindBy(id="com.omh.android.storage.sample:id/action_bar")
    private WebElement topActionBar;

    @AndroidFindBy(className="android.widget.TextView")
    private WebElement topActionBarTxt;

    @AndroidFindBy(id="com.omh.android.storage.sample:id/btn_login")
    private WebElement loginBtn;

    // Messages UI

    @AndroidFindBy(id="com.omh.android.storage.sample:id/alertTitle")
    private WebElement alertTitle;

    @AndroidFindBy(id="android:id/message")
    private WebElement alertMsg;



    /*
    METHODS
     */

    public boolean verifySignInBtnDisplayed() {
        getTextFromMobElement(loginBtn);
        return waitForMobElementToBeVisible(loginBtn);
    }

    private boolean tapOnLoginBtn() {
        boolean flag = false;
        flag = tapMobElement(loginBtn) && implicityWaitTimeOnScreenManual(1);
        return flag;
    }

    private boolean printAlertMsgs() {
        boolean flag = false;
        try {
            String text = getTextFromMobElement(alertTitle) + "\n" + getTextFromMobElement(alertMsg);
            System.out.println(" \n==================\n" + text + " \n==================\n");
            flag = true;
        } catch (Exception e) {
            ErrorsManager.errNExpManager(e);}
        return flag;
    }

    public boolean checkAlerMsgPrint() {
        return printAlertMsgs();
    }


    /*
   RETURN-REDIRECT PAGE CALLS
    */
    public WebViewBrowserScreen signInFromBrowser() {
        if(tapOnLoginBtn()) {
            return new WebViewBrowserScreen(this.driver);
        } else {return null;}
    }

    public StorageSampleLoggedScreen signedUser() {
        implicityWaitTimeOnScreenManual(3);
        return new StorageSampleLoggedScreen(this.driver);
    }


    /*
    AFTER SIGNED IN VALIDATIONS
     */

    public boolean verifySignInState() {
        System.out.println("The app is returned in Signed In state");
        return implicityWaitTimeOnScreenManual(3);/* &&
                waitForMobElementToBeVisible(loggedOutBtn) && waitForMobElementToBeVisible(refreshBtn) &&
                waitForMobElementToBeVisible(tvName) && waitForMobElementToBeVisible(tvEmail) &&
                waitForMobElementToBeVisible(tokenInfo);*/
    }

}