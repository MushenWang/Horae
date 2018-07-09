package me.mushen.horae.eunomia.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @Desc
 * @Author Mushen
 * @Create 2018-07-09
 */
@Getter
@Builder
@ToString
public class MemoryM {
    // the approximate number objects for which finalization is pending.
    private int objectPendingFinalizationCount;

    /* *************** representing the heap memory usage *************** */
    // the initial amount of memory in bytes that the Java virtual machine allocates, -1(undefined)
    private long heapMemoryInit;
    // the amount of used memory in bytes
    private long heapMemoryUsed;
    // the amount of committed memory in bytes
    private long heapMemoryCommitted;
    // the maximum amount of memory in bytes that can be used, -1(undefined)
    private long heapMemoryMax;

    /* *************** representing the non-heap memory usage *************** */
    // the initial amount of memory in bytes that the Java virtual machine allocates, -1(undefined)
    private long noHeapMemoryInit;
    // the amount of used memory in bytes
    private long noHeapMemoryUsed;
    // the amount of committed memory in bytes
    private long noHeapMemoryCommitted;
    // the maximum amount of memory in bytes that can be used, -1(undefined)
    private long noHeapMemoryMax;

    // true: if verbose output for the memory system is enabled
    private boolean verbose;
}
