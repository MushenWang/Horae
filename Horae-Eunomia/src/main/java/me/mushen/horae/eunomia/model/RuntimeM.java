package me.mushen.horae.eunomia.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * @Desc
 * @Author Mushen
 * @Create 2018-07-08
 */
@Getter
@Builder
@ToString
public class RuntimeM {
    // the name representing the running Java virtual machine
    private String jvmName;
    // start time of the Java virtual machine in milliseconds
    private long startTimestamp;
    // uptime of the Java virtual machine in milliseconds
    private long uptime;
    // the version of the specification for the management interface implemented by the running Java virtual machine
    private String managementSpecVersion;

    /* ********** java.lang.SecurityException: SecurityManager.checkPropertiesAccess() ********** */
    // the Java virtual machine specification name: System.getProperty("java.vm.specification.name")
    private String specName;
    // the Java virtual machine specification vendor: System.getProperty("java.vm.specification.vendor")
    private String specVendor;
    // the Java virtual machine specification version: System.getProperty("java.vm.specification.version")
    private String specVersion;

    // the Java virtual machine implementation name: System.getProperty("java.vm.name")
    private String vmName;
    // the Java virtual machine implementation vendor: System.getProperty("java.vm.vendor")
    private String vmVendor;
    // the Java virtual machine implementation version: System.getProperty("java.vm.version")
    private String vmVersion;

    // a list of String objects, each element is an argument passed to the Java virtual machine
    private List<String> arguments;
    // the Java class path: System.getProperty("java.class.path")
    private String classPath;
    // the boot class path
    // the Java virtual machine supports the boot class path mechanism used by the bootstrap class loader to search for class files
    private String bootClassPath;
    // the Java library path: System.getProperty("java.library.path")
    private String libraryPath;
}
