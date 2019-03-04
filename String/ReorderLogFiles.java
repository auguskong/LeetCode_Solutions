/* 
1. letter-logs come before any digit-log.
2. letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  
3. The digit-logs should be put in their original order.
*/

class Solution {
    public String[] reorderLogFiles(String[] logs) {

        Comparator<String> com = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int s1Start = s1.indexOf(' ');
                int s2Start = s2.indexOf(' ');
                char s1Char = s1.charAt(s1Start + 1);
                char s2Char = s2.charAt(s2Start + 1);

                if (s1Char <= '9') {
                    if (s2Char <= '9') { // natural order
                        return 0;
                    } else { // s1 is digit-log, s2 is letter-log
                        return 1;
                    }
                }
                if (s2Char <= '9') { // s2 is digit-log, s1 is letter-log
                    return -1;
                }

                // s1 and s2 are both letter-log
                int preCompute = s1.substring(s1Start + 1).compareTo(s2.substring(s2Start + 1));
                // ignore identifier letter-logs are ordered tie
                if (preCompute == 0) {
                    return s1.substring(0, s1Start).compareTo(s2.substring(0, s2Start));
                }

                return preCompute;
            }
        };

        Arrays.sort(logs, com);
        return logs;
    }
}