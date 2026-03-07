package main;

public class User implements Validatable {

    public String userName;
    public String userID;
    public String[] likedCategories;

    public User(String userName, String userID, String likedCategories) {

    }

    public Movie[] getRecommendations() {

        return null;
    }

    public boolean isValidUserName() {

        return false;
    }

    public boolean isValidUserID() {

        return false;
    }

}
