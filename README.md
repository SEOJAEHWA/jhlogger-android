# jhlogger-android
Log for android.
Show log stack trace, json object, intent object.

## Installation

Download:
```groovy
dependencies {
    implementation 'com.jhfactory:jhlogger:0.9.0'
}
```


## How to use
### Initialize
Initialize Logger in Application or Activity or Fragment.
```java
Logger.init()
        .setTag("SEOJAEHWA")
        .setLogLevel(LogLevel.DEBUG)
        .setShowThreadInfo(true);

```

### Show Log
```java
Logger.v("onCreate -------------------------------");
Logger.i("onCreate -------------------------------");
Logger.d("onCreate -------------------------------");
Logger.w("onCreate -------------------------------");
Logger.e("onCreate -------------------------------");
Logger.printStackTrace(e);
Logger.intent(intent);
```

If you do not want to show trace info...
```java
Logger.d("onCreate -------------------------------", false);
```
### Logcat




## License
<pre>
Copyright 2017 SEOJAEHWA

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
</pre>
