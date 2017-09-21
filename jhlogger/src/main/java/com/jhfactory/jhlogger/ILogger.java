package com.jhfactory.jhlogger;

/**
 *
 */
interface ILogger {

    void v(String msg);

    void i(String msg);

    void d(String msg);

    void d(String msg, boolean showStackTrace);

    void d(String msg, int shownStackTraceCount);

    void w(String msg);

    void e(String msg);

    void wtf(String msg);

    void d(String msg, Throwable tr);

    void d(String msg, Throwable tr, boolean showStackTrace);

    void w(String msg, Throwable tr);

    void e(String msg, Throwable tr);

    void wtf(String msg, Throwable tr);

    void json(String json);

    void json(String msg, String json);
}
