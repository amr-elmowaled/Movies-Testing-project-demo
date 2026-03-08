package org.example;
import java.util.List;

public class User {

private String username;
private String userId;
private List<String> likedCategories;

// Constructor to store the text data of the user
public User(String username, String userId, List<String> likedCategories) {
    this.username = username;
    this.userId = userId;
    this.likedCategories = likedCategories;
}

    // Functions:

    // Getters:

    public String getUsername() {
        return username;
    }

    public String getUserId() {
        return userId;
    }

    public List<String> getLikedCategories() {
        return likedCategories;
    }


    // Validator functions :


    public boolean isValidUsername() {


        // Condition 1: username must not be null or empty
        if (username == null || username.isEmpty()) {
            return false;
        }


        // Condition 2: username must not start with a space
        if (username.charAt(0) == ' ') {
            return false;
        }


        // Condition 3: every character must be a letter or a space
        for (int i = 0; i < username.length(); i++) {

            // get the current character
            char c = username.charAt(i);

            // if the character is NOT a letter AND NOT a space
            // then the username is invalid
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }

       // if the username satisfy all conditions
        return true ;
    }

    public boolean isValidUserId() {

        // Condition 1: userId must not be null or empty
        if (userId == null || userId.isEmpty()) {
            return false;
        }

        // Condition 2: userId must be exactly 9 characters
        if (userId.length() != 9) {
            return false;
        }

        // Condition 3: first 8 characters must ALL be digits
        for (int i = 0; i < 8; i++) {

            // get the current character
            char c = userId.charAt(i);

            // if the character is not a digit → invalid
            if (!Character.isDigit(c)) {
                return false;
            }
        }


        // Condition 4: last character must be a digit or a letter
        char lastChar = userId.charAt(8);

        if (!Character.isDigit(lastChar) && !Character.isLetter(lastChar)) {
            return false;
        }

        // all conditions passed → userId is valid
        return true;

    }


    public boolean isUniqueUserId(List<User> allUsers) {


        // loop through every user in the list to check that there is no similar User id
        for (int i = 0; i < allUsers.size(); i++) {

            // get the current user from the list
            User checkedUser = allUsers.get(i);

            // Condition 2: skip comparing the user with itself
            // if checkedUser is the exact same object as this user → skip it
            if (checkedUser == this) {
                continue;
            }

            // Condition 3: compare the two userIds
            String checkedUserId = checkedUser.getUserId();

            // Condition 4: if they match → userId is not unique
            if (checkedUserId.equals(this.userId)) {
                return false;
            }
        }

        // Condition 5: if no duplicate found so the  userId is unique
        return true;

    }
    
}
