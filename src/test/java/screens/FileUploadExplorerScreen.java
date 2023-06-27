package screens;

import general.BaseScreen;
import general.ErrorsManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class FileUploadExplorerScreen extends BaseScreen {

    public FileUploadExplorerScreen(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);    }

    @Override
    public boolean verifyLoads() { return false; }

    /*
   It might be possible to validate the view but can trigger errors
   1. Locate a file by XY coordinates and tap on it
   2. Wait then redirect the driver to the StorageSampleLoggedScreen
     */

    private boolean selectAFileToUploadFromFileExplorer() {
        return tapOnScreenXY(450, 1080);
    }

    public StorageSampleLoggedScreen storageSampleLoggedScreen() {
        try {
            selectAFileToUploadFromFileExplorer();
            return new StorageSampleLoggedScreen(this.driver);
        } catch (Exception e) {
            ErrorsManager.errNExpManager(e);
            return null;
        }
    }

}
