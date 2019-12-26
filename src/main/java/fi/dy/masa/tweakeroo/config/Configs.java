package fi.dy.masa.tweakeroo.config;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.google.common.collect.ImmutableList;
import fi.dy.masa.malilib.config.ConfigType;
import fi.dy.masa.malilib.config.ConfigUtils;
import fi.dy.masa.malilib.config.IConfigHandler;
import fi.dy.masa.malilib.config.options.ConfigBoolean;
import fi.dy.masa.malilib.config.options.ConfigBooleanHotkeyed;
import fi.dy.masa.malilib.config.options.ConfigColor;
import fi.dy.masa.malilib.config.options.ConfigDouble;
import fi.dy.masa.malilib.config.options.ConfigHotkey;
import fi.dy.masa.malilib.config.options.ConfigInteger;
import fi.dy.masa.malilib.config.options.ConfigOptionList;
import fi.dy.masa.malilib.config.options.ConfigString;
import fi.dy.masa.malilib.config.options.ConfigStringList;
import fi.dy.masa.malilib.config.options.IConfigBase;
import fi.dy.masa.malilib.config.values.ActiveMode;
import fi.dy.masa.malilib.config.values.HudAlignment;
import fi.dy.masa.malilib.util.restrictions.UsageRestriction.ListType;
import fi.dy.masa.tweakeroo.Reference;
import fi.dy.masa.tweakeroo.tweaks.MiscTweaks;
import fi.dy.masa.tweakeroo.tweaks.PlacementTweaks;
import fi.dy.masa.tweakeroo.util.InventoryUtils;
import fi.dy.masa.tweakeroo.util.PlacementRestrictionMode;
import fi.dy.masa.tweakeroo.util.SnapAimMode;

