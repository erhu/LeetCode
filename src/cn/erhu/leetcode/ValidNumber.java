package cn.erhu.leetcode;

/**
 * Validate if a given string is numeric.
 * <p/>
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 * <p/>
 * User: hujunjie
 * Date: 14-10-16
 * Time: 上午8:20
 */
class ValidNumber {
    boolean isNumber(String s) {
        if (s != null && !s.trim().equals("")) {
            s = s.trim();

            /* 排除常见的错误情况 */
            // do not has number
            if (!hasNumber(s)) {
                return false;
            }

            // last char is alpha
            if (isAlpha(s.charAt(s.length() - 1))) {
                return false;
            }

            /* 分开判断科学计数法和普通数字 */
            // 科学计数法
            if (s.indexOf('e') >= 1) {
                return isScientificNotation(s);
            }
            // 普通数字
            else {
                return isNormalNumber(s);
            }
        }
        return false;
    }

    /**
     * 普通数字（非科学计数法）
     */
    boolean isNormalNumber(String s) {
        s = s.trim();
        char[] arr = s.toCharArray();
        // ..2
        if (isDot(arr[0]) && (firstDigitalIndex(arr) > 1)) {
            return false;
        }

        // -+9.34
        if (arr[0] == '-' || arr[0] == '+') {
            // + 3 => false
            int first_digital = firstDigitalIndex(arr);
            // 符号位与第一个数字间有空格 => false
            if (first_digital > 1 && hasWhiteSpace(s.substring(0, first_digital))) {
                return false;
            }
            return isNumber(s.substring(1, s.length()));
        }

        int index_of_dot = indexOfChar(arr, '.');

        if (index_of_dot == -1) {
            return isInteger(s);
        }
        // .245
        else if (index_of_dot == 0) {
            return isInteger(s.substring(1, s.length()));
        }
        // 33334.
        else if (index_of_dot == s.length() - 1) {
            return isInteger(s.substring(0, s.length() - 1));
        }
        // 34.4
        else if (index_of_dot > 0) {
            return isInteger(s.substring(0, index_of_dot))
                    && isInteger(s.substring(index_of_dot + 1, s.length()));
        }
        return false;
    }

    boolean isInteger(String s) {
        if (s != null && !s.equals("")) {
            char[] arr = s.toCharArray();
            if (arr[0] == '-' || arr[0] == '+') {
                return isInteger(s.substring(1, s.length()));
            }

            // 小数点在中间
            if (hasDot(s) && indexOfChar(s.toCharArray(), '.') != arr.length - 1) {
                return false;
            }

            // 2334
            if (allCharIsNumber(s)) {
                return true;
            }
        }
        return false;
    }

    boolean isScientificNotation(String s) {
        s = s.trim();
        char[] arr = s.toCharArray();
        int index_of_e = indexOfChar(arr, 'e');
        if (index_of_e > 0) {
            // e 左边第1倍不是数字，并且也不是小数点
            if (!isDigital(arr[index_of_e - 1]) && arr[index_of_e - 1] != '.') {
                return false;
            }
        }

        // 3e1
        // 0.e => false
        // 4e3.
        // .2e8
        // .e1 => false
        // 96 e5 => false
        // " 005047e+6"

        // 第一位不能是e
        if (index_of_e > 0) {
            // 科学计数法中，最后一位不能是点
            if (isDot(arr[arr.length - 1])) {
                return false;
            }
            if (isDot(arr[0])) {
                return isInteger(s.substring(1, index_of_e))
                        && isInteger(s.substring(index_of_e + 1, s.length()));

            }
            return isNormalNumber(s.substring(0, index_of_e))
                    && isInteger(s.substring(index_of_e + 1, s.length()));
        }
        return false;
    }


    boolean hasNumber(String s) {
        if (s != null) {
            char[] arr = s.toCharArray();
            for (char c : arr) {
                if ((int) c >= (int) '0' && (int) c <= (int) '9') {
                    return true;
                }
            }
        }
        return false;
    }

    boolean hasDot(String s) {
        if (s != null) {
            char[] arr = s.toCharArray();
            for (char c : arr) {
                if (isDot(c)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean allCharIsNumber(String s) {
        if (s == null) {
            return false;
        }
        char[] arr = s.toCharArray();
        if (arr.length == 0) {
            return false;
        }

        for (char c : arr) {
            if (!isDigital(c)) {
                return false;
            }
        }
        return true;
    }

    int firstDigitalIndex(char[] arr) {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (isDigital(arr[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    boolean hasWhiteSpace(String s) {
        if (s != null) {
            char[] arr = s.toCharArray();
            for (char c : arr) {
                if (c == ' ') {
                    return true;
                }
            }
        }
        return false;
    }

    int indexOfChar(char[] arr, char c) {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == c) {
                    return i;
                }
            }
        }
        return -1;
    }

    boolean isDigital(char c) {
        return (int) c >= (int) '0' && (int) c <= (int) '9';
    }

    boolean isAlpha(char c) {
        return ((int) c >= (int) 'A' && (int) c <= (int) 'Z')
                || ((int) c >= (int) 'a' && (int) c <= (int) 'z');
    }

    boolean isDot(char c) {
        return c == '.';
    }
}
