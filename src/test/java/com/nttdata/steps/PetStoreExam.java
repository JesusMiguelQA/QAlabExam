package com.nttdata.steps;

import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class PetStoreExam {
    Response response;
    private String URL_BASE;

    public void definirURL(String url) {
        URL_BASE = url;
        RestAssured.baseURI = URL_BASE;
     }

      public void crearOrder(int id, int petId, int quantity, String shipDate, String status, boolean complete) {

            String body = "{\n" +
                    "    \"id\": 9222968140,\n" +
                    "    \"petId\": 0,\n" +
                    "    \"quantity\": 0,\n" +
                    "    \"shipDate\": \"2024-12-18T02:17:41.640+0000\",\n" +
                    "    \"status\": \"placed\",\n" +
                    "    \"complete\": true\n" +
                    "}";

                response = RestAssured
                  .given()
                  .relaxedHTTPSValidation()
                  .baseUri(URL_BASE)
                  .body(body)
                  .log().all()
                        .post("/store/order")
                        .then()
                        .log().all()
                        .extract().response();

//
        }
    public void ValidarCodigoRespuesta(int statusCode) {
        Assert.assertEquals("Validación de respuesta" , statusCode, response.statusCode());
    }

    public void validarEstadoOrder(String estado) {
        String estadoObtenido = response.jsonPath().getString("status");
        Assert.assertEquals("El estado del order no es el esperado", estado, estadoObtenido);
    }


    public void consultarOrder(String idOrder) {

    response = given()
                .relaxedHTTPSValidation()
                .baseUri(URL_BASE)
                .get("/store/order/" + idOrder)
                .then()
                .log().all()
                .extract().response();
    }



    public void validarIDOrder(String idOrder) {
        String idOrderObtenido = response.jsonPath().getString("id");
        String idOrderEsperado = response.jsonPath().getString("id");
        Assert.assertEquals("El ID del order no coincide", idOrderEsperado, idOrderObtenido);    }



}
