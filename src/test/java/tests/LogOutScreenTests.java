package tests;

import general.MobileDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.StorageSampleLoggedScreen;
import screens.StorageSampleLoginScreen;
import screens.WebViewBrowserScreen;

public class LogOutScreenTests extends MobileDriverManager {

    private StorageSampleLoginScreen storageSampleLoginScreen;
    private WebViewBrowserScreen webViewBrowserScreen;
    private StorageSampleLoggedScreen storageSampleLoggedScreen;

    @BeforeMethod
    public void setAuthSampleLoginScreen() {
        storageSampleLoginScreen = new StorageSampleLoginScreen(getDriver());
        assertTrue(storageSampleLoginScreen.verifyLoads(), basicErrorMsg("Unable to load the screen"));
        storageSampleLoggedScreen = storageSampleLoginScreen.signedUser();
        assertTrue(storageSampleLoggedScreen.verifyLoads(), basicErrorMsg("The logged in user was not loaded"));
        assertAll();
    }

    @Test
    public void FW_101_verifyThatUserCanlogOutTheSession() {
        storageSampleLoginScreen = storageSampleLoggedScreen.signOutUserSession();
        System.out.println("The user session has been closed successfully");
        assertTrue(storageSampleLoginScreen.verifyLoads(), basicErrorMsg("Unable to load login screen"));
        assertAll();
    }
}
