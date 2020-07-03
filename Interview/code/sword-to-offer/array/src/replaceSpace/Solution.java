package replaceSpace;

class Solution {
    public String replaceSpace(String s) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            // meet space
            if (s.charAt(i) == ' ') {
                str.append("%20");
            } else {
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
}


// Time Complexity: O(n)
// Space Complexity: O(n)
