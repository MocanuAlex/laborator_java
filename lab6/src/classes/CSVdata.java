package classes;

public class CSVdata implements Comparable<CSVdata>{
String payment_key;
String trans_type;
String bank_name;

    public CSVdata(String payment_key, String trans_type, String bank_name) {
        this.payment_key = payment_key;
        this.trans_type = trans_type;
        this.bank_name = bank_name;
    }

    public int compareTo(CSVdata other){
        return this.bank_name.compareTo(other.bank_name);
    }

    @Override
    public String toString() {
        return  "payment_key=" + payment_key +
                ", trnas_type=" + trans_type +
                ", bank_name=" + bank_name;
    }
}