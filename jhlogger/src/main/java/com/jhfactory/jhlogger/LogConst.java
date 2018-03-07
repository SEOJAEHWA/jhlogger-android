package com.jhfactory.jhlogger;

import android.content.Intent;
import android.os.Build;
import android.util.SparseArray;


final class LogConst {

    static final SparseArray<String> FLAGS = new SparseArray<>();

    static {
        FLAGS.put(Intent.FLAG_ACTIVITY_CLEAR_TASK, "FLAG_ACTIVITY_CLEAR_TASK");
        FLAGS.put(Intent.FLAG_ACTIVITY_SINGLE_TOP, "FLAG_ACTIVITY_SINGLE_TOP");
        FLAGS.put(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT, "FLAG_ACTIVITY_BROUGHT_TO_FRONT");
        FLAGS.put(Intent.FLAG_ACTIVITY_CLEAR_TOP, "FLAG_ACTIVITY_CLEAR_TOP");
        FLAGS.put(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS, "FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS");
        FLAGS.put(Intent.FLAG_ACTIVITY_FORWARD_RESULT, "FLAG_ACTIVITY_FORWARD_RESULT");
        FLAGS.put(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY, "FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY");
        FLAGS.put(Intent.FLAG_ACTIVITY_MULTIPLE_TASK, "FLAG_ACTIVITY_MULTIPLE_TASK");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            FLAGS.put(Intent.FLAG_ACTIVITY_NEW_DOCUMENT, "FLAG_ACTIVITY_NEW_DOCUMENT");
        }
        FLAGS.put(Intent.FLAG_ACTIVITY_NEW_TASK, "FLAG_ACTIVITY_NEW_TASK");
        FLAGS.put(Intent.FLAG_ACTIVITY_NO_ANIMATION, "FLAG_ACTIVITY_NO_ANIMATION");
        FLAGS.put(Intent.FLAG_ACTIVITY_NO_HISTORY, "FLAG_ACTIVITY_NO_HISTORY");
        FLAGS.put(Intent.FLAG_ACTIVITY_NO_USER_ACTION, "FLAG_ACTIVITY_NO_USER_ACTION");
        FLAGS.put(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP, "FLAG_ACTIVITY_PREVIOUS_IS_TOP");
        FLAGS.put(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT, "FLAG_ACTIVITY_REORDER_TO_FRONT");
        FLAGS.put(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED, "FLAG_ACTIVITY_RESET_TASK_IF_NEEDED");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            FLAGS.put(Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS, "FLAG_ACTIVITY_RETAIN_IN_RECENTS");
        }
        FLAGS.put(Intent.FLAG_ACTIVITY_TASK_ON_HOME, "FLAG_ACTIVITY_TASK_ON_HOME");
        FLAGS.put(Intent.FLAG_DEBUG_LOG_RESOLUTION, "FLAG_DEBUG_LOG_RESOLUTION");
        FLAGS.put(Intent.FLAG_EXCLUDE_STOPPED_PACKAGES, "FLAG_EXCLUDE_STOPPED_PACKAGES");
        FLAGS.put(Intent.FLAG_FROM_BACKGROUND, "FLAG_FROM_BACKGROUND");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            FLAGS.put(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION, "FLAG_GRANT_PERSISTABLE_URI_PERMISSION");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            FLAGS.put(Intent.FLAG_GRANT_PREFIX_URI_PERMISSION, "FLAG_GRANT_PREFIX_URI_PERMISSION");
        }
        FLAGS.put(Intent.FLAG_GRANT_READ_URI_PERMISSION, "FLAG_GRANT_READ_URI_PERMISSION");
        FLAGS.put(Intent.FLAG_GRANT_WRITE_URI_PERMISSION, "FLAG_GRANT_WRITE_URI_PERMISSION");
        FLAGS.put(Intent.FLAG_INCLUDE_STOPPED_PACKAGES, "FLAG_INCLUDE_STOPPED_PACKAGES");
        FLAGS.put(Intent.FLAG_RECEIVER_FOREGROUND, "FLAG_RECEIVER_FOREGROUND");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            FLAGS.put(Intent.FLAG_RECEIVER_NO_ABORT, "FLAG_RECEIVER_NO_ABORT");
        }
        FLAGS.put(Intent.FLAG_RECEIVER_REGISTERED_ONLY, "FLAG_RECEIVER_REGISTERED_ONLY");
        FLAGS.put(Intent.FLAG_RECEIVER_REPLACE_PENDING, "FLAG_RECEIVER_REPLACE_PENDING");
        FLAGS.put(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET, "FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET");
    }

    private LogConst() {

    }
}
