package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    public SignInPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h1")
    public WebElement heading1;

    @FindBy(css = "p[class='sds-page-section__title--sub signup-block']")
    public WebElement paragraphUnderSignIn;

    @FindBy(css = "input[name='user[email]']")
    public WebElement emailInputBox;

    @FindBy(css = "input[name='user[password]']")
    public WebElement passwordInputBox;

    @FindBy(css = ".sds-helper-text")
    public WebElement warningUnderPasswordInputBox;

    @FindBy(css = "div[class='password-help'] a")
    public WebElement linkForgotPasswordUnderPasswordInputBox;

    @FindBy(css = "div[class='sds-disclaimer ']")
    public WebElement privacyStatementAndTermsPolicy;

    @FindBy(xpath = "//div[@class='sds-field']/button")
    public WebElement signInButton;

    @FindBy(css = "h3[class='social-title sds-heading--3']")
    public WebElement headings;

    @FindBy(xpath = "//a[@href='/signin/fb_go/']")
    public WebElement linkSignInWithFacebook;

    @FindBy(css = "a[href='/signin/google_go/']")
    public WebElement linkSignInWithGoogle;

    @FindBy(xpath = "//a[@href='/signin/apple_go/']")
    public WebElement linkSignInWithApple;

    @FindBy(xpath = "//div[@class='sds-notification__content']")
    public WebElement errorMessage;
}
