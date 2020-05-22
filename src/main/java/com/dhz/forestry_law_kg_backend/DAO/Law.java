package com.dhz.forestry_law_kg_backend.DAO;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("law")
public class Law {

    @Field("id")
    private String id;

    @Field("name")
    private String name;

    @Field("status")
    private String status;

    @Field("location_dep")
    private String location_dep;

    @Field("year")
    private String year;

    @Field("pub_unit")
    private String pub_unit;

    @Field("pub_time")
    private String pub_time;

    @Field("implement_time")
    private String implement_time;

    @Field("classify")
    private String classify;

    @Field("key_word")
    private String key_word;

    @Field("content_id")
    private String content_id;

    @Field("credit_line")
    private String credit_line;

    @Field("catalogue")
    private String catalogue;

    @Field("content")
    private String content;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation_dep() {
        return location_dep;
    }

    public void setLocation_dep(String location_dep) {
        this.location_dep = location_dep;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPub_unit() {
        return pub_unit;
    }

    public void setPub_unit(String pub_unit) {
        this.pub_unit = pub_unit;
    }

    public String getPub_time() {
        return pub_time;
    }

    public void setPub_time(String pub_time) {
        this.pub_time = pub_time;
    }

    public String getImplement_time() {
        return implement_time;
    }

    public void setImplement_time(String implement_time) {
        this.implement_time = implement_time;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getKey_word() {
        return key_word;
    }

    public void setKey_word(String key_word) {
        this.key_word = key_word;
    }

    public String getContent_id() {
        return content_id;
    }

    public void setContent_id(String content_id) {
        this.content_id = content_id;
    }

    public String getCredit_line() {
        return credit_line;
    }

    public void setCredit_line(String credit_line) {
        this.credit_line = credit_line;
    }

    public String getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(String catalogue) {
        this.catalogue = catalogue;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
