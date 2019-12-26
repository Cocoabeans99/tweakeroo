package fi.dy.masa.tweakeroo.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import fi.dy.masa.malilib.config.ConfigType;
import fi.dy.masa.malilib.config.options.IConfigBoolean;
import fi.dy.masa.malilib.config.options.IConfigNotifiable;
import fi.dy.masa.malilib.gui.GuiBase;
import fi.dy.masa.malilib.hotkeys.IHotkey;
import fi.dy.masa.malilib.hotkeys.IKeybind;
import fi.dy.masa.malilib.hotkeys.KeyCallbackToggleBooleanConfigWithMessage;
import fi.dy.masa.malilib.hotkeys.KeybindMulti;
import fi.dy.masa.malilib.hotkeys.KeybindSettings;
import fi.dy.masa.malilib.interfaces.IValueChangeCallback;
import fi.dy.masa.malilib.util.StringUtils;
import fi.dy.masa.tweakeroo.LiteModTweakeroo;

public enum FeatureToggle implements IConfigBoolean, IHotkey, IConfigNotifiable<IConfigBoolean>
{
    CARPET_ACCURATE_PLACEMENT_PROTOCOL ("carpetAccuratePlacementProtocol",  false, "",    "如果启用，则FlexibleBlockPlacement和AccurateBlockPlacement功能将使用最新的Carpet mod中实现的协议", "地毯协议准确放置"),
    FAST_PLACEMENT_REMEMBER_ALWAYS  ("fastPlacementRememberOrientation",    true, "",     "如果启用，则FastBlockPlacement将记住你放置的第一个方块的方向。\n(在开启FlexibleBlockPlacement的情况下)", "FastBlockPlacement记住方向"),
    REMEMBER_FLEXIBLE               ("rememberFlexibleFromClick",           true, "",     "如果启用，则只要按住右键，FlexibleBlockPlacement就会记住状态。", "从第一次点击开始记住方向"),
    TWEAK_ACCURATE_BLOCK_PLACEMENT  ("tweakAccurateBlockPlacement",         false, "",    "启用更简单的FlexibleBlockplacement,像Carpet mod,要么面向要么背对要放置的方块面"),
    TWEAK_AFTER_CLICKER             ("tweakAfterClicker",                   false, "",    KeybindSettings.INGAME_BOTH, "*启用一个\"点击后\" 功能, clicker  调整，在刚刚放置的方块上自动右键单击，\n有时用于设置中继器延迟，有时用于快速调整数值。"),
    TWEAK_AIM_LOCK                  ("tweakAimLock",                        false, "",    "*启用瞄准锁定，将偏航角和俯仰角锁定到当前值。\n与锁定到捕捉值的SnapAimLock不同,这允许将它们“自由地”锁定到当前值。"),
    TWEAK_ANGEL_BLOCK               ("tweakAngelBlock",                     false, "",    "启用一种\"Angel Block\"功能,将允许在创造模式中将方块放在天上"),
    TWEAK_BLOCK_REACH_OVERRIDE      ("tweakBlockReachOverride",             false, "",    "开启后,使用通用 -> blockReachDistance来调整能够放置方块的最远距离"),
    TWEAK_BREAKING_GRID             ("tweakBreakingGrid",                   false, "",    KeybindSettings.INGAME_BOTH, "启用后，只能以可配置的间隔破坏网格模式中的块。"),
    TWEAK_BREAKING_RESTRICTION      ("tweakBreakingRestriction",            false, "",    "启用破坏限制模式(按照预定模式破坏方块，比如只拆某一层的方块)\n(Plane, Layer, Face, Column, Line, Diagonal)"),
    TWEAK_CHAT_BACKGROUND_COLOR     ("tweakChatBackgroundColor",            false, "",    "更改聊天框背景颜色\n使用通用 -> chatBackgroundColor来调整"),
    TWEAK_CHAT_PERSISTENT_TEXT      ("tweakChatPersistentText",             false, "",    "存储聊天框输入栏中的文本,\n再次打开输入栏时会将刚才的文字重写进去"),
    TWEAK_CHAT_TIMESTAMP            ("tweakChatTimestamp",                  false, "",    "给聊天记录加上时间前缀([00:00:00])"),
    TWEAK_CHUNK_RENDER_MAIN_THREAD  ("tweakChunkRenderOnMainThread",        false, "",    "强制在主线程上渲染区块。这能加快部分区块渲染，但在有大量区块更新时会大幅降低FPS。"),
    TWEAK_CHUNK_RENDER_TIMEOUT      ("tweakChunkRenderTimeoutOverride",     false, "",    "使用通用 -> chunkRenderTimeout的值来自定义区块渲染超时时长"),
    TWEAK_CLOUD_HEIGHT_OVERRIDE     ("tweakCloudHeightOverride",            false, "",    "使用通用 -> cloudHeightOverride来自定义云高"),
    TWEAK_COMMAND_BLOCK_EXTRA_FIELDS("tweakCommandBlockExtraFields",        false, "",    "给命令方块GUI添加新功能，用于设置命令方块的名称，以及查看统计结果"),
    TWEAK_CUSTOM_FLAT_PRESETS       ("tweakCustomFlatPresets",              false, "",    "允许将自定义超平坦世界预设添加到列表中。\n预设在列表 -> flatWorldPresets中定义"),
    TWEAK_ELYTRA_CAMERA             ("tweakElytraCamera",                   false, "",    "*允许在按住elytraCamera激活键的同时锁定真实的玩家旋转，控件将仅影响渲染/相机的单独的相机旋转。"),
    TWEAK_SHULKERBOX_STACKING       ("tweakEmptyShulkerBoxesStack",         false, true, "",    "将允许空潜影盒堆叠到64(仅限单人)"),
    TWEAK_SHULKERBOX_STACK_GROUND   ("tweakEmptyShulkerBoxesStackOnGround", false, true, "",    "将允许空潜影盒在掉落物状态时堆叠到64(仅限单人)"),
    TWEAK_EXPLOSION_REDUCED_PARTICLES ("tweakExplosionReducedParticles",    false, "",    "启用后将强制使用EXPLOSION_NORMAL粒子\n(降低爆炸特效)"),
    TWEAK_F3_CURSOR                 ("tweakF3Cursor",                       false, "",    "*始终启用F3屏幕光标渲染"),
    TWEAK_FAKE_SNEAKING             ("tweakFakeSneaking",                   false, "",    "启用后，不按潜行也不会从方块边上掉下去"),
    TWEAK_FAST_BLOCK_PLACEMENT      ("tweakFastBlockPlacement",             false, "",    "快 速 放 置\n(真的很快!)"),
    TWEAK_FAST_LEFT_CLICK           ("tweakFastLeftClick",                  false, "",    "在按住左键时自动快速左键单击,每个游戏刻的点击次数在通用 -> configs中设置。"),
    TWEAK_FAST_RIGHT_CLICK          ("tweakFastRightClick",                 false, "",    "在按住右键时自动快速右键单击,每个游戏刻的点击次数在通用 -> configs中设置。"),
    TWEAK_FILL_CLONE_LIMIT          ("tweakFillCloneLimit",                 false, true, "",    "允许在单人游戏中自定义/fill和/clone命令的方块上限,\n可以在通用 -> fillCloneLimit中调整"),
    TWEAK_FLY_SPEED                 ("tweakFlySpeed",                       false, "",    "允许在创造或旁观者模式自定义飞行速度并为其使用一些预设"),
    TWEAK_FLEXIBLE_BLOCK_PLACEMENT  ("tweakFlexibleBlockPlacement",         false, "",    "按住热键来以不同状态放置方块"),
    TWEAK_FREE_CAMERA               ("tweakFreeCamera",                     false, "",    "开启自由视角模式(观察者模式!),但玩家将保留在首次激活该模式的位置"),
    TWEAK_FREE_CAMERA_MOTION        ("tweakFreeCameraMotion",               false, "",    "启用后，在自由视角模式模式下的WASD将不会输入给玩家本体"),
    TWEAK_GAMMA_OVERRIDE            ("tweakGammaOverride",                  false, "",    "无 限 夜 视"),
    TWEAK_HAND_RESTOCK              ("tweakHandRestock",                    false, "",    "自 动 补 货"),
    TWEAK_HOLD_ATTACK               ("tweakHoldAttack",                     false, "",    "模拟按住左键"),
    TWEAK_HOLD_USE                  ("tweakHoldUse",                        false, "",    "模拟按住右键"),
    TWEAK_HOTBAR_SCROLL             ("tweakHotbarScroll",                   false, "",    "启用物品栏滚动选择"),
    TWEAK_HOTBAR_SLOT_CYCLE         ("tweakHotbarSlotCycle",                false, "",    KeybindSettings.INGAME_BOTH, "允许在放置方块后循环选定的快捷栏栏位,直到设置的最大栏位。"),
    TWEAK_HOTBAR_SLOT_RANDOMIZER    ("tweakHotbarSlotRandomizer",           false, "",    KeybindSettings.INGAME_BOTH, "允许在放置方块后随机选定的快捷栏栏位,直到设置的最大栏位。"),
    TWEAK_HOTBAR_SWAP               ("tweakHotbarSwap",                     false, "",    "通过热键启用物品栏滚动选择功能"),
    TWEAK_INVENTORY_PREVIEW         ("tweakInventoryPreview",               false, true, "",    "内容物预览(箱子、潜影盒)"),
    TWEAK_ITEM_UNSTACKING_PROTECTION("tweakItemUnstackingProtection",       false, "",    "防止在舀岩浆时因为背包满了而把岩浆桶扔进岩浆,\n可以在列表 -> unstackingItems中自定义适用的物品(水瓶之类的)"),
    TWEAK_LAVA_VISIBILITY           ("tweakLavaVisibility",                 false, "",    "岩 浆 夜 视(戴着水下呼吸的帽子进岩浆可以看得更清楚)"),
    TWEAK_MAP_PREVIEW               ("tweakMapPreview",                     false, "",    "*如果启用，则在清单中按住shift将呈现地图预览"),
    TWEAK_MOVEMENT_KEYS             ("tweakMovementKeysLast",               false, "",    "启用后按下相反的移动键不会停下来，而是以最后按的方向键的方向进行移动"),
    TWEAK_PERIODIC_ATTACK           ("tweakPeriodicAttack",                 false, "",    "长按左键自动攻击"),
    TWEAK_PERIODIC_USE              ("tweakPeriodicUse",                    false, "",    "长安右键自动使用"),
    TWEAK_PERMANENT_SNEAK           ("tweakPermanentSneak",                 false, "",    "启用后会一直潜行"),
    TWEAK_PERMANENT_SPRINT          ("tweakPermanentSprint",                false, "",    "启用后在前进时会自动进入疾跑"),
    TWEAK_PICK_BEFORE_PLACE         ("tweakPickBeforePlace",                false, "",    "*如果启用，则在每个块放置之前，将切换到要放置的同一个块"),
    TWEAK_PLACEMENT_GRID            ("tweakPlacementGrid",                  false, "",    KeybindSettings.INGAME_BOTH, "启用后，只能以网格模式放置方块，间隔可自定义。"),
    TWEAK_PLACEMENT_LIMIT           ("tweakPlacementLimit",                 false, "",    KeybindSettings.INGAME_BOTH, "启用后每次右键最多只能放置一定数量的方块,可自定义上限"),
    TWEAK_PLACEMENT_RESTRICTION     ("tweakPlacementRestriction",           false, "",    "启用放置限制模式(Plane, Layer, Face, Column, Line, Diagonal)"),
    TWEAK_PLACEMENT_REST_FIRST      ("tweakPlacementRestrictionFirst",      false, "",    "启用后只放置在与首次放置的方块类型相同的方块上"),
    TWEAK_PLACEMENT_REST_HAND       ("tweakPlacementRestrictionHand",       false, "",    "启用后只放置在与手中的方块类型相同的方块上"),
    TWEAK_PLAYER_INVENTORY_PEEK     ("tweakPlayerInventoryPeek",            false, "",    "*按住热键以查看/预览玩家清单"),
    TWEAK_PLAYER_LIST_ALWAYS_ON     ("tweakPlayerListAlwaysVisible",        false, "",    "使玩家列表一直出现(相当于按住Tab)"),
    TWEAK_PLAYER_ON_FIRE_SCALE      ("tweakPlayerOnFireScale",              false, "",    "调整自己着火时的火焰特效,\n使用通用 -> playerOnFireScale来调整"),
    TWEAK_POTION_WARNING            ("tweakPotionWarning",                  false, "",    "当药水效果快要结束时发出警告"),
    TWEAK_PRINT_DEATH_COORDINATES   ("tweakPrintDeathCoordinates",          false, "",    "启用后在死亡时将会将死亡坐标发送到聊天栏"),
    TWEAK_RELAXED_BLOCK_PLACEMENT   ("tweakRelaxedBlockPlacement",          false, true, "",    "*允许在不受限制的情况下放置方块，例如半空中的栅栏门和南瓜"),
    TWEAK_REMOVE_OWN_POTION_EFFECTS ("tweakRemoveOwnPotionEffects",         false, "",    "移除药水的粒子效果(仅对于自己)"),
    TWEAK_RENDER_INVISIBLE_ENTITIES ("tweakRenderInvisibleEntities",        false, "",    "*启用后，不可见实体的呈现方式与在旁观者模式下的呈现方式相同"),
    TWEAK_RENDER_LIMIT_ENTITIES     ("tweakRenderLimitEntities",            false, "",    "允许限制每帧渲染的实体数和经验球数,在通用设置中自定义数量上限"),
    TWEAK_REPAIR_MODE               ("tweakRepairMode",                     false, "",    "经验修复模式(耐久修复满了会自动切换装备)"),
    TWEAK_SHULKERBOX_DISPLAY        ("tweakShulkerBoxDisplay",              false, "",    "按住shift来预览潜影盒内容物"),
    TWEAK_SIGN_COPY                 ("tweakSignCopy",                       false, "",    "告示牌内容复制(开启后放的牌子会预先写好上一个牌子的内容)"),
    TWEAK_SNAP_AIM                  ("tweakSnapAim",                        false, "",    KeybindSettings.INGAME_BOTH, "*启用快速瞄准，使玩家面对预先设定的精确偏航角旋转"),
    TWEAK_SNAP_AIM_LOCK             ("tweakSnapAimLock",                    false, "",    "*启用快速瞄准锁定，将偏航角和/或俯仰角旋转锁定到当前捕捉的值"),
    TWEAK_SPECTATOR_TELEPORT        ("tweakSpectatorTeleport",              false, "",    "允许观察者传送到其他观察者的位置"),
    TWEAK_STATIC_FOV                ("tweakStaticFov",                      false, "",    "防止视角拉伸(冲刺、飞行时)"),
    TWEAK_STRUCTURE_BLOCK_LIMIT     ("tweakStructureBlockLimit",            false, true, "",    "自定义结构方块的范围上限,在通用 -> structureBlockMaxSize中调整"),
    TWEAK_SWAP_ALMOST_BROKEN_TOOLS  ("tweakSwapAlmostBrokenTools",          false, "",    "自动替换快坏掉的工具 "),
    TWEAK_TAB_COMPLETE_COORDINATE   ("tweakTabCompleteCoordinate",          false, "",    "启用后,在用Tab补全坐标时如果不看方块,会使用玩家当前坐标(而不是~ ~ ~)"),
    TWEAK_TILE_RENDER_DISTANCE      ("tweakTileEntityRenderDistance",       false, "",    "*允许从任意距离渲染实体，而不仅是从通常的64个区块之外渲染"),
    TWEAK_TOOL_SWITCH               ("tweakToolSwitch",                     false, "",    "能够自动切换到合适的工具"),
    TWEAK_Y_MIRROR                  ("tweakYMirror",                        false, "",    "镜像放方块(比如反向放楼梯)"),
    TWEAK_ZOOM                      ("tweakZoom",                           false, "",    KeybindSettings.INGAME_BOTH, "允许使用缩放热键");

