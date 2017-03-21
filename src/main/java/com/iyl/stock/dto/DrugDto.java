package com.iyl.stock.dto;

/*
 * DrugDto
 */
public class DrugDto {

    private String drugCd;
    private String drugNm;
    private String mainIngredientCd;
    private String description;

    public String getDrugCd() {
        return drugCd;
    }

    public void setDrugCd(String drugCd) {
        this.drugCd = drugCd;
    }

    public String getDrugNm() {
        return drugNm;
    }

    public void setDrugNm(String drugNm) {
        this.drugNm = drugNm;
    }

    public String getMainIngredientCd() {
        return mainIngredientCd;
    }

    public void setMainIngredientCd(String mainIngredientCd) {
        this.mainIngredientCd = mainIngredientCd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
