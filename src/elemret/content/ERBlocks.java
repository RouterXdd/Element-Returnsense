package elemret.content;

import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.DrawPart.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;

public class ERBlocks {
    public static Block
            //factory
    crystalConstructor, electroCondenser,
            //water
            zircon,
            //flame

            //toxic

            //wind

            //ice

            //electro

            //endgame
    liod,
            b;

    public static void load(){
        //factory
        crystalConstructor = new GenericCrafter("crystal-constructor"){{
            requirements(Category.crafting, with(Items.copper, 90, Items.silicon, 60, Items.lead, 90, Items.titanium, 45));
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(ERItems.emptyCrystal, 1);
            craftTime = 90f;
            size = 2;
            hasPower = true;
            itemCapacity = 30;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame());

            consumePower(2.6f);
            consumeItems(with(Items.metaglass, 3));
        }};
        electroCondenser = new GenericCrafter("electro-condenser"){{
            requirements(Category.crafting, with(Items.silicon, 160, Items.lead, 110, Items.thorium, 90, Items.titanium, 60));
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(ERItems.electroCrystal, 1);
            craftTime = 130f;
            size = 3;
            hasPower = true;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawWeave(), new DrawDefault());

            ambientSound = Sounds.techloop;
            ambientSoundVolume = 0.02f;

            consumeItems(with(ERItems.emptyCrystal, 1));
            consumePower(8f);
            itemCapacity = 10;
        }};
        //water
        zircon = new ItemTurret("zircon"){{
            range = 120f;

            requirements(Category.turret, with(Items.copper, 170, Items.lead, 90, Items.silicon, 130, ERItems.waterCrystal, 50));
            ammo(
                    ERItems.waterCrystal, new BasicBulletType(){{
                        width = 7f;
                        height = 11f;
                        damage = 6f;
                        lifetime = 30;
                        buildingDamageMultiplier = 0.4f;
                        speed = 4f;
                        hitShake = 0.2f;
                        ammoMultiplier = 1f;
                        homingPower = 0.6f;
                    }}
            );
            shoot = new ShootSummon(0f, 0f, 2, 56f);
            maxAmmo = 30;
            ammoPerShot = 1;
            reload = 6f;
            size = 1;
            unitSort = UnitSorts.weakest;

            coolantMultiplier = 0.4f;
            scaledHealth = 120;

            coolant = consumeCoolant(0.2f);
        }};
        //endgame
        liod = new PowerTurret("liod"){{
            requirements(Category.turret, with(Items.silicon, 340, Items.lead, 270, Items.thorium, 160, Items.surgeAlloy, 120, ERItems.elementCrystal, 60));

            shootType = new BasicBulletType(){{
                shootEffect = new MultiEffect(Fx.shootTitan, new WaveEffect(){{
                    colorTo = Pal.darkMetal;
                    sizeTo = 26f;
                    lifetime = 14f;
                    strokeFrom = 4f;
                }});
                smokeEffect = Fx.shootSmokeTitan;
                hitColor = Pal.darkMetal;
                coolant = consumeCoolant(1f);
                sprite = "large-orb";
                trailEffect = Fx.missileTrail;
                trailInterval = 3f;
                trailParam = 4f;
                pierce = true;
                pierceBuilding = true;
                speed = 3f;
                lifetime = 120f;
                damage = 0;
                width = height = 16f;
                backColor = Pal.darkMetal;
                frontColor = Color.gray;
                shrinkX = shrinkY = 0f;
                homingRange = 20f;
                homingPower = 0.5f;
                trailColor = Pal.darkMetal;
                trailLength = 4;
                trailWidth = 2.2f;
                heatColor = Pal.lightFlame;
                despawnEffect = hitEffect = new ExplosionEffect(){{
                    waveColor = Pal.darkMetal;
                    smokeColor = Color.gray;
                    sparkColor = Pal.darkerGray;
                    waveStroke = 4f;
                    waveRad = 40f;
                }};
                despawnSound = Sounds.dullExplosion;
                shootSound = Sounds.cannon;

                intervalBullet = new BasicBulletType(3f, 40){{
                    width = 9f;
                    hitSize = 5f;
                    height = 15f;
                    pierce = true;
                    lifetime = 30f;
                    pierceBuilding = true;
                    hitColor = backColor = trailColor = Pal.darkMetal;
                    frontColor = Color.gray;
                    trailWidth = 2.1f;
                    trailLength = 5;
                    hitEffect = despawnEffect = new WaveEffect(){{
                        colorFrom = colorTo = Pal.darkerGray;
                        sizeTo = 4f;
                        strokeFrom = 4f;
                        lifetime = 10f;
                    }};
                    buildingDamageMultiplier = 0.3f;
                    homingPower = 0.2f;
                }};

                bulletInterval = 8f;
                intervalRandomSpread = 360f;
                intervalBullets = 3;
                intervalAngle = 360f;
                intervalSpread = 300f;
            }};

            drawer = new DrawTurret(){{
                parts.add(new RegionPart("-blade"){{
                              progress = PartProgress.recoil;
                              heatColor = Color.valueOf("ff6214");
                              mirror = true;
                              under = true;
                              moveX = 2f;
                              moveY = -1f;
                              moveRot = -7f;
                          }});
            }};

            consumePower(17.4f);

            inaccuracy = 1f;
            shake = 2f;
            shootY = 4;
            size = 4;
            reload = 100f;
            cooldownTime = reload;
            recoil = 3f;
            range = 360;
            shootCone = 20f;
            scaledHealth = 220;
            rotateSpeed = 1.5f;
            researchCostMultiplier = 0.04f;

            limitRange(20f);
        }};

    }
}
