The automation tower defense RTS, written in Java.

---------------
Thanks for source code, the game and the happiness from
https://github.com/Anuken/Mindustry

I almost going to buy a copy of the game, but the author is bad mood animal, so not worth it.
-------------
This is some random dirty hack, no coding rules applied so no push request.

== how to build
1. `./gradlew` for original build
2. then use `neoebuild`


changes:

1. [QoL] : when select a section, print brief analyzed info into logfile.
   info: resources, produtions, todo productions, possible factory army turrets.
   
2. [Coding] : drop gradle, use neoebuild. 
   It seems uses annotation for code gen, but further use  `com.sun.tools.javac.*` and `sun.reflect.annotation.*`(bad), so not clean for plain build.
   workflow: 
      1. ./gradle to let annotations run and gen .java. 
      2. use neoebuild to build 
3. [Coding] : joined `TextFrog` the script language, see `mindustry.tfg` , can hot reloading.


