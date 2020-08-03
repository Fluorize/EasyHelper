package com.gmail.supergame314.easyhelper;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.SpectralArrow;
import org.bukkit.entity.TippedArrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class EasyHelper extends JavaPlugin implements Listener {

    static String prefix = "§f§l[§2§lEH§f§l]";
    static Map<Player, Integer> chatting= new HashMap<>();

    static List<Inventory> gui = new ArrayList<>();


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equals("eh")){
            if(!(sender instanceof Player)) {
                sender.sendMessage("You can't use it from console.");
                return true;
            }
            Player p=(Player)sender;
            p.openInventory(gui.get(0));
        }
        return true;
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this,this);
        // Plugin startup logic
        gui.add(0,Bukkit.createInventory(null, 54,"§l[EH] Menu"));
        gui.get(0).setItem(0,getItem(Material.LOG,0,"§a§lアイテム系統","§7持っているアイテムを編集します。"));
        Inventory i = Bukkit.createInventory(null, 54,"§l[EH] アイテム系");
        i.setItem(0,getItem(Material.ENCHANTMENT_TABLE,0,"§5§lエンチャント"));
        i.setItem(1,getItem(Material.ANVIL,0,"§5§lダメージ","§7チャット欄を利用します"));
        i.setItem(2,getItem(Material.REDSTONE_TORCH_ON,0,"§5§l表示フラグ"));
        i.setItem(3,getItem(Material.NAME_TAG,0,"§5§l名前","§7チャット欄を利用します"));
        i.setItem(4,getItem(Material.SIGN,0,"§5§l説明欄","§7チャット欄を利用します"));
        gui.add(1,i);
        i=Bukkit.createInventory(null, 54,"§l[EH] エンチャント");
        i.setItem(0,getItem(Material.DIAMOND_SWORD,0,"剣に使われるエンチャント"));
        i.setItem(2,getItem(Material.BLAZE_ROD,0,"§a§lダメージ増加"));
        i.setItem(3,getItem(Material.SKULL_ITEM,2,"§a§lアンデット特攻"));
        i.setItem(4,getItem(Material.STRING,0,"§a§l虫特攻"));
        i.setItem(5,getItem(Material.STICK,0,"§a§lノックバック","§7なんか棒って吹っ飛びそうなイメージ...."));
        i.setItem(6,getItem(Material.FLINT_AND_STEEL,0,"§a§l火属性"));
        i.setItem(7,getItem(Material.IRON_INGOT,0,"§a§lドロップ増加"));
        i.setItem(8,getItem(Material.SEEDS,0,"§a§l範囲ダメージ増加","§7何故このアイテムが使われたかは知られていない...."));
        i.setItem(9,getItem(Material.DIAMOND_CHESTPLATE,0,"防具に使われるエンチャント"));
        i.setItem(11,getItem(Material.CHAINMAIL_CHESTPLATE,0,"§a§lダメージ軽減"));
        i.setItem(12,getItem(Material.WATER_BUCKET,0,"§a§l火炎耐性"));
        i.setItem(13,getItem(Material.OBSIDIAN,0,"§a§l爆発耐性"));
        i.setItem(14,getItem(Material.ARROW,0,"§a§l飛び道具耐性"));
        i.setItem(15,getItem(Material.FEATHER,0,"§a§l落下耐性"));
        i.setItem(16,getItem(Material.DOUBLE_PLANT,4,"§a§l棘の鎧","§7バラの棘より。"));
        i.setItem(17,getItem(Material.CHAINMAIL_BOOTS,0,"§a§l水中歩行"));
        i.setItem(20,getItem(Material.STONE_PICKAXE,0,"§a§l水中採掘"));
        i.setItem(21,getItem(Material.SPONGE,0,"§a§l水中呼吸","§7何を使えばよかったんだろ"));
        i.setItem(22,getItem(Material.ICE,0,"§a§l氷渡り","§7現実にあったらかっこいいなんて思ったり"));
        i.setItem(27,getItem(Material.DIAMOND_PICKAXE,0,"§a§l道具に使われるエンチャント"));
        i.setItem(29,getItem(Material.STONE_PICKAXE,0,"§a§l効率強化"));
        i.setItem(30,getItem(Material.STONE,0,"§a§lシルクタッチ"));
        i.setItem(31,getItem(Material.REDSTONE,0,"§a§l幸運"));
        i.setItem(36,getItem(Material.BOW,0,"弓に使われるエンチャント"));
        i.setItem(37,getItem(Material.STONE,0,"§a§l無限"));
        i.setItem(38,getItem(Material.STONE,0,"§a§lパンチ","§7弓のノックバックです"));
        ItemStack im = getItem(Material.TIPPED_ARROW,0,"§a§lフレイム","§7弓の火属性です");
        PotionMeta meta = (PotionMeta) im.getItemMeta();
        meta.setColor(Color.RED);
        im.setItemMeta(meta);
        i.setItem(39,im);
        i.setItem(40,getItem(Material.FIREBALL,0,"§a§l射撃ダメージ増加"));
        i.setItem(45,getItem(Material.FISHING_ROD,0,"釣りに使われるエンチャント"));
        i.setItem(46,getItem(Material.WATER_LILY,0,"§a§l宝釣り"));
        i.setItem(47,getItem(Material.RAW_FISH,0,"§a§l入れ食い"));
        i.setItem(49,getItem(Material.ENCHANTED_BOOK,0,"全般に使われるエンチャント"));
        i.setItem(50,getItem(Material.BEDROCK,0,"§a§l耐久力"));
        i.setItem(51,getItem(Material.EXP_BOTTLE,0,"§a§l修繕"));
        i.setItem(52,getItem(Material.BLAZE_POWDER,0,"§c§l消滅の呪い"));
        i.setItem(53,getItem(Material.MOB_SPAWNER,0,"§c§l束縛の呪い"));
        gui.add(2,i);
        gui.add(Bukkit.createInventory(null, 9,"§l[EH] エンチャント ー 強さ"));
        gui.get(3).setItem(0,getItem(Material.BOOK,0,"§e§lOff","§7このエンチャントを外します"));
        gui.get(3).setItem(1,getItem(Material.ENCHANTED_BOOK,0,"§e§lLvl.1","§7サポートされてないレベルも選択できます。","§7エンチャントの上限はwikiなどご覧ください...."));
        gui.get(3).setItem(2,getItem(Material.ENCHANTED_BOOK,0,"§e§lLvl.2","§7サポートされてないレベルも選択できます。","§7エンチャントの上限はwikiなどご覧ください...."));
        gui.get(3).setItem(3,getItem(Material.ENCHANTED_BOOK,0,"§e§lLvl.3","§7サポートされてないレベルも選択できます。","§7エンチャントの上限はwikiなどご覧ください...."));
        gui.get(3).setItem(4,getItem(Material.ENCHANTED_BOOK,0,"§e§lLvl.4","§7サポートされてないレベルも選択できます。","§7エンチャントの上限はwikiなどご覧ください...."));
        gui.get(3).setItem(5,getItem(Material.ENCHANTED_BOOK,0,"§e§lLvl.5","§7サポートされてないレベルも選択できます。","§7エンチャントの上限はwikiなどご覧ください...."));
        gui.get(3).setItem(6,getItem(Material.ENCHANTED_BOOK,0,"§c§lLvl.6","§7役に立つか知りません"));
        gui.get(3).setItem(7,getItem(Material.ENCHANTED_BOOK,0,"§c§lLvl.7","§7役に立つか知りません"));
        gui.get(3).setItem(8,getItem(Material.ENCHANTED_BOOK,0,"§c§l他","§7チャット欄を利用します"));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void invClick(InventoryClickEvent event) {
        int mode = gui.indexOf(event.getClickedInventory());
        Player p = (Player) event.getWhoClicked();
        if (mode == -1)
            return;
        if(event.getCurrentItem()==null)return;
        event.setCancelled(true);
        switch (mode) {
            case 0:
               if (event.getSlot() == 0) {
                    p.openInventory(gui.get(1));
               }
               break;
            case 1:
                ItemsEditor.ieMain(event);
                break;
            case 2:
                ItemsEditor.enchantment(event);
                break;
            case 3:
                if (event.getSlot()==8){
                    chatting.put(p,3);
                }
                ItemsEditor.addEnchant(event);
                p.closeInventory();
                break;
        }

    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onChat(AsyncPlayerChatEvent event) {
        Player p = event.getPlayer();
        if (!chatting.containsKey(p))
            return;
        event.setCancelled(true);
        String msg = event.getMessage();
        switch (chatting.get(p)){
            case 0:
                try{
                    if(msg.equals("q")) {
                        p.sendMessage(prefix+"§a入力モードを終了します");
                        break;
                    }
                    ItemsEditor.changeDamage(p,Integer.parseInt(msg));
                }catch(NumberFormatException e) {
                    p.sendMessage(prefix+"§c§l数値を入力してください！");
                    return;
                }
                break;
            case 1:
                ItemsEditor.changeName(p,msg);
                break;
            case 2:
                ItemsEditor.changeLore(p,msg);
                break;
            case 3:
                try{
                    if(msg.equals("q")) {
                        p.sendMessage(prefix+"§a入力モードを終了します");
                        break;
                    }
                    ItemsEditor.addEnchant(p,Integer.parseInt(msg));
                }catch(NumberFormatException e) {
                    p.sendMessage(prefix+"§c§l数値を入力してください！");
                    return;
                }
                break;

        }
        chatting.remove(p);
    }

    static private ItemStack getItem(Material m,int d,String n,String... l){
        ItemStack item = new ItemStack(m,1,(short)d);
        ItemMeta me=item.getItemMeta();
        me.setLore(Arrays.asList(l));
        me.setDisplayName(n);
        item.setItemMeta(me);
        return item;
    }

}
