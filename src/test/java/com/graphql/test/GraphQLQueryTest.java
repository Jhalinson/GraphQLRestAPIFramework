package com.graphql.test;

import com.graphql.test.pojos.GraphQLQuery;
import com.graphql.test.pojos.QueryVariable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class GraphQLQueryTest {

    @Test
    public void getAllFilmsTest() {
        RestAssured.baseURI = "https://swapi-graphql.netlify.app";
        String query = "{\"query\":\"{\\n  allFilms {\\n    films {\\n      title\\n    }\\n  }\\n}\",\"variables\":null}";
        given().log().all()
                .contentType("application/json")
                .body(query)
                .when().log().all()
                .post("/.netlify/functions/index")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .and()
                .body("data.allFilms.films[0].title", equalTo("A New Hope"));
    }

    @Test
    public void getAllUsers() {
        RestAssured.baseURI = "https://hasura.io";
        String query = "{\"query\":\"query{\\nusers(limit:10){\\n  id\\n  name\\n}}\",\"variables\":null}";
        given().log().all()
                .contentType("application/json")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDYxZDFkY2JkYzFiNmUxMDA3MTJhYzQ3MSJ9LCJuaWNrbmFtZSI6ImpoYWxpbnNvbjc3NyIsIm5hbWUiOiJqaGFsaW5zb243NzdAZ21haWwuY29tIiwicGljdHVyZSI6Imh0dHBzOi8vcy5ncmF2YXRhci5jb20vYXZhdGFyLzNjMjkyMzcxYmEyNjliZmYzMmE4NTIxYWUxMTA2Y2UxP3M9NDgwJnI9cGcmZD1odHRwcyUzQSUyRiUyRmNkbi5hdXRoMC5jb20lMkZhdmF0YXJzJTJGamgucG5nIiwidXBkYXRlZF9hdCI6IjIwMjItMDEtMDJUMTc6MTE6MjYuMTIxWiIsImlzcyI6Imh0dHBzOi8vZ3JhcGhxbC10dXRvcmlhbHMuYXV0aDAuY29tLyIsInN1YiI6ImF1dGgwfDYxZDFkY2JkYzFiNmUxMDA3MTJhYzQ3MSIsImF1ZCI6IlAzOHFuRm8xbEZBUUpyemt1bi0td0V6cWxqVk5HY1dXIiwiaWF0IjoxNjQxMTQzNDg3LCJleHAiOjE2NDExNzk0ODcsImF0X2hhc2giOiJrZFFuT09wQWdtQkl0MENNU19LbFBRIiwibm9uY2UiOiJaUUtJSjRHVW1ESnRsTGU2bk8yZHVBOFpUOUFmTUJDdSJ9.MFUdhGCC-LZEsFNfVNf-FXywnKrIpLU3g80TFdFD_is9FMRKMbHBakAWnSO_ITVLR3X72KBUtF-LT04M7AZzoDoX7j2mp2gV1ozYX2ErCCq731nwOBS_wosU2OzSN4h5dQqWdg5lkhoGq1eszXdJG13nCfcD58ZEpASlsZm-uwJtS4I11Hpumgb5bhuYQJyFYYURZwFgxfqzE1p1KA3qBV0HDtDvYUK5o99OqP4PrfDWi1fMf01CyhyhMewrkKr-hPY7dBh-NCxDFsixKKrba72rBlN5G0Ajadlh_cjaig2oNaKrrtlgdVFz1K_8aUpcGjf3RFDIcn-BRzzpeY61Hw")
//                .auth().oauth2("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDYxZDFkY2JkYzFiNmUxMDA3MTJhYzQ3MSJ9LCJuaWNrbmFtZSI6ImpoYWxpbnNvbjc3NyIsIm5hbWUiOiJqaGFsaW5zb243NzdAZ21haWwuY29tIiwicGljdHVyZSI6Imh0dHBzOi8vcy5ncmF2YXRhci5jb20vYXZhdGFyLzNjMjkyMzcxYmEyNjliZmYzMmE4NTIxYWUxMTA2Y2UxP3M9NDgwJnI9cGcmZD1odHRwcyUzQSUyRiUyRmNkbi5hdXRoMC5jb20lMkZhdmF0YXJzJTJGamgucG5nIiwidXBkYXRlZF9hdCI6IjIwMjItMDEtMDJUMTc6MTE6MjYuMTIxWiIsImlzcyI6Imh0dHBzOi8vZ3JhcGhxbC10dXRvcmlhbHMuYXV0aDAuY29tLyIsInN1YiI6ImF1dGgwfDYxZDFkY2JkYzFiNmUxMDA3MTJhYzQ3MSIsImF1ZCI6IlAzOHFuRm8xbEZBUUpyemt1bi0td0V6cWxqVk5HY1dXIiwiaWF0IjoxNjQxMTQzNDg3LCJleHAiOjE2NDExNzk0ODcsImF0X2hhc2giOiJrZFFuT09wQWdtQkl0MENNU19LbFBRIiwibm9uY2UiOiJaUUtJSjRHVW1ESnRsTGU2bk8yZHVBOFpUOUFmTUJDdSJ9.MFUdhGCC-LZEsFNfVNf-FXywnKrIpLU3g80TFdFD_is9FMRKMbHBakAWnSO_ITVLR3X72KBUtF-LT04M7AZzoDoX7j2mp2gV1ozYX2ErCCq731nwOBS_wosU2OzSN4h5dQqWdg5lkhoGq1eszXdJG13nCfcD58ZEpASlsZm-uwJtS4I11Hpumgb5bhuYQJyFYYURZwFgxfqzE1p1KA3qBV0HDtDvYUK5o99OqP4PrfDWi1fMf01CyhyhMewrkKr-hPY7dBh-NCxDFsixKKrba72rBlN5G0Ajadlh_cjaig2oNaKrrtlgdVFz1K_8aUpcGjf3RFDIcn-BRzzpeY61Hw")
                .body(query)
                .when().log().all()
                .post("/learn/graphql")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .and()
                .body("data.users[0].name", equalTo("tui.glen"));
    }

    @DataProvider
    public Object[] getQueryData() {
        return new Object[][]{{"2"}};
    }

    @Test(dataProvider = "getQueryData")
    public void getAllUsersTestWithDataTest(String limit) {
        RestAssured.baseURI = "https://hasura.io";
        String query = "{\"query\":\"query{\\nusers(limit:" + limit + "){\\n  id\\n  name\\n}}\",\"variables\":null}";
        given().log().all()
                .contentType("application/json")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDYxZDFkY2JkYzFiNmUxMDA3MTJhYzQ3MSJ9LCJuaWNrbmFtZSI6ImpoYWxpbnNvbjc3NyIsIm5hbWUiOiJqaGFsaW5zb243NzdAZ21haWwuY29tIiwicGljdHVyZSI6Imh0dHBzOi8vcy5ncmF2YXRhci5jb20vYXZhdGFyLzNjMjkyMzcxYmEyNjliZmYzMmE4NTIxYWUxMTA2Y2UxP3M9NDgwJnI9cGcmZD1odHRwcyUzQSUyRiUyRmNkbi5hdXRoMC5jb20lMkZhdmF0YXJzJTJGamgucG5nIiwidXBkYXRlZF9hdCI6IjIwMjItMDEtMDJUMTc6MTE6MjYuMTIxWiIsImlzcyI6Imh0dHBzOi8vZ3JhcGhxbC10dXRvcmlhbHMuYXV0aDAuY29tLyIsInN1YiI6ImF1dGgwfDYxZDFkY2JkYzFiNmUxMDA3MTJhYzQ3MSIsImF1ZCI6IlAzOHFuRm8xbEZBUUpyemt1bi0td0V6cWxqVk5HY1dXIiwiaWF0IjoxNjQxMTQzNDg3LCJleHAiOjE2NDExNzk0ODcsImF0X2hhc2giOiJrZFFuT09wQWdtQkl0MENNU19LbFBRIiwibm9uY2UiOiJaUUtJSjRHVW1ESnRsTGU2bk8yZHVBOFpUOUFmTUJDdSJ9.MFUdhGCC-LZEsFNfVNf-FXywnKrIpLU3g80TFdFD_is9FMRKMbHBakAWnSO_ITVLR3X72KBUtF-LT04M7AZzoDoX7j2mp2gV1ozYX2ErCCq731nwOBS_wosU2OzSN4h5dQqWdg5lkhoGq1eszXdJG13nCfcD58ZEpASlsZm-uwJtS4I11Hpumgb5bhuYQJyFYYURZwFgxfqzE1p1KA3qBV0HDtDvYUK5o99OqP4PrfDWi1fMf01CyhyhMewrkKr-hPY7dBh-NCxDFsixKKrba72rBlN5G0Ajadlh_cjaig2oNaKrrtlgdVFz1K_8aUpcGjf3RFDIcn-BRzzpeY61Hw")
//                .auth().oauth2("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDYxZDFkY2JkYzFiNmUxMDA3MTJhYzQ3MSJ9LCJuaWNrbmFtZSI6ImpoYWxpbnNvbjc3NyIsIm5hbWUiOiJqaGFsaW5zb243NzdAZ21haWwuY29tIiwicGljdHVyZSI6Imh0dHBzOi8vcy5ncmF2YXRhci5jb20vYXZhdGFyLzNjMjkyMzcxYmEyNjliZmYzMmE4NTIxYWUxMTA2Y2UxP3M9NDgwJnI9cGcmZD1odHRwcyUzQSUyRiUyRmNkbi5hdXRoMC5jb20lMkZhdmF0YXJzJTJGamgucG5nIiwidXBkYXRlZF9hdCI6IjIwMjItMDEtMDJUMTc6MTE6MjYuMTIxWiIsImlzcyI6Imh0dHBzOi8vZ3JhcGhxbC10dXRvcmlhbHMuYXV0aDAuY29tLyIsInN1YiI6ImF1dGgwfDYxZDFkY2JkYzFiNmUxMDA3MTJhYzQ3MSIsImF1ZCI6IlAzOHFuRm8xbEZBUUpyemt1bi0td0V6cWxqVk5HY1dXIiwiaWF0IjoxNjQxMTQzNDg3LCJleHAiOjE2NDExNzk0ODcsImF0X2hhc2giOiJrZFFuT09wQWdtQkl0MENNU19LbFBRIiwibm9uY2UiOiJaUUtJSjRHVW1ESnRsTGU2bk8yZHVBOFpUOUFmTUJDdSJ9.MFUdhGCC-LZEsFNfVNf-FXywnKrIpLU3g80TFdFD_is9FMRKMbHBakAWnSO_ITVLR3X72KBUtF-LT04M7AZzoDoX7j2mp2gV1ozYX2ErCCq731nwOBS_wosU2OzSN4h5dQqWdg5lkhoGq1eszXdJG13nCfcD58ZEpASlsZm-uwJtS4I11Hpumgb5bhuYQJyFYYURZwFgxfqzE1p1KA3qBV0HDtDvYUK5o99OqP4PrfDWi1fMf01CyhyhMewrkKr-hPY7dBh-NCxDFsixKKrba72rBlN5G0Ajadlh_cjaig2oNaKrrtlgdVFz1K_8aUpcGjf3RFDIcn-BRzzpeY61Hw")
                .body(query)
                .when().log().all()
                .post("/learn/graphql")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .and()
                .body("data.users[0].name", equalTo("tui.glen"));
    }

    @Test
    public void getAllUsersWithPojoTest() {
        RestAssured.baseURI = "https://hasura.io";
        GraphQLQuery graphQLQuery = new GraphQLQuery();

        graphQLQuery.setQuery("query($limit:Int!){\n" +
                "  users(limit: $limit) {\n" +
                "    name\n" +
                "    id\n" +
                "  }\n" +
                "}");

        QueryVariable queryVariable = QueryVariable.builder().limit(10).build();


        graphQLQuery.setVariables(queryVariable);

        given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDYxZDFkY2JkYzFiNmUxMDA3MTJhYzQ3MSJ9LCJuaWNrbmFtZSI6ImpoYWxpbnNvbjc3NyIsIm5hbWUiOiJqaGFsaW5zb243NzdAZ21haWwuY29tIiwicGljdHVyZSI6Imh0dHBzOi8vcy5ncmF2YXRhci5jb20vYXZhdGFyLzNjMjkyMzcxYmEyNjliZmYzMmE4NTIxYWUxMTA2Y2UxP3M9NDgwJnI9cGcmZD1odHRwcyUzQSUyRiUyRmNkbi5hdXRoMC5jb20lMkZhdmF0YXJzJTJGamgucG5nIiwidXBkYXRlZF9hdCI6IjIwMjItMDEtMDJUMTc6MTE6MjYuMTIxWiIsImlzcyI6Imh0dHBzOi8vZ3JhcGhxbC10dXRvcmlhbHMuYXV0aDAuY29tLyIsInN1YiI6ImF1dGgwfDYxZDFkY2JkYzFiNmUxMDA3MTJhYzQ3MSIsImF1ZCI6IlAzOHFuRm8xbEZBUUpyemt1bi0td0V6cWxqVk5HY1dXIiwiaWF0IjoxNjQxMTQzNDg3LCJleHAiOjE2NDExNzk0ODcsImF0X2hhc2giOiJrZFFuT09wQWdtQkl0MENNU19LbFBRIiwibm9uY2UiOiJaUUtJSjRHVW1ESnRsTGU2bk8yZHVBOFpUOUFmTUJDdSJ9.MFUdhGCC-LZEsFNfVNf-FXywnKrIpLU3g80TFdFD_is9FMRKMbHBakAWnSO_ITVLR3X72KBUtF-LT04M7AZzoDoX7j2mp2gV1ozYX2ErCCq731nwOBS_wosU2OzSN4h5dQqWdg5lkhoGq1eszXdJG13nCfcD58ZEpASlsZm-uwJtS4I11Hpumgb5bhuYQJyFYYURZwFgxfqzE1p1KA3qBV0HDtDvYUK5o99OqP4PrfDWi1fMf01CyhyhMewrkKr-hPY7dBh-NCxDFsixKKrba72rBlN5G0Ajadlh_cjaig2oNaKrrtlgdVFz1K_8aUpcGjf3RFDIcn-BRzzpeY61Hw")
//                .auth().oauth2("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDYxZDFkY2JkYzFiNmUxMDA3MTJhYzQ3MSJ9LCJuaWNrbmFtZSI6ImpoYWxpbnNvbjc3NyIsIm5hbWUiOiJqaGFsaW5zb243NzdAZ21haWwuY29tIiwicGljdHVyZSI6Imh0dHBzOi8vcy5ncmF2YXRhci5jb20vYXZhdGFyLzNjMjkyMzcxYmEyNjliZmYzMmE4NTIxYWUxMTA2Y2UxP3M9NDgwJnI9cGcmZD1odHRwcyUzQSUyRiUyRmNkbi5hdXRoMC5jb20lMkZhdmF0YXJzJTJGamgucG5nIiwidXBkYXRlZF9hdCI6IjIwMjItMDEtMDJUMTc6MTE6MjYuMTIxWiIsImlzcyI6Imh0dHBzOi8vZ3JhcGhxbC10dXRvcmlhbHMuYXV0aDAuY29tLyIsInN1YiI6ImF1dGgwfDYxZDFkY2JkYzFiNmUxMDA3MTJhYzQ3MSIsImF1ZCI6IlAzOHFuRm8xbEZBUUpyemt1bi0td0V6cWxqVk5HY1dXIiwiaWF0IjoxNjQxMTQzNDg3LCJleHAiOjE2NDExNzk0ODcsImF0X2hhc2giOiJrZFFuT09wQWdtQkl0MENNU19LbFBRIiwibm9uY2UiOiJaUUtJSjRHVW1ESnRsTGU2bk8yZHVBOFpUOUFmTUJDdSJ9.MFUdhGCC-LZEsFNfVNf-FXywnKrIpLU3g80TFdFD_is9FMRKMbHBakAWnSO_ITVLR3X72KBUtF-LT04M7AZzoDoX7j2mp2gV1ozYX2ErCCq731nwOBS_wosU2OzSN4h5dQqWdg5lkhoGq1eszXdJG13nCfcD58ZEpASlsZm-uwJtS4I11Hpumgb5bhuYQJyFYYURZwFgxfqzE1p1KA3qBV0HDtDvYUK5o99OqP4PrfDWi1fMf01CyhyhMewrkKr-hPY7dBh-NCxDFsixKKrba72rBlN5G0Ajadlh_cjaig2oNaKrrtlgdVFz1K_8aUpcGjf3RFDIcn-BRzzpeY61Hw")
                .body(graphQLQuery)
                .when().log().all()
                .post("/learn/graphql")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .and()
                .body("data.users[0].name", equalTo("tui.glen"));
    }
}
