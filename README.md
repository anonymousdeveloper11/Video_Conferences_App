# Video_Conferences_App
Android application with real time activity like video meeting.
The video meeting will start using the Jitsi Meet.
To send a meeting invitation we will use firebase cloud messaging which is a 
cross-platform messaging solution that lets you reliably send messages at no cost. Using FCM, you can notify a client app that a new email or other data is 
available to sync.


For that users will sign up for their account using some basic details like the first name, last name, email, and password. To store all of the user data we will be using the cloud fire store database, which is a flexible and scalable database for mobile, web, and server development from Firebase and Google Cloud Platform.



After sign up, the user will sign in to their account using email and password. We will store logged user information into shared preferences to handle auto-sign in so users don't need to enter email and password every time.


After sign in, we will display a list of other users that are signed up in our application except for the currently logged user because nobody is going to start a video meeting with himself.


In a video meeting, the user will initiate the video meeting by sending a meeting invitation to another user. To send a meeting invitation we will use firebase cloud messaging which is a cross-platform messaging solution that lets you reliably send messages at no cost. Using FCM, you can notify a client app that a new email or other data is available to sync.


Once the meeting invitation sent, the receiver has two options, accept or reject the invitation. On acceptance or rejection, the related response message will be sent to the meeting initiator or sender. If the user wants to cancel the meeting invitation then it can be done by the hang-up process, in which another remote message will be sent to the receiver to cancel the current meeting invitation. This is the complete meeting invitation process.



On acceptance of the meeting invitation, the video meeting will start using the Jitsi Meet. To implement video meetings or conferences lots of groundwork is needed, to simplify this process we will use a pre-built Jitsi Meet client which is a free, open-source project that provides web browsers and mobile applications with real-time communication (RTC) via simple application programming interfaces (APIs). It allows audio and video communication to work inside applications and web pages by allowing direct peer-to-peer communication, eliminating the need to install plugins or download native apps. This Jitsi Meet client provides the facilities like, switch sound devices, invite more people to the meeting, audio-only mode, toggle camera, tile view in case of more people. The best part is you can also start chat conversion during video meetings.



![Screenshot_20210607-185804](https://user-images.githubusercontent.com/51409168/122112086-2d68be00-ce40-11eb-82c9-5117abebb0e3.png)

