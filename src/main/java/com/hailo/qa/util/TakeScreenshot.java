package com.hailo.qa.util;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hailo.qa.base.TestBase;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

@Listeners(CustomListner.class)
public class TakeScreenshot extends TestBase {

	@BeforeMethod
	public void setUp() {
		initialization();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void TakeScreenshotNow() {
		Assert.assertEquals(false, true);
	}
}
