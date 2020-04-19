[![Build Status](https://travis-ci.org/PHPirates/jetbrains-plugin-template.svg?branch=master)](https://travis-ci.org/PHPirates/jetbrains-plugin-template)
![GitHub Workflow Status (branch)](https://img.shields.io/github/workflow/status/PHPirates/jetbrains-plugin-template/CI/master?style=flat-square)


# Sample Jetbrains plugin with gradle build

# Features
* Uses Gradle to build the plugin.
* Uses Travis-CI to let Travis automatically build the plugin and run tests on every push.
* On every tagged commit, a zip is automatically deployed to GitHub releases.
* Uses both Java and Kotlin.
* Demonstrates a non-standard source directory, as well as multiple source directories (for example for generated files) and more customisations.
* Uses resource files in resources directory.
* Since Travis-CI recommends [not to use cache](https://docs.travis-ci.com/user/caching/#Things-not-to-cache) for files slow to download and quick to install, this will not cache the IntelliJ binaries.

# Instructions for building this plugin from source with IntelliJ

* Create a new project from version control.
* Click 'yes' if prompted to open the `build.gradle` file.
* Select 'use auto-import' and 'ok'.
* If you get 'Invalid Gradle JDK configuration found', make sure you have a JDK installed.
* By virtue of gradle and the gradle wrapper, the rest goes automatically, so be patient.

## To run/debug locally, i.e. run a sample IntelliJ instance with the plugin in it
Click the Gradle button on the right, the gradle task is located in Tasks - intellj - runIde. Right-click and run.

You will be launching a brand new IntelliJ instance, so the first time you get the normal start window. Just open any project (like this one). Settings like open project and color scheme should be remembered, so you don't have to do this every time.

Note how IntelliJ adds this task as a run configuration in the normal location if you have run it once. 

## To generate a zip which contains the plugin
Click the Gradle button on the right, the gradle task is located in Tasks - intellij - buildPlugin. Right-click and run. The zip will be in build/distributions.

## To run tests
Click the Gradle button on the right, the gradle task is located in Tasks - verification - check. Right-click and run. Note that check includes test so it will run the tests.

# Experimental instructions to convert your plugin to a gradle build
* Copy the files `build.gradle`, `settings.gradle`, and if you will use Travis-CI `.travis.yml` and adapt to your project.
* Open a different project and then create a new project (you can't do that while you have the project open), choose Gradle, choose whatever language you used and IntelliJ Platform Plugin.
* As GroupID specify the package domain, for example `com.example`, as ArtifactID specify the project name.
* If IntelliJ suggests to use a gradle wrapper, do so by clicking 'apply suggestion'.
* On the right you should have a Gradle button, if you run Tasks - intellij - runIde then a new IDE instance should boot which contains the plugin.
* You should find the jar which contains the plugin in `build/libs/plugin_name.jar`.
