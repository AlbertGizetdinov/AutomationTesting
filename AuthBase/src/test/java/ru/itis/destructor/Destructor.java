package ru.itis.destructor;

import org.junit.Assert;
import ru.itis.ApplicationManager;

public class Destructor {
    public static Thread addDestructor(Runnable runnable) {
        Thread hook = new Thread(runnable);
        Runtime.getRuntime().addShutdownHook(hook);
        return hook;
    }

    public static boolean removeDestructor(Thread hook) {
        return Runtime.getRuntime().removeShutdownHook(hook);
    }

    public static Thread addManagerDestructor(ApplicationManager applicationManager) {
        return addDestructor(() -> {
            try {
                applicationManager.getDriver().quit();
            } catch (Exception ignored) {
            } finally {
                String verificationErrorString = applicationManager.getVerificationErrors().toString();
                if (!verificationErrorString.equals("")) {
                    Assert.fail(verificationErrorString);
                }
            }
        });
    }


}
