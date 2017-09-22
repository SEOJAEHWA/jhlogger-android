package com.jhfactory.jhlogger;

import android.content.Intent;

/**
 *
 */
interface IExtLogger {

    void json(String json);

    void json(String msg, String json);

    void printStackTrace(Exception e);

    void intent(Intent intent);
}
