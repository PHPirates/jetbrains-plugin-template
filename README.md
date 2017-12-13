[![Build Status](https://travis-ci.org/PHPirates/jetbrains-plugin-gradle.svg?branch=master)](https://travis-ci.org/PHPirates/jetbrains-plugin-gradle)

# Sample Jetbrains plugin with gradle build

# Setup instructions
These are for building this sample plugin, adapt for your own plugin.

* Create a new project, choose Gradle, choose whatever language you used and IntelliJ Platform Plugin.
* As GroupID specify the package domain, for example `com.example`, as ArtifactID specify the project name.
* If IntelliJ suggests to use a gradle wrapper, do so by clicking 'apply suggestion'.
* On the right you should have a Gradle button, if you run Tasks - intellij - runIde then a new IDE instance should boot which contains the plugin.
* You should find the jar which contains the plugin in `build/libs/plugin_name.jar`.