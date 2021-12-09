package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Testers {

    @Test()
    public void test01(){
        String name = "Lucas";
        Assert.assertEquals(name, "Lucas");
    }
}