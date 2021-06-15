package com.example.videomeetingapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videomeetingapp.R;
import com.example.videomeetingapp.listeners.UsersListeners;
import com.example.videomeetingapp.models.User;

import java.util.ArrayList;
import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder>{

    private List<User> users;

    private UsersListeners usersListeners;
    private List<User> selectedUsers;

    public UsersAdapter(List<User> users, UsersListeners usersListeners) {
        this.users = users;
        this.usersListeners = usersListeners;
        selectedUsers = new ArrayList<>();
    }

    public List<User> getSelectedUsers(){
        return selectedUsers;
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UsersViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_container_user, parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {

        holder.setUserData(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

     class UsersViewHolder extends RecyclerView.ViewHolder{

        TextView textFirstChar, textUsername, textEmail;
        ImageView imageAudioMeeting, imageVideoMeeting;
        ConstraintLayout userContainer;
        ImageView imageSelected;
         UsersViewHolder(@NonNull View itemView) {
            super(itemView);

            textFirstChar = itemView.findViewById(R.id.textFirstChar);
            textEmail = itemView.findViewById(R.id.textEmail);
            textUsername = itemView.findViewById(R.id.textUsername);
            imageAudioMeeting = itemView.findViewById(R.id.imageAudioMeeting);
            imageVideoMeeting = itemView.findViewById(R.id.imageVideoMeeting);
            userContainer = itemView.findViewById(R.id.userContainer);
            imageSelected = itemView.findViewById(R.id.imageSelected);

        }
        void setUserData(User user){
             textFirstChar.setText(user.firstName.substring(0,1));
             textUsername.setText(String.format("%s %s", user.firstName, user.lastName));
             textEmail.setText(user.email);
             imageAudioMeeting.setOnClickListener(v -> usersListeners.initiateAudioMeeting(user));

             imageVideoMeeting.setOnClickListener(v -> usersListeners.initiateVideoMeeting(user));

         userContainer.setOnLongClickListener(v -> {
             if(imageSelected.getVisibility() != View.VISIBLE){
                 selectedUsers.add(user);
                 imageSelected.setVisibility(View.VISIBLE);
                 imageVideoMeeting.setVisibility(View.GONE);
                 imageAudioMeeting.setVisibility(View.GONE);
                 usersListeners.onMultipleUsersAction(true);
             }

             return true;
         });

         userContainer.setOnClickListener(v -> {
             if(imageSelected.getVisibility() == View.VISIBLE){
                 selectedUsers.remove(user);
                 imageSelected.setVisibility(View.GONE);
                 imageVideoMeeting.setVisibility(View.VISIBLE);
                 imageAudioMeeting.setVisibility(View.VISIBLE);
                 if(selectedUsers.size() == 0){
                     usersListeners.onMultipleUsersAction(false);
                 }else {
                     if(selectedUsers.size() > 0){
                         selectedUsers.add(user);
                         imageSelected.setVisibility(View.VISIBLE);
                         imageVideoMeeting.setVisibility(View.GONE);
                         imageAudioMeeting.setVisibility(View.GONE);
                     }
                 }
             }
         });
         }
    }
}
