package steps;

import objects.Mail;
import org.openqa.selenium.WebDriver;
import driver.DriverSingleton;
import pages.*;

public class Steps {

    private WebDriver driver;

    public void initBrowser()
    {
        driver = DriverSingleton.getDriver();
    }

    public void closeDriver()
    {
        DriverSingleton.closeDriver();
    }

    public void loginMailRu(String username, String password)
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login(username, password);
    }

    public boolean isHomePageOpened(String mailAddress)
    {
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.homePageStatus(mailAddress);
    }


    public void createMail(Mail mail)
    {
        HomePage homePage = new HomePage(driver);
        homePage.writeMailButtonClick();
        homePage.fillAddresseeField(mail.getAddressee_mail_field());
        homePage.fillSubjectField(mail.getSubject());
        homePage.fillFrame(mail.getText_field());
    }


    public void sendMail(){
        DraftFolderPage draftManager = new DraftFolderPage(driver);
        draftManager.sendButtonClick();
    }

    public boolean verifySentFolder(String  addresseeMail, String  subject, String text){
        SentManager sentManager = new SentManager(driver);
        sentManager.openPage();
        sentManager.sentItemsClick();
        return sentManager.verifySentFolder(addresseeMail,subject,text);
    }

    public void checkInboxFolder(String  addresseeMail, String  subject){
        InboxFolder inboxFolder  = new InboxFolder(driver);
        inboxFolder.finderMail(addresseeMail, subject);


    }

    public void logOff(){
        HomePage homePage = new HomePage(driver);
        homePage.logOffLinkClick();
    }
}
