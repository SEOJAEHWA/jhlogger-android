package com.jhfactory.jhlogger;

public class LogSettings {

    private LogLevel logLevel = LogLevel.DEBUG;
    private boolean showThreadInfo = false;
    private String tag = "SMARTINFINI";
    private int stackTraceIdx = 5;
    private int shownStackTraceCount = 1;

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public LogSettings setLogLevel(LogLevel level) {
        logLevel = level;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public LogSettings setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public int getStackTraceIdx() {
        return stackTraceIdx;
    }

    public LogSettings setStackTraceIdx(int stackTraceIdx) {
        this.stackTraceIdx = stackTraceIdx;
        return this;
    }

    public int getShownStackTraceCount() {
        return shownStackTraceCount;
    }

    public boolean isShowThreadInfo() {
        return showThreadInfo;
    }

    public LogSettings setShowThreadInfo(boolean showThreadInfo) {
        this.showThreadInfo = showThreadInfo;
        return this;
    }


    public boolean showStackTrace() {
        return getLogLevel().equals(LogLevel.DEBUG) && isShowThreadInfo();
    }
}
