package Tests;

import Utils.CSVReader;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class ReadFileTests {


    @Test
    public void shouldRunOnlyTestsMarkedWithY() {
        CSVReader readCSV = new CSVReader();
        readCSV.checkConditionOfExecuteColumn();

        assertThat(readCSV.getTestIDs(), containsString("TC_003"));
        assertThat(readCSV.getTestIDs(), containsString("TC_001"));
        assertThat(readCSV.getTestIDs(), containsString("TC_004"));

    }
}
