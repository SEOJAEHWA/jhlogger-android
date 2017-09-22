package com.jhfactory.jhlogger;

/**
 *
 */
interface ILogger {

    void v(String msg);

    void i(String msg);

    void d(String msg);

    void d(String msg, boolean forceShowStackTrace);

    void d(String msg, int shownStackTraceCount);

    void d(String msg, boolean forceShowStackTrace, int shownStackTraceCount);

    void w(String msg);

    void e(String msg);

    void wtf(String msg);
}
