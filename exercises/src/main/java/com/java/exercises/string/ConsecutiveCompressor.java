package com.java.exercises.string;

public class ConsecutiveCompressor {

    /**
     * this method compress a string with removing character consecutive elements.
     *
     * @param s
     * @return
     */
    public String compress(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }

        if (s.length() == 1) {
            return s;
        }

        char[] chars = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            char curr = chars[i];
            sb.append(curr);

            int c = 1;
            while (i + 1 < chars.length && curr == chars[i + 1]) {
                c++;
                i++;
            }

            if (c > 1) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
