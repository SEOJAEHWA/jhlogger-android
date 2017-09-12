package com.jhfactory.jhlogger;

import android.support.annotation.NonNull;

/**
 *
 */
public enum LogLevel {
    RELEASE,   // hide all logs
    DEBUG,  // show all logs
    INFO; // show only info, verbose logs

    public static LogLevel fromString(@NonNull String text) {
        for (LogLevel b : LogLevel.values()) {
            if (text.equalsIgnoreCase(b.name())) {
                return b;
            }
        }
        return INFO;
    }
}
