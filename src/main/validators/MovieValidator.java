package validators;

import Movie;
import java.util.HashSet;
import java.util.Set;

public class MovieValidator {

    private static final Set<String> usedNumbers = new HashSet<>();
    private static final Set<String> ALLOWED_CATEGORIES = Set.of("horror", "action", "drama","family","adventure","animation","crime","comedy","romance","war");

    public static void reset() {
        usedNumbers.clear();
    }

    public static void validate(Movie movie) throws ValidationException {

        // validate title
        if (!isValidTitle(movie.getTitle())) {
            throw new ValidationException("Movie Title ERROR: " + movie.getTitle() + " is wrong");
        }

        // validate movie id letters
        String capsFromTitle = extractCapitals(movie.getTitle());
        if (!movie.getId().startsWith(capsFromTitle)) {
            throw new ValidationException("Movie Id letters ERROR: " + movie.getId() + " are wrong");
        }

        // validate vovie id numbers
        String idNumbers = movie.getId().substring(capsFromTitle.length());
        if (!isValidNumberSuffix(idNumbers)) {
            throw new ValidationException("Movie Id numbers ERROR: " + movie.getId() + " aren't unique");
        }
        usedNumbers.add(idNumbers);

        // validate category
        if (!ALLOWED_CATEGORIES.contains(movie.getCategory().toLowerCase())) {
            throw new ValidationException("Movie Category ERROR: " + movie.getCategory() + " is invalid");
        }
    }

    //adding helper functions
    private static boolean isValidTitle(String title) {
        if (title == null || title.trim().isEmpty()) return false;
        String[] words = title.split("\\s+");
        for (String word : words) {
            if (word.isEmpty() || !Character.isUpperCase(word.charAt(0))) {
                return false;
            }
        }
        return true;
    }

    private static String extractCapitals(String title) {
        StringBuilder sb = new StringBuilder();
        for (char c : title.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static boolean isValidNumberSuffix(String suffix) {
        return suffix.matches("\\d{3}") && !usedNumbers.contains(suffix);// Must be exactly 3 digits and globally unique
    }
}