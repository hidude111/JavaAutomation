package Utils.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager{
    public static final ExtentReports extentReports = new ExtentReports();

    //Use synchronized for thread safety, we can ensure that the test will finish first, then we run this method
    //This is generatating the template for the Extent Reports...
    public synchronized static ExtentReports createExtentReports(){
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
        reporter.config().setReportName("ParaSoft Login Tests");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Author", "Timmy Nguyen");
        return extentReports;
    }

}