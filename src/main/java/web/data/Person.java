package web.data;

import lombok.Data;

@Data
public class Person {
    String name;
    String address;

    public Person(String a, String b){
        this.name = a;
        this.address = b;
    }

}
