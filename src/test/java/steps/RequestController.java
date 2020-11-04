package steps;

import net.serenitybdd.rest.SerenityRest;

public class RequestController {

    BusinessController businessController = new BusinessController();

    public void requestQueryKeyword(String place) {

        SerenityRest.given()
                .queryParam("query", place)
                .queryParam("key", "AIzaSyB0yh4U2BOwEJeNqCkBe9Gws977i8koYbI")
                .contentType("application/json")
                .post(businessController.getURLQueryKeyword());

    }

    public void requestQueryPlace(String placeId) {

        SerenityRest.given()
                .queryParam("place_id", placeId)
                .queryParam("key", "AIzaSyB0yh4U2BOwEJeNqCkBe9Gws977i8koYbI")
                .contentType("application/json")
                .post(businessController.getURLQueryPlace());

    }
}
