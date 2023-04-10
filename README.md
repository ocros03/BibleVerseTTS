# Bible Verse TTS

## How to install FreeTTS
1. [Download FreeTTS here](https://sourceforge.net/projects/freetts/postdownload)
2. Extract the zip file to the C:\ drive that provides two folders, freetts-1.2 and META-INF
3. Access the directory C:\freetts-1.2.2-bin\freetts-1.2\lib\jsapi.exe
4. Install the jsapi by double-clicking on the jsapi.exe file. Accept the License Agreement by clicking on the I Agree button.
5. Now click on the Close button. The above process generates a jar file (in the same location where the jsapi.exe file resides) named jsapi.jar. It is a jar file that contains the FreeTTS library that is required to create a text-to-speech application. We have installed JSAPI properly.
6. Now, we will create a Java project in IDE as usually we create. In our case, we have created a Java project with the name TTS. In this project, we have created a class name TextToSpeechExample1 and write the following code.
7. Add the following jar files to your project
* cmu_time_awb
* cmu_us_kal
* cmudict04
* cmulex
* cmutimelex
* en_us
* freetts
* freetts-jsapi10
* jsapi
* mbrola
8. Navigate the directory C:\freetts-1.2.2-bin\freetts-1.2 and copy the speech.properties file and paste the properties file into the home directory. In our case the directory is C:\Users\Anubhav.
9. [For more info, visit this site](https://www.javatpoint.com/convert-text-to-speech-in-java)
