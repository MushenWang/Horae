package me.mushen.horae.eunomia.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @Desc
 * @Author Mushen
 * @Create 2018-06-30
 */
@Getter
@ToString
@AllArgsConstructor
public class Failure {
    // Failure Code
    private int failCode;
    // Failure Code
    private String failName;
    // Failure Description
    private String failDesc;
}
