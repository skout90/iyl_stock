package com.iyl.stock.common;

/**
 * <pre>
 * Class Name  : CamelUtil.java
 * Description :
 * Modification Information
 *
 *    수정일　　　 　　  수정자　　　     수정내용
 *    ────────────   ─────────   ───────────────────────────────
 *    2017. 5. 3.   남준호              최초생성
 * </pre>
 *
 * @author 남준호
 * @since 2017. 5. 3.
 * @version 1.0
 *
 * Copyright (C) 2017 by IYL All right reserved.
 */
public class CamelUtil {
    public static String convert2CamelCase(String underScore) {
        if ((underScore.indexOf(95) < 0) && (Character.isLowerCase(underScore.charAt(0)))) {
            return underScore;
        }
        StringBuilder result = new StringBuilder();
        boolean nextUpper = false;
        int len = underScore.length();

        for (int i = 0; i < len; ++i) {
            char currentChar = underScore.charAt(i);
            if (currentChar == '_') {
                nextUpper = true;
            }
            else if (nextUpper) {
                result.append(Character.toUpperCase(currentChar));
                nextUpper = false;
            }
            else {
                result.append(Character.toLowerCase(currentChar));
            }
        }

        return result.toString();
    }
}
