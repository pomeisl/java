package com.java.exercises.string;

import java.util.ArrayList;
import java.util.List;

public class SeriesCompressor {

    public List<String> compress(int[] arr) {
        List<String> result = new ArrayList<String>();

        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb = new StringBuilder();
            int curr = arr[i];
            sb.append(curr);

            int c = 1;
            while (i + 1 < arr.length && curr + 1 == arr[i + 1]) {
                curr = arr[i + 1];
                c++;
                i++;
            }

            if (c > 1) {
                sb.append("..." + curr);
            }

            result.add(sb.toString());
        }

        return result;
    }
}
