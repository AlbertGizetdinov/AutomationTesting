package ru.itis.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.basic.TestBase;

public class B_DeleteLineTest extends TestBase {

    @Test
    public void deleteLineTest() throws InterruptedException {
        int before = applicationManager.getReaderHelper().count();
        int index = (int) Math.floor(Math.random() * before);
        System.out.println(++index);
        applicationManager.getWriterHelper().delete(index);
        Thread.sleep(2000);
        Assert.assertEquals(before - 1, applicationManager.getReaderHelper().count());
    }
}
