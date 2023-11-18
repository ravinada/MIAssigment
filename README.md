![Screenshot_20231119_011417](https://github.com/ravinada/MIAssigment/assets/49580276/90672c7a-0df7-4fd6-9bb3-fff5293a20a9)# Landscape Activity with Two Fragments

## Overview

This Android application features an activity (`LandscapeActivity`) designed for landscape mode, comprising two child fragments (`FragmentA` and `FragmentB`). The layout is horizontally subdivided, with `FragmentA` on the left and `FragmentB` on the right. The activity allows users to interact with recycler views in both fragments, selecting multiple elements and moving them between fragments using dedicated buttons.

## Key Features

1. **Landscape Mode Layout:**
   - Activity X is displayed in landscape mode.
   - Divided into two equal parts horizontally.

2. **Fragment Details:**
   - **Fragment A:**
     - Contains a recycler view with 10 elements (0 to 9).
     - Allows multiple element selection.
   - **Fragment B:**
     - Initially empty recycler view.

3. **Element Movement:**
   - Users can select multiple elements in either recycler view.
   - Dedicated buttons for moving selected elements:
     - "Move to Right": Moves selected elements from Fragment A to Fragment B.
     - "Move to Left": Moves selected elements from Fragment B to Fragment A.
   - Movement works in a cut-and-paste fashion.

4. **List Manipulation:**
   - Elements moved are appended to the end of the target fragment's recycler view.
   - Selected elements are removed from the source fragment's recycler view.

## Screenshot
![Screenshot_20231119_011417](https://github.com/ravinada/MIAssigment/assets/49580276/0be96a61-7141-4d87-9175-fcc6b98a277b)

![Screenshot_20231119_002727](https://github.com/ravinada/MIAssigment/assets/49580276/16c93634-c468-4907-824c-fbe62b2c9059)

## Implementation Details

- **Language:** Kotlin
- **Tech Stack:** Android SDK, RecyclerView
- **Architecture:** Follows the Android recommended practices for fragment-based UI.

## How to Use

1. Clone the repository.
2. Open the project in Android Studio.
3. Build and run the application on an Android emulator or device.
4. Test the landscape activity and the element movement features.

## Important Note

- The implementation adheres to best practices and does not use static/companion variables or broadcasts.

**Enjoy exploring and interacting with the Landscape Activity and its fragments!**

For any issues or queries, please feel free to open an [issue](https://github.com/yourusername/your-repository/issues) on GitHub.
