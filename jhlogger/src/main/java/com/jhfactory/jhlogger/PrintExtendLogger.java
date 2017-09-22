package com.jhfactory.jhlogger;

import android.content.ComponentName;
import android.content.Intent;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 */
class PrintExtendLogger extends PrintLogger implements IExtLogger {

    private static final SparseArray<String> FLAGS = new SparseArray<>();

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

    PrintExtendLogger(@NonNull LogSettings settings) {
        super(settings);
    }

    @Override
    public void json(String json) {
        Log.d(getTag(), printLogMessage(getJsonLog(json)));
    }

    @Override
    public void json(String msg, String json) {
        Log.d(getTag(), printLogMessage(msg + "\n" + getJsonLog(json)));
    }

    @Override
    public void printStackTrace(Exception e) {
        e.printStackTrace();
    }

    @Override
    public void intent(Intent intent) {
        Log.d(getTag(), "Intent[@" + Integer.toHexString(intent.hashCode()) + "] " + getPattern(43, "─"));
        Log.d(getTag(), "│└ Action   : " + intent.getAction());
        Log.d(getTag(), "│└ Category : " + intent.getCategories());
        Log.d(getTag(), "│└ Data     : " + intent.getDataString());
        Log.d(getTag(), "│└ Component: " + getComponentName(intent.getComponent()));
        Log.d(getTag(), "│└ Flag       " + getFlags(intent.getFlags(), 7));
        Log.d(getTag(), "│└ Bundle     " + getExtras(intent.getExtras(), 7));
        Log.d(getTag(), printLogMessage("└" + getPattern(50, "─") + " END"));
    }

    private String getJsonLog(String json) {
        if (TextUtils.isEmpty(json)) {
            return "json content is Empty or Null.";
        }
        try {
            json = json.trim();
            if (json.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(json);
                return jsonObject.toString(4);
            }
            if (json.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(json);
                return jsonArray.toString(4);
            }
        }
        catch (JSONException e) {
            return e.getMessage() + "\n" + json;
        }
        return "";
    }

    private String getComponentName(ComponentName componentName) {
        if (componentName != null) {
            return componentName.getPackageName() + "/" + componentName.getClassName();
        }
        else {
            return "null";
        }
    }

    private String getFlags(int flags, int space) {
        String result = "";
        String pattern = " ";
        for (int i = 0; i < FLAGS.size(); i++) {
            int flag = FLAGS.keyAt(i);
            if ((flag & flags) != 0) {
                result += "\n│" + getPattern(space, pattern) + "└ " + FLAGS.get(flag);
            }
        }
        return result;
    }

    private String getExtras(Bundle extras, int space) {
        if (extras == null) {
            return "null";
        }
        String result = "";
        String pattern = " ";
        for (String key : extras.keySet()) {
            Object value = extras.get(key);
            if (value instanceof Bundle) {
                result += "\n│" + getPattern(space, pattern) + "└ [" + key + "]";
                result += getExtras((Bundle) value, space * 2);
            }
            else {
                try {
                    result += "\n│" + getPattern(space, pattern) + "└ [" + key + "] " + String.valueOf(extras.get(key));
                }
                catch (BadParcelableException e) {
                    printStackTrace(e);
                }
            }
        }
        return result;
    }

    private String getPattern(int space, String pattern) {
        String one = "";
        for (int i = 0; i < space; i++) {
            one += pattern;
        }
        return one;
    }
}
