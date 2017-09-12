package com.jhfactory.jhlogger;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 */
class DefaultLogger implements ILogger {

    DefaultLogger() {
    }

    @Override
    public void v(String msg) {
        Log.v(Logger.getTag(), msg);
    }

    @Override
    public void i(String msg) {
        Log.i(Logger.getTag(), msg);
    }

    @Override
    public void d(String msg) {
        Log.d(Logger.getTag(), getLogMessage(msg));
    }

    @Override
    public void d(String msg, boolean showStackTrace) {
        if (showStackTrace) {
            Log.d(Logger.getTag(), getLogMessage(msg, true));
        }
        else {
            Log.d(Logger.getTag(), msg);
        }
    }

    @Override
    public void w(String msg) {
        Log.w(Logger.getTag(), getLogMessage(msg));
    }

    @Override
    public void e(String msg) {
        Log.e(Logger.getTag(), getLogMessage(msg));
    }

    @Override
    public void wtf(String msg) {
        Log.wtf(Logger.getTag(), getLogMessage(msg));
    }

    @Override
    public void d(String msg, Throwable tr) {
        Log.d(Logger.getTag(), getLogMessage(msg), tr);
    }

    @Override
    public void d(String msg, Throwable tr, boolean showStackTrace) {
        if (showStackTrace) {
            Log.d(Logger.getTag(), getLogMessage(msg, true), tr);
        }
        else {
            Log.d(Logger.getTag(), msg, tr);
        }
    }

    @Override
    public void w(String msg, Throwable tr) {
        Log.w(Logger.getTag(), getLogMessage(msg), tr);
    }

    @Override
    public void e(String msg, Throwable tr) {
        Log.e(Logger.getTag(), getLogMessage(msg), tr);
    }

    @Override
    public void wtf(String msg, Throwable tr) {
        Log.wtf(Logger.getTag(), getLogMessage(msg), tr);
    }

    @Override
    public void json(String json) {
        Log.d(Logger.getTag(), getLogMessage(getJsonLog(json)));
    }

    @Override
    public void json(String msg, String json) {
        Log.d(Logger.getTag(), getLogMessage(msg + "\n" + getJsonLog(json)));
    }

    private String getJsonLog(String json) {
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
        }
        catch (JSONException e) {
            return e.getMessage() + "\n" + json;
        }
        return "";
    }

    private String getLogMessage(final String msg) {
        boolean showStackTrace = Logger.getLogLevel().equals(LogLevel.DEBUG)
                && Logger.isShowThreadInfo();
        return getLogMessage(msg, showStackTrace);
    }

    private String getLogMessage(final String msg, boolean showStackTrace) {
        if (showStackTrace) {
            final StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            try {
                if (stackTraceElements.length >= Logger.getStackTraceIdx()) {
                    final StackTraceElement element = stackTraceElements[Logger.getStackTraceIdx()];
                    return msg + "\n> " +
                            Class.forName(element.getClassName()).getSimpleName() + "." +
                            element.getMethodName() + " (" + element.getFileName() + ":" +
                            element.getLineNumber() + ")";
                }
            }
            catch (ClassNotFoundException e) {
                Log.e(Logger.getTag(), e.getMessage() + "\n" + msg);
            }
        }
        return msg;
    }
}
