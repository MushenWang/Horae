package me.mushen.horae.eunomia.result;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * @Desc
 * @Author Mushen
 * @Create 2018-06-30
 */
@Getter
@ToString
public class Result {
    // result code: Success(1), Failure(0)
    private int code;
    // specific failure info, if code is 0, this should not be empty.
    private List<Failure> failures;

    public Result(int code) {
        this(code, null);
    }

    public Result(int code, List<Failure> failures) {
        this.code = code;
        this.failures = failures;
    }
}
