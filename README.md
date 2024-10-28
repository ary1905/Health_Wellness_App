# HealthMate - Health & Wellness Android App

[![Platform](https://img.shields.io/badge/Platform-Android-blue?style=flat-square&logo=android)](https://developer.android.com/) 
[![Java](https://img.shields.io/badge/Language-Java-orange?style=flat-square&logo=java)](https://www.oracle.com/java/) 
[![License](https://img.shields.io/github/license/ary1905/Health_Wellness_App?style=flat-square)](LICENSE)  
![GitHub repo size](https://img.shields.io/github/repo-size/ary1905/Health_Wellness_App?style=flat-square)  
[![Last Commit](https://img.shields.io/github/last-commit/ary1905/Health_Wellness_App?style=flat-square)](https://github.com/ary1905/Health_Wellness_App/commits/main)  

## Overview

HealthMate is a Health and Wellness Android application developed to track, monitor, and improve users' overall well-being. This app provides health assessments, tracks physical activity, calculates BMI, offers nutritional guidance, and provides expert videos on diet and exercise. HealthMate is built using **Java** and **Android Studio**, with Firebase for video data and SQLite for local user data.

## Features

- **User Authentication**: Secure sign-up and login functionality.
- **Health Assessments**: Track health status at intervals of 3, 6, and 12 months.
- **Step Counter**: Monitor daily steps and reset automatically at midnight.
- **BMI Calculator**: Input height and weight for real-time BMI tracking.
- **Nutritional Videos**: Educational videos by experts fetched from Firebase.
- **Dietary Guidelines Carousel**: Scroll through guidelines based on Indian dietary standards.
- **Profile Management**: Manage personal information and contact a dietician or emergency services directly.

## Screenshots

| Dashboard                          | Assessment                         | Profile                          |
|------------------------------------|------------------------------------|----------------------------------|
| ![Dashboard](images/dashboard.png) | ![Assessment](images/assessment.png) | ![Profile](images/profile.png) |

> _Ensure the images (`dashboard.png`, `assessment.png`, `profile.png`) are in the `images` folder in your repository._

## Getting Started

### Prerequisites

- **Android Studio**: Install [Android Studio](https://developer.android.com/studio) (v4.1 or higher).
- **Java JDK**: Ensure Java Development Kit is installed.
- **Firebase Account**: To use nutrition video functionality, configure Firebase.

### Installation

1. **Clone the Repository**

    ```bash
    git clone https://github.com/ary1905/Health_Wellness_App.git
    ```

2. **Open in Android Studio**

   - Open Android Studio, select *File > Open* and choose the cloned project directory.
   - Allow dependencies to sync.

3. **Set up Firebase** 

   - Navigate to [Firebase Console](https://console.firebase.google.com/), create a new project, and add your app’s package name.
   - Download `google-services.json` and place it in the `app/` directory.

4. **Run the App**

   - Build and run the app on an Android device or emulator running Android 13+.

## Usage

- **Sign-Up**: Create an account to access full app features.
- **Assessments**: Track progress using the Assessment tab, with automated graphs and statistics.
- **Dietary Carousel**: Access dietary tips through a user-friendly Material carousel.
- **Profile Edit**: Modify profile details, including emergency contact functionality.

## Database

- **SQLite**: User data, dietary guidelines, and assessments are stored locally in SQLite.
- **Firebase**: Nutrition video URLs and metadata are fetched from Firebase.

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

Distributed under the MIT License. See `LICENSE` for more information.

## Contact

**Ary1905**  
[GitHub](https://github.com/ary1905)  
[Email](mailto:your-email@example.com)
