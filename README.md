# Toggleton

----
[![](https://jitpack.io/v/michaelobi/toggleton.svg)](https://jitpack.io/#michaelobi/toggleton)

## Installation

Add the JitPack repository to your root build.gradle file;
```gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```

In the module's build.gradle file;
```gradle
 dependencies {
    compile 'com.github.michaelobi:toggleton:0.2'
 }
```

## Usage

### ToggleableImageView
In layout files, use the `<ToggleImageButton />` tag like any other Android View Widget. 

In Java code,

```java
ToogleableImageView toggleableImageView = (ToggleableImageView) findViewById(R.id.toggle);

// Create an ArrayList to hold ToggleStates
ArrayList<DrawableToggleState> toggleStates = new ArrayList<>();

// Create ToggleStates by passing the key and a drawable to the constructor
toggleStates.add(new DrawableToggleState(STATE_REPEAT_ALL, ContextCompat.getDrawable(this, R.drawable.ic_repeat)));
toggleStates.add(new DrawableToggleState(STATE_REPEAT_ONE, ContextCompat.getDrawable(this, R.drawable.ic_repeat_one)));

// Set ToggleStates on View
toggleableImageView.setToggleStates(toggleStates);
```

#### Listening for changes in state
```java
toggleableImageView.setToggleListener(new ToggleableWidget.ToggleListener() {
    @Override
    public void onToggle(ToggleState previous, ToggleState current) {
        Log.d(TAG, "onToggle() called with: previous = [" + previous + "], current = [" + current + "]");
        Toast.makeText(MainActivity.this, "New State:" + current.getKey(), Toast.LENGTH_SHORT).show();
    }
});
```
The `onToggle()` callback provides the previous state and current state of the widget.

### License (MIT)

```
Copyright (c) [2016] [Michael Obi]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```