package com.nttdata.glue;
import com.nttdata.steps.PetStoreExam;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;


public class PetStepExamDef {
    @Steps //Notación
    PetStoreExam tienda;
    @Given("la url es {string}")
    public void laUrlEs(String url) {
        tienda.definirURL(url);
    }

       @When("envío una solicitud POST para crear order con los siguientes datos:")

       public void envíoUnaSolicitudPOSTParaCrearOrderConLosSiguientesDatos(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
           tienda.crearOrder(id, petId, quantity, shipDate, status, complete);

    }

    @And("valido que el estado del order sea {string}")
    public void validoQueElEstadoDelOrderSea(String estado) {
        tienda.validarEstadoOrder(estado);
    }

    // Segundo Escenario

    @When("consulto order ID {string}")
    public void consultoOrderID(String idOrder) {
        tienda.consultarOrder(idOrder);
    }



    @And("valido que el ID del order {string}")
    public void validoQueElIDDelOrder(String idOrder) {
        tienda.validarIDOrder(idOrder);
    }

    @Then("valido el código de respuesta como {int}")
    public void validoElCódigoDeRespuestaComo(int statusCode) {
        tienda.ValidarCodigoRespuesta(statusCode);

//

    }
}



