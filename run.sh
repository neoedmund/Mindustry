#!/bin/bash -e
nb mybuild
rm -f dist/tools.jar
rm -f dist/rt.jar
neoejloader dist mindustry.desktop.DesktopLauncher

