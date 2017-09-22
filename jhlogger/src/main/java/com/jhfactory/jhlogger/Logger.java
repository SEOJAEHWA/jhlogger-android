package com.jhfactory.jhlogger;

import android.content.Intent;

/**
 *
 */
public class Logger {

    private static LogSettings settings;
    private static ILogger logger;
    private static IExtLogger extLogger;

    public static LogSettings init() {
        settings = new LogSettings();
        logger = new PrintDefaultLogger(settings);
        extLogger = new PrintExtendLogger(settings);
        new PrintLogger(settings);
        return settings;
    }

    private static boolean showLogOnReleaseMode() {
        return settings.getLogLevel().equals(LogLevel.RELEASE) || showLogOnDebugMode();
    }

    private static boolean showLogOnDebugMode() {
        return settings.getLogLevel().equals(LogLevel.DEBUG);
    }

    public static void v(String msg) {
        if (showLogOnReleaseMode()) {
            logger.v(msg);
        }
    }

    public static void i(String msg) {
        if (showLogOnReleaseMode()) {
            logger.i(msg);
        }
    }

    public static void d(String msg) {
        if (showLogOnDebugMode()) {
            logger.d(msg);
        }
    }

    public static void d(String msg, boolean showStackTrace) {
        if (showLogOnDebugMode()) {
            logger.d(msg, showStackTrace);
        }
    }

    public static void d(String msg, int shownStackTraceCount) {
        if (showLogOnDebugMode()) {
            logger.d(msg, shownStackTraceCount);
        }
    }

    public static void w(String msg) {
        if (showLogOnDebugMode()) {
            logger.w(msg);
        }
    }

    public static void e(String msg) {
        if (showLogOnDebugMode()) {
            logger.e(msg);
        }
    }

    public static void wtf(String msg) {
        if (showLogOnDebugMode()) {
            logger.wtf(msg);
        }
    }

    public static void json(String json) {
        if (showLogOnDebugMode()) {
            extLogger.json(json);
        }
    }

    public static void json(String msg, String json) {
        if (showLogOnDebugMode()) {
            extLogger.json(msg, json);
        }
    }

    public static void printStackTrace(Exception e) {
        if (showLogOnDebugMode()) {
            extLogger.printStackTrace(e);
        }
    }

    public static void intent(Intent intent) {
        if (showLogOnDebugMode()) {
            extLogger.intent(intent);
        }
    }
}
