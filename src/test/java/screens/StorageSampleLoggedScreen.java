package screens;

import general.BaseScreen;
import general.ErrorsManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StorageSampleLoggedScreen extends BaseScreen {
    public StorageSampleLoggedScreen(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Override
    public boolean verifyLoads() {
        return waitForMobElementToBeVisible(androidTextViewList.get(0)) && waitForMobElementToBeVisible(sortLbl)
                && waitForMobElementToBeVisible(gridOrLinearLayout) && waitForMobElementToBeVisible(createBtn);
    }

    /*
    UI Elements
     */

    @AndroidFindBy(className="android.widget.TextView")
    private List<WebElement> androidTextViewList;

    @AndroidFindBy(id="com.omh.android.storage.sample:id/sortByName")
    private WebElement sortLbl;

    @AndroidFindBy(id="com.omh.android.storage.sample:id/swapGridOrLinearLayoutManager")
    private WebElement gridOrLinearLayout;

    @AndroidFindBy(id="com.omh.android.storage.sample:id/createFileButton")
    private WebElement createBtn;

    @AndroidFindBy(className="android.view.ViewGroup")
    private List<WebElement> androidViewGroupList;

    /*
    Methods
     */

    public boolean listFilesInDrive() {
        return tapMobElement(gridOrLinearLayout) && implicityWaitTimeOnScreenManual(2);
    }

    public boolean navigateBackAndForthInsideAFolder(int getX, int getY) {
        return tapOnScreenXY(getX, getY) && implicityWaitTimeOnScreenManual(2) && getFolderText()
                && returnToMainDriveScreen() && implicityWaitTimeOnScreenManual(2);
    }

    private boolean returnToMainDriveScreen() {
        boolean flag = false;
        try {
            pressAndroidKey(AndroidKey.BACK);
            flag = true;
        } catch (Exception e) { ErrorsManager.errNExpManager(e);}
        return flag;
    }

    private boolean getFolderText() {
        boolean flag = false;
        try {
            System.out.println(getTextFromMobElement(androidTextViewList.get(1)));
            flag = true;
        } catch (Exception e) {ErrorsManager.errNExpManager(e);}
        return flag;
    }
}
