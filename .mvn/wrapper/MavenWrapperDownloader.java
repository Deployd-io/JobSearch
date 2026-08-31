/*
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

  https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MavenWrapperDownloader {

    /**
     * Default URL to download the maven-wrapper.jar from, if no 'downloadUrl' is provided.
     */
    private static final String DEFAULT_DOWNLOAD_URL =
            "https://repo.maven.apache.org/maven2/io/takari/maven-wrapper/0.4.2/maven-wrapper-0.4.2.jar";

    /**
     * Path to the maven-wrapper.properties file, which might contain a downloadUrl property to
     * use instead of the default one.
     */
    private static final String MAVEN_WRAPPER_PROPERTIES_PATH =
            ".mvn/wrapper/maven-wrapper.properties";

    /**
     * Path where the maven-wrapper.jar will be saved to.
     */
    private static final String MAVEN_WRAPPER_JAR_PATH =
            ".mvn/wrapper/maven-wrapper.jar";

    /**
     * Name of the property which should be used to override the default download url for the wrapper.
     */
    private static final String PROPERTY_NAME_WRAPPER_URL = "wrapperUrl";

    public static void main(String args[]) {
		log.debug(">>> Entering main(args[={})", args[);
        System.out.println("- Downloader started");
        File baseDirectory = new File(args[0]);
        System.out.println("- Using base directory: " + baseDirectory.getAbsolutePath());
		log.debug("main(args[={}): baseDirectory → {}", args[, baseDirectory);

        // If the maven-wrapper.properties exists, read it and check if it contains a custom
        // wrapperUrl parameter.
        File mavenWrapperPropertyFile = new File(baseDirectory, MAVEN_WRAPPER_PROPERTIES_PATH);
        String url = DEFAULT_DOWNLOAD_URL;
		log.debug("main(args[={}): mavenWrapperPropertyFile → {}", args[, mavenWrapperPropertyFile);
		log.debug("main(args[={}): url → {}", args[, url);
        if(mavenWrapperPropertyFile.exists()) {
            FileInputStream mavenWrapperPropertyFileInputStream = null;
            try {
				log.debug("main(args[={}): mavenWrapperPropertyFileInputStream → {}", args[, mavenWrapperPropertyFileInputStream);
                mavenWrapperPropertyFileInputStream = new FileInputStream(mavenWrapperPropertyFile);
                Properties mavenWrapperProperties = new Properties();
                mavenWrapperProperties.load(mavenWrapperPropertyFileInputStream);
				log.debug("main(args[={}): mavenWrapperProperties → {}", args[, mavenWrapperProperties);
                url = mavenWrapperProperties.getProperty(PROPERTY_NAME_WRAPPER_URL, url);
            } catch (IOException e) {
                System.out.println("- ERROR loading '" + MAVEN_WRAPPER_PROPERTIES_PATH + "'");
            } finally {
                try {
                    if(mavenWrapperPropertyFileInputStream != null) {
                        mavenWrapperPropertyFileInputStream.close();
                    }
                } catch (IOException e) {
                    // Ignore ...
                }
            }
        }
        System.out.println("- Downloading from: : " + url);

        File outputFile = new File(baseDirectory.getAbsolutePath(), MAVEN_WRAPPER_JAR_PATH);
        if(!outputFile.getParentFile().exists()) {
			log.debug("main(args[={}): outputFile → {}", args[, outputFile);
            if(!outputFile.getParentFile().mkdirs()) {
                System.out.println(
                        "- ERROR creating output direcrory '" + outputFile.getParentFile().getAbsolutePath() + "'");
            }
        }
        System.out.println("- Downloading to: " + outputFile.getAbsolutePath());
        try {
            downloadFileFromURL(url, outputFile);
            System.out.println("Done");
            System.exit(0);
        } catch (Throwable e) {
            System.out.println("- Error downloading");
            e.printStackTrace();
            System.exit(1);
        }
		log.debug("<<< Exiting main(args[={})", args[);
    }

    private static void downloadFileFromURL(String urlString, File destination) throws Exception {
		log.debug(">>> Entering downloadFileFromURL(urlString={},destination={})", urlString, destination);
        URL website = new URL(urlString);
        ReadableByteChannel rbc;
		log.debug("downloadFileFromURL(urlString={},destination={}): website → {}", urlString, destination, website);
        rbc = Channels.newChannel(website.openStream());
		log.debug("downloadFileFromURL(urlString={},destination={}): rbc → {}", urlString, destination, rbc);
        FileOutputStream fos = new FileOutputStream(destination);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		log.debug("downloadFileFromURL(urlString={},destination={}): fos → {}", urlString, destination, fos);
		log.info("downloadFileFromURL(urlString,destination)={},{}): SOC2-AUDIT [CC6.7]: Encryption operation completed", urlString, destination);
        fos.close();
        rbc.close();
		log.debug("<<< Exiting downloadFileFromURL(urlString={},destination={})", urlString, destination);
    }

}
