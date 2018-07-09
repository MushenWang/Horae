package me.mushen.horae.eunomia.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @Desc
 * @Author Mushen
 * @Create 2018-07-08
 */
@Getter
@Builder
@ToString
public class ClassLoadingM {
    // the total number of classes loaded
    private long totalLoadedClassCount;
    // the number of currently loaded classes
    private int loadedClassCount;
    // the total number of unloaded classes
    private long unloadedClassCount;
    // true: if the verbose output for the class loading system is enabled
    private boolean verbose;
}
