package com.lanou3g.admin.Category.domain;

public class Category {
    private String javaSE;
    private String javaEE;
    private String javaScript;

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" +
                "javaSE='" + javaSE + '\'' +
                ", javaEE='" + javaEE + '\'' +
                ", javaScript='" + javaScript + '\'' +
                '}';
    }

    public String getJavaSE() {
        return javaSE;
    }

    public void setJavaSE(String javaSE) {
        this.javaSE = javaSE;
    }

    public String getJavaEE() {
        return javaEE;
    }

    public void setJavaEE(String javaEE) {
        this.javaEE = javaEE;
    }

    public String getJavaScript() {
        return javaScript;
    }

    public void setJavaScript(String javaScript) {
        this.javaScript = javaScript;
    }

    public Category(String javaSE, String javaEE, String javaScript) {
        this.javaSE = javaSE;
        this.javaEE = javaEE;
        this.javaScript = javaScript;
    }
}
