package tests;

import general.MobileDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.StorageSampleLoggedScreen;
import screens.StorageSampleLoginScreen;
import screens.WebViewBrowserScreen;

public class StorageSampleLoginScreenTests extends MobileDriverManager {

    private StorageSampleLoginScreen storageSampleLoginScreen;
    private WebViewBrowserScreen webViewBrowserScreen;
    private StorageSampleLoggedScreen storageSampleLoggedScreen;

    @BeforeMethod
    public void setAuthSampleLoginScreen() {
        storageSampleLoginScreen = new StorageSampleLoginScreen(getDriver());
        assertTrue(storageSampleLoginScreen.verifyLoads(), basicErrorMsg("Unable to load the screen"));
        assertAll();
    }

    @Test
    public void demoTestCase() {
        assertTrue(storageSampleLoginScreen.verifySignInBtnDisplayed(), basicErrorMsg("Unable to get the button info"));
        assertAll();
    }

    @Test @Parameters({"deviceType"})
    public void verifyThatUserCanTapXInBrowserOrTapOusideModal(String deviceType) {
        if(deviceType.equals("GMS")) {
            //assertTrue(storageSampleLoginScreen.tapOutsideModal(), basicErrorMsg("It can't be tapped outside"));
            System.err.println("This has not been implemented yet!");
        } else {
            webViewBrowserScreen = storageSampleLoginScreen.signInFromBrowser();
            assertTrue(webViewBrowserScreen.verifySignPageLoads(), basicErrorMsg("The signin web view was not loaded correctly"));
            assertTrue(webViewBrowserScreen.clickTheXOnBrowser(), basicErrorMsg("Unable to tap on the X close browser"));
            assertTrue(storageSampleLoginScreen.checkAlerMsgPrint(), basicErrorMsg("Alert message has not been triggered"));
        }
        assertAll();
    }


    @Test @Parameters({"deviceType"})
    public void verifyThatUserIsReturnedToSampleAppInLoggedInState(String deviceType) {
        if(deviceType.equals("nonGMS")) {
            webViewBrowserScreen = storageSampleLoginScreen.signInFromBrowser();
            assertTrue(webViewBrowserScreen.verifySignPageLoads(), basicErrorMsg("The signIn web view was not loaded correctly"));
            assertTrue(webViewBrowserScreen.clickLoggedInAccountXY(540,700), basicErrorMsg("Unable to click on the XY location given"));
            storageSampleLoginScreen = webViewBrowserScreen.returnAsSignInState(800,1920);
        } else {
            //assertTrue(storageSampleLoginScreen.verifySignInPopUpShown(), basicErrorMsg("Unable to shown the pop up account"));
            System.err.println("This has not been implemented yet!");
        }
        //assertTrue(storageSampleLoginScreen.verifySignInState(), basicErrorMsg("The signed in state fails the validation"));
        assertAll();
    }

    @Test
    public void verifyUserLogsInSuccessfullyInDrive() {
        storageSampleLoggedScreen = storageSampleLoginScreen.signedUser();
        assertTrue(storageSampleLoggedScreen.verifyLoads(), basicErrorMsg("The logged in user was not loaded"));
        assertTrue(storageSampleLoggedScreen.listFilesInDrive(), basicErrorMsg("The list of files has failed to be tapped"));
        assertAll();
    }
}
