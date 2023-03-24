package com.lu.daily;

/**
 * @author sheldon
 * @date 2023-03-24
 */
public class rev_q1032 {

    public static class StreamChecker {

        private final String[] words;
        private final StringBuilder sb = new StringBuilder();

        public StreamChecker(String[] words) {
            this.words = words;
        }

        public boolean query(char letter) {
            sb.append(letter);
            String s = sb.toString();
            for (String word : words) {
                if (s.endsWith(word)) {
                    return true;
                }
            }
            return false;
        }

    }

}
