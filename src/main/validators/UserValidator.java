
package validators;


public class UserValidator {

    //validate user name
    // validate username
    public String validateUserName(String name) {

    if (name == null || name.trim().isEmpty()) {
        return "Username ERROR: " + name + " is wrong";
    }

    // Name cannot start with space
    if (Character.isSpaceChar(name.charAt(0))) {
        return "Username ERROR: " + name + " is wrong";
    }

    // Only letters + spaces allowed
    for (char c : name.toCharArray()) {
        if (!(Character.isLetter(c) || c == ' ')) {
            return "Username ERROR: " + name + " is wrong";
        }
    }

    return null; // valid
}
    

    // validate id (length 9, starts with digit, at least one letter)
    // validate user ID (exactly 9 chars, starts with digit, at most one letter at end, unique)
private static final Set<String> usedUserIds = new HashSet<>();

public String validateUserId(String userId) {

    if (userId == null || userId.trim().isEmpty()) {
        return "User Id ERROR: " + userId + " is wrong";
    }

    userId = userId.trim();

    if (userId.length() != 9) {
        return "User Id ERROR: " + userId + " is wrong";
    }

    if (!Character.isDigit(userId.charAt(0))) {
        return "User Id ERROR: " + userId + " is wrong";
    }

    // First 8 characters must be digits
    for (int i = 0; i < 8; i++) {
        if (!Character.isDigit(userId.charAt(i))) {
            return "User Id ERROR: " + userId + " is wrong";
        }
    }

    // Last character can be digit or letter
    char lastChar = userId.charAt(8);
    if (!Character.isDigit(lastChar) && !Character.isLetter(lastChar)) {
        return "User Id ERROR: " + userId + " is wrong";
    }

    // Check global uniqueness
    if (usedUserIds.contains(userId)) {
        return "User Id ERROR: " + userId + " is wrong";
    }
    usedUserIds.add(userId);

    return null; // valid
}
}