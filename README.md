# Minecraft - Create Goggles Curio #

A mod for Minecraft 1.16.5 that adds the Create Goggles to the Curios head slot.

<!-- omit in toc -->
## Table of Contents ##

* [Minecraft - Create Goggles Curio](#minecraft---create-goggles-curio)
    * [Building](#building)
        * [Preparations](#preparations)
        * [Installing the Java JDK](#installing-the-java-jdk)
            * [Windows](#windows)
            * [Other Operating Systems](#other-operating-systems)
        * [Compiling](#compiling)
            * [Windows](#windows-1)
            * [Other Operating Systems](#other-operating-systems-1)
    * [Testing](#testing)
    * [License](#license)

## Building ##

Building this project does involve some manual setup. The instructions below
should get you up and running.

### Preparations ###

1. Create a directory inside this project called `localMods`.
2. Download the following mods and place their JAR files into the newly created
   directory:
    * Create v0.3.2g - [link](https://www.curseforge.com/minecraft/mc-mods/create/files/3536025)
3. Ensure the downloaded mods have file names matching the following patterns:
    * Create - `create-mc1.16.5_v0.3.2g`

### Installing the Java JDK ###

#### Windows ####

1. Install `scoop.sh` - [link](https://scoop.sh/)
2. Install `git` (required to add buckets) by running `scoop install git`
3. Add the `java` bucket by running `scoop bucket add java`
4. Install a JDK of your choice by running `scoop install <PROVIDER><VERSION>-jdk`
    * This project is confirmed to compile when using `temurin-jdk`. It is
      recommended to try that one first.

#### Other Operating Systems ####

Check your package manager for an appropriate JDK package that meets the
following requirements:

* Supported by Gradle 6 or later

If in doubt, install the latest available JDK of at least version 17 or later.

### Compiling ###

Build outputs can be found in `build/libs` regardless of operating system.

#### Windows ####

1. Run `.\gradlew.bat build`

#### Other Operating Systems ####

1. Run `./gradlew build`

## Testing ##

All changes should be tested locally before submitting a pull request. At a
minimum they must compile. To test you changes:

1. Build the project with your changes.
2. Prepare a new Minecraft instance using only the following mods:
    * Minecraft v1.16.5
    * Forge v36.2.39
    * Create v0.3.2g
    * Flywheel v0.2.5
    * Curios API v4.1.0.0
    * Your built changes from the `build/libs` directory
3. Run the instance.
4. Verify the following:
    * The Engineer's Goggles can be equipped in the head Curios slot
    * The Engineer's Goggles display the stress overlay when equipped in your
      head slot.
    * The Engineer's Goggles display the stress overlay when equipped in your
      head Curios slot.
    * The stress overlay is not displayed outside of the above two
      circumstances during routine play.

## License ##

Copyright (c) 2023 G'lek Tarssza

All rights reserved.

See [LICENSE.md](LICENSE.md) for the full license.
