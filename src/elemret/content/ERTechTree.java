package elemret.content;

import arc.struct.*;
import mindustry.content.*;
import mindustry.game.Objectives.*;

import static mindustry.content.Blocks.*;
import static mindustry.content.Items.*;
import static mindustry.content.SectorPresets.*;
import static mindustry.content.TechTree.*;
import static mindustry.content.UnitTypes.*;

public class ERTechTree {
    public static void load() {
        Planets.serpulo.techTree = nodeRoot("element", coreShard, () -> {


            node(conveyor, () -> {

            });
        });
    }
}
