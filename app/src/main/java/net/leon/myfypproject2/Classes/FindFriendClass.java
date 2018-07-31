package net.leon.myfypproject2.Classes;

public class FindFriendClass {
    private String username, ProfilePicture, Fullname;
    public FindFriendClass(){}
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfilePicture() {
        return ProfilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        ProfilePicture = profilePicture;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public FindFriendClass(String username, String profilePicture, String fullname) {
        this.username = username;
        ProfilePicture = profilePicture;
        Fullname = fullname;
    }


}
