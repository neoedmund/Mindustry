#!/bin/bash -e
rm -f dist/tools.jar
rm -f dist/rt.jar
nb mybuild
neoejloader dist mindustry.desktop.DesktopLauncher -debug

