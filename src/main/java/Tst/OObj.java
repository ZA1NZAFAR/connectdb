package Tst;

import lombok.Getter;
import lombok.With;

@Getter
public class OObj {
    @With private int id;
    @With private String name;

    public OObj(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
