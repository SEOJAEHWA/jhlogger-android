package com.jhfactory.jhlogger;

import android.support.annotation.NonNull;
import android.util.Log;

/**
 *
 */
class PrintDefaultLogger extends PrintLogger implements ILogger {

    PrintDefaultLogger(@NonNull LogSettings settings) {
        super(settings);
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
        }
        else {
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
}
