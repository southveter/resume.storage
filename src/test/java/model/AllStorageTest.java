package model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ListStorageTest.class,
        MapStorageTest.class,
        ResumeStorageTest.class,
        SortedResumeStorageTest.class,
        MapResumeStorageTest.class
})
public class AllStorageTest {

}
