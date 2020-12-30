public class Money {

    private int amount;
    private String currencyCode;

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (!(obj instanceof Money)) return false;

        Money that = (Money) obj;

        boolean currencyEquals =
                (this.currencyCode == null && that.currencyCode == null) ||
                        (this.currencyCode != null && this.currencyCode.equals(that.currencyCode));

        return currencyEquals && (this.amount == that.amount);

    }

    public Money(int amount, String currencyCode) {
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
