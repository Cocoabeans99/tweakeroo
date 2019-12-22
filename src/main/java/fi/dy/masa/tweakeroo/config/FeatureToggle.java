package fi.dy.masa.tweakeroo.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import fi.dy.masa.malilib.config.ConfigType;
import fi.dy.masa.malilib.config.IConfigBoolean;
import fi.dy.masa.malilib.config.IConfigNotifiable;
import fi.dy.masa.malilib.config.IHotkeyTogglable;
import fi.dy.masa.malilib.gui.GuiBase;
import fi.dy.masa.malilib.hotkeys.IKeybind;
import fi.dy.masa.malilib.hotkeys.KeyCallbackToggleBooleanConfigWithMessage;
import fi.dy.masa.malilib.hotkeys.KeybindMulti;
import fi.dy.masa.malilib.hotkeys.KeybindSettings;
import fi.dy.masa.malilib.interfaces.IValueChangeCallback;
import fi.dy.masa.malilib.util.StringUtils;
import fi.dy.masa.tweakeroo.Tweakeroo;

public enum FeatureToggle implements IHotkeyTogglable, IConfigNotifiable<IConfigBoolean>
{
    CARPET_ACCURATE_PLACEMENT_PROTOCOL ("carpetAccuratePlacementProtocol",  false, "",    "If enabled, then the Flexible Block Placement and the\nAccurate Block Placement use the protocol implemented\nin the recent carpet mod versions", "Carpet protocol Accurate Placement"),
    FAST_PLACEMENT_REMEMBER_ALWAYS  ("fastPlacementRememberOrientation",    true, "",     "启用该选项后，快速建造模式将始终记住您放置的第一个方块的方向，\n否则将仅在启用并激活灵活放置功能的情况下记住方块方向", "Fast Placement Remember Orientation"),
    REMEMBER_FLEXIBLE               ("rememberFlexibleFromClick",           true, "",     "启用该选项后，只要按住使用键，就会从第一个放置的方块中记住灵活方块的放置状态。", "Remember Flexible Orientation From First Click"),
    TWEAK_ACCURATE_BLOCK_PLACEMENT  ("tweakAccurateBlockPlacement",         false, "",    "启用更简单的“灵活放置”，类似于Carpet mod，因此基本可以使所单击的方块朝向内或向外。"),
    TWEAK_AFTER_CLICKER             ("tweakAfterClicker",                   false, "",    KeybindSettings.INGAME_BOTH, "启用自动调整功能，该功能会自动在刚放置的方块上单击鼠标右键。\n对于设置中继器延迟来说很有用。\n要快速调整单击次数，请在按住绑定按键的同时滚动滚轮"),
    TWEAK_AIM_LOCK                  ("tweakAimLock",                        false, "",    "！！！！！！！启用瞄准锁定，将偏航和俯仰旋转锁定为当前值。这与捕捉锁定不同，后者将锁定锁定为捕捉值，从而可以将锁定自由锁定为当前值"),
    TWEAK_ANGEL_BLOCK               ("tweakAngelBlock",                     false, "",    "启用“天使方块”选项，从而允许在半空中放置方块（仅限创造模式）"),
    TWEAK_BLOCK_REACH_OVERRIDE      ("tweakBlockReachOverride",             false, "",    "使用在 Generic -> blockReachDistance 中设置的距离覆盖默认的玩家可触碰到的方块距离"),
    TWEAK_BREAKING_GRID             ("tweakBreakingGrid",                   false, "",    KeybindSettings.INGAME_BOTH, "启用后，您只能在可配置的间隔中破坏方块。\n要快速调整间隔，请在按住绑定按键的同时滚动滚轮"),
    TWEAK_BREAKING_RESTRICTION      ("tweakBreakingRestriction",            false, "",    "启用“突破限制”模式（平面，图层，面，列，直线，对角线）。\n简单来说按住左键不能连续破坏方块，需要多次点击"),
    TWEAK_CHAT_BACKGROUND_COLOR     ("tweakChatBackgroundColor",            false, "",    "使用在 Generics->chat BackgroundColor 中设置的颜色覆盖默认的聊天背景颜色"),
    TWEAK_CHAT_PERSISTENT_TEXT      ("tweakChatPersistentText",             false, "",    "存储聊天框中的文本，并在再次打开聊天框时将其还原"),
    TWEAK_CHAT_TIMESTAMP            ("tweakChatTimestamp",                  false, "",    "在聊天消息上添加时间戳"),
    TWEAK_COMMAND_BLOCK_EXTRA_FIELDS("tweakCommandBlockExtraFields",        false, "",    "向命令方块的 GUI 添加额外的字段，用于设置命令块的名称并查看统计信息结果"),
    TWEAK_CUSTOM_FLAT_PRESETS       ("tweakCustomFlatPresets",              false, "",    "允许将自定义超平坦世界预设添加到列表中。预设需要在 Lists -> flatWorldPresets 中定义"),
    TWEAK_ELYTRA_CAMERA             ("tweakElytraCamera",                   false, "",    "允许在按住 \"elytraCamera\" 激活键的同时锁定玩家的真实旋转，\n然后控件将仅影响单独的'视角旋转'。\n推荐仅在良好而笔直地飞行时向下/环顾四周"),
    TWEAK_SHULKERBOX_STACKING       ("tweakEmptyShulkerBoxesStack",         false, true, "",    "启用该选项后，最多可堆叠64个空的潜影盒。\n注意：它们将堆叠在一起！在服务器上，这将导致故障，除非服务器具有与之相同的 mod。\n在单人游戏中，这会更改基于潜影盒的系统行为"),
    TWEAK_SHULKERBOX_STACK_GROUND   ("tweakEmptyShulkerBoxesStackOnGround", false, true, "",    "当作为地面上的物品时，最多可堆叠64个空的潜影盒"),
    TWEAK_EXPLOSION_REDUCED_PARTICLES ("tweakExplosionReducedParticles",    false, "",    "启用该选项后，所有爆炸粒子都将使用 EXPLOSION_NORMAL 粒子，\n而不是 EXPLOSION LARGE 或 EXPLOSION HUGE 粒子"),
    TWEAK_F3_CURSOR                 ("tweakF3Cursor",                       false, "",    "启用该选项后，将始终显示与F3屏幕中样式相同的光标"),
    TWEAK_FAKE_SNEAKING             ("tweakFakeSneaking",                   false, "",    "启用虚假潜行，即防止您从边缘跌落，且不降低移动速度"),
    TWEAK_FAST_BLOCK_PLACEMENT      ("tweakFastBlockPlacement",             false, "",    "将光标移到新方块上时，快速地放置方块"),
    TWEAK_FAST_LEFT_CLICK           ("tweakFastLeftClick",                  false, "",    "在按住攻击按钮的时候自动快速单击左键。\n在 Generic -> fastLeftClickCount 中可以设置每个 tick 的点击次数"),
    TWEAK_FAST_RIGHT_CLICK          ("tweakFastRightClick",                 false, "",    "在按住攻击按钮的时候自动快速单击右键。\n在 Generic -> fastRightClickCount 中可以设置每个 tick 的点击次数"),
    TWEAK_FILL_CLONE_LIMIT          ("tweakFillCloneLimit",                 false, true, "",    "Enables overriding the /fill and /clone command\nblock limits in single player.\nThe new limit can be set in the Generic configs,\nin the 'fillCloneLimit' config value"),
    TWEAK_FLY_SPEED                 ("tweakFlySpeed",                       false, "",    KeybindSettings.INGAME_BOTH, "Enables overriding the fly speed in creative or spectator mode\nand using some presets for it"),
    TWEAK_FLEXIBLE_BLOCK_PLACEMENT  ("tweakFlexibleBlockPlacement",         false, "",    "Enables placing blocks in different orientations\nor with an offset, while holding down the\nhotkeys for those modes."),
    TWEAK_FREE_CAMERA               ("tweakFreeCamera",                     false, "",    "Enables a free camera mode, similar to spectator mode,\nbut where the player will remain in place where\nyou first activate the free camera mode"),
    TWEAK_FREE_CAMERA_MOTION        ("tweakFreeCameraMotion",               false, "",    "When the Free Camera mode is enabled, if this feature is also enabled,\nthe movement inputs will affect the camera entity instead of the actual player.\nThis option is provided so that it's also possible to control\nthe actual player while in Free Camera mode, by disabling this option.\nNormally, if you just want to control the camera entity while in Free camera mode,\nthen just set the same hotkey for both features."),
    TWEAK_GAMMA_OVERRIDE            ("tweakGammaOverride",                  false, "",    "Overrides the video settings gamma value with\nthe one set in the Generic configs"),
    TWEAK_HAND_RESTOCK              ("tweakHandRestock",                    false, "",    "Enables swapping a new stack to the main or the offhand\nwhen the previous stack runs out"),
    TWEAK_HOLD_ATTACK               ("tweakHoldAttack",                     false, "",    "Emulates holding down the attack button"),
    TWEAK_HOLD_USE                  ("tweakHoldUse",                        false, "",    "Emulates holding down the use button"),
    TWEAK_HOTBAR_SCROLL             ("tweakHotbarScroll",                   false, "",    "Enables the hotbar swapping via scrolling feature"),
    TWEAK_HOTBAR_SLOT_CYCLE         ("tweakHotbarSlotCycle",                false, "",    KeybindSettings.INGAME_BOTH, "Enables cycling the selected hotbar slot after each placed\nblock, up to the set max slot number.\nTo quickly adjust the value, scroll while\nholding down the tweak toggle keybind."),
    TWEAK_HOTBAR_SLOT_RANDOMIZER    ("tweakHotbarSlotRandomizer",           false, "",    KeybindSettings.INGAME_BOTH, "Enables randomizing the selected hotbar slot after each placed\nblock, up to the set max slot number.\nTo quickly adjust the value, scroll while\nholding down the tweak toggle keybind."),
    TWEAK_HOTBAR_SWAP               ("tweakHotbarSwap",                     false, "",    "Enables the hotbar swapping via hotkeys feature"),
    TWEAK_INVENTORY_PREVIEW         ("tweakInventoryPreview",               false, true, "",    "Enables an inventory preview while having the cursor over\na block or an entity with an inventory and holding down\nthe configured hotkey."),
    TWEAK_ITEM_UNSTACKING_PROTECTION("tweakItemUnstackingProtection",       false, "",    "If enabled, then items configured in Lists -> unstackingItems\nwon't be allowed to spill out when using.\nThis is meant for example to prevent throwing buckets\ninto lava when filling them."),
    TWEAK_LAVA_VISIBILITY           ("tweakLavaVisibility",                 false, "",    "If enabled and the player has a Respiration helmet and/or\nWather Breathing active, the lava fog is greatly reduced."),
    TWEAK_MAP_PREVIEW               ("tweakMapPreview",                     false, "",    "If enabled, then holding shift over maps in an inventory\nwill render a preview of the map"),
    TWEAK_MOVEMENT_KEYS             ("tweakMovementKeysLast",               false, "",    "If enabled, then opposite movement keys won't cancel each other,\nbut instead the last pressed key is the active input."),
    TWEAK_PERIODIC_ATTACK           ("tweakPeriodicAttack",                 false, "",    "Enables periodic attacks (left clicks)\nConfigure the interval in Generic -> periodicAttackInterval"),
    TWEAK_PERIODIC_USE              ("tweakPeriodicUse",                    false, "",    "Enables periodic uses (right clicks)\nConfigure the interval in Generic -> periodicUseInterval"),
    TWEAK_PERMANENT_SNEAK           ("tweakPermanentSneak",                 false, "",    "If enabled, the player will be sneaking the entire time"),
    TWEAK_PERMANENT_SPRINT          ("tweakPermanentSprint",                false, "",    "If enabled, the player will be always sprinting when moving forward"),
    TWEAK_PLACEMENT_GRID            ("tweakPlacementGrid",                  false, "",    KeybindSettings.INGAME_BOTH, "When enabled, you can only place blocks in\na grid pattern, with a configurable interval.\nTo quickly adjust the value, scroll while\nholding down the tweak toggle keybind."),
    TWEAK_PLACEMENT_LIMIT           ("tweakPlacementLimit",                 false, "",    KeybindSettings.INGAME_BOTH, "When enabled, you can only place a set number\nof blocks per use/right click.\nTo quickly adjust the value, scroll while\nholding down the tweak toggle keybind."),
    TWEAK_PLACEMENT_RESTRICTION     ("tweakPlacementRestriction",           false, "",    "Enables the Placement Restriction mode\n  (Plane, Layer, Face, Column, Line, Diagonal)"),
    TWEAK_PLACEMENT_REST_FIRST      ("tweakPlacementRestrictionFirst",      false, "",    "Restricts block placement so that you can only\nplace blocks against the same block type\nyou first clicked on"),
    TWEAK_PLACEMENT_REST_HAND       ("tweakPlacementRestrictionHand",       false, "",    "Restricts block placement so that you can only\nplace blocks against the same block type\nyou are holding in your hand"),
    TWEAK_PLAYER_INVENTORY_PEEK     ("tweakPlayerInventoryPeek",            false, "",    "Enables a player inventory peek/preview, while holding the\nconfigured hotkey key for it."),
    TWEAK_POTION_WARNING            ("tweakPotionWarning",                  false, "",    "Prints a warning message to the hotbar when\nnon-ambient potion effects are about to run out"),
    TWEAK_PRINT_DEATH_COORDINATES   ("tweakPrintDeathCoordinates",          false, "",    "Enables printing the player's coordinates to chat on death.\nThis feature is originally from usefulmod by nessie."),
    TWEAK_PICK_BEFORE_PLACE         ("tweakPickBeforePlace",                false, "",    "If enabled, then before each block placement, the same block\nis switched to hand that you are placing against"),
    TWEAK_PLAYER_LIST_ALWAYS_ON     ("tweakPlayerListAlwaysVisible",        false, "",    "If enabled, then the player list is always rendered without\nhaving to hold down the key (tab by default)"),
    TWEAK_REMOVE_OWN_POTION_EFFECTS ("tweakRemoveOwnPotionEffects",         false, "",    "Removes the potion effect particles from the\nplayer itself in first person mode"),
    TWEAK_RENDER_INVISIBLE_ENTITIES ("tweakRenderInvisibleEntities",        false, "",    "When enabled, invisible entities are rendered like\nthey would be in spectator mode."),
    TWEAK_RENDER_LIMIT_ENTITIES     ("tweakRenderLimitEntities",            false, "",    "Enables limiting the number of certain types of entities\nto render per frame. Currently XP Orbs and Item entities\nare supported, see Generic configs for the limits."),
    TWEAK_REPAIR_MODE               ("tweakRepairMode",                     false, "",    "If enabled, then fully repaired items held in hand will\nbe swapped to damaged items that have Mending on them."),
    TWEAK_SHULKERBOX_DISPLAY        ("tweakShulkerBoxDisplay",              false, "",    "Enables the Shulker Box contents display when hovering\nover them in an inventory and holding shift"),
    TWEAK_SIGN_COPY                 ("tweakSignCopy",                       false, "",    "When enabled, placed signs will use the text from\nthe previously placed sign.\nCan be combined with tweakNoSignGui to quickly place copies\nof a sign, by enabling that tweak after making the first sign."),
    TWEAK_SNAP_AIM                  ("tweakSnapAim",                        false, "",    KeybindSettings.INGAME_BOTH, "Enabled a snap aim tweak, to make the player face to pre-set exact yaw rotations"),
    TWEAK_SNAP_AIM_LOCK             ("tweakSnapAimLock",                    false, "",    "Enables a snap aim lock, locking the yaw and/or pitch rotations\nto the currently snapped value"),
    TWEAK_SPECTATOR_TELEPORT        ("tweakSpectatorTeleport",              false, "",    "Allows spectators to teleport to other spectators.\nThis is originally from usefulmod by nessie."),
    TWEAK_STRUCTURE_BLOCK_LIMIT     ("tweakStructureBlockLimit",            false, true, "",    "Allows overriding the structure block limit.\nThe new limit is set in Generic -> structureBlockMaxSize"),
    TWEAK_SWAP_ALMOST_BROKEN_TOOLS  ("tweakSwapAlmostBrokenTools",          false, "",    "If enabled, then any damageable items held in the hand that\nare about to break will be swapped to fresh ones"),
    TWEAK_TAB_COMPLETE_COORDINATE   ("tweakTabCompleteCoordinate",          false, "",    "If enabled, then tab-completing coordinates while not\nlooking at a block, will use the player's position\ninstead of adding the ~ character."),
    TWEAK_TOOL_SWITCH               ("tweakToolSwitch",                     false, "",    "Enables automatically switching to an effective tool for the targeted block"),
    TWEAK_Y_MIRROR                  ("tweakYMirror",                        false, "",    "Mirrors the targeted y-position within the block bounds.\nThis is basically for placing slabs or stairs\nin the opposite top/bottom state from normal,\nif you have to place them against another slab for example."),
    TWEAK_ZOOM                      ("tweakZoom",                           false, "",    KeybindSettings.INGAME_BOTH, "Enables using the zoom hotkey to, well, zoom in");

    private final String name;
    private final String comment;
    private final String prettyName;
    private final IKeybind keybind;
    private final boolean defaultValueBoolean;
    private final boolean singlePlayer;
    private boolean valueBoolean;
    private IValueChangeCallback<IConfigBoolean> callback;

    private FeatureToggle(String name, boolean defaultValue, String defaultHotkey, String comment)
    {
        this(name, defaultValue, false, defaultHotkey, KeybindSettings.DEFAULT, comment);
    }

    private FeatureToggle(String name, boolean defaultValue, boolean singlePlayer, String defaultHotkey, String comment)
    {
        this(name, defaultValue, singlePlayer, defaultHotkey, KeybindSettings.DEFAULT, comment);
    }

    private FeatureToggle(String name, boolean defaultValue, String defaultHotkey, KeybindSettings settings, String comment)
    {
        this(name, defaultValue, false, defaultHotkey, settings, comment);
    }

    private FeatureToggle(String name, boolean defaultValue, boolean singlePlayer, String defaultHotkey, KeybindSettings settings, String comment)
    {
        this(name, defaultValue, singlePlayer, defaultHotkey, settings, comment, StringUtils.splitCamelCase(name.substring(5)));
    }

    private FeatureToggle(String name, boolean defaultValue, String defaultHotkey, String comment, String prettyName)
    {
        this(name, defaultValue, false, defaultHotkey, comment, prettyName);
    }

    private FeatureToggle(String name, boolean defaultValue, boolean singlePlayer, String defaultHotkey, String comment, String prettyName)
    {
        this(name, defaultValue, singlePlayer, defaultHotkey, KeybindSettings.DEFAULT, comment, prettyName);
    }

    private FeatureToggle(String name, boolean defaultValue, boolean singlePlayer, String defaultHotkey, KeybindSettings settings, String comment, String prettyName)
    {
        this.name = name;
        this.valueBoolean = defaultValue;
        this.defaultValueBoolean = defaultValue;
        this.singlePlayer = singlePlayer;
        this.comment = comment;
        this.prettyName = prettyName;
        this.keybind = KeybindMulti.fromStorageString(defaultHotkey, settings);
        this.keybind.setCallback(new KeyCallbackToggleBooleanConfigWithMessage(this));
    }

    @Override
    public ConfigType getType()
    {
        return ConfigType.HOTKEY;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public String getConfigGuiDisplayName()
    {
        if (this.singlePlayer)
        {
            return GuiBase.TXT_GOLD + this.getName() + GuiBase.TXT_RST;
        }

        return this.getName();
    }

    @Override
    public String getPrettyName()
    {
        return this.prettyName;
    }

    @Override
    public String getStringValue()
    {
        return String.valueOf(this.valueBoolean);
    }

    @Override
    public String getDefaultStringValue()
    {
        return String.valueOf(this.defaultValueBoolean);
    }

    @Override
    public void setValueFromString(String value)
    {
    }

    @Override
    public void onValueChanged()
    {
        if (this.callback != null)
        {
            this.callback.onValueChanged(this);
        }
    }

    @Override
    public void setValueChangeCallback(IValueChangeCallback<IConfigBoolean> callback)
    {
        this.callback = callback;
    }

    @Override
    public String getComment()
    {
        if (this.comment == null)
        {
            return "";
        }

        if (this.singlePlayer)
        {
            return this.comment + "\n" + StringUtils.translate("tweakeroo.label.config_comment.single_player_only");
        }
        else
        {
            return this.comment;
        }
    }

    @Override
    public IKeybind getKeybind()
    {
        return this.keybind;
    }

    @Override
    public boolean getBooleanValue()
    {
        return this.valueBoolean;
    }

    @Override
    public boolean getDefaultBooleanValue()
    {
        return this.defaultValueBoolean;
    }

    @Override
    public void setBooleanValue(boolean value)
    {
        boolean oldValue = this.valueBoolean;
        this.valueBoolean = value;

        if (oldValue != this.valueBoolean)
        {
            this.onValueChanged();
        }
    }

    @Override
    public boolean isModified()
    {
        return this.valueBoolean != this.defaultValueBoolean;
    }

    @Override
    public boolean isModified(String newValue)
    {
        return Boolean.parseBoolean(newValue) != this.defaultValueBoolean;
    }

    @Override
    public void resetToDefault()
    {
        this.valueBoolean = this.defaultValueBoolean;
    }

    @Override
    public JsonElement getAsJsonElement()
    {
        return new JsonPrimitive(this.valueBoolean);
    }

    @Override
    public void setValueFromJsonElement(JsonElement element)
    {
        try
        {
            if (element.isJsonPrimitive())
            {
                this.valueBoolean = element.getAsBoolean();
            }
            else
            {
                Tweakeroo.logger.warn("Failed to set config value for '{}' from the JSON element '{}'", this.getName(), element);
            }
        }
        catch (Exception e)
        {
            Tweakeroo.logger.warn("Failed to set config value for '{}' from the JSON element '{}'", this.getName(), element, e);
        }
    }
}
