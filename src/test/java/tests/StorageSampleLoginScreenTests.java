package tests;

import general.MobileDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.StorageSampleLoginScreen;

public class StorageSampleLoginScreenTests extends MobileDriverManager {

    private StorageSampleLoginScreen storageSampleLoginScreen;

    @BeforeMethod
    public void setAuthSampleLoginScreen() {
        storageSampleLoginScreen = new StorageSampleLoginScreen(getDriver());
        assertTrue(storageSampleLoginScreen.verifyLoads(), basicErrorMsg("Unable to load the screen"));
        assertAll();
    }

    @Test
    public void DemoTestCase() {
        System.out.println("This test has been executed successfully!");
    }
}
