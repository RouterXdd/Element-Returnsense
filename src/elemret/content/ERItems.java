package elemret.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.type.*;

public class ERItems {
    public static Item emptyCrystal, waterCrystal, flameCrystal, toxicCrystal, windCrystal, iceCrystal, electroCrystal, elementCrystal;

    public static void load(){
        emptyCrystal = new Item("empty-crystal", Color.valueOf("c4c4c4")){{
            hardness = 2;
            cost = 1.2f;
        }};
        waterCrystal = new Item("water-crystal", Color.valueOf("2a60bc")){{
            hardness = 2;
            cost = 1.2f;
        }};
        flameCrystal = new Item("fire-crystal", Color.valueOf("c1441e")){{
            hardness = 2;
            cost = 1.2f;
            flammability = 1.5f;
        }};
        windCrystal = new Item("air-crystal", Color.valueOf("2994c5")){{
            hardness = 2;
            cost = 1.2f;
        }};
        iceCrystal = new Item("ice-crystal", Color.valueOf("5dadd2")){{
            hardness = 2;
            cost = 1.2f;
        }};
        electroCrystal = new Item("electro-crystal", Color.valueOf("8e31c0")){{
            hardness = 2;
            cost = 1.6f;
            charge = 1.5f;
        }};
        toxicCrystal = new Item("toxic-crystal", Color.valueOf("30a61d")){{
            hardness = 2;
            cost = 1.6f;
        }};
        elementCrystal = new Item("element-crystal", Color.valueOf("1b1b1b")){{
            hardness = 2;
            cost = 3.2f;
        }};
    }
}
