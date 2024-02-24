package elemret.content;

import arc.struct.*;
import mindustry.content.*;
import mindustry.game.Objectives.*;

import static mindustry.content.Blocks.*;
import static mindustry.content.Items.*;
import static mindustry.content.SectorPresets.*;
import static mindustry.content.TechTree.*;
import static mindustry.content.UnitTypes.*;
import static elemret.content.ERBlocks.*;
import static elemret.content.ERItems.*;
import static elemret.content.ERSectors.*;
import static elemret.content.ERUnits.*;

public class ERTechTree {
    public static void load() {
        nodeRoot("element", crystalConstructor, () -> {

            node(electroCondenser, () -> {

            });
            nodeProduce(emptyCrystal, () -> {
                nodeProduce(electroCrystal, () -> {

                });
                nodeProduce(toxicCrystal, () -> {

                });
                nodeProduce(elementCrystal, () -> {

                });
                nodeProduce(windCrystal, () -> {

                });
                nodeProduce(flameCrystal, () -> {

                });
                nodeProduce(waterCrystal, () -> {

                });
                nodeProduce(iceCrystal, () -> {

                });
            });

        });
    }
}