public class Configs implements IConfigHandler
{
    public static class Generic
    {
        public static final ConfigInteger       AFTER_CLICKER_CLICK_COUNT           = new ConfigInteger     ("afterClickerClickCount",  1, 1, 32, "启用tweakAfterClicker时，每个放置块的右键单击次数");
        public static final ConfigDouble        BLOCK_REACH_DISTANCE                = new ConfigDouble      ("blockReachDistance", 4.5, 0, 8, "调整启用override tweak后，能够放置方块的最大距离，\n在服务器中允许放置方块的最大距离为8，\n允许破坏方块的最大距离为6.");
        public static final ConfigInteger       BREAKING_GRID_SIZE                  = new ConfigInteger     ("breakingGridSize", 3, 1, 1000, "*网格断开模式的网格间隔大小.\n按住调整按钮并滑动滚轮以快速调整数值.");
        public static final ConfigOptionList    BREAKING_RESTRICTION_MODE           = new ConfigOptionList  ("breakingRestrictionMode", PlacementRestrictionMode.LINE, "*使用突破限制模式(可自定义热键)");
        public static final ConfigColor         CHAT_BACKGROUND_COLOR               = new ConfigColor       ("chatBackgroundColor", "#80000000", "调整聊天信息的背景颜色\n（如果tweakChatBackgroundColor功能已启用）");
        public static final ConfigString        CHAT_TIME_FORMAT                    = new ConfigString      ("chatTimeFormat", "[HH:mm:ss]", "调整聊天信息的时间格式(如果tweakChatTimestamp功能已启用)，\n使用Java中SimpleDateFormat类的格式标准.");
        public static final ConfigInteger       CHUNK_RENDER_TIMEOUT                = new ConfigInteger     ("chunkRenderTimeout", 50000000, 1, Integer.MAX_VALUE, "调整区块渲染中每个区块的超时值(单位为纳秒)");
        public static final ConfigBoolean       CLIENT_PLACEMENT_ROTATION           = new ConfigBoolean     ("clientPlacementRotation", true, "启动单人模式及客户端的旋转放置,\n就像在没有Carpet mod的单人模式中使用精确放置");
        public static final ConfigDouble        CLOUD_HEIGHT_OVERRIDE               = new ConfigDouble      ("cloudHeightOverride", 128, -1024, 1024, "调整当tweakCloudHeightOverride功能启用时，新的云层高度");
        public static final ConfigOptionList    ELYTRA_CAMERA_INDICATOR             = new ConfigOptionList  ("elytraCameraIndicator", ActiveMode.WITH_KEY, "选择当鞘翅视角模式激活时是否要渲染真实的俯仰角");
        public static final ConfigInteger       FAST_BLOCK_PLACEMENT_COUNT          = new ConfigInteger     ("fastBlockPlacementCount", 2, 1, 16, "调整当FastBlockPlacement功能开启时，\n每游戏刻允许放置的方块数上限");
        public static final ConfigInteger       FAST_LEFT_CLICK_COUNT               = new ConfigInteger     ("fastLeftClickCount",  10, 1, 64, "调整当tweakFastLeftClick功能启用并按住左键时,\n每游戏刻左键的点击次数");
        public static final ConfigInteger       FAST_RIGHT_CLICK_COUNT              = new ConfigInteger     ("fastRightClickCount", 10, 1, 64, "调整当tweakFastRightClick功能启用并按住右键时,\n每游戏刻右键的点击次数");
        public static final ConfigInteger       FILL_CLONE_LIMIT                    = new ConfigInteger     ("fillCloneLimit", 10000000, 1, 1000000000, "调整在单人模式中使用/fill和/clone命令变更方块的数量上限\n(如果已启用覆盖开关)");
        public static final ConfigColor         FLEXIBLE_PLACEMENT_OVERLAY_COLOR    = new ConfigColor       ("flexibleBlockPlacementOverlayColor", "#C03030F0", "调整当前指向的放置方块的覆盖层颜色");
        public static final ConfigDouble        FLY_SPEED_PRESET_1                  = new ConfigDouble      ("flySpeedPreset1", 0.01, 0, 4, "预设飞行速度 1");
        public static final ConfigDouble        FLY_SPEED_PRESET_2                  = new ConfigDouble      ("flySpeedPreset2", 0.064, 0, 4, "预设飞行速度 2");
        public static final ConfigDouble        FLY_SPEED_PRESET_3                  = new ConfigDouble      ("flySpeedPreset3", 0.128, 0, 4, "预设飞行速度 3");
        public static final ConfigDouble        FLY_SPEED_PRESET_4                  = new ConfigDouble      ("flySpeedPreset4", 0.32, 0, 4, "预设飞行速度 4");
        public static final ConfigBoolean       FREE_CAMERA_MOTION_TOGGLE           = new ConfigBoolean     ("freeCameraMotionToggle", true, "如果启用，则在开关观察者模式的同时\n也将自动开关视角自由运动功能");
        public static final ConfigInteger       GAMMA_OVERRIDE_VALUE                = new ConfigInteger     ("gammaOverrideValue", 16, 0, 1000, "调整当启用gamma覆盖功能(如无限夜视)时的gamma值");
        public static final ConfigBoolean       HAND_RESTOCK_PRE                    = new ConfigBoolean     ("handRestockPre", true, "启用后将在手中物品用完之前自动从背包补充");
        public static final ConfigInteger       HOTBAR_SLOT_CYCLE_MAX               = new ConfigInteger     ("hotbarSlotCycleMax", 2, 1, 9, "如果启用了hotbarslotcycle功能，这是循环使用的最后一个栏位。\n当超过此处设置的最大方格时，循环将跳回到第一个栏位。");
        public static final ConfigInteger       HOTBAR_SLOT_RANDOMIZER_MAX          = new ConfigInteger     ("hotbarSlotRandomizerMax", 5, 1, 9, "如果启用了hotbarSlotRandomizer功能，这是使用循环的最后一个栏位。\n所选的栏位将在物品使用后从1到该最大方格中随机挑选。");
        public static final ConfigOptionList    HOTBAR_SWAP_OVERLAY_ALIGNMENT       = new ConfigOptionList  ("hotbarSwapOverlayAlignment", HudAlignment.BOTTOM_RIGHT, "*物品栏交换叠加的位置");
        public static final ConfigInteger       HOTBAR_SWAP_OVERLAY_OFFSET_X        = new ConfigInteger     ("hotbarSwapOverlayOffsetX", 4, "*物品栏交换叠加的水平偏移");
        public static final ConfigInteger       HOTBAR_SWAP_OVERLAY_OFFSET_Y        = new ConfigInteger     ("hotbarSwapOverlayOffsetY", 4, "*物品栏交换叠加的竖直偏移");
        public static final ConfigInteger       ITEM_SWAP_DURABILITY_THRESHOLD      = new ConfigInteger     ("itemSwapDurabilityThreshold", 20, 0, 10000, "调整物品低耐久自动更换的阈值\n请注意，总耐久低的物品耐久阈值将更低并在5%%左右交换");
        public static final ConfigBoolean       LAVA_VISIBILITY_OPTIFINE            = new ConfigBoolean     ("lavaVisibilityOptifineCompat", true, "使用另一种版本的LavaVisibility(岩浆夜视)功能，它与Optifine兼容");
        public static final ConfigInteger       MAP_PREVIEW_SIZE                    = new ConfigInteger     ("mapPreviewSize", 160, 16, 512, "*渲染地图预览的大小");
        public static final ConfigInteger       PERIODIC_ATTACK_INTERVAL            = new ConfigInteger     ("periodicAttackInterval", 20, 0, Integer.MAX_VALUE, "调整自动攻击中每两次左键单击间游戏刻");
        public static final ConfigInteger       PERIODIC_USE_INTERVAL               = new ConfigInteger     ("periodicUseInterval", 20, 0, Integer.MAX_VALUE, "调整自动使用中每两次右键单击间游戏刻");
        public static final ConfigBoolean       PERMANENT_SNEAK_ALLOW_IN_GUIS       = new ConfigBoolean     ("permanentSneakAllowInGUIs", false, "如果启用,则在GUI打开时permanent sneak(永久潜行)也会起作用");
        public static final ConfigInteger       PLACEMENT_GRID_SIZE                 = new ConfigInteger     ("placementGridSize", 3, 1, 1000, "调整网格放置模式的网格间隔大小。\n按住调整按钮并滑动滚轮以快速调整数值");
        public static final ConfigInteger       PLACEMENT_LIMIT                     = new ConfigInteger     ("placementLimit", 3, 1, 10000, "更改启用tweakPlacementLimit时每次右键单击最多可以放置的方块数\n按住调整按钮并滑动滚轮以快速调整数值");
        public static final ConfigOptionList    PLACEMENT_RESTRICTION_MODE          = new ConfigOptionList  ("placementRestrictionMode", PlacementRestrictionMode.FACE, "更改要使用的放置限制模式(可自定义热键)");
        public static final ConfigBoolean       PLACEMENT_RESTRICTION_TIED_TO_FAST  = new ConfigBoolean     ("placementRestrictionTiedToFast", true, "启用后，开关快速放置模式时，会自动开关放置限制模式");
        public static final ConfigDouble        PLAYER_ON_FIRE_SCALE                = new ConfigDouble      ("playerOnFireScale", 1, 0, 10, "调整玩家着火时的粒子效果，\n可接受的数值范围: 0.0 - 10.0");
        public static final ConfigBoolean       POTION_WARNING_BENEFICIAL_ONLY      = new ConfigBoolean     ("potionWarningBeneficialOnly", true, "只在正面效果的药水效果将耗尽时发出警报");
        public static final ConfigInteger       POTION_WARNING_THRESHOLD            = new ConfigInteger     ("potionWarningThreshold", 600, 1, 1000000, "剩余药水效果时间在低于此时间后将发出警报(以游戏刻为单位)");
        public static final ConfigInteger       RENDER_LIMIT_ITEM                   = new ConfigInteger     ("renderLimitItem", -1, -1, 10000, "每帧渲染的实体数量上限,使用-1禁用此限制");
        public static final ConfigInteger       RENDER_LIMIT_XP_ORB                 = new ConfigInteger     ("renderLimitXPOrb", -1, -1, 10000, "每帧渲染的经验球数量上限,使用-1禁用此限制");
        public static final ConfigBoolean       SHULKER_DISPLAY_BACKGROUND_COLOR    = new ConfigBoolean     ("shulkerDisplayBgColor", true, "是否将盒子颜色作为Shulker Box预览功能的背景");
        public static final ConfigBoolean       SHULKER_DISPLAY_REQUIRE_SHIFT       = new ConfigBoolean     ("shulkerDisplayRequireShift", true, "预览时是否需要按住shift");
        public static final ConfigBoolean       SLOT_SYNC_WORKAROUND                = new ConfigBoolean     ("slotSyncWorkaround", true, "*这可以防止服务器从正在快速使用\n例如fastrightclick的物品覆盖的耐久或堆叠大小。");
        public static final ConfigBoolean       SNAP_AIM_INDICATOR                  = new ConfigBoolean     ("snapAimIndicator", true, "*是否渲染捕捉瞄准角指示器");
        public static final ConfigColor         SNAP_AIM_INDICATOR_COLOR            = new ConfigColor       ("snapAimIndicatorColor", "#603030FF", "*对齐目标指示器背景的颜色");
        public static final ConfigOptionList    SNAP_AIM_MODE                       = new ConfigOptionList  ("snapAimMode", SnapAimMode.YAW, "*快速对齐模式：偏航或俯仰，或我全都要");
        public static final ConfigBoolean       SNAP_AIM_ONLY_CLOSE_TO_ANGLE        = new ConfigBoolean     ("snapAimOnlyCloseToAngle", true, "*如果启用该选项，则仅当内角在其一定距离内时才捕捉到该角度。可在snapAimThreshold中设置阈值");
        public static final ConfigBoolean       SNAP_AIM_PITCH_OVERSHOOT            = new ConfigBoolean     ("snapAimPitchOvershoot", false, "*是否允许俯仰角从正常的+/- 90度到+/- 180度的超调");
        public static final ConfigDouble        SNAP_AIM_PITCH_STEP                 = new ConfigDouble      ("snapAimPitchStep", 12.5, 0, 90, "*快动目标调整的俯仰角步长");
        public static final ConfigDouble        SNAP_AIM_THRESHOLD_PITCH            = new ConfigDouble      ("snapAimThresholdPitch", 1.5, "*玩家将在其中旋转到俯仰角的角度阈值。");
        public static final ConfigDouble        SNAP_AIM_THRESHOLD_YAW              = new ConfigDouble      ("snapAimThresholdYaw", 5.0, "*玩家将在其中旋转到偏航角的角度阈值。");
        public static final ConfigDouble        SNAP_AIM_YAW_STEP                   = new ConfigDouble      ("snapAimYawStep", 45, 0, 360, "*瞄准锁定的偏航角设定");
        public static final ConfigInteger       STRUCTURE_BLOCK_MAX_SIZE            = new ConfigInteger     ("structureBlockMaxSize", 128, 1, 256, "调整结构方块保存区域的最大尺寸");
        public static final ConfigDouble        ZOOM_FOV                            = new ConfigDouble      ("zoomFov", 30, 0, 600, "调整用于缩放功能的FOV值");

        public static final ImmutableList<IConfigBase> OPTIONS = ImmutableList.of(
                CLIENT_PLACEMENT_ROTATION,
                FREE_CAMERA_MOTION_TOGGLE,
                LAVA_VISIBILITY_OPTIFINE,
                HAND_RESTOCK_PRE,
                PERMANENT_SNEAK_ALLOW_IN_GUIS,
                PLACEMENT_RESTRICTION_TIED_TO_FAST,
                POTION_WARNING_BENEFICIAL_ONLY,
                SHULKER_DISPLAY_BACKGROUND_COLOR,
                SHULKER_DISPLAY_REQUIRE_SHIFT,
                SLOT_SYNC_WORKAROUND,
                SNAP_AIM_INDICATOR,
                SNAP_AIM_ONLY_CLOSE_TO_ANGLE,
                SNAP_AIM_PITCH_OVERSHOOT,

                BREAKING_RESTRICTION_MODE,
                ELYTRA_CAMERA_INDICATOR,
                PLACEMENT_RESTRICTION_MODE,
                HOTBAR_SWAP_OVERLAY_ALIGNMENT,
                SNAP_AIM_MODE,

                CHAT_TIME_FORMAT,
                CHAT_BACKGROUND_COLOR,
                FLEXIBLE_PLACEMENT_OVERLAY_COLOR,
                SNAP_AIM_INDICATOR_COLOR,

                AFTER_CLICKER_CLICK_COUNT,
                BLOCK_REACH_DISTANCE,
                BREAKING_GRID_SIZE,
                CHUNK_RENDER_TIMEOUT,
                CLOUD_HEIGHT_OVERRIDE,
                FAST_BLOCK_PLACEMENT_COUNT,
                FAST_LEFT_CLICK_COUNT,
                FAST_RIGHT_CLICK_COUNT,
                FILL_CLONE_LIMIT,
                FLY_SPEED_PRESET_1,
                FLY_SPEED_PRESET_2,
                FLY_SPEED_PRESET_3,
                FLY_SPEED_PRESET_4,
                GAMMA_OVERRIDE_VALUE,
                HOTBAR_SLOT_CYCLE_MAX,
                HOTBAR_SLOT_RANDOMIZER_MAX,
                HOTBAR_SWAP_OVERLAY_OFFSET_X,
                HOTBAR_SWAP_OVERLAY_OFFSET_Y,
                ITEM_SWAP_DURABILITY_THRESHOLD,
                MAP_PREVIEW_SIZE,
                PERIODIC_ATTACK_INTERVAL,
                PERIODIC_USE_INTERVAL,
                PLACEMENT_GRID_SIZE,
                PLACEMENT_LIMIT,
                PLAYER_ON_FIRE_SCALE,
                POTION_WARNING_THRESHOLD,
                RENDER_LIMIT_ITEM,
                RENDER_LIMIT_XP_ORB,
                SNAP_AIM_PITCH_STEP,
                SNAP_AIM_THRESHOLD_PITCH,
                SNAP_AIM_THRESHOLD_YAW,
                SNAP_AIM_YAW_STEP,
                STRUCTURE_BLOCK_MAX_SIZE,
                ZOOM_FOV
        );
    }

    public static class Fixes
    {
        public static final ConfigBoolean ELYTRA_FIX                = new ConfigBoolean("elytraFix", false, "鞘翅部署/着陆修复(by Earthcomputer and Nessie)");
        public static final ConfigBoolean TILE_UNLOAD_OPTIMIZATION  = new ConfigBoolean("tileEntityUnloadOptimization", false, "删除正在卸载的TileEntities的操作，如果一次加载和/或卸载很多TileEntities的话，可以大大提高性能。(???)");

        public static final ImmutableList<IConfigBase> OPTIONS = ImmutableList.of(
                ELYTRA_FIX,
                TILE_UNLOAD_OPTIMIZATION
        );
    }

    public static class Lists
    {
        public static final ConfigOptionList FAST_PLACEMENT_ITEM_LIST_TYPE      = new ConfigOptionList("fastPlacementItemListType", ListType.BLACKLIST, "FastBlockPlacement(快速放置)的物品限制类型");
        public static final ConfigStringList FAST_PLACEMENT_ITEM_BLACKLIST      = new ConfigStringList("fastPlacementItemBlackList", ImmutableList.of("minecraft:ender_chest", "minecraft:white_shulker_box"), "如果fastPlacementItemListType被设置成黑名单，\n则这些物品将不被允许使用FastBlockPlacement(快速放置)功能");
        public static final ConfigStringList FAST_PLACEMENT_ITEM_WHITELIST      = new ConfigStringList("fastPlacementItemWhiteList", ImmutableList.of(), "如果fastPlacementItemListType被设置成白名单，\n则这些物品将被允许使用FastBlockPlacement(快速放置)功能");
        public static final ConfigOptionList FAST_RIGHT_CLICK_BLOCK_LIST_TYPE   = new ConfigOptionList("fastRightClickBlockListType", ListType.BLACKLIST, "FastRightClick(右键连点)的物品限制类型");
        public static final ConfigStringList FAST_RIGHT_CLICK_BLOCK_BLACKLIST   = new ConfigStringList("fastRightClickBlockBlackList", ImmutableList.of("minecraft:chest", "minecraft:ender_chest", "minecraft:trapped_chest", "minecraft:white_shulker_box"), "如果fastRightClickBlockListType被设置成黑名单，\n则这些物品将不被允许使用FastRightClick(右键连点)功能");
        public static final ConfigStringList FAST_RIGHT_CLICK_BLOCK_WHITELIST   = new ConfigStringList("fastRightClickBlockWhiteList", ImmutableList.of(), "如果fastRightClickBlockListType被设置成白名单，\n则这些物品将被允许使用FastRightClick(右键连点)功能");
        public static final ConfigOptionList FAST_RIGHT_CLICK_ITEM_LIST_TYPE    = new ConfigOptionList("fastRightClickItemListType", ListType.BLACKLIST, "The item restriction type for the Fast Right Click tweak");
        public static final ConfigStringList FAST_RIGHT_CLICK_ITEM_BLACKLIST    = new ConfigStringList("fastRightClickItemBlackList", ImmutableList.of("minecraft:fireworks"), "The items that are NOT allowed to be used for the Fast Right Click tweak,\nif the fastRightClickListType is set to Black List");
        public static final ConfigStringList FAST_RIGHT_CLICK_ITEM_WHITELIST    = new ConfigStringList("fastRightClickItemWhiteList", ImmutableList.of("minecraft:bucket", "minecraft:water_bucket", "minecraft:lava_bucket", "minecraft:glass_bottle"), "The items that are allowed to be used for the Fast Right Click tweak,\nif the fastRightClickListType is set to White List");
        public static final ConfigStringList FLAT_WORLD_PRESETS                 = new ConfigStringList("flatWorldPresets", ImmutableList.of("White Glass;1*minecraft:stained_glass;minecraft:plains;;minecraft:stained_glass", "Glass;1*minecraft:glass;minecraft:plains;;minecraft:glass"), "自定义平坦的世界预设字符串。\n格式为: name;blocks_string;biome;generation_features;icon_item\n方块字符串的格式为原版格式, 例如: 62*minecraft:dirt,minecraft:grass\n生物群系可以是 registry name或者 the int ID\n图标物品名称格式则为 minecraft:iron_nugget");
        public static final ConfigOptionList ITEM_GLINT_LIST_TYPE               = new ConfigOptionList("itemGlintListType", ListType.BLACKLIST, "*禁用闪烁功能的物品限制类型");
        public static final ConfigStringList ITEM_GLINT_BLACKLIST               = new ConfigStringList("itemGlintBlackList", ImmutableList.of("minecraft:potion"), "如果itemGlintListType被设为黑名单，\n则这些物品将不会拥有闪烁特效");
        public static final ConfigStringList ITEM_GLINT_WHITELIST               = new ConfigStringList("itemGlintWhiteList", ImmutableList.of(), "如果itemGlintListType被设为白名单，\n则这些物品将拥有闪烁特效");
        public static final ConfigOptionList POTION_WARNING_LIST_TYPE           = new ConfigOptionList("potionWarningListType", ListType.NONE, "药水警告效果的类型列表");
        public static final ConfigStringList POTION_WARNING_BLACKLIST           = new ConfigStringList("potionWarningBlackList", ImmutableList.of("minecraft:hunger", "minecraft:mining_fatigue", "minecraft:nausea", "minecraft:poison", "minecraft:slowness", "minecraft:weakness"), "这些药水效果将消失时不会被警告");
        public static final ConfigStringList POTION_WARNING_WHITELIST           = new ConfigStringList("potionWarningWhiteList", ImmutableList.of("minecraft:fire_resistance", "minecraft:invisibility", "minecraft:water_breathing"), "这些药水效果将消失时会被警告");
        public static final ConfigStringList REPAIR_MODE_SLOTS                  = new ConfigStringList("repairModeSlots", ImmutableList.of("mainhand", "offhand"), "修复模式会自动修复哪里的物品，有效值：\nmainhand，offhand，head，chest，legs，feet");
        public static final ConfigStringList UNSTACKING_ITEMS                   = new ConfigStringList("unstackingItems", ImmutableList.of("minecraft:bucket", "minecraft:glass_bottle"), "*tweakItemUnstackingProtection调整应考虑的项目");

        public static final ImmutableList<IConfigBase> OPTIONS = ImmutableList.of(
                FAST_PLACEMENT_ITEM_LIST_TYPE,
                FAST_PLACEMENT_ITEM_BLACKLIST,
                FAST_PLACEMENT_ITEM_WHITELIST,
                FAST_RIGHT_CLICK_BLOCK_LIST_TYPE,
                FAST_RIGHT_CLICK_BLOCK_BLACKLIST,
                FAST_RIGHT_CLICK_BLOCK_WHITELIST,
                FAST_RIGHT_CLICK_ITEM_LIST_TYPE,
                FAST_RIGHT_CLICK_ITEM_BLACKLIST,
                FAST_RIGHT_CLICK_ITEM_WHITELIST,
                FLAT_WORLD_PRESETS,
                ITEM_GLINT_LIST_TYPE,
                ITEM_GLINT_BLACKLIST,
                ITEM_GLINT_WHITELIST,
                POTION_WARNING_LIST_TYPE,
                POTION_WARNING_BLACKLIST,
                POTION_WARNING_WHITELIST,
                REPAIR_MODE_SLOTS,
                UNSTACKING_ITEMS
        );
    }

    public static class Disable
    {
        public static final ConfigBooleanHotkeyed       DISABLE_BLOCK_BREAK_PARTICLES   = new ConfigBooleanHotkeyed("disableBlockBreakingParticles",        false, "", "移除方块破坏时的粒子");
        public static final ConfigBooleanHotkeyed       DISABLE_DOUBLE_TAP_SPRINT       = new ConfigBooleanHotkeyed("disableDoubleTapSprint",               false, "", "禁用快速按两下前进键进入疾跑状态");
        public static final ConfigBooleanHotkeyed       DISABLE_BOSS_FOG                = new ConfigBooleanHotkeyed("disableBossFog",                       false, "", "消除boss生物造成的迷雾");
        public static final ConfigBooleanHotkeyed       DISABLE_CLIENT_ENTITY_UPDATES   = new ConfigBooleanHotkeyed("disableClientEntityUpdates",           false, "", "禁用除客户端上的玩家实体之外的所有实体更新");
        public static final ConfigBooleanHotkeyed       DISABLE_DEAD_MOB_RENDERING      = new ConfigBooleanHotkeyed("disableDeadMobRendering",              false, "", "不渲染死亡生物(生命值为0的实体)");
        public static final ConfigBooleanHotkeyed       DISABLE_DEAD_MOB_TARGETING      = new ConfigBooleanHotkeyed("disableDeadMobTargeting",              false, "", "防止目标实体处于0HP状态");
        public static final ConfigBooleanHotkeyed       DISABLE_ENTITY_RENDERING        = new ConfigBooleanHotkeyed("disableEntityRendering",               false, "", "禁用玩家实体之外的所有实体的渲染");
        public static final ConfigBooleanHotkeyed       DISABLE_ENTITY_TICKING          = new ConfigBooleanClient  ("disableEntityTicking",                 false, "", "移除除玩家以外的实体刻");
        public static final ConfigBooleanHotkeyed       DISABLE_FALLING_BLOCK_RENDER    = new ConfigBooleanHotkeyed("disableFallingBlockEntityRendering",   false, "", "如果启用，则不会渲染下落方块实体");
        public static final ConfigBooleanHotkeyed       DISABLE_INVENTORY_EFFECTS       = new ConfigBooleanHotkeyed("disableInventoryEffectRendering",      false, "", "从GUI中删除药水效果渲染");
        public static final ConfigBooleanHotkeyed       DISABLE_ITEM_GLINT              = new ConfigBooleanHotkeyed("disableItemGlint",                     false, "", "禁用项目的闪烁效果。可以在 列表-> itemGlint 中配置要删除或启用项目的项目");
        public static final ConfigBooleanHotkeyed       DISABLE_ITEM_SWITCH_COOLDOWN    = new ConfigBooleanHotkeyed("disableItemSwitchRenderCooldown",      false, "", "如果启用，则在切换所持有的物品或使用该物品时，将不会有任何冷却/装备动画");
        public static final ConfigBooleanHotkeyed       DISABLE_LIGHT_UPDATES           = new ConfigBooleanHotkeyed("disableLightUpdates",                  false, "", "如果启用，则禁用某些客户端(与渲染相关的)灯光更新");
        public static final ConfigBooleanHotkeyed       DISABLE_LIGHT_UPDATES_ALL       = new ConfigBooleanHotkeyed("disableLightUpdatesAll",               false, "", "如果启用，则禁用某些客户端(与渲染相关的)灯光更新\n(如果不启用gamma值覆盖(即无限夜视)，看起来将会十分糟糕)");
        public static final ConfigBooleanHotkeyed       DISABLE_MOB_SPAWNER_MOB_RENDER  = new ConfigBooleanHotkeyed("disableMobSpawnerMobRendering",        false, "", "移除刷怪箱的实体渲染效果");
        public static final ConfigBooleanHotkeyed       DISABLE_NETHER_FOG              = new ConfigBooleanHotkeyed("disableNetherFog",                     false, "", "移除地狱中的雾");
        public static final ConfigBooleanHotkeyed       DISABLE_OBSERVER                = new ConfigBooleanClient  ("disableObserver",                      false, "", "彻底禁用侦测器检测方块更新");
        public static final ConfigBooleanHotkeyed       DISABLE_OBSERVER_PLACE_UPDATE   = new ConfigBooleanClient  ("disableObserverPlaceUpdate",           false, "", "防止侦测器放置时被激活");
        public static final ConfigBooleanHotkeyed       DISABLE_OFFHAND_RENDERING       = new ConfigBooleanHotkeyed("disableOffhandRendering",              false, "", "禁用副手物品渲染");
        public static final ConfigBooleanHotkeyed       DISABLE_PARTICLES               = new ConfigBooleanHotkeyed("disableParticles",                     false, "", "禁用所有粒子效果");
        public static final ConfigBooleanHotkeyed       DISABLE_PORTAL_GUI_CLOSING      = new ConfigBooleanHotkeyed("disablePortalGuiClosing",              false, "", "启用后在地狱门中也可打开GUI(例如背包、聊天框)");
        public static final ConfigBooleanHotkeyed       DISABLE_RAIN_EFFECTS            = new ConfigBooleanHotkeyed("disableRainEffects",                   false, "", "禁用雨的渲染和声音");
        public static final ConfigBooleanHotkeyed       DISABLE_SIGN_GUI                = new ConfigBooleanHotkeyed("disableSignGui",                       false, "", "*禁止打开Sign编辑GUI");
        public static final ConfigBooleanHotkeyed       DISABLE_SHULKER_BOX_TOOLTIP     = new ConfigBooleanHotkeyed("disableShulkerBoxTooltip",             false, "", "禁用shulkerboxtooltip mod的潜影盒内容物显示");
        public static final ConfigBooleanHotkeyed       DISABLE_SLIME_BLOCK_SLOWDOWN    = new ConfigBooleanHotkeyed("disableSlimeBlockSlowdown",            false, "", "让你在粘液块上不减速");
        public static final ConfigBooleanHotkeyed       DISABLE_TILE_ENTITY_RENDERING   = new ConfigBooleanHotkeyed("disableTileEntityRendering",           false, "", "停止渲染所有实体");
        public static final ConfigBooleanHotkeyed       DISABLE_TILE_ENTITY_TICKING     = new ConfigBooleanClient  ("disableTileEntityTicking",             false, "", "停止所有的实体刻");
        public static final ConfigBooleanHotkeyed       DISABLE_VILLAGER_TRADE_LOCKING  = new ConfigBooleanClient  ("disableVillagerTradeLocking",          false, "", "防止村民交易锁定");
        public static final ConfigBooleanHotkeyed       DISABLE_WALL_UNSPRINT           = new ConfigBooleanHotkeyed("disableWallUnsprint",                  false, "", "撞墙不会让你退出疾跑模式");

        public static final ImmutableList<ConfigBooleanHotkeyed> OPTIONS = ImmutableList.of(
                DISABLE_BLOCK_BREAK_PARTICLES,
                DISABLE_DOUBLE_TAP_SPRINT,
                DISABLE_BOSS_FOG,
                DISABLE_CLIENT_ENTITY_UPDATES,
                DISABLE_DEAD_MOB_RENDERING,
                DISABLE_DEAD_MOB_TARGETING,
                DISABLE_ENTITY_RENDERING,
                DISABLE_ENTITY_TICKING,
                DISABLE_FALLING_BLOCK_RENDER,
                DISABLE_INVENTORY_EFFECTS,
                DISABLE_ITEM_GLINT,
                DISABLE_ITEM_SWITCH_COOLDOWN,
                DISABLE_LIGHT_UPDATES,
                DISABLE_LIGHT_UPDATES_ALL,
                DISABLE_MOB_SPAWNER_MOB_RENDER,
                DISABLE_NETHER_FOG,
                DISABLE_OBSERVER,
                DISABLE_OBSERVER_PLACE_UPDATE,
                DISABLE_OFFHAND_RENDERING,
                DISABLE_PARTICLES,
                DISABLE_PORTAL_GUI_CLOSING,
                DISABLE_RAIN_EFFECTS,
                DISABLE_SIGN_GUI,
                DISABLE_SHULKER_BOX_TOOLTIP,
                DISABLE_SLIME_BLOCK_SLOWDOWN,
                DISABLE_TILE_ENTITY_RENDERING,
                DISABLE_TILE_ENTITY_TICKING,
                DISABLE_VILLAGER_TRADE_LOCKING,
                DISABLE_WALL_UNSPRINT
        );
    }

    public static class Internal
    {
        public static final ConfigInteger       FLY_SPEED_PRESET                    = new ConfigInteger     ("flySpeedPreset", 0, 0, 3, "*仅用于Mod内部跟踪当前选定的飞行速度预设");
        public static final ConfigDouble        GAMMA_VALUE_ORIGINAL                = new ConfigDouble      ("gammaValueOriginal", 0, 0, 1, "gamma值覆盖(无限夜视)未启用时的gamma值");
        public static final ConfigInteger       HOTBAR_SCROLL_CURRENT_ROW           = new ConfigInteger     ("hotbarScrollCurrentRow", 3, 0, 3, "*仅用于内部跟踪快捷栏滚动功能");
        public static final ConfigDouble        SLIME_BLOCK_SLIPPERINESS_ORIGINAL   = new ConfigDouble      ("slimeBlockSlipperinessOriginal", 0.8, 0, 1, "粘液块的原始滑动值");
        public static final ConfigDouble        SNAP_AIM_LAST_PITCH                 = new ConfigDouble      ("snapAimLastPitch", 0, -135, 135, "最后捕捉到的音调值");
        public static final ConfigDouble        SNAP_AIM_LAST_YAW                   = new ConfigDouble      ("snapAimLastYaw", 0, 0, 360, "最后捕捉到的偏航值");

        public static final ImmutableList<IConfigBase> OPTIONS = ImmutableList.of(
                FLY_SPEED_PRESET,
                GAMMA_VALUE_ORIGINAL,
                HOTBAR_SCROLL_CURRENT_ROW,
                SLIME_BLOCK_SLIPPERINESS_ORIGINAL,
                SNAP_AIM_LAST_YAW
        );
    }

    @Override
    public String getModName()
    {
        return Reference.MOD_NAME;
    }

    @Override
    public String getConfigFileName()
    {
        return Reference.MOD_ID + ".json";
    }

    @Override
    public Map<String, List<? extends IConfigBase>> getConfigsPerCategories()
    {
        Map<String, List<? extends IConfigBase>> map = new LinkedHashMap<>();

        map.put("Generic",          Generic.OPTIONS);
        map.put("Fixes",            Fixes.OPTIONS);
        map.put("Lists",            Lists.OPTIONS);
        map.put("TweakToggles",     ConfigUtils.createConfigWrapperForType(ConfigType.BOOLEAN, ImmutableList.copyOf(FeatureToggle.values())));
        map.put("TweakHotkeys",     ConfigUtils.createConfigWrapperForType(ConfigType.HOTKEY, ImmutableList.copyOf(FeatureToggle.values())));
        map.put("GenericHotkeys",   Hotkeys.HOTKEY_LIST);
        map.put("DisableToggles",   ConfigUtils.createConfigWrapperForType(ConfigType.BOOLEAN, Disable.OPTIONS));
        map.put("DisableHotkeys",   ConfigUtils.createConfigWrapperForType(ConfigType.HOTKEY, Disable.OPTIONS));
        map.put("Internal",         Internal.OPTIONS);

        return map;
    }

    @Override
    public boolean shouldShowCategoryOnConfigGuis(String category)
    {
        return category.equals("Internal") == false;
    }

    @Override
    public void onPostLoad()
    {
        InventoryUtils.setRepairModeSlots(Lists.REPAIR_MODE_SLOTS.getStrings());
        InventoryUtils.setUnstackingItems(Lists.UNSTACKING_ITEMS.getStrings());

        PlacementTweaks.updateFastRightClickBlockRestriction();
        PlacementTweaks.updateFastRightClickItemRestriction();
        PlacementTweaks.updateFastPlacementItemRestriction();

        MiscTweaks.updateItemGlintRestriction();
        MiscTweaks.updatePotionRestrictionLists();
    }

    public static ConfigDouble getActiveFlySpeedConfig()
    {
        return getFlySpeedConfig(Configs.Internal.FLY_SPEED_PRESET.getIntegerValue());
    }

    public static ConfigDouble getFlySpeedConfig(int preset)
    {
        switch (preset)
        {
            case 0:  return Configs.Generic.FLY_SPEED_PRESET_1;
            case 1:  return Configs.Generic.FLY_SPEED_PRESET_2;
            case 2:  return Configs.Generic.FLY_SPEED_PRESET_3;
            case 3:  return Configs.Generic.FLY_SPEED_PRESET_4;
            default: return Configs.Generic.FLY_SPEED_PRESET_1;
        }
    }

    public static ConfigHotkey getFlySpeedHotkey(int preset)
    {
        switch (preset)
        {
            case 0:  return Hotkeys.FLY_PRESET_1;
            case 1:  return Hotkeys.FLY_PRESET_2;
            case 2:  return Hotkeys.FLY_PRESET_3;
            case 3:  return Hotkeys.FLY_PRESET_4;
            default: return Hotkeys.FLY_PRESET_1;
        }
    }
}
