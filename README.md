# BlurIM [ ![Download](https://api.bintray.com/packages/chathurahettiarachchi/maven/BlurIM/images/download.svg) ](https://bintray.com/chathurahettiarachchi/maven/BlurIM/_latestVersion)

Most of the time, what we suffer in Android development is, which library do i need to use. Is this library provide all functionalities? Oh... This make me ill.. haahaa :) :) 

Anyway.. This is an Android library which warp up with all the functionalities you want to make an ImageView with a blur effect. This library contains,

* Blur from resource inside
* Blur effect adjustment with scale and effectScale
* Blur effect to URL image ( can be little buggy)

![blurimg](https://cloud.githubusercontent.com/assets/13764097/21796945/267fe8f2-d732-11e6-8cba-752aa2fa85ab.jpg)

  
####Let's take a look how to add this to your project

For the android project just include the following dependency inside you build.gradle's depedency list.

Gradle
------
```
repositories {
  jcenter()
}

dependencies {
    ...
    compile 'com.chootdev:blurimg:1.0.1'
}
```

if you using maven use following
Maven
------
```
<dependency>
  <groupId>com.chootdev</groupId>
  <artifactId>blurimg</artifactId>
  <version>1.0.1</version>
  <type>pom</type>
</dependency>
```

After setup installing lib to your project you just need only to call it using just few lines of code. It will return you a string with the results.

Usage
-----
To add blur effect to a resource inside of project
```java
BlurImage.withContext(this)
         .blurFromResource(R.drawable.YOUR_RESOURCE)
         .into(imageView);
```

To change blur effect you can user following methods,
```java
BlurImage.withContext(this)
         .setBitmapScale(0.1f)
         .blurFromResource(R.drawable.YOUR_RESOURCE)
         .into(imageView);
```
Or....
```java
BlurImage.withContext(this)
         .setBlurRadius(9.5f)
         .blurFromResource(R.drawable.YOUR_RESOURCE)
         .into(imageView);
```
Or....
```java
BlurImage.withContext(this)
         .setBlurRadius(9.5f)
         .setBitmapScale(0.1f)
         .blurFromResource(R.drawable.YOUR_RESOURCE)
         .into(imageView);
```
If you need to load an image from internet, you can simply use this library as well.. :)
```java
BlurImage.withContext(this)
         .blurFromUri("YOUR_URL")
         .into(imageView);
         
// for an example
BlurImage.withContext(this)
         .blurFromUri("https://media.mnn.com/assets/images/2014/11/WhiteTiger02ColorfulAnimalsGallery.jpg.638x0_q80_crop-smart.jpg")
         .into(imageView);
```

Limitations
-----------
* Currently can be exceptions with some events. Pleace follow same pattern.
* Loading image from URL may take longer time

Output Generated
----------------
Out put with inbuilt resource

![001](https://cloud.githubusercontent.com/assets/13764097/21797372/a3c09bb6-d734-11e6-8e86-09880f1dab4a.png)



Out put with URL image

![002](https://cloud.githubusercontent.com/assets/13764097/21797373/a415cb86-d734-11e6-8aaa-4f2d5d5b701b.png)

Changelog
---------
* **1.0.1**
    * Support for URL
* **1.0.0**
    * Stable the release
* **1.0.0**
    * Support for resource
* **0.0.1**
    * Initial release
    
## Author

Chathura Hettiarachchi, chathura93@yahoo.com

Checkout my other contributions, https://github.com/ChathuraHettiarachchi?tab=repositories

# License
Copyright 2016 Chathura Hettiarachchi

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
