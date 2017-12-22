[![Build Status](https://travis-ci.org/PHPirates/jetbrains-plugin-template.svg?branch=master)](https://travis-ci.org/PHPirates/jetbrains-plugin-template)

# Sample Jetbrains plugin with gradle build

# Features
* Uses Gradle to 
* Uses Travis-CI
* Uses both Java and Kotlin
* Demonstrates a non-standard source directory, as well as multiple source directories (for example for generated files).
* Uses resource files in resources directory.
* Since Travis-CI recommends [not to use cache](https://docs.travis-ci.com/user/caching/#Things-not-to-cache) for files slow to download and quick to install, this will not cache the IntelliJ binaries.

# Instructions for building this plugin from source with IntelliJ

* Download or clone the project.
* 

## To generate a zip
Click the Gradle button on the right, 

## To run tests

# Instructions to convert your plugin to a gradle build
* Copy the files `build.gradle`, `settings.gradle`, and if you will use Travis-CI `.travis.yml` and adapt to your project.
* Open a different project and then create a new project (you can't do that while you have the project open), choose Gradle, choose whatever language you used and IntelliJ Platform Plugin.
* As GroupID specify the package domain, for example `com.example`, as ArtifactID specify the project name.
* If IntelliJ suggests to use a gradle wrapper, do so by clicking 'apply suggestion'.
* On the right you should have a Gradle button, if you run Tasks - intellij - runIde then a new IDE instance should boot which contains the plugin.
* You should find the jar which contains the plugin in `build/libs/plugin_name.jar`.
