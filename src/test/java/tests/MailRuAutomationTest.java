package tests;

import objects.Mail;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.Steps;

public class MailRuAutomationTest {

    private Steps steps;
    private final String USERNAME = "leskovskaya_test";
    private final String PASSWORD = "test123";
    private final String MAIL_ADDRESS = "leskovskaya_test@mail.ru";
    private final String ADDRESSEE_MAIL_FIELD = "test@test.ru";
    private final String SUBJECT_FIELD = "test";
    private final String TEXT_FIELD = "Text";



    @BeforeClass (description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }

    // Login to the mail box, assert, that the login is successful.
    @Test
    public void isLoginSuccessful()
    {
        Mail mail = new Mail();
        steps.loginMailRu(USERNAME, PASSWORD);
        steps.createMail(mail);
        steps.sendMail();
        Assert.assertTrue(steps.isHomePageOpened(MAIL_ADDRESS), "Home page was not open");
    }

    @AfterClass(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }
}
