package com.java.exercises.string;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsecutiveCompressorTest {
    private ConsecutiveCompressor subject = new ConsecutiveCompressor();

    @Test
    public void givenString_HasConsecutive_Compress() {
        String result = subject.compress("aabcccd");

        assertThat(result).isEqualTo("a2bc3d");
    }

    @Test
    public void givenString_HasNtConsecutive_DoeNtCompress() {
        String result = subject.compress("asdf");

        assertThat(result).isEqualTo("asdf");
    }

    @Test
    public void givenString_IsExactlyOneLong_ReturnSame() {
        String result = subject.compress("e");

        assertThat(result).isEqualTo("e");
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenString_IsNull_Throws() {
        subject.compress(null);
    }
}
