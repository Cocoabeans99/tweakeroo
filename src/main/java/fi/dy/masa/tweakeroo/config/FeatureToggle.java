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
    CARPET_ACCURATE_PLACEMENT_PROTOCOL ("carpetAccuratePlacementProtocol",  false, "",    "������ã���FlexibleBlockPlacement��AccurateBlockPlacement���ܽ�ʹ�����µ�Carpet mod��ʵ�ֵ�Э��", "��̺Э��׼ȷ����"),
    FAST_PLACEMENT_REMEMBER_ALWAYS  ("fastPlacementRememberOrientation",    true, "",     "������ã���FastBlockPlacement����ס����õĵ�һ������ķ���\n(�ڿ���FlexibleBlockPlacement�������)", "FastBlockPlacement��ס����"),
    REMEMBER_FLEXIBLE               ("rememberFlexibleFromClick",           true, "",     "������ã���ֻҪ��ס�Ҽ���FlexibleBlockPlacement�ͻ��ס״̬��", "�ӵ�һ�ε����ʼ��ס����"),
    TWEAK_ACCURATE_BLOCK_PLACEMENT  ("tweakAccurateBlockPlacement",         false, "",    "���ø��򵥵�FlexibleBlockplacement,��Carpet mod,Ҫô����Ҫô����Ҫ���õķ�����"),
    TWEAK_AFTER_CLICKER             ("tweakAfterClicker",                   false, "",    KeybindSettings.INGAME_BOTH, "*����һ��\"�����\" ����, clicker  �������ڸոշ��õķ������Զ��Ҽ�������\n��ʱ���������м����ӳ٣���ʱ���ڿ��ٵ�����ֵ��"),
    TWEAK_AIM_LOCK                  ("tweakAimLock",                        false, "",    "*������׼��������ƫ���Ǻ͸�������������ǰֵ��\n����������׽ֵ��SnapAimLock��ͬ,���������ǡ����ɵء���������ǰֵ��"),
    TWEAK_ANGEL_BLOCK               ("tweakAngelBlock",                     false, "",    "����һ��\"Angel Block\"����,�������ڴ���ģʽ�н������������"),
    TWEAK_BLOCK_REACH_OVERRIDE      ("tweakBlockReachOverride",             false, "",    "������,ʹ��ͨ�� -> blockReachDistance�������ܹ����÷������Զ����"),
    TWEAK_BREAKING_GRID             ("tweakBreakingGrid",                   false, "",    KeybindSettings.INGAME_BOTH, "���ú�ֻ���Կ����õļ���ƻ�����ģʽ�еĿ顣"),
    TWEAK_BREAKING_RESTRICTION      ("tweakBreakingRestriction",            false, "",    "�����ƻ�����ģʽ(����Ԥ��ģʽ�ƻ����飬����ֻ��ĳһ��ķ���)\n(Plane, Layer, Face, Column, Line, Diagonal)"),
    TWEAK_CHAT_BACKGROUND_COLOR     ("tweakChatBackgroundColor",            false, "",    "��������򱳾���ɫ\nʹ��ͨ�� -> chatBackgroundColor������"),
    TWEAK_CHAT_PERSISTENT_TEXT      ("tweakChatPersistentText",             false, "",    "�洢������������е��ı�,\n�ٴδ�������ʱ�Ὣ�ղŵ�������д��ȥ"),
    TWEAK_CHAT_TIMESTAMP            ("tweakChatTimestamp",                  false, "",    "�������¼����ʱ��ǰ׺([00:00:00])"),
    TWEAK_CHUNK_RENDER_MAIN_THREAD  ("tweakChunkRenderOnMainThread",        false, "",    "ǿ�������߳�����Ⱦ���顣���ܼӿ첿��������Ⱦ�������д����������ʱ��������FPS��"),
    TWEAK_CHUNK_RENDER_TIMEOUT      ("tweakChunkRenderTimeoutOverride",     false, "",    "ʹ��ͨ�� -> chunkRenderTimeout��ֵ���Զ���������Ⱦ��ʱʱ��"),
    TWEAK_CLOUD_HEIGHT_OVERRIDE     ("tweakCloudHeightOverride",            false, "",    "ʹ��ͨ�� -> cloudHeightOverride���Զ����Ƹ�"),
    TWEAK_COMMAND_BLOCK_EXTRA_FIELDS("tweakCommandBlockExtraFields",        false, "",    "�������GUI����¹��ܣ������������������ƣ��Լ��鿴ͳ�ƽ��"),
    TWEAK_CUSTOM_FLAT_PRESETS       ("tweakCustomFlatPresets",              false, "",    "�����Զ��峬ƽ̹����Ԥ����ӵ��б��С�\nԤ�����б� -> flatWorldPresets�ж���"),
    TWEAK_ELYTRA_CAMERA             ("tweakElytraCamera",                   false, "",    "*�����ڰ�סelytraCamera�������ͬʱ������ʵ�������ת���ؼ�����Ӱ����Ⱦ/����ĵ����������ת��"),
    TWEAK_SHULKERBOX_STACKING       ("tweakEmptyShulkerBoxesStack",         false, true, "",    "�������ǱӰ�жѵ���64(���޵���)"),
    TWEAK_SHULKERBOX_STACK_GROUND   ("tweakEmptyShulkerBoxesStackOnGround", false, true, "",    "�������ǱӰ���ڵ�����״̬ʱ�ѵ���64(���޵���)"),
    TWEAK_EXPLOSION_REDUCED_PARTICLES ("tweakExplosionReducedParticles",    false, "",    "���ú�ǿ��ʹ��EXPLOSION_NORMAL����\n(���ͱ�ը��Ч)"),
    TWEAK_F3_CURSOR                 ("tweakF3Cursor",                       false, "",    "*ʼ������F3��Ļ�����Ⱦ"),
    TWEAK_FAKE_SNEAKING             ("tweakFakeSneaking",                   false, "",    "���ú󣬲���Ǳ��Ҳ����ӷ�����ϵ���ȥ"),
    TWEAK_FAST_BLOCK_PLACEMENT      ("tweakFastBlockPlacement",             false, "",    "�� �� �� ��\n(��ĺܿ�!)"),
    TWEAK_FAST_LEFT_CLICK           ("tweakFastLeftClick",                  false, "",    "�ڰ�ס���ʱ�Զ������������,ÿ����Ϸ�̵ĵ��������ͨ�� -> configs�����á�"),
    TWEAK_FAST_RIGHT_CLICK          ("tweakFastRightClick",                 false, "",    "�ڰ�ס�Ҽ�ʱ�Զ������Ҽ�����,ÿ����Ϸ�̵ĵ��������ͨ�� -> configs�����á�"),
    TWEAK_FILL_CLONE_LIMIT          ("tweakFillCloneLimit",                 false, true, "",    "�����ڵ�����Ϸ���Զ���/fill��/clone����ķ�������,\n������ͨ�� -> fillCloneLimit�е���"),
    TWEAK_FLY_SPEED                 ("tweakFlySpeed",                       false, "",    "�����ڴ�����Թ���ģʽ�Զ�������ٶȲ�Ϊ��ʹ��һЩԤ��"),
    TWEAK_FLEXIBLE_BLOCK_PLACEMENT  ("tweakFlexibleBlockPlacement",         false, "",    "��ס�ȼ����Բ�ͬ״̬���÷���"),
    TWEAK_FREE_CAMERA               ("tweakFreeCamera",                     false, "",    "���������ӽ�ģʽ(�۲���ģʽ!),����ҽ��������״μ����ģʽ��λ��"),
    TWEAK_FREE_CAMERA_MOTION        ("tweakFreeCameraMotion",               false, "",    "���ú��������ӽ�ģʽģʽ�µ�WASD�������������ұ���"),
    TWEAK_GAMMA_OVERRIDE            ("tweakGammaOverride",                  false, "",    "�� �� ҹ ��"),
    TWEAK_HAND_RESTOCK              ("tweakHandRestock",                    false, "",    "�� �� �� ��"),
    TWEAK_HOLD_ATTACK               ("tweakHoldAttack",                     false, "",    "ģ�ⰴס���"),
    TWEAK_HOLD_USE                  ("tweakHoldUse",                        false, "",    "ģ�ⰴס�Ҽ�"),
    TWEAK_HOTBAR_SCROLL             ("tweakHotbarScroll",                   false, "",    "������Ʒ������ѡ��"),
    TWEAK_HOTBAR_SLOT_CYCLE         ("tweakHotbarSlotCycle",                false, "",    KeybindSettings.INGAME_BOTH, "�����ڷ��÷����ѭ��ѡ���Ŀ������λ,ֱ�����õ������λ��"),
    TWEAK_HOTBAR_SLOT_RANDOMIZER    ("tweakHotbarSlotRandomizer",           false, "",    KeybindSettings.INGAME_BOTH, "�����ڷ��÷�������ѡ���Ŀ������λ,ֱ�����õ������λ��"),
    TWEAK_HOTBAR_SWAP               ("tweakHotbarSwap",                     false, "",    "ͨ���ȼ�������Ʒ������ѡ����"),
    TWEAK_INVENTORY_PREVIEW         ("tweakInventoryPreview",               false, true, "",    "������Ԥ��(���ӡ�ǱӰ��)"),
    TWEAK_ITEM_UNSTACKING_PROTECTION("tweakItemUnstackingProtection",       false, "",    "��ֹ��Ҩ�ҽ�ʱ��Ϊ�������˶����ҽ�Ͱ�ӽ��ҽ�,\n�������б� -> unstackingItems���Զ������õ���Ʒ(ˮƿ֮���)"),
    TWEAK_LAVA_VISIBILITY           ("tweakLavaVisibility",                 false, "",    "�� �� ҹ ��(����ˮ�º�����ñ�ӽ��ҽ����Կ��ø����)"),
    TWEAK_MAP_PREVIEW               ("tweakMapPreview",                     false, "",    "*������ã������嵥�а�סshift�����ֵ�ͼԤ��"),
    TWEAK_MOVEMENT_KEYS             ("tweakMovementKeysLast",               false, "",    "���ú����෴���ƶ�������ͣ��������������󰴵ķ�����ķ�������ƶ�"),
    TWEAK_PERIODIC_ATTACK           ("tweakPeriodicAttack",                 false, "",    "��������Զ�����"),
    TWEAK_PERIODIC_USE              ("tweakPeriodicUse",                    false, "",    "�����Ҽ��Զ�ʹ��"),
    TWEAK_PERMANENT_SNEAK           ("tweakPermanentSneak",                 false, "",    "���ú��һֱǱ��"),
    TWEAK_PERMANENT_SPRINT          ("tweakPermanentSprint",                false, "",    "���ú���ǰ��ʱ���Զ����뼲��"),
    TWEAK_PICK_BEFORE_PLACE         ("tweakPickBeforePlace",                false, "",    "*������ã�����ÿ�������֮ǰ�����л���Ҫ���õ�ͬһ����"),
    TWEAK_PLACEMENT_GRID            ("tweakPlacementGrid",                  false, "",    KeybindSettings.INGAME_BOTH, "���ú�ֻ��������ģʽ���÷��飬������Զ��塣"),
    TWEAK_PLACEMENT_LIMIT           ("tweakPlacementLimit",                 false, "",    KeybindSettings.INGAME_BOTH, "���ú�ÿ���Ҽ����ֻ�ܷ���һ�������ķ���,���Զ�������"),
    TWEAK_PLACEMENT_RESTRICTION     ("tweakPlacementRestriction",           false, "",    "���÷�������ģʽ(Plane, Layer, Face, Column, Line, Diagonal)"),
    TWEAK_PLACEMENT_REST_FIRST      ("tweakPlacementRestrictionFirst",      false, "",    "���ú�ֻ���������״η��õķ���������ͬ�ķ�����"),
    TWEAK_PLACEMENT_REST_HAND       ("tweakPlacementRestrictionHand",       false, "",    "���ú�ֻ�����������еķ���������ͬ�ķ�����"),
    TWEAK_PLAYER_INVENTORY_PEEK     ("tweakPlayerInventoryPeek",            false, "",    "*��ס�ȼ��Բ鿴/Ԥ������嵥"),
    TWEAK_PLAYER_LIST_ALWAYS_ON     ("tweakPlayerListAlwaysVisible",        false, "",    "ʹ����б�һֱ����(�൱�ڰ�סTab)"),
    TWEAK_PLAYER_ON_FIRE_SCALE      ("tweakPlayerOnFireScale",              false, "",    "�����Լ��Ż�ʱ�Ļ�����Ч,\nʹ��ͨ�� -> playerOnFireScale������"),
    TWEAK_POTION_WARNING            ("tweakPotionWarning",                  false, "",    "��ҩˮЧ����Ҫ����ʱ��������"),
    TWEAK_PRINT_DEATH_COORDINATES   ("tweakPrintDeathCoordinates",          false, "",    "���ú�������ʱ���Ὣ�������귢�͵�������"),
    TWEAK_RELAXED_BLOCK_PLACEMENT   ("tweakRelaxedBlockPlacement",          false, true, "",    "*�����ڲ������Ƶ�����·��÷��飬�������е�դ���ź��Ϲ�"),
    TWEAK_REMOVE_OWN_POTION_EFFECTS ("tweakRemoveOwnPotionEffects",         false, "",    "�Ƴ�ҩˮ������Ч��(�������Լ�)"),
    TWEAK_RENDER_INVISIBLE_ENTITIES ("tweakRenderInvisibleEntities",        false, "",    "*���ú󣬲��ɼ�ʵ��ĳ��ַ�ʽ�����Թ���ģʽ�µĳ��ַ�ʽ��ͬ"),
    TWEAK_RENDER_LIMIT_ENTITIES     ("tweakRenderLimitEntities",            false, "",    "��������ÿ֡��Ⱦ��ʵ�����;�������,��ͨ���������Զ�����������"),
    TWEAK_REPAIR_MODE               ("tweakRepairMode",                     false, "",    "�����޸�ģʽ(�;��޸����˻��Զ��л�װ��)"),
    TWEAK_SHULKERBOX_DISPLAY        ("tweakShulkerBoxDisplay",              false, "",    "��סshift��Ԥ��ǱӰ��������"),
    TWEAK_SIGN_COPY                 ("tweakSignCopy",                       false, "",    "��ʾ�����ݸ���(������ŵ����ӻ�Ԥ��д����һ�����ӵ�����)"),
    TWEAK_SNAP_AIM                  ("tweakSnapAim",                        false, "",    KeybindSettings.INGAME_BOTH, "*���ÿ�����׼��ʹ������Ԥ���趨�ľ�ȷƫ������ת"),
    TWEAK_SNAP_AIM_LOCK             ("tweakSnapAimLock",                    false, "",    "*���ÿ�����׼��������ƫ���Ǻ�/��������ת��������ǰ��׽��ֵ"),
    TWEAK_SPECTATOR_TELEPORT        ("tweakSpectatorTeleport",              false, "",    "����۲��ߴ��͵������۲��ߵ�λ��"),
    TWEAK_STATIC_FOV                ("tweakStaticFov",                      false, "",    "��ֹ�ӽ�����(��̡�����ʱ)"),
    TWEAK_STRUCTURE_BLOCK_LIMIT     ("tweakStructureBlockLimit",            false, true, "",    "�Զ���ṹ����ķ�Χ����,��ͨ�� -> structureBlockMaxSize�е���"),
    TWEAK_SWAP_ALMOST_BROKEN_TOOLS  ("tweakSwapAlmostBrokenTools",          false, "",    "�Զ��滻�컵���Ĺ��� "),
    TWEAK_TAB_COMPLETE_COORDINATE   ("tweakTabCompleteCoordinate",          false, "",    "���ú�,����Tab��ȫ����ʱ�����������,��ʹ����ҵ�ǰ����(������~ ~ ~)"),
    TWEAK_TILE_RENDER_DISTANCE      ("tweakTileEntityRenderDistance",       false, "",    "*��������������Ⱦʵ�壬�������Ǵ�ͨ����64������֮����Ⱦ"),
    TWEAK_TOOL_SWITCH               ("tweakToolSwitch",                     false, "",    "�ܹ��Զ��л������ʵĹ���"),
    TWEAK_Y_MIRROR                  ("tweakYMirror",                        false, "",    "����ŷ���(���練���¥��)"),
    TWEAK_ZOOM                      ("tweakZoom",                           false, "",    KeybindSettings.INGAME_BOTH, "����ʹ�������ȼ�");

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
