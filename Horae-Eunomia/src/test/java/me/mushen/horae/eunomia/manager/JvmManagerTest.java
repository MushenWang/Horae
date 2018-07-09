package me.mushen.horae.eunomia.manager;

import org.junit.Test;

/**
 * @Desc
 * @Author Mushen
 * @Create 2018-07-09
 */
public class JvmManagerTest {

    private JvmManager jvmManager = new JvmManager();

    @Test
    public void testShow() {
        System.out.println("Runtime System");
        System.out.println(
                jvmManager.showRuntime()
        );

        System.out.println("ClassLoading System");
        System.out.println(
                jvmManager.showClassLoading()
        );

        System.out.println("Memory System");
        System.out.println(
                jvmManager.showMemory()
        );

        System.out.println("Compilation System");
        System.out.println(
                jvmManager.showCompilation()
        );
    }
}
