package com.example.videomeetingapp.listeners;

import com.example.videomeetingapp.models.User;

public interface UsersListeners {

    void initiateVideoMeeting(User user);

    void initiateAudioMeeting(User user);

    void onMultipleUsersAction(Boolean isMultipleUsersSelected);
}
