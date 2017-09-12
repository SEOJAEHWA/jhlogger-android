package com.jhfactory.jhlogger;

public class LogSettings {

    private LogLevel logLevel = LogLevel.DEBUG;
    private boolean showThreadInfo = false;
    private String tag = "SMARTINFINI";
    private int stackTraceIdx = 5;

    LogLevel getLogLevel() {
        return logLevel;
    }

    public LogSettings setLogLevel(LogLevel level) {
        logLevel = level;
        return this;
    }

    String getTag() {
        return tag;
    }

    public LogSettings setTag(String tag) {
        this.tag = tag;
        return this;
    }

    int getStackTraceIdx() {
        return stackTraceIdx;
    }

    public LogSettings setStackTraceIdx(int stackTraceIdx) {
        this.stackTraceIdx = stackTraceIdx;
        return this;
    }

    boolean isShowThreadInfo() {
        return showThreadInfo;
    }

    public LogSettings setShowThreadInfo(boolean showThreadInfo) {
        this.showThreadInfo = showThreadInfo;
        return this;
    }
}
