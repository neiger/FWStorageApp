package screens;

import general.BaseScreen;
import general.ErrorsManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.checkerframework.checker.units.qual.A;
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
                && waitForMobElementToBeVisible(moreOptionsBtn);
    }

    /*
    UI Elements
     */

    @AndroidFindBy(className="android.widget.TextView")
    private List<WebElement> androidTextViewList;

    @AndroidFindBy(id="com.omh.android.storage.sample:id/sortByName")
    private WebElement sortLbl;

    // Ellipsis more button
    @AndroidFindBy(xpath="//android.widget.ImageView[@content-desc=\"More options\"]")
    private WebElement moreOptionsBtn;

    // Ellipsis options
    @AndroidFindBy(className="android.widget.ListView")
    private List<WebElement> listViewOptions;

    /*
     POPUP Create
     */
    @AndroidFindBy(id="com.omh.android.storage.sample:id/alertTitle")
    private WebElement alertTitle;

    @AndroidFindBy(id="android:id/button2")
    private WebElement cancelBtn;

    @AndroidFindBy(id="android:id/button1")
    private WebElement createBtn;

    /*
    POPUP fields to complete
     */
    @AndroidFindBy(id="com.omh.android.storage.sample:id/fileName")
    private WebElement fileNameTxtField;

    @AndroidFindBy(id="com.omh.android.storage.sample:id/fileType")
    private WebElement fileTypeDownArrow;

    @AndroidFindBy(className="android.widget.CheckedTextView")
    private List<WebElement> fileTypeCheckedTextView;

    /*
    Methods
     */

    public boolean listFilesInDrive() {
        return tapMobElement(moreOptionsBtn) && implicityWaitTimeOnScreenManual(2)
                && tapMobElement(listViewOptions.get(0)) && implicityWaitTimeOnScreenManual(2);
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

    /*
    AFTER LOGGED IN VALIDATIONS
     */

    public boolean verifySignInState() {
        System.out.println("The app is returned in Signed In state");
        return waitForMobElementToBeVisible(sortLbl) && waitForMobElementToBeVisible(moreOptionsBtn);
    }

    public boolean tapAndCreateAFolder() {
        try{
            tapMobElement(moreOptionsBtn);
            implicityWaitTimeOnScreenManual(1);
            tapOnScreenXY(675, 365);
            implicityWaitTimeOnScreenManual(1);

            writeASimpleNameOnField();
            tapMobElement(createBtn);
            implicityWaitTimeOnScreenManual(3);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void writeASimpleNameOnField() {
        sendTextOnEmptyMobElement(fileNameTxtField, "Automated File-Folder Created");
    }

    public boolean deleteAFileFolder() {
        return tapOnScreenXY(445,460);
    }

    public boolean tapAndCreateAFile() {
        try{
            tapMobElement(moreOptionsBtn);
            implicityWaitTimeOnScreenManual(1);
            tapOnScreenXY(675, 365);
            implicityWaitTimeOnScreenManual(1);
            writeASimpleNameOnField();
            tapMobElement(fileTypeDownArrow);
            tapMobElement(fileTypeCheckedTextView.get(2));
            tapMobElement(createBtn);
            implicityWaitTimeOnScreenManual(3);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
