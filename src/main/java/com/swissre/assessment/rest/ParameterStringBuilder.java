package com.swissre.assessment.rest;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import static java.net.URLEncoder.encode;
import static java.nio.charset.StandardCharsets.UTF_8;

final class ParameterStringBuilder {
    static String getParameterString(Map<String, String> parameters) throws UnsupportedEncodingException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("?");

        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            stringBuilder.append(encode(entry.getKey(), String.valueOf(UTF_8)));
            stringBuilder.append("=");
            stringBuilder.append(encode(entry.getValue(), String.valueOf(UTF_8)));
            stringBuilder.append("&");
        }

        return removeLastAmpersand(stringBuilder.toString());
    }

    private static String removeLastAmpersand(String string) {
        return string.length() > 1
                ? string.substring(0, string.length() - 1)
                : string;
    }
}