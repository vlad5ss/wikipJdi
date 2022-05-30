DI Mobile Example
How to launch web tests on Android emulator
Stable environment: Java 8, Maven 3.6.3, JDI-Light 1.3.23, TestNG 6.14.3, Aspectj 1.9.*, Appium 1.20.2, Android 10

Launch Android emulator and wait until home screen is ready.
Launch Appium and find out the listening URL in the console (usually http://0.0.0.0:4723)
Set following settings in test/resources/test.properties file:
   driver=android 
   remote.type=appium
# should be URL form prev. step and remove leading # if any
   driver.remote.url=http://0.0.0.0:4724/wd/hub 
Set following settings in test/resources/android.properties file
# Section 'There we can find Device UID and name' and remove leading # if any
   deviceName={GET_UID_FROM_YOUR_ANDROID_VIRTUAL_DEVICE} 
More information about JDI-Light in Documentation

External tools installation (for novice)
Android emulator installation
The easiest way to use Android Emulator is via Android Studio, but it's also possible to install Android SDK only (https://developer.android.com/studio/releases/sdk-tools) We describe a way via Android Studio.

Download and install Android Studio (https://developer.android.com/studio). Note: in case of error with HAXM installation just ignore it.
Run Android Studio
Run AVD Manager (Configure -> AVD Manager) (or via Tools -> AVD Manager for an open project)
Create a virtual device with any available parameters (for example, Pixel_3a_API_30_x86)
Run virtual device via button in Actions column Virtual device run
Power up your device via Power button (is highlighted on a previous screen)
Open Chrome, confirm all agreements to get empty Chrome window with search field
Open About Chrome and find Chrome version (chromedriver and Chrome version should be equal, so copy it. Needed after Appium installation)
Ready Chrome
Ready!

Install Appium
Install Appium
For Windows usually we need to install npm (https://nodejs.org/en/) and run npm install -g appium
All information is on official site https://appium.io/docs/en/about-appium/getting-started/?lang=en
After installation make sure that you can run appium in terminal:
(for Windows) add appium directory to PATH environment variable. If you used 'npm install ...' command for installation appium will be in C:\Users\{USER_NAME}\AppData\Roaming\npm
(for Windows) if you see error message like 'File cannot be loaded because the execution of scripts is disabled on this system. Please see "get-help about_signing" for more details' open new PowerShell terminal 'as Administrator' and run this command Set-ExecutionPolicy -ExecutionPolicy Unrestricted
Download chromedriver for Chrome with version equal to Chrome version on your device (The number before the first '.' should be equal!). More information https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/web/chromedriver.md
Download correct version from https://chromedriver.chromium.org/downloads
Put it to npm modules. For Windows example path is: c:\Users\{USER_NAME}\AppData\Roaming\npm\node_modules\appium\node_modules\appium-chromedriver\chromedriver\win\
(For Windows) Several environment variables are needed to work with emulator (!Note Restart Appium after this step if it's running (Ctrl+C can be used to stop Appium)):
JAVA_HOME - path to JDK installation folder (NOT bin folder inside!). Example 'c:\Program Files\Java\jdk1.8.0_281'
ANDROID_HOME - path to Android SDK, can be found in Android Studio in Menu File -> Settings... -> Android SDK. Example c:\Users\{USER_NAME}\AppData\Local\Android\Sdk\
ANDROID_SDK_ROOT - the same value as ANDROID_HOME
ANDROID_TOOLS - ANDROID_HOME\tools
Android SDK
There we can find Device UID and name
Device name is visible in Android Virtual Device Manager in a list
UID is available in Extended controls (...) -> Help -> About Device UID and name
Run jdi-mobile-report-portal-demo tests
Launch the created virtual device
Run 'appium' in console
Open the tests project in IDEA. (Optional)
Run the following maven command
mvn test -Dreport.portal.user=<user_name> -Dreport.portal.password=<user_password> -Dmobile.device.udid=<your_emulator_id> -Dmobile.cl