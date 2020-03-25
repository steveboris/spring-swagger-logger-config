package com.titus.springswaggerlogger.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about the contact") // Help to show class description in the documentation automatically generated from the swagger
public class Contact {

    @ApiModelProperty(notes="The unique id of the contact") // Information for attributes
    private String id;
    @ApiModelProperty(notes="The person's name")
    private String name;
    @ApiModelProperty(notes="The person's phone number")
    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}