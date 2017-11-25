package com.chatbot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Document(collection = "product")
public class Product  {

    @Id
    private String id;

    private String name;

    private String image;

    private BigInteger price;

    @JsonIgnore
    @DBRef
    private Category category;

    @JsonIgnore
    private List<String> tags =  new ArrayList<>();


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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public List<String> getTagList() {
        return tags;
    }

    public void setTagList(List<String> tagList) {
        this.tags = tagList;
    }

    public void addTags(String [] tagArray){
        tags.addAll(Arrays.asList(tagArray));
    }
}
