package com.jhfactory.jhlogger;

import android.content.Intent;

/**
 *
 */
public final class Logger {

    private static LogSettings settings;
    private static PrintLog logPrinter;

    private Logger() {

    }

    public static LogSettings init() {
        settings = new LogSettings();
        logPrinter = new PrintLog(settings);
        return settings;
    }

    public static void v(String msg) {
        if (showLogOnReleaseMode()) {
            logPrinter.v(msg);
        }
    }

    public static void i(String msg) {
        if (showLogOnReleaseMode()) {
            logPrinter.i(msg);
        }
    }

    public static void d(String msg) {
        if (showLogOnDebugMode()) {
            logPrinter.d(msg);
        }
    }

    public static void d(String msg, boolean showStackTrace) {
        if (showLogOnDebugMode()) {
            logPrinter.d(msg, showStackTrace);
        }
    }

    public static void d(String msg, int shownStackTraceCount) {
        if (showLogOnDebugMode()) {
            logPrinter.d(msg, shownStackTraceCount);
        }
    }

    public static void w(String msg) {
        if (showLogOnDebugMode()) {
            logPrinter.w(msg);
        }
    }

    public static void e(String msg) {
        if (showLogOnDebugMode()) {
            logPrinter.e(msg);
        }
    }

    public static void wtf(String msg) {
        if (showLogOnDebugMode()) {
            logPrinter.wtf(msg);
        }
    }

    public static void json(String json) {
        if (showLogOnDebugMode()) {
            logPrinter.json(json);
        }
    }

    public static void json(String msg, String json) {
        if (showLogOnDebugMode()) {
            logPrinter.json(msg, json);
        }
    }

    public static void printStackTrace(Exception e) {
        if (showLogOnDebugMode()) {
            logPrinter.printStackTrace(e);
        }
    }

    public static void intent(Intent intent) {
        if (showLogOnDebugMode()) {
            logPrinter.intent(intent);
        }
    }

    private static boolean showLogOnReleaseMode() {
        return settings.getLogLevel().equals(LogLevel.RELEASE) || showLogOnDebugMode();
    }

    private static boolean showLogOnDebugMode() {
        return settings.getLogLevel().equals(LogLevel.DEBUG);
    }
}
