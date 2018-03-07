package com.jhfactory.jhlogger;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

/**
 *
 */
class PrintLog implements ILogger {

    private LogSettings settings;

    PrintLog(@NonNull LogSettings settings) {
        this.settings = settings;
    }

    @Override
    public void v(String msg) {
        Log.v(getTag(), printLogMessage(msg));
    }

    @Override
    public void i(String msg) {
        Log.i(getTag(), printLogMessage(msg));
    }

    /**
     * Debug log
     *
     * @param msg log message
     */
    @Override
    public void d(String msg) {
        Log.d(getTag(), printLogMessage(msg));
    }

    /**
     * Debug log
     *
     * @param msg                 log message
     * @param forceShowStackTrace If true, show stackTrace log in force.
     */
    @Override
    public void d(String msg, boolean forceShowStackTrace) {
        Log.d(getTag(), printLogMessage(msg, forceShowStackTrace));
    }

    /**
     * Debug log
     * StackTrace is always shown.
     *
     * @param msg                  log message
     * @param shownStackTraceCount Shown StackTrace line count.
     */
    @Override
    public void d(String msg, int shownStackTraceCount) {
        Log.d(getTag(), printLogMessage(msg, shownStackTraceCount));
    }

    /**
     * Debug log
     *
     * @param msg                  log message
     * @param forceShowStackTrace  If true, show stackTrace log in force.
     * @param shownStackTraceCount Shown StackTrace line count.
     */
    @Override
    public void d(String msg, boolean forceShowStackTrace, int shownStackTraceCount) {
        if (forceShowStackTrace) {
            Log.d(getTag(), printLogMessage(msg, true, shownStackTraceCount));
        } else {
            Log.d(getTag(), msg);
        }
    }

    @Override
    public void w(String msg) {
        Log.w(getTag(), printLogMessage(msg));
    }

    @Override
    public void e(String msg) {
        Log.e(getTag(), printLogMessage(msg));
    }

    @Override
    public void wtf(String msg) {
        Log.wtf(getTag(), printLogMessage(msg));
    }

    @Override
    public void json(String json) {
        json("", json);
    }

    @Override
    public void json(String msg, String json) {
        if (!TextUtils.isEmpty(msg)) {
            Log.d(getTag(), printLogMessage(msg));
        }
        for (String log : LogUtils.getPrettyJsonStringArray(json)) {
            Log.d(getTag(), log);
        }
    }

    @Override
    public void printStackTrace(Exception e) {
        e.printStackTrace();
    }

    @Override
    public void intent(Intent intent) {
        Log.d(getTag(), "┌Intent[@" + Integer.toHexString(intent.hashCode()) + "] " + LogUtils.getPattern(42, "─"));
        Log.d(getTag(), "│ Action   : " + intent.getAction());
        Log.d(getTag(), "│ Category : " + intent.getCategories());
        Log.d(getTag(), "│ Data     : " + intent.getDataString());
        Log.d(getTag(), "│ Component: " + LogUtils.getComponentName(intent.getComponent()));
        Log.d(getTag(), "│ Flag       " + LogUtils.getFlags(intent.getFlags(), 4));
        Log.d(getTag(), "│ Bundle     " + LogUtils.getExtras(intent.getExtras(), 4));
        Log.d(getTag(), "└" + printLogMessage(LogUtils.getPattern(48, "─") + " END"));
    }

    private String getTag() {
        return this.settings.getTag();
    }

    private boolean showStackTrace() {
        return settings.showStackTrace();
    }

    private int getStackTraceIdx() {
        return settings.getStackTraceIdx();
    }

    private int getShownStackTraceCount() {
        return settings.getShownStackTraceCount();
    }

    private String printLogMessage(String msg) {
        return printLogMessage(msg, showStackTrace(), getStackTraceIdx(), getShownStackTraceCount());
    }

    private String printLogMessage(String msg, int shownStackTraceCount) {
        return printLogMessage(msg, true, getStackTraceIdx(), shownStackTraceCount);
    }

    private String printLogMessage(String msg, boolean showStackTrace) {
        return printLogMessage(msg, showStackTrace, getStackTraceIdx(), getShownStackTraceCount());
    }

    private String printLogMessage(String msg, boolean showStackTrace, int shownStackTraceCount) {
        return printLogMessage(msg, showStackTrace, getStackTraceIdx(), shownStackTraceCount);
    }

    private String printLogMessage(final String msg, boolean showStackTrace, int stackTraceIdx, int shownStackTraceCount) {
        if (showStackTrace) {
            return msg + LogUtils.getStackTraceMessage(stackTraceIdx, shownStackTraceCount);
        }
        return msg;
    }
}
