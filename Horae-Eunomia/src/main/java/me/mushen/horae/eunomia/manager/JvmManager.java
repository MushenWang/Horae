package me.mushen.horae.eunomia.manager;

import me.mushen.horae.eunomia.model.RuntimeM;
import me.mushen.horae.eunomia.result.PojoResult;
import me.mushen.horae.eunomia.result.Results;

import java.lang.management.*;
import java.util.List;

/**
 * @Desc
 * @Author Mushen
 * @Create 2018-07-08
 */
public class JvmManager {
    // runtime system of the Java virtual machine
    private final RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
    // class loading system of the Java virtual machine
    private final ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
    // memory system of the Java virtual machine
    private final MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
    // compilation system of the Java virtual machine
    private final CompilationMXBean compilationMXBean = ManagementFactory.getCompilationMXBean();
    // the thread system of the Java virtual machine
    private final ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
    // a list of GarbageCollectorMXBean in the Java virtual machine
    private final List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
    // a list of MemoryManagerMXBean in the Java virtual machine
    private final List<MemoryManagerMXBean> memoryManagerMXBeans = ManagementFactory.getMemoryManagerMXBeans();
    // operating system on which the Java virtual machine is running
    private final OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();


    /**
     * show Java virtual machine Runtime Properties.
     * @return
     */
    public PojoResult<RuntimeM> showRuntimeM() {
        try {
            RuntimeM.RuntimeMBuilder builder =
                    RuntimeM.builder()
                            .jvmName(runtimeMXBean.getName())
                            .startTimestamp(runtimeMXBean.getStartTime())
                            .uptime(runtimeMXBean.getUptime())
                            .managementSpecVersion(runtimeMXBean.getManagementSpecVersion())
                            .specName(runtimeMXBean.getSpecName())
                            .specVendor(runtimeMXBean.getSpecVendor())
                            .specVersion(runtimeMXBean.getSpecVersion())
                            .vmName(runtimeMXBean.getVmName())
                            .vmVendor(runtimeMXBean.getVmVendor())
                            .vmVendor(runtimeMXBean.getVmVersion())
                            .arguments(runtimeMXBean.getInputArguments())
                            .libraryPath(runtimeMXBean.getLibraryPath())
                            .classPath(runtimeMXBean.getClassPath())
                            .bootClassPath(
                                    runtimeMXBean.isBootClassPathSupported()
                                            ? runtimeMXBean.getBootClassPath()
                                            : "the Java virtual machine don't supports the boot class path mechanism"
                            );

            return new PojoResult<>(builder.build());
        } catch(SecurityException e) {
            return new PojoResult<>(Results.failure(e));
        }
    }
}
