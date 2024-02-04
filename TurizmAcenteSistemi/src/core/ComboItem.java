package core;

public class ComboItem {
    private int key; // Verinin benzersiz kimliğini temsil eden anahtar
    private String value; // Gösterilecek metni temsil eden değer

    public ComboItem(int key, String value) {
        this.key = key;
        this.value = value;
    }

    // Anahtarı getiren metot
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public String toString() {
        return this.value;
    } // Nesnenin değerini string olarak döndürür
}