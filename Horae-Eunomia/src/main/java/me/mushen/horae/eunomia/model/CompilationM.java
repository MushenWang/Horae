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
public class CompilationM {
    // the name of the JIT compiler
    private String jitCompilerName;
    // compilation time in milliseconds
    private long totalCompilationTime;
}
