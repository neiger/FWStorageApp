package tests;

import general.MobileDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.FileUploadExplorerScreen;
import screens.StorageSampleLoggedScreen;
import screens.StorageSampleLoginScreen;

public class FileUploadExplorerScreenTests extends MobileDriverManager {

    private StorageSampleLoginScreen storageSampleLoginScreen;
    private StorageSampleLoggedScreen storageSampleLoggedScreen;
    private FileUploadExplorerScreen fileUploadExplorerScreen;

    @BeforeMethod  //Launch app and confirm that user is signed in
    public void setAuthSampleLoginScreen() {
        storageSampleLoginScreen = new StorageSampleLoginScreen(getDriver());
        assertTrue(storageSampleLoginScreen.verifyLoads(), basicErrorMsg("Unable to load the screen"));
        storageSampleLoggedScreen = storageSampleLoginScreen.signedUser();
        assertTrue(storageSampleLoggedScreen.verifyLoads(), basicErrorMsg("The logged in user was not loaded"));
        assertAll();
    }

    @Test
    public void FW_29_verifyThatAFileCanBeUploadedCorrectly() {
        fileUploadExplorerScreen = storageSampleLoggedScreen.fileUploadExplorerScreen();
        storageSampleLoggedScreen = fileUploadExplorerScreen.storageSampleLoggedScreen();
        assertTrue(storageSampleLoggedScreen.tapToUploadTheFile(), basicErrorMsg("Unable to tap to upload the file"));
        assertTrue(storageSampleLoggedScreen.deleteAFileFolder(), basicErrorMsg("Unable to delete the file"));
        assertAll();
    }

}
