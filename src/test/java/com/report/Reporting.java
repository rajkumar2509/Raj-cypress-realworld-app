package com.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.base.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting extends BaseClass{
	public static void generateJvmReport(String jsonFile) throws FileNotFoundException, IOException {
		File file = new File(getProjectPath()+getPropertyFilevalue("jvmPath"));

		Configuration configuration = new Configuration(file, "Cypress Real Wolrd App");

		configuration.addClassifications("Browser Name", "Chrome");
		configuration.addClassifications("Browser Version", "114.0.5735.90");
		configuration.addClassifications("OS", "Windows 11");
		configuration.addClassifications("Assessment", "01");

		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);
		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
		builder.generateReports();
	}
}
