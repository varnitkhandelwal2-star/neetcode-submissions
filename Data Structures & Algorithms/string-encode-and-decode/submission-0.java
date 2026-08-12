class Solution {

    // ENCODE: har string ke aage "length#" lagao
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()); // length likhdo
            sb.append('#');        // separator
            sb.append(s);          // actual string
        }
        return sb.toString();
    }

    // DECODE: length padho, # skip karo, utne chars lo
    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            // '#' dhundo
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            // length nikalo i se j tak
            int len = Integer.parseInt(str.substring(i, j));

            // j+1 se len chars lo (actual string)
            String word = str.substring(j + 1, j + 1 + len);
            result.add(word);

            // next string pe jao
            i = j + 1 + len;
        }

        return result;
    }
}