Hello, I've chosen the 2nd task

How to run tests:
0. Install JDK 1.8 and Maven on your local machine, version of your Chrome browser should be 74. 
1. Clone current repository 
2. Open this directory and go into the folder with pom.xml file
3. Execute in terminal or cmd tool command - "mvn test -Pchrome" or "mvn test -Pfirefox" to run tests

There are the following problems which weren't fixed by lack of time or can be done better:

1) Найти все одинаковые для обоих телефонов параметры - it wasn't done
2) There is problem with running tests on FireFox browser
3) There is ad popup in the right bottom corner. It is displayed sometimes and it overlaps "Купити" button,
so the best solution is to run Chrome with adblock extension, but I fix this problem by simple closing it
4) DB is hosted on my Home PC
5) Instead of running tests locally better to run it on standalone host, in this way we don't have configuration problem like
problems with compatibility chrome browser and chrome driver, addons and extensions for browsers, etc 
