package ds.strings;

//This function takes two strings s1 and s2 as an argument and finds the first occurrence of the sub-string s2 in the string s1.
// The process of matching does not include the terminating null-characters(‘\0’), but function stops there.
public class StrStrProblem {
    int strstr(String str, String target) {
        if (str == null || target == null) {
            return -1;
        }
        if (str.length() == 0) {
            return -1;
        }
        int index = -1;
        char[] strArr = str.toCharArray();
        char[] tarArr = target.toCharArray();
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] == tarArr[0]) {
                index = i;
                int j = 1;
                int var = i + 1;
                boolean matched = false;
                while (true) {
                    if (j == tarArr.length) {
                        matched = true;
                        break;
                    }
                    if (var >= strArr.length) {
                        break;
                    }
                    if (strArr[var] != tarArr[j]) {
                        break;
                    }
                    var++;
                    j++;
                }
                if (matched) {
                    return index;
                }
                index = -1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(new StrStrProblem().strstr("aaaaaaaaaaaaaab", "aaaab"));
    }
}
