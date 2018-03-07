package com.jhfactory.jhlogger;

import android.content.ComponentName;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class LogUtils {

    private LogUtils() {

    }

    static String[] getPrettyJsonStringArray(String json) {
        final String prettyJson = getJsonLog(json);
        if (!TextUtils.isEmpty(prettyJson)) {
            return prettyJson.split("[\\r\\n]+");
        }
        return new String[0];
    }

    private static String getJsonLog(String json) {
        if (TextUtils.isEmpty(json)) {
            return "json content is Empty or Null.";
        }
        try {
            json = json.trim();
            if (json.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(json);
                return jsonObject.toString(4);
            }
            if (json.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(json);
                return jsonArray.toString(4);
            }
        } catch (JSONException e) {
            return e.getMessage() + "\n" + json;
        }
        return "";
    }

    static String getStackTraceMessage(int stackTraceIdx, int shownStackTraceCount) {
        final StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        try {
            int stackTraceOffset = getStackTraceOffset(stackTraceElements, stackTraceIdx);
            StringBuilder stackTraceMsg = new StringBuilder();
            for (int i = 0; i < shownStackTraceCount; i++) {
                if (stackTraceOffset + i >= stackTraceElements.length) {
                    break;
                }
                final StackTraceElement element = stackTraceElements[stackTraceOffset + i];
                stackTraceMsg.append("\n> ")
                        .append(Class.forName(element.getClassName()).getSimpleName())
                        .append(".")
                        .append(element.getMethodName())
                        .append(" (")
                        .append(element.getFileName())
                        .append(":")
                        .append(element.getLineNumber())
                        .append(")");
            }
            return stackTraceMsg.toString();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static int getStackTraceOffset(StackTraceElement[] trace, int stackTraceIdx) {
        for (int i = stackTraceIdx; i < trace.length; i++) {
            StackTraceElement e = trace[i];
            String name = e.getClassName();
            if (!name.equals(PrintLog.class.getName()) && !name.equals(Logger.class.getName())) {
                return i;
            }
        }
        return -1;
    }

    static String getComponentName(ComponentName componentName) {
        if (componentName != null) {
            return componentName.getPackageName() + "/" + componentName.getClassName();
        } else {
            return "null";
        }
    }

    static String getFlags(int flags, int space) {
        StringBuilder result = new StringBuilder();
        String pattern = " ";
        for (int i = 0; i < LogConst.FLAGS.size(); i++) {
            int flag = LogConst.FLAGS.keyAt(i);
            if ((flag & flags) != 0) {
                result.append("\n│").append(getPattern(space, pattern))
                        .append("└ ").append(LogConst.FLAGS.get(flag));
            }
        }
        return result.toString();
    }

    static String getExtras(Bundle extras, int space) {
        if (extras == null) {
            return "null";
        }
        StringBuilder result = new StringBuilder();
        String pattern = " ";
        for (String key : extras.keySet()) {
            Object value = extras.get(key);
            if (value instanceof Bundle) {
                result.append("\n│").append(getPattern(space, pattern))
                        .append("└ [").append(key).append("]");
                result.append(getExtras((Bundle) value, space * 2));
            } else {
                try {
                    result.append("\n│").append(getPattern(space, pattern))
                            .append("└ [").append(key).append("] ")
                            .append(String.valueOf(extras.get(key)));
                } catch (BadParcelableException e) {
//                    printStackTrace(e);
                }
            }
        }
        return result.toString();
    }

    static String getPattern(int space, String pattern) {
        StringBuilder one = new StringBuilder();
        for (int i = 0; i < space; i++) {
            one.append(pattern);
        }
        return one.toString();
    }
}