    private final String name;
    private final String comment;
    private final String prettyName;
    private final IKeybind keybind;
    private final boolean defaultValueBoolean;
    private final boolean singlePlayer;
    private String modName;
    private boolean valueBoolean;
    private boolean lastSavedValueBoolean;
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
        this.keybind = KeybindMulti.fromStorageString(name, defaultHotkey, settings);
        this.keybind.setCallback(new KeyCallbackToggleBooleanConfigWithMessage(this));

        this.cacheSavedValue();
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
    public String getModName()
    {
        return this.modName;
    }

    @Override
    public void setModName(String modName)
    {
        this.modName = modName;
        this.keybind.setModName(modName);
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
    public boolean isDirty()
    {
        return this.lastSavedValueBoolean != this.valueBoolean || this.keybind.isDirty();
    }

    @Override
    public void cacheSavedValue()
    {
        this.lastSavedValueBoolean = this.valueBoolean;
        this.keybind.cacheSavedValue();
    }

    @Override
    public void resetToDefault()
    {
        this.valueBoolean = this.defaultValueBoolean;
    }

    @Override
    public void setValueFromJsonElement(JsonElement element, String configName)
    {
        try
        {
            if (element.isJsonPrimitive())
            {
                this.valueBoolean = element.getAsBoolean();
            }
            else
            {
                LiteModTweakeroo.logger.warn("Failed to set config value for '{}' from the JSON element '{}'", configName, element);
            }
        }
        catch (Exception e)
        {
            LiteModTweakeroo.logger.warn("Failed to set config value for '{}' from the JSON element '{}'", configName, element, e);
        }

        this.cacheSavedValue();
    }

    @Override
    public JsonElement getAsJsonElement()
    {
        return new JsonPrimitive(this.valueBoolean);
    }
}
