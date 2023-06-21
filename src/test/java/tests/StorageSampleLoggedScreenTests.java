package tests;

import general.MobileDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.StorageSampleLoggedScreen;
import screens.StorageSampleLoginScreen;

public class StorageSampleLoggedScreenTests extends MobileDriverManager {

    private StorageSampleLoginScreen storageSampleLoginScreen;
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
    public void verifyUserCanChangeGridOrLinearLayoutViewInDrive() {
        assertTrue(storageSampleLoggedScreen.listFilesInDrive(), basicErrorMsg("The list of files has failed to be tapped"));
        assertAll();
    }

    @Test
    public void verifyUserCanNavigateBetweenFolders() {
        assertTrue(storageSampleLoggedScreen.navigateBackAndForthInsideAFolder(270, 585), basicErrorMsg("Unable to navigate between folders"));
        assertAll();
    }
}