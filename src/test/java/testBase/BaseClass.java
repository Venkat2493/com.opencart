package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;

	@Parameters({ "os", "browser" })
	@BeforeClass(groups = { "Sanity", "Regression", "Master", "datadriven" })
	public void setUp(String os, String br) throws IOException {

		// Loading config.properties file
		FileReader file = new FileReader(
				"C:\\Users\\venka\\eclipse-workspace\\com.opencart\\src\\test\\resources\\config.properties");
		p = new Properties();
		p.load(file);

		logger = LogManager.getLogger(this.getClass()); // Implemented "log4j2"

		// created the IF condition for execute the browser in remote level.
		if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {

			DesiredCapabilities capab = new DesiredCapabilities();

			// Operating System = OS
			if (os.equalsIgnoreCase("windows")) {
				capab.setPlatform(Platform.WIN10);

			} 
			else if (os.equalsIgnoreCase("mac")) {
				capab.setPlatform(Platform.MAC);
			} 
			else if (os.equalsIgnoreCase("linux")) {
				capab.setPlatform(Platform.LINUX);
			} 
			else {
				System.out.println("No Matching OS");
			}

			// browser
			switch (br.toLowerCase()) {

			case "chrome":
				capab.setBrowserName("chrome");
				break;
			case "edge":
				capab.setBrowserName("MicrosoftEdge");
				break;
			case "firefox":
				capab.setBrowserName("Firefox");
				break;

			default:
				System.out.println("Invalid browser name...");
				return;

			}

			driver = new RemoteWebDriver(new URL("http://192.168.0.106:4444/wd/hub"), capab);

		}

		if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (br.toLowerCase()) {

			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("Invalid browser name...");
				return;

			}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(p.getProperty("appURL")); // reading url from properties file.
		driver.manage().window().maximize();

	}

	@AfterClass(groups = { "Sanity", "Regression", "Master", "datadriven" })
	public void tearDown() {
		driver.quit();
	}

	// Random String & Number using Common-lang3 dependency and version should be
	// below 3.15
	public String randomString() {

		String generateAlphabetic = RandomStringUtils.randomAlphabetic(5);
		return generateAlphabetic;
	}

	public String randomNumber() {

		String generateNumber = RandomStringUtils.randomNumeric(5);
		return generateNumber;
	}

	public String randomAlphaNumeric() {

		String generateAlphabetic = RandomStringUtils.randomAlphabetic(5);
		String generateNumber = RandomStringUtils.randomNumeric(5);
		return (generateAlphabetic + generateNumber);
	}

	public String captureScreen(String tname) throws IOException {

		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		Date dt = new Date();
		String currentdatetimestamp = df.format(dt);

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + currentdatetimestamp
				+ ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;
	}
}
