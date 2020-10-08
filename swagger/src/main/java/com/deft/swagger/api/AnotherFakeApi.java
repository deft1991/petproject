package com.deft.swagger.api;

import com.deft.swagger.model.Client;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * @author Sergey Golitsyn
 * created on 08.10.2020
 */

@Api(value = "another-fake", description = "the another-fake API")
@RequestMapping(value = "/v2")
public interface AnotherFakeApi {

    @ApiOperation(value = "To test special tags", nickname = "testSpecialTags", notes = "To test special tags", response = Client.class, tags = {"$another-fake?",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Client.class)})
    @RequestMapping(value = "/another-fake/dummy",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PATCH)
    ResponseEntity<Client> testSpecialTags(@ApiParam(value = "client model", required = true) @Valid @RequestBody Client body);

}
