
<a name="readme-top"></a>

<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

<br />
<div align="center">
  <img src="logo.svg"/>
  <p align="center">
    <strong> An android ui component that adds gradient backdrop to your collapsing appbar</strong>
    <br/>
    <a href="https://github.com/othneildrew/Best-README-Template">Sample Apk</a>
    ·
    <a href="https://github.com/snehilrx/ShineBar/issues">Report Bug</a>
    ·
    <a href="https://github.com/snehilrx/ShineBar/issues">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project
This project started as the way for me to learn the new AGSL shader for android. You can read more about AGSL shader ![here](https://developer.android.com/develop/ui/views/graphics/agsl)

Since alsl is support for android 13 and above, this project was rewritten in glsl. 

The main idea behind this project was to show a gradient backdrop to collapsing appbar which responds to the scroll change. The backdrop provides add an immersive experience to the app.

<img width="400px" src="https://user-images.githubusercontent.com/7668602/210174320-3fc571f5-717b-4bed-af3e-6b345e642e90.gif"/>

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

Add this to your `app/build.gradle` file.
```  
  implementation com.snehil:shinebar:1.0.0
```
<!-- USAGE EXAMPLES -->
## Usage

Extend your application base theme with parent as `Theme.Material3.DayNight.ShineBar`
```xml
  <style name="Theme.ShineBar" parent="Theme.Material3.DayNight.ShineBar">
        <!-- Primary brand color. -->
        <item name="colorPrimary">@color/purple_500</item>
        <item name="colorPrimaryDark">@color/purple_700</item>
        <item name="colorAccent">@color/teal_200</item>
        <!-- Customize your theme here. -->
   </style>
```

To add the shinebar to your `layout.xml` file

```xml
<androidx.coordinatorlayout.widget.CoordinatorLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/black"
        android:fitsSystemWindows="true">

        <com.snehil.shinebar.Shinebar
            android:id="@+id/shinebar"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:fitsSystemWindows="false"
            app:layout_behavior="com.snehil.shinebar.Shinebar$ShinebarBehaviour" />

        <com.google.android.material.appbar.AppBarLayout
            android:id="@+id/appbar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@android:color/transparent"
            android:fitsSystemWindows="true">

            <com.google.android.material.appbar.CollapsingToolbarLayout
                style="?attr/collapsingToolbarLayoutLargeStyle"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:background="@android:color/transparent"
                app:layout_scrollFlags="scroll|enterAlways"
                app:titleCollapseMode="scale"
                app:contentScrim="@android:color/transparent"
                app:statusBarScrim="@android:color/transparent"
                app:toolbarId="@id/toolbar">

                <com.snehil.shinebar.ShineToolBar
                    android:id="@+id/toolbar"
                    android:layout_width="match_parent"
                    android:layout_height="?attr/actionBarSize"
                    android:background="@android:color/transparent"
                    app:elevation="0dp"
                    app:layout_collapseMode="pin" />


                <androidx.constraintlayout.widget.ConstraintLayout
                    android:layout_width="match_parent"
                    android:layout_height="match_parent">

                    <TextView
                        android:id="@+id/textView"
                        android:layout_width="0dp"
                        android:layout_height="0dp"
                        android:layout_marginStart="16dp"
                        android:layout_marginEnd="16dp"
                        android:includeFontPadding="true"
                        android:fontFamily="@font/inter_bold"
                        android:text="@string/main_quote"
                        app:autoSizeMaxTextSize="19sp"
                        app:autoSizeMinTextSize="12sp"
                        app:autoSizeTextType="uniform"
                        app:layout_constraintBottom_toBottomOf="@+id/cardView"
                        app:layout_constraintEnd_toEndOf="parent"
                        app:layout_constraintStart_toEndOf="@+id/cardView"
                        app:layout_constraintTop_toTopOf="@+id/cardView" />

                    <androidx.cardview.widget.CardView
                        android:id="@+id/cardView"
                        android:layout_width="0dp"
                        android:layout_height="270dp"
                        android:layout_gravity="center|start"
                        android:layout_marginStart="16dp"
                        android:layout_marginTop="64dp"
                        android:layout_marginBottom="24dp"
                        app:cardCornerRadius="32dp"
                        app:layout_constraintBottom_toBottomOf="parent"
                        app:layout_constraintEnd_toStartOf="@+id/guideline3"
                        app:layout_constraintStart_toStartOf="parent"
                        app:layout_constraintTop_toTopOf="parent">

                        <VideoView
                            android:id="@+id/videoView"
                            android:layout_width="match_parent"
                            android:layout_height="wrap_content" />
                    </androidx.cardview.widget.CardView>

                    <androidx.constraintlayout.widget.Guideline
                        android:id="@+id/guideline3"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:orientation="vertical"
                        app:layout_constraintGuide_percent="0.42" />
                </androidx.constraintlayout.widget.ConstraintLayout>

            </com.google.android.material.appbar.CollapsingToolbarLayout>
        </com.google.android.material.appbar.AppBarLayout>
  <include
    layout="your content layout"/>
</androidx.coordinatorlayout.widget.CoordinatorLayout>
```

To make your app immersive call `makeAppbarImmersive`
```kotlin   
shinebarInstance.makeAppbarImmersive(this, binding.root)
```

To customize the start color and end color of the gradient backdrop

```kotlin
shinebarInstance.apply {
  setStartColor(it.first)
  setEndColor(it.second)
}
```

## Roadmap

[ ] Publish this library to maven central.
[ ] Publish an agsl verion for android 13 and above.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Your Name - snehil - snehil101@gmail.com

Project Link: [https://github.com/snehilrx/ShineBar](https://github.com/snehilrx/ShineBar)

<p align="right">(<a href="#readme-top">back to top</a>)</p>




<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=for-the-badge
[contributors-url]: https://github.com/othneildrew/Best-README-Template/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/othneildrew/Best-README-Template.svg?style=for-the-badge
[forks-url]: https://github.com/othneildrew/Best-README-Template/network/members
[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=for-the-badge
[stars-url]: https://github.com/othneildrew/Best-README-Template/stargazers
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=for-the-badge
[issues-url]: https://github.com/othneildrew/Best-README-Template/issues
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-url]: https://github.com/othneildrew/Best-README-Template/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/othneildrew
[product-screenshot]: images/screenshot.png
[Next.js]: https://img.shields.io/badge/next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white
[Next-url]: https://nextjs.org/
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[Vue.js]: https://img.shields.io/badge/Vue.js-35495E?style=for-the-badge&logo=vuedotjs&logoColor=4FC08D
[Vue-url]: https://vuejs.org/
[Angular.io]: https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white
[Angular-url]: https://angular.io/
[Svelte.dev]: https://img.shields.io/badge/Svelte-4A4A55?style=for-the-badge&logo=svelte&logoColor=FF3E00
[Svelte-url]: https://svelte.dev/
[Laravel.com]: https://img.shields.io/badge/Laravel-FF2D20?style=for-the-badge&logo=laravel&logoColor=white
[Laravel-url]: https://laravel.com
[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[Bootstrap-url]: https://getbootstrap.com
[JQuery.com]: https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white
[JQuery-url]: https://jquery.com
