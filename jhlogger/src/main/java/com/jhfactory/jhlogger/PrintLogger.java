package com.jhfactory.jhlogger;

import android.support.annotation.NonNull;

/**
 *
 */
@SuppressWarnings("WeakerAccess")
public class PrintLogger {

    private LogSettings settings;

    public PrintLogger(@NonNull LogSettings settings) {
        this.settings = settings;
    }

    public String getTag() {
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

    public String printLogMessage(String msg) {
        return printLogMessage(msg, showStackTrace(), getStackTraceIdx(), getShownStackTraceCount());
    }

    public String printLogMessage(String msg, int shownStackTraceCount) {
        return printLogMessage(msg, true, getStackTraceIdx(), shownStackTraceCount);
    }

    public String printLogMessage(String msg, boolean showStackTrace) {
        return printLogMessage(msg, showStackTrace, getStackTraceIdx(), getShownStackTraceCount());
    }

    public String printLogMessage(String msg, boolean showStackTrace, int shownStackTraceCount) {
        return printLogMessage(msg, showStackTrace, getStackTraceIdx(), shownStackTraceCount);
    }

    private String printLogMessage(final String msg, boolean showStackTrace, int stackTraceIdx, int shownStackTraceCount) {
        if (showStackTrace) {
            final StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            try {
                int stackTraceOffset = getStackTraceOffset(stackTraceElements, stackTraceIdx);
                String stackTraceMsg = "";
                for (int i = 0; i < shownStackTraceCount; i++) {
                    if (stackTraceOffset + i >= stackTraceElements.length) {
                        break;
                    }
                    final StackTraceElement element = stackTraceElements[stackTraceOffset + i];
                    stackTraceMsg += "\n> " +
                            Class.forName(element.getClassName()).getSimpleName() + "." +
                            element.getMethodName() + " (" + element.getFileName() + ":" +
                            element.getLineNumber() + ")";
                }
                return msg + stackTraceMsg;
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return msg;
    }

    private static int getStackTraceOffset(StackTraceElement[] trace, int stackTraceIdx) {
        for (int i = stackTraceIdx; i < trace.length; i++) {
            StackTraceElement e = trace[i];
            String name = e.getClassName();
            if (!name.equals(PrintExtendLogger.class.getName()) && !name.equals(Logger.class.getName())) {
                return i;
            }
        }
        return -1;
    }
}
