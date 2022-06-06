package scripts;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class CarsTest extends Base{

    /*
    Test Case 1: Validate Cars.com Sign in page form
    Given user navigates to “https://www.cars.com/”
    When user clicks on top right “Sign In” link
    Then user should be navigated to “Sign in” page
    And user should be able to see heading1 as "Sign in"
    And user should be able to see paragraph under “Sign in” header as “New to Cars.com? Sign up. Are you a dealer?”
    And user should be able to see Email input box with “Email” label and enabled
    And user should be able to see Password input box with “Password” label and enabled
    And user should be able to see warning under Password input box as “Minimum of eight characters”
    And user should be able to a link as “Forgot password?” under the Password input box
    And user should be able see “By signing in to your profile, you agree to our  Privacy Statement  and  Terms of Service.” Text
    And user should be able to “Sign in” button with its text and be displayed and enabled
     */

    @Test(priority = 1, description = "TC1")
    public void testSignIn() {
        driver.get("https://www.cars.com/");
        // When user clicks on top right “Sign In” link
        homePage.signInLink.click();

        // And user should be able to see Email input box with “Email” label and enabled
        // And user should be able to see Password input box with “Password” label and enabled
        // And user should be able to “Sign in” button with its text and be displayed and enabled
        Assert.assertTrue(signInPage.emailInputBox.isDisplayed() && signInPage.emailInputBox.isEnabled());
        Assert.assertTrue(signInPage.passwordInputBox.isDisplayed() && signInPage.passwordInputBox.isEnabled());
        Assert.assertTrue(signInPage.signInButton.isDisplayed() && signInPage.signInButton.isEnabled() && signInPage.signInButton.getText().equals("Sign in"));
    }

    @Test(priority = 2, description = "TC1")
    public void testSignInText() {
        driver.get("https://www.cars.com/");
        // When user clicks on top right “Sign In” link
        homePage.signInLink.click();

        // And user should be able to see heading1 as "Sign in"
        // And user should be able to see paragraph under “Sign in” header as “New to Cars.com? Sign up. Are you a dealer?”
        Assert.assertTrue(signInPage.heading1.isDisplayed() && signInPage.heading1.getText().equals("Sign in"));
        Assert.assertTrue(signInPage.paragraphUnderSignIn.isDisplayed() && signInPage.paragraphUnderSignIn.getText().equals("New to Cars.com? Sign up. Are you a dealer?"));

        // And user should be able to see warning under Password input box as “Minimum of eight characters”
        // And user should be able to a link as “Forgot password?” under the Password input box
        Assert.assertTrue(signInPage.warningUnderPasswordInputBox.isDisplayed() && signInPage.warningUnderPasswordInputBox.getText().equals("Minimum of eight characters"));
        Assert.assertTrue(signInPage.linkForgotPasswordUnderPasswordInputBox.isDisplayed() && signInPage.linkForgotPasswordUnderPasswordInputBox.getText().equals("Forgot password?"));

        // And user should be able to see “By signing in to your profile, you agree to our  Privacy Statement  and  Terms of Service.” Text
        Assert.assertTrue(signInPage.privacyStatementAndTermsPolicy.isDisplayed() && signInPage.privacyStatementAndTermsPolicy.getText().equals("By signing in to your profile, you agree to our  Privacy Statement  and  Terms of Service."));

    }
        /*
        Test Case 2: Validate Cars.com Sign in page social media section
        Given user navigates to “https://www.cars.com/”
        When user clicks on top right “Sign In” link
        Then user should be navigated to “Sign in” page
        And user should be able to see headings as "Connect with social"
        And user should be able to “Sign in with Facebook” link with its text and be displayed and enabled
        And user should be able to “Sign in with Google” link with its text and be displayed and enabled
        And user should be able to “Sign in with Apple” link with its text and be displayed and enabled
         */

        @Test(priority = 3, description = "TC2")
        public void testConnectWithSocial(){
            driver.get("https://www.cars.com/");
            // When user clicks on top right “Sign In” link
            homePage.signInLink.click();

            // And user should be able to see headings as "Connect with social"
            Assert.assertTrue(signInPage.headings.isDisplayed() && signInPage.headings.getText().equals("Connect with social"));

            // And user should be able to “Sign in with Facebook” link with its text and be displayed and enabled
            // And user should be able to “Sign in with Google” link with its text and be displayed and enabled
            // And user should be able to “Sign in with Apple” link with its text and be displayed and enabled
            Assert.assertTrue(signInPage.linkSignInWithFacebook.isDisplayed() && signInPage.linkSignInWithFacebook.isEnabled() &&
                    signInPage.linkSignInWithFacebook.getText().equals("Sign in with Facebook"));

            Assert.assertTrue(signInPage.linkSignInWithGoogle.isDisplayed() && signInPage.linkSignInWithGoogle.isEnabled() &&
                    signInPage.linkSignInWithGoogle.getText().equals("Sign in with Google"));

            Assert.assertTrue(signInPage.linkSignInWithApple.isDisplayed() && signInPage.linkSignInWithApple.isEnabled() &&
                    signInPage.linkSignInWithApple.getText().equals("Sign in with Apple"));
        }

        /*
        Test Case 3: Validate user cannot sign in to Cars.com with invalid credentials
        Given user navigates to “https://www.cars.com/”
        When user clicks on top right “Sign In” link
        Then user should be navigated to “Sign in” page
        When user enters johndoe@gmail.com to the Email input box
        And user enters abcd1234 to the Password input box
        And user clicks on the “Sign in” button
        Then user should not be logged in and displayed an error message on the top of the form as below
        “We were unable to sign you in.
        Your email or password was not recognized. Try again soon.”
         */

    @Test(priority = 4, description = "TC3")
    public void testSignInNegative() {
        driver.get("https://www.cars.com/");
        // When user clicks on top right “Sign In” link
        homePage.signInLink.click();

        signInPage.emailInputBox.sendKeys("johndoe@gmail.com" + Keys.RETURN);
        signInPage.passwordInputBox.sendKeys("abcd123" + Keys.RETURN);
        signInPage.signInButton.click();
        Assert.assertTrue(signInPage.errorMessage.isDisplayed() && signInPage.errorMessage.getText().equals("We were unable to sign you in.\n"+
                "Your email or password was not recognized. Try again soon."));
    }
}
