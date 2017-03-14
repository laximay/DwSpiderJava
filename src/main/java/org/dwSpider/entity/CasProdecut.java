package org.dwSpider.entity;

/**
 * Created by wenjing on 2017/3/14.
 */
public class CasProdecut {

    private String casName;//化合物英文学名
    private String casNO;//产品编号
    private String synonyms;//同义词
    private String formula;//化学公式
    private String exactMass;//精确质量
    private String molecularWeight;//分子量
    private String psa;
    private String logp;
    private String casUrl;//商品详情页链接

    @Override
    public String toString() {
        return "CasProdecut{" +
                "casName='" + casName + '\'' +
                ", casNO='" + casNO + '\'' +
                ", synonyms='" + synonyms + '\'' +
                ", formula='" + formula + '\'' +
                ", exactMass='" + exactMass + '\'' +
                ", molecularWeight='" + molecularWeight + '\'' +
                ", psa='" + psa + '\'' +
                ", logp='" + logp + '\'' +
                ", casUrl='" + casUrl + '\'' +
                '}';
    }

    public String getCasName() {
        return casName;
    }

    public void setCasName(String casName) {
        this.casName = casName;
    }

    public String getCasNO() {
        return casNO;
    }

    public void setCasNO(String casNO) {
        this.casNO = casNO;
    }

    public String getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(String synonyms) {
        this.synonyms = synonyms;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getExactMass() {
        return exactMass;
    }

    public void setExactMass(String exactMass) {
        this.exactMass = exactMass;
    }

    public String getMolecularWeight() {
        return molecularWeight;
    }

    public void setMolecularWeight(String molecularWeight) {
        this.molecularWeight = molecularWeight;
    }

    public String getPsa() {
        return psa;
    }

    public void setPsa(String psa) {
        this.psa = psa;
    }

    public String getLogp() {
        return logp;
    }

    public void setLogp(String logp) {
        this.logp = logp;
    }

    public String getCasUrl() {
        return casUrl;
    }

    public void setCasUrl(String casUrl) {
        this.casUrl = casUrl;
    }
}
