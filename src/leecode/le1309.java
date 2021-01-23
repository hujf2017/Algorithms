package leecode;


/**
 * @author Hujf
 * @title: le1309
 * @date 2021/1/23 0023上午 9:20
 * @description: TODO
 */
public class le1309 {
    public String freqAlphabets(String s) {
        char[] alphabetChars = new char[27];
            for (int i = 1; i < alphabetChars.length; i++) {
                alphabetChars[i] = (char) (96 + i);
            }
            StringBuilder builder = new StringBuilder();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (i < chars.length - 2 && chars[i + 2] == '#') {
                    builder.append(alphabetChars[(chars[i] - '0') * 10 + (chars[i + 1] - '0')]);
                    i += 2;
                } else {
                    builder.append(alphabetChars[chars[i] - '0']);
                }
            }
            return builder.toString();
        }

}
