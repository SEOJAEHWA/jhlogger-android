package com.jhfactory.jhlogger;

/**
 *
 */
public class Logger {

    private static LogSettings settings;
    private static ILogger logger;

    public static LogSettings init() {
        settings = new LogSettings();
        logger = new DefaultLogger();
        return settings;
    }

    public static void v(String msg) {
        if (getLogLevel().equals(LogLevel.RELEASE) || getLogLevel().equals(LogLevel.DEBUG)) {
            logger.v(msg);
        }
    }

    public static void i(String msg) {
        if (getLogLevel().equals(LogLevel.RELEASE) || getLogLevel().equals(LogLevel.DEBUG)) {
            logger.i(msg);
        }
    }

    public static void d(String msg) {
        if (getLogLevel().equals(LogLevel.DEBUG)) {
            logger.d(msg);
        }
    }

    public static void d(String msg, boolean showStackTrace) {
        if (getLogLevel().equals(LogLevel.DEBUG)) {
            logger.d(msg, showStackTrace);
        }
    }

    public static void w(String msg) {
        if (getLogLevel().equals(LogLevel.DEBUG)) {
            logger.w(msg);
        }
    }

    public static void e(String msg) {
        if (getLogLevel().equals(LogLevel.DEBUG)) {
            logger.e(msg);
        }
    }

    public static void wtf(String msg) {
        if (getLogLevel().equals(LogLevel.DEBUG)) {
            logger.wtf(msg);
        }
    }

    public static void d(String msg, Throwable tr) {
        if (getLogLevel().equals(LogLevel.DEBUG)) {
            logger.d(msg, tr);
        }
    }
    public static void d(String msg, Throwable tr, boolean showStackTrace) {
        if (getLogLevel().equals(LogLevel.DEBUG)) {
            logger.d(msg, tr, showStackTrace);
        }
    }

    public static void w(String msg, Throwable tr) {
        if (getLogLevel().equals(LogLevel.DEBUG)) {
            logger.w(msg, tr);
        }
    }

    public static void e(String msg, Throwable tr) {
        if (getLogLevel().equals(LogLevel.DEBUG)) {
            logger.e(msg, tr);
        }
    }

    public static void wtf(String msg, Throwable tr) {
        if (getLogLevel().equals(LogLevel.DEBUG)) {
            logger.wtf(msg, tr);
        }
    }

    public static void json(String json) {
        if (getLogLevel().equals(LogLevel.DEBUG)) {
            logger.json(json);
        }
    }

    public static void json(String msg, String json) {
        if (getLogLevel().equals(LogLevel.DEBUG)) {
            logger.json(msg, json);
        }
    }

    public static void printStackTrace(Exception e) {
        if (getLogLevel().equals(LogLevel.DEBUG)) {
            e.printStackTrace();
        }
    }

    static String getTag() {
        return settings.getTag();
    }

    static LogLevel getLogLevel() {
        return settings.getLogLevel();
    }

    static int getStackTraceIdx() {
        return settings.getStackTraceIdx();
    }

    static boolean isShowThreadInfo() {
        return settings.isShowThreadInfo();
    }
}
