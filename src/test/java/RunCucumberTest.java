import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "USE_CASES", // مكان ملفات .feature
    glue = "acceptance",                // مكان ملفات الخطوات
    plugin = {"pretty", "html:target/cucumber-report.html"}, // لإخراج النتائج
    monochrome = true
)
public class RunCucumberTest {

}
