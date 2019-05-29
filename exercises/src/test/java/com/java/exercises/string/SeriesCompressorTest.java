package com.java.exercises.string;

import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class SeriesCompressorTest {
    SeriesCompressor subject = new SeriesCompressor();

    @Test
    public void givenArray_HasSeries_Compressed() {
        List<String> result = subject.compress(new int[]{1, 2, 3, 5, 8});

        assertThat(result).containsExactly("1...3", "5", "8");
    }

    @Test
    public void givenArray_HasOnlySeries_ContainsOnlyCompressed() {
        List<String> result = subject
                .compress(new int[]{1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 14, 15, 16, 17, 18});

        assertThat(result).containsExactly("1...6", "8...12", "14...18");
    }

    @Test
    public void givenArray_LongSeries_Compressed() {
        int[] series = IntStream
                .rangeClosed(1, 999999)
                .toArray();
        List<String> result = subject.compress(series);

        assertThat(result).containsExactly("1...999999");
    }

    @Test
    public void givenArray_SameElements_DoesNtCompressed() {
        List<String> result = subject.compress(new int[]{1, 1, 1, 1});

        assertThat(result).containsExactly("1", "1", "1", "1");
    }
}
