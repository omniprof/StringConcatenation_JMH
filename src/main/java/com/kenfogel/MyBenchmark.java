package com.kenfogel;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MyBenchmark {

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 2)
    @Warmup(iterations = 2, time = 2)
    public String stringConcat() {
        String result = "";
        for (int i = 0; i < 1000; i++) {
            result += String.valueOf(i);
        }
        return result;
    }

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 2)
    @Warmup(iterations = 2, time = 2)
    public String stringBuilderConcat() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            result.append(i);
        }
        return result.toString();
    }
}
