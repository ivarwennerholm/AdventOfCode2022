package Day3_1;

import Day3_2.RucksackContent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RucksackContentTest {

    RucksackContent test = new RucksackContent();

    @Test
    public void readFileToListTest() {
        test.readFileToListInit();
        String expectedValue1 = "fzmmmfwDWFzlQQqjCQjDGnqq";
        String expectedValue2 = "tJHJvLJVVttNsvTtTvgHHSVwCsQRQQZCZZMqQMQBnqBMQs";
        String expectedValue3 = "LgThNJhNSgTJVgvgtghPhbpfWzfbwfPmpprb";
        String expectedValue4 = "lDLnSnLZRjmWrlhrFF";
        String expectedValue5 = "PffQJNqJbPZbpmjrrCVNFmCh";
        String expectedValue6 = "qzbcbqfMfZMTfQTqqzzTPPLMHgBBBtHRStvgHRDBnSRL";
        String actualValue1 = test.getGroupOfThreeList().get(0).getElf1().getRucksack().getContents();
        String actualValue2 = test.getGroupOfThreeList().get(0).getElf2().getRucksack().getContents();
        String actualValue3 = test.getGroupOfThreeList().get(0).getElf3().getRucksack().getContents();
        String actualValue4 = test.getGroupOfThreeList().get(1).getElf1().getRucksack().getContents();
        String actualValue5 = test.getGroupOfThreeList().get(1).getElf2().getRucksack().getContents();
        String actualValue6 = test.getGroupOfThreeList().get(1).getElf3().getRucksack().getContents();
        Assertions.assertEquals(expectedValue1, actualValue1);
        Assertions.assertEquals(expectedValue2, actualValue2);
        Assertions.assertEquals(expectedValue3, actualValue3);
        Assertions.assertEquals(expectedValue4, actualValue4);
        Assertions.assertEquals(expectedValue5, actualValue5);
        Assertions.assertEquals(expectedValue6, actualValue6);
    }
}
