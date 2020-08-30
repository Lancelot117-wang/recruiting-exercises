Running this program (with Eclipse):
1. Create a new Java project with JavaSE-1.8 or later version
2. Copy main and test package into src folder
3. Right click the project in Package Explorer, in Properties->Java Build Path->Libraries->Add Library, add JUnit5 as dependency
4. Run TestRunner as Java Application

Running this program (with Intellij IDEA):
1. Create a new Java project with Java1.8 (jre1.8.0_251) or later version
2. Copy main and test package into src folder
3. In header toolkit, File->Project Structure->Modules->Dependencies->"+"->JAR or directories, add hamcrest-core-1.3.jar and junit-4.12.jar from .\lib in IDEA installation folder (defaultly provided by IDEA)
4. Run "TestRunner.main()"