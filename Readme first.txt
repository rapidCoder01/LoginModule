**********************************************
This is a Login Module Backend :
**********************************************

Designed with the help of Java ,jsp & Servlets
you can use this backend module for any websites 

Database used : MySQL 

Projects contains :

Login portal
Admin portal
Registration page
Forgot password page
Otp page
Validation page

**********************************************

Security :
-----------

Login & Logout safety :-

This module contains some security elments which makes your website a little bit on a safer side to use . 
Provides safety with your browser related cache-controls, revalidation, and some other header commands

Forgot Password :-

This module uses mailAPI facility which makes you a little bit secure for getting your password after clicking on the 
forgot password button.
It redirects you to your Otp page which sends One Time Password into your registered mail id 
as you enters your otp into your Otp page its again redirects you to validation page which validates your otp 
if the submitted otp matches with our send otp then your ACCOUNT Password is sent your mail id .

From mail you can get you password and login to your website again.

***********************************************

Now some changes you need to do into mailer.java after cpying this project into your local system .

Step 1:
-------
You have to create a mail id from where you want to send mails , it can be your personnel or official 
depending on your needs.

Step 2:
-------
Go into your manage you account google account section

Step3:
------
Go to Security > Signing in to Google > App Password

Step 4:
-------
Enter your gmail password ,then Select the app and device you want to generate the app password for.
In app choose Others - name anything for your app

Step 5:
-------
Click o generate and copy the generated 16 digit pass key

Step 6:
-------
Open you program in Eclipse/netbeans anywhere where you want
then, go to mailer.java class

Step 7:
-------
Enter your mail id and 16 digit pass key 
place alredy specified there.

Thats all now your application is now ready to send mails to anyone who registers into your website .

*****************************************************************************************************

Libraries present in lib folder in src/main/webapp/web-INF/lib

Attached this all libraries in program in :- Eclipse

Go to project right click and 
select build path >configure build path > libraries > classpath > add jars 

select all and add.

****************************************************************************

This program needs tomcat to run on local host 
so install & configure tomcat first before running this project .

****************************************************************************































 
 