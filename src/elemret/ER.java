package elemret;

import arc.*;
import arc.util.*;
import elemret.content.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

public class ER extends Mod{

    public ER(){
    }

    @Override
    public void loadContent(){
        Log.info("Loading some example content.");
        ERItems.load();
        ERLiquids.load();
        ERUnits.load();
        ERBlocks.load();
        ERSectors.load();
        ERTechTree.load();
    }

}
