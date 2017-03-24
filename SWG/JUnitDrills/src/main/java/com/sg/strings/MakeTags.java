package com.sg.strings;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class MakeTags {

    public String makeTags(String tag, String content) {
        String result = "<" + tag + ">" + content + "</" + tag + ">";
        return result;
    }

}
