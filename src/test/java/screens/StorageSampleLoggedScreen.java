package screens;

import general.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class StorageSampleLoggedScreen extends BaseScreen {
    public StorageSampleLoggedScreen(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Override
    public boolean verifyLoads() {
        return waitForMobElementToBeVisible(lblTitle) && waitForMobElementToBeVisible(sortLbl)
                && waitForMobElementToBeVisible(gridOrLinearLayout) && waitForMobElementToBeVisible(createBtn);
    }

    /*
    UI Elements
     */

    @AndroidFindBy(className="android.widget.TextView")
    private WebElement lblTitle;

    @AndroidFindBy(id="com.omh.android.storage.sample:id/sortByName")
    private WebElement sortLbl;

    @AndroidFindBy(id="com.omh.android.storage.sample:id/swapGridOrLinearLayoutManager")
    private WebElement gridOrLinearLayout;

    @AndroidFindBy(id="com.omh.android.storage.sample:id/createFileButton")
    private WebElement createBtn;

    /*
    Methods
     */

    public boolean listFilesInDrive() {
        return tapMobElement(gridOrLinearLayout) && implicityWaitTimeOnScreenManual(2);
    }

}
