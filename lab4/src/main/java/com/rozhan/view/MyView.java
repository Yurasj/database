package com.rozhan.view;

import com.rozhan.controller.ActorController;
import com.rozhan.controller.AwardController;
import com.rozhan.controller.CompanyController;
import com.rozhan.controller.LanguageController;
import com.rozhan.controller.MovieController;
import com.rozhan.controller.ReviewController;
import com.rozhan.domain.Actor;
import com.rozhan.domain.Award;
import com.rozhan.domain.Company;
import com.rozhan.domain.Language;
import com.rozhan.domain.Movie;
import com.rozhan.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MyView {

    @Autowired
    private ActorController actorController;
    @Autowired
    private AwardController awardController;
    @Autowired
    private CompanyController companyController;
    @Autowired
    private LanguageController languageController;
    @Autowired
    private MovieController movieController;
    @Autowired
    private ReviewController reviewController;

    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private final Scanner input = new Scanner(System.in);
    private final Actor nullActor = new Actor(null, null, null, null);
    private final Award nullAward = new Award(null, null);
    private final Company nullCompany = new Company(null, null, null);
    private final Language nullLanguage = new Language(null, null);
    private final Movie nullMovie = new Movie(null, null, null, null, null, null, null);
    private final Review nullReview = new Review(null, null, null, null);

    public MyView() {
        menu = new LinkedHashMap<>();
        menu.put("A", "  A - Select all table");

        menu.put("1", "   1 - Table: Actor");
        menu.put("11", "  11 - Create Actor");
        menu.put("12", "  12 - Update Actor");
        menu.put("13", "  13 - Delete from Actor");
        menu.put("14", "  14 - Find all Actors");
        menu.put("15", "  15 - Find Actor by ID");

        menu.put("2", "   2 - Table: Award");
        menu.put("21", "  21 - Create Award");
        menu.put("22", "  22 - Update Award");
        menu.put("23", "  23 - Delete from Award");
        menu.put("24", "  24 - Find all Awards");
        menu.put("25", "  25 - Find Award by ID");

        menu.put("3", "   3 - Table: Company");
        menu.put("31", "  31 - Create Company");
        menu.put("32", "  32 - Update Company");
        menu.put("33", "  33 - Delete from Company");
        menu.put("34", "  34 - Find all Companies");
        menu.put("35", "  35 - Find Company by ID");

        menu.put("4", "   4 - Table: Language");
        menu.put("41", "  41 - Create Language");
        menu.put("42", "  42 - Update Language");
        menu.put("43", "  43 - Delete from Language");
        menu.put("44", "  44 - Find all Languages");
        menu.put("45", "  45 - Find Language by ID");

        menu.put("5", "   5 - Table: Movie");
        menu.put("51", "  51 - Create Movie");
        menu.put("52", "  52 - Update Movie");
        menu.put("53", "  53 - Delete from Movie");
        menu.put("54", "  54 - Find all Movies");
        menu.put("55", "  55 - Find Movie by ID");

        menu.put("6", "   6 - Table: Review");
        menu.put("61", "  61 - Create Review");
        menu.put("62", "  62 - Update Review");
        menu.put("63", "  63 - Delete from Review");
        menu.put("64", "  64 - Find all Reviews");
        menu.put("65", "  65 - Find Review by ID");

        menu.put("Q", "  Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("A", this::selectAllTable);

        methodsMenu.put("11", this::createActor);
        methodsMenu.put("12", this::updateActor);
        methodsMenu.put("13", this::deleteFromActor);
        methodsMenu.put("14", this::findAllActors);
        methodsMenu.put("15", this::findActorById);

        methodsMenu.put("21", this::createAward);
        methodsMenu.put("22", this::updateAward);
        methodsMenu.put("23", this::deleteFromAward);
        methodsMenu.put("24", this::findAllAwards);
        methodsMenu.put("25", this::findAwardById);

        methodsMenu.put("31", this::createCompany);
        methodsMenu.put("32", this::updateCompany);
        methodsMenu.put("33", this::deleteFromCompany);
        methodsMenu.put("34", this::findAllCompanies);
        methodsMenu.put("35", this::findCompanyById);

        methodsMenu.put("41", this::createLanguage);
        methodsMenu.put("42", this::updateLanguage);
        methodsMenu.put("43", this::deleteFromLanguage);
        methodsMenu.put("44", this::findAllLanguages);
        methodsMenu.put("45", this::findLanguageById);

        methodsMenu.put("51", this::createMovie);
        methodsMenu.put("52", this::updateMovie);
        methodsMenu.put("53", this::deleteFromMovie);
        methodsMenu.put("54", this::findAllMovies);
        methodsMenu.put("55", this::findMovieById);

        methodsMenu.put("61", this::createReview);
        methodsMenu.put("62", this::updateReview);
        methodsMenu.put("63", this::deleteFromReview);
        methodsMenu.put("64", this::findAllReviews);
        methodsMenu.put("65", this::findReviewById);
    }

    private void selectAllTable() {
        findAllActors();
        findAllAwards();
        findAllCompanies();
        findAllLanguages();
        findAllMovies();
        findAllReviews();
    }

    // region ACTOR ---------------------------------------------------
    private void createActor() {
        System.out.println("Input 'full_name': ");
        String full_name = input.nextLine();
        System.out.println("Input 'bio': ");
        String bio = input.nextLine();
        System.out.println("Input 'age': ");
        Integer age = Integer.valueOf((input.nextLine()));
        Actor actor = new Actor(null, full_name, bio, age);

        int count = actorController.create(actor);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateActor() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'full_name': ");
        String full_name = input.nextLine();
        System.out.println("Input new 'bio': ");
        String bio = input.nextLine();
        System.out.println("Input new 'age': ");
        Integer age = Integer.valueOf((input.nextLine()));
        Actor actor = new Actor(null, full_name, bio, age);

        int count = actorController.update(id, actor);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromActor() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = actorController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllActors() {
        System.out.println("\nTable: ACTOR");
        List<Actor> actors = actorController.findAll();
        for (Actor actor : actors) {
            System.out.println(actor);
        }
    }

    private void findActorById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Actor> actor = actorController.findById(id);
        System.out.println(actor.orElse(nullActor));
    }

    // region AWARD ---------------------------------------------------
    private void createAward() {
        System.out.println("Input 'award_name': ");
        String awardName = input.nextLine();

        Award award = new Award(null, awardName);

        int count = awardController.create(award);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateAward() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'award_name': ");
        String awardName = input.nextLine();

        Award award = new Award(null, awardName);

        int count = awardController.update(id, award);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromAward() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = awardController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllAwards() {
        System.out.println("\nTable: AWARD");
        List<Award> awards = awardController.findAll();
        for (Award award : awards) {
            System.out.println(award);
        }
    }

    private void findAwardById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Award> award = awardController.findById(id);
        System.out.println(award.orElse(nullAward));
    }

    // region COMPANY ---------------------------------------------------
    private void createCompany() {
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'info': ");
        String info = input.nextLine();
        Company company = new Company(null, name, info);

        int count = companyController.create(company);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateCompany() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'name': ");
        String name = input.nextLine();
        System.out.println("Input new 'info': ");
        String info = input.nextLine();
        Company company = new Company(null, name, info);

        int count = companyController.update(id, company);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromCompany() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = companyController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllCompanies() {
        System.out.println("\nTable: COMPANY");
        List<Company> companies = companyController.findAll();
        for (Company company : companies) {
            System.out.println(company);
        }
    }

    private void findCompanyById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Company> company = companyController.findById(id);
        System.out.println(company.orElse(nullCompany));
    }

    // region LANGUAGE ---------------------------------------------------
    private void createLanguage() {
        System.out.println("Input 'language': ");
        String languageName = input.nextLine();

        Language language = new Language(null, languageName);

        int count = languageController.create(language);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateLanguage() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'language': ");
        String languageName = input.nextLine();

        Language language = new Language(null, languageName);

        int count = languageController.update(id, language);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromLanguage() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = languageController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllLanguages() {
        System.out.println("\nTable: LANGUAGE");
        List<Language> languages = languageController.findAll();
        for (Language language : languages) {
            System.out.println(language);
        }
    }

    private void findLanguageById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Language> language = languageController.findById(id);
        System.out.println(language.orElse(nullLanguage));
    }

    // region MOVIE -------------------------------------------------
    private void createMovie() {
        System.out.println("Input 'company_id': ");
        Integer company_id = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'language_id': ");
        Integer language_id = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'actor_id': ");
        Integer actor_id = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'award_id': ");
        Integer award_id = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'info': ");
        String info = input.nextLine();

        Movie movie = new Movie(null, company_id, language_id, actor_id, award_id, name, info );

        int count = movieController.create(movie);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateMovie() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'company_id': ");
        Integer company_id = Integer.valueOf((input.nextLine()));
        System.out.println("Input new 'language_id': ");
        Integer language_id = Integer.valueOf((input.nextLine()));
        System.out.println("Input new 'actor_id': ");
        Integer actor_id = Integer.valueOf((input.nextLine()));
        System.out.println("Input new 'award_id': ");
        Integer award_id = Integer.valueOf((input.nextLine()));
        System.out.println("Input new 'name': ");
        String name = input.nextLine();
        System.out.println("Input new 'info': ");
        String info = input.nextLine();

        Movie movie = new Movie(null, company_id, language_id, actor_id, award_id, name, info );

        int count = movieController.update(id, movie);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromMovie() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = movieController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllMovies() {
        System.out.println("\nTable: MOVIE");
        List<Movie> movies = movieController.findAll();
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    private void findMovieById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Movie> movie = movieController.findById(id);
        System.out.println(movie.orElse(nullMovie));
    }

    // region Review ---------------------------------------------------
    private void createReview() {
        System.out.println("Input 'comment': ");
        String comment = input.nextLine();
        System.out.println("Input 'rating': ");
        Integer rating = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'movie_id': ");
        Integer movie_id = Integer.valueOf((input.nextLine()));

        Review review = new Review(null, comment, rating, movie_id);

        int count = reviewController.create(review);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateReview() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'comment': ");
        String comment = input.nextLine();
        System.out.println("Input new 'rating': ");
        Integer rating = Integer.valueOf((input.nextLine()));
        System.out.println("Input new 'movie_id': ");
        Integer movie_id = Integer.valueOf((input.nextLine()));

        Review review = new Review(null, comment, rating, movie_id);

        int count = reviewController.update(id, review);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromReview() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = reviewController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllReviews() {
        System.out.println("\nTable: REVIEW");
        List<Review> reviews = reviewController.findAll();
        for (Review review : reviews) {
            System.out.println(review);
        }
    }

    private void findReviewById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Review> review = reviewController.findById(id);
        System.out.println(review.orElse(nullReview));
    }

    // region output
    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu(String fig) {

        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!keyMenu.equals("Q"));
    }
}
