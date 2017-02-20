package org.liveproject.com.SeleniumAutomation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class IPNPropertyResolver {

	// To Do - Current design of the IPNSite using the Single IPN Site object

	private static IPNPropertyResolver ipnPropertyResolver;

	private Properties properties = new Properties();

	private IPNPropertyResolver() {

		try {

			properties.load(new FileInputStream("resources/ipnproperties.properties"));

		} catch (FileNotFoundException e) {

			throw new RuntimeException("Unable to load IPN properties", e);

		} catch (IOException e) {

			throw new RuntimeException("Unable to load IPN properties", e);

		}

	}

	// Do not not worried about Thread synchronization.

	public static IPNPropertyResolver getInstnace() {



		if (ipnPropertyResolver == null) {

			synchronized (IPNPropertyResolver.class) {

				if (ipnPropertyResolver == null) {

					ipnPropertyResolver = new IPNPropertyResolver();

				}

			}

		}


		return ipnPropertyResolver;

	}
}
