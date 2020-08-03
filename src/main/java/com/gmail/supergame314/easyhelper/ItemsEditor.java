package com.gmail.supergame314.easyhelper;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.gmail.supergame314.easyhelper.EasyHelper.*;

public class ItemsEditor{

    static Map<Player,Enchantment> eMap = new HashMap<>();

    static void ieMain(InventoryClickEvent event){
        Player p = (Player) event.getWhoClicked();
        switch (event.getSlot()){
            case 0:
                p.openInventory(gui.get(2));
                break;
            case 1:
                if(p.getInventory().getItemInMainHand()==null){
                    p.sendMessage(prefix+"あなたは手に何も持ってません！");
                    return;
                }
                p.sendMessage(prefix+"§a§lダメージ値をチャット欄に入力してください(qと入力するとこのモードを終了します)");
                p.closeInventory();
                chatting.put(p,0);
                break;
            case 3:
                if(p.getInventory().getItemInMainHand()==null){
                    p.sendMessage(prefix+"あなたは手に何も持ってません！");
                    return;
                }
                p.sendMessage(prefix+"§a§l名前をチャット欄に入力してください(&は変換します)");
                p.closeInventory();
                chatting.put(p,1);
                break;
            case 4:
                if(p.getInventory().getItemInMainHand()==null){
                    p.sendMessage(prefix+"あなたは手に何も持ってません！");
                    return;
                }
                p.sendMessage(prefix+"§a§l説明をチャット欄に入力してください(&は変換します。&を利用したい場合は\"&&\"と入力してください。&zで改行です。)");
                p.closeInventory();
                chatting.put(p,2);
                break;
        }
    }

    static void enchantment(InventoryClickEvent event){
        Player p = (Player) event.getWhoClicked();
        switch (event.getSlot()){
            case 2:
                eMap.put(p,Enchantment.DAMAGE_ALL);
                p.openInventory(gui.get(3));
                break;
            case 3:
                eMap.put(p,Enchantment.DAMAGE_UNDEAD);
                p.openInventory(gui.get(3));
                break;
            case 4:
                eMap.put(p,Enchantment.DAMAGE_ARTHROPODS);
                p.openInventory(gui.get(3));
                break;
            case 5:
                eMap.put(p,Enchantment.KNOCKBACK);
                p.openInventory(gui.get(3));
                break;
            case 6:
                eMap.put(p,Enchantment.FIRE_ASPECT);
                p.openInventory(gui.get(3));
                break;
            case 7:
                eMap.put(p,Enchantment.LOOT_BONUS_MOBS);
                p.openInventory(gui.get(3));
                break;
            case 8:
                eMap.put(p,Enchantment.SWEEPING_EDGE);
                p.openInventory(gui.get(3));
                break;
            case 11:
                eMap.put(p,Enchantment.PROTECTION_ENVIRONMENTAL);
                p.openInventory(gui.get(3));
                break;
            case 12:
                eMap.put(p,Enchantment.PROTECTION_FIRE);
                p.openInventory(gui.get(3));
                break;
            case 13:
                eMap.put(p,Enchantment.PROTECTION_EXPLOSIONS);
                p.openInventory(gui.get(3));
                break;
            case 14:
                eMap.put(p,Enchantment.PROTECTION_PROJECTILE);
                p.openInventory(gui.get(3));
                break;
            case 15:
                eMap.put(p,Enchantment.PROTECTION_FALL);
                p.openInventory(gui.get(3));
                break;
            case 16:
                eMap.put(p,Enchantment.THORNS);
                p.openInventory(gui.get(3));
                break;
            case 17:
                eMap.put(p,Enchantment.DEPTH_STRIDER);
                p.openInventory(gui.get(3));
                break;
            case 20:
                eMap.put(p,Enchantment.WATER_WORKER);
                p.openInventory(gui.get(3));
                break;
            case 21:
                eMap.put(p,Enchantment.OXYGEN);
                p.openInventory(gui.get(3));
                break;
            case 22:
                eMap.put(p,Enchantment.FROST_WALKER);
                p.openInventory(gui.get(3));
                break;
            case 29:
                eMap.put(p,Enchantment.DIG_SPEED);
                p.openInventory(gui.get(3));
                break;
            case 30:
                eMap.put(p,Enchantment.SILK_TOUCH);
                p.openInventory(gui.get(3));
                break;
            case 31:
                eMap.put(p,Enchantment.LOOT_BONUS_BLOCKS);
                p.openInventory(gui.get(3));
                break;
            case 37:
                eMap.put(p,Enchantment.ARROW_INFINITE);
                p.openInventory(gui.get(3));
                break;
            case 38:
                eMap.put(p,Enchantment.ARROW_KNOCKBACK);
                p.openInventory(gui.get(3));
                break;
            case 39:
                eMap.put(p,Enchantment.ARROW_FIRE);
                p.openInventory(gui.get(3));
                break;
            case 40:
                eMap.put(p,Enchantment.ARROW_DAMAGE);
                p.openInventory(gui.get(3));
                break;
            case 46:
                eMap.put(p,Enchantment.LUCK);
                p.openInventory(gui.get(3));
                break;
            case 47:
                eMap.put(p,Enchantment.LURE);
                p.openInventory(gui.get(3));
                break;
            case 50:
                eMap.put(p,Enchantment.DURABILITY);
                p.openInventory(gui.get(3));
                break;
            case 51:
                eMap.put(p,Enchantment.MENDING);
                p.openInventory(gui.get(3));
                break;
            case 52:
                eMap.put(p,Enchantment.VANISHING_CURSE);
                p.openInventory(gui.get(3));
                break;
            case 53:
                eMap.put(p,Enchantment.BINDING_CURSE);
                p.openInventory(gui.get(3));
                break;
        }
    }

    static void addEnchant(InventoryClickEvent event){
        Player p = (Player) event.getWhoClicked();
        eMap.remove(p);
        switch(event.getSlot()){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                ItemStack i = p.getInventory().getItemInMainHand();
                if(i==null){
                    p.sendMessage(prefix+"あなたは手に何も持ってません！");
                    return;
                }
                i.addUnsafeEnchantment(eMap.get(p),event.getSlot());
                break;
        }

    }

    static void changeDamage(Player p,int damage){
        ItemStack item = p.getInventory().getItemInMainHand();
        if(item==null)return;
        item.setDurability((short) damage);
    }

    static void changeName(Player p,String s){
        s=s.replaceAll("&","§");
        s=s.replaceAll("§§","&");
        ItemStack item = p.getInventory().getItemInMainHand();
        if(item==null)return;
        ItemMeta meta=item.getItemMeta();
        meta.setDisplayName(s);
        item.setItemMeta(meta);
    }

    static void changeLore(Player p,String s){
        s=s.replaceAll("&","§");
        s=s.replaceAll("§§","&");
        ItemStack item = p.getInventory().getItemInMainHand();
        if(item==null)return;
        ItemMeta meta=item.getItemMeta();
        meta.setLore(Arrays.asList(s.split("§z")));
        item.setItemMeta(meta);
    }



}
