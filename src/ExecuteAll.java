import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class ExecuteAll {

    //All test classes can be run through this class.
    //But currently you can run one by one as the url is launched for every class
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(
                com.example.tests.Registration.class,
                com.example.tests.Login.class
                );

        for (Failure failure : result.getFailures()) {
            System.out.println("Test Case Failed: "+failure.toString());
        }
//Out put test analysis. I.E number of tests executed,
// what failed, ignored and the cumulative outcome f the tests
        System.out.println("TestCases: "+result.getRunCount());
        System.out.println("Failed: "+result.getFailureCount());
        System.out.println("Ignored: "+result.getIgnoreCount());
        System.out.println("Success: "+result.wasSuccessful());
    }
}