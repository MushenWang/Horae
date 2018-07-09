package me.mushen.horae.eunomia.manager;

import me.mushen.horae.eunomia.model.ClassLoadingM;
import me.mushen.horae.eunomia.model.MemoryM;
import me.mushen.horae.eunomia.model.RuntimeM;
import me.mushen.horae.eunomia.result.PojoResult;
import me.mushen.horae.eunomia.result.Result;
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
     * Show the runtime system of the Java virtual machine.
     * @return
     */
    public PojoResult<RuntimeM> showRuntime() {
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

    /**
     * Show the class loading system of the Java virtual machine.
     * @return
     */
    public PojoResult<ClassLoadingM> showClassLoading() {
        return new PojoResult<>(
                ClassLoadingM.builder()
                        .totalLoadedClassCount(classLoadingMXBean.getTotalLoadedClassCount())
                        .loadedClassCount(classLoadingMXBean.getLoadedClassCount())
                        .unloadedClassCount(classLoadingMXBean.getUnloadedClassCount())
                        .verbose(classLoadingMXBean.isVerbose())
                        .build()
        );
    }

    /**
     * Show the memory system of the Java virtual machine.
     * @return
     */
    public PojoResult<MemoryM> showMemory() {
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        MemoryUsage noHeapMemoryUsage = memoryMXBean.getNonHeapMemoryUsage();

        return new PojoResult<>(
                MemoryM.builder()
                        .objectPendingFinalizationCount(memoryMXBean.getObjectPendingFinalizationCount())
                        .heapMemoryInit(heapMemoryUsage.getInit())
                        .heapMemoryUsed(heapMemoryUsage.getUsed())
                        .heapMemoryCommitted(heapMemoryUsage.getCommitted())
                        .heapMemoryMax(heapMemoryUsage.getMax())
                        .noHeapMemoryInit(noHeapMemoryUsage.getInit())
                        .noHeapMemoryUsed(noHeapMemoryUsage.getUsed())
                        .noHeapMemoryCommitted(noHeapMemoryUsage.getCommitted())
                        .noHeapMemoryMax(noHeapMemoryUsage.getMax())
                        .verbose(memoryMXBean.isVerbose())
                        .build()
        );
    }

    /**
     * Enables or disables the verbose output for the class loading system.
     * @param verbose
     * @return
     */
    public Result updateClassLoadingVerbose(boolean verbose) {

        return updateVerbose(verbose, "ClassLoading");
    }

    /**
     * Enables or disables verbose output for the memory system.
     * @param verbose
     * @return
     */
    public Result updateMemoryVerbose(boolean verbose) {

        return updateVerbose(verbose, "Memory");
    }

    /**
     * Runs the garbage collector.
     * The call gc() is effectively equivalent to the call: System.gc()
     */
    public void gc() {
        memoryMXBean.gc();
    }



    private Result updateVerbose(boolean verbose, String systemName) {
        Result result = Results.success();
        try {
            switch (systemName) {
                case "ClassLoading":
                    classLoadingMXBean.setVerbose(verbose);
                    break;
                case "Memory":
                    memoryMXBean.setVerbose(verbose);
                    break;
                default:
                    // do nothing
            }
        } catch(SecurityException e) {
            result = Results.failure(e);
        }

        return result;
    }
}
