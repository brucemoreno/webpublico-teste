package org.acme.controller;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.entity.PessoaFisicaEntity;
import org.acme.service.PessoaFisicaService;
import org.hibernate.boot.model.relational.Sequence;
import org.jboss.logging.annotations.Param;

@Path("/pessoafisica")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class PessoaFisicaController {

    private final PessoaFisicaService pessoaFisicaService;

        public PessoaFisicaController(PessoaFisicaService pessoaFisicaService){
            this.pessoaFisicaService = pessoaFisicaService;
        }


    @GET
    public Response findAll(@QueryParam("page") @DefaultValue("0") Integer page,
                            @QueryParam("pageSize") @DefaultValue("10") Integer pageSize) {
            var pessoaFisica = pessoaFisicaService.findAll(page, pageSize);
        return Response.ok(pessoaFisica).build();
    }
    @POST
    @Transactional
    public Response pessoaFisicaPost(PessoaFisicaEntity pessoaFisicaEntity) {
        return Response.ok(pessoaFisicaService.postPessoaFisica(pessoaFisicaEntity)).build();
    }
    @GET
    @Path("/{id}")
    public Response pessoaFiscaFindById(@PathParam("id") Long id) {
        return Response.ok(pessoaFisicaService.findById(id)).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updatePessoaFisica(@PathParam("id") Long id, PessoaFisicaEntity pessoaFisicaEntity) {
        return Response.ok(pessoaFisicaService.updatePessoaFisica(id, pessoaFisicaEntity)).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletePessoaFisica(@PathParam("id") Long id) {
            pessoaFisicaService.deletePessoaFisica(id);
            return Response.noContent().build();
    }

}