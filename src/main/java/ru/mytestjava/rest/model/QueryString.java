package ru.mytestjava.rest.model;


public class QueryString {

    private Integer id;

    private String queryText;

    private int numberOfDigits;

    public QueryString() {
    }

    public QueryString(String queryText) {
        this.queryText = queryText;
        this.numberOfDigits = getDigitsQty(queryText);
    }

    @Override
    public String toString() {
        return "\"" + queryText + "\":" + numberOfDigits;
    }

    public Integer getId() {
        return id;
    }

    public String getQueryText() {
        return queryText;
    }

    public int getNumberOfDigits() {
        return numberOfDigits;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }

    public void setNumberOfDigits(int numberOfDigits) {
        this.numberOfDigits = numberOfDigits;
    }

    public boolean isNew() {
        return (this.id == null);
    }

    public int getDigitsQty(String string) {
        int qty = 0;
        for (char ch : string.toCharArray())
            if ((int) ch > 47 && (int) ch < 58) qty++;
        return qty;
    }
}
