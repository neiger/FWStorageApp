package tests;

import general.MobileDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.StorageSampleLoginScreen;
import screens.WebViewBrowserScreen;

public class StorageSampleLoginScreenTests extends MobileDriverManager {

    private StorageSampleLoginScreen storageSampleLoginScreen;
    private WebViewBrowserScreen webViewBrowserScreen;

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
    public void verifyThatUserIsReturnedToSampleAppInLoggedInState(String deviceType) {
        if(deviceType.equals("nonGMS")) {
            WebViewBrowserScreen webViewBrowserScreen = storageSampleLoginScreen.signInFromBrowser();
            assertTrue(webViewBrowserScreen.verifySignPageLoads(), basicErrorMsg("The signIn web view was not loaded correctly"));
            assertTrue(webViewBrowserScreen.clickLoggedInAccountXY(540,700), basicErrorMsg("Unable to click on the XY location given"));
            storageSampleLoginScreen = webViewBrowserScreen.returnAsSignInState(800,2025);
        } else {
            //assertTrue(storageSampleLoginScreen.verifySignInPopUpShown(), basicErrorMsg("Unable to shown the pop up account"));
        }
        assertTrue(storageSampleLoginScreen.verifySignInState(), basicErrorMsg("The signed in state fails the validation"));
        assertAll();
    }

}
