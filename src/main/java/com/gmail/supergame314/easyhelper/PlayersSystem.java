package com.gmail.supergame314.easyhelper;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import static com.gmail.supergame314.easyhelper.EasyHelper.*;

import java.util.*;

public class PlayersSystem {

    private List<Inventory> playersI = new ArrayList<>();
    private Map<Inventory,Player> menuInv = new HashMap<>();
    private Map<Inventory,Player> eachPlayer = new HashMap<>();
    private Map<Inventory,Player> endCh = new HashMap<>();

    public void reloadData(){
        playersI = new ArrayList<>();
        playersI.add(Bukkit.createInventory(null,54,"§l[EH] プレイヤー一覧"));
        int page = 0;
        for(Player p:Bukkit.getOnlinePlayers()) {
            ItemStack item = new ItemStack(Material.SKULL_ITEM,1,(short)3);
            SkullMeta meta = (SkullMeta) item.getItemMeta();
            meta.setOwningPlayer(p);
            meta.setDisplayName(p.getName());
            meta.setLore(Arrays.asList("§c§lHP: "+p.getHealth()+"/20",
                    "§a§l満腹度: "+p.getFoodLevel()+"/20",
                    "§d§l場所: §e§l"+p.getLocation().getWorld().getName()+"§dの§e§l"+p.getLocation().getBlockX()+"§d,§e§l"+p.getLocation().getBlockY()+"§d,§e§l"+p.getLocation().getBlockZ(),
                    "§9§lゲームモード: "+p.getGameMode().name(),
                    "§b§l表示上の名前: §r"+p.getDisplayName(),
                    "§7左クリックで詳細、右クリックでテレポート"));
            item.setItemMeta(meta);
            if(playersI.get(page).getItem(44)!=null){
                playersI.get(page).setItem(53,EasyHelper.getItem(Material.ARROW,1,"§6§l次へ"));
                playersI.add(Bukkit.createInventory(null,54,"§l[EH] プレイヤー一覧"));
                page++;
                playersI.get(page).setItem(45,EasyHelper.getItem(Material.ARROW,1,"§6§l前へ"));
            }
            playersI.get(page).addItem(item);
        }
    }

    public void showInv(Player p){
        reloadData();
        p.openInventory(playersI.get(0));
    }


    public void showEachPlayersMenu(Player p,Player target){
        p.openInventory(createMenuGui(target));
    }

    public void invClick(InventoryClickEvent event){
        Player p = (Player) event.getWhoClicked();
        if(event.getSlot()==53){
            //next
            p.openInventory(playersI.get(indexOfInv(event.getInventory())+1));
            return;
        }
        if(event.getSlot()==45){
            //back
            p.openInventory(playersI.get(indexOfInv(event.getInventory())-1));
            return;
        }
        Player target = Bukkit.getPlayer(event.getCurrentItem().getItemMeta().getDisplayName());
        if(target!=null){
            if(event.getClick()== ClickType.RIGHT){
                p.teleport(target);
            }else if(event.getClick() == ClickType.LEFT){
                showEachPlayersMenu(p,target);
            }
        }
    }

    public boolean isOwnInv(Inventory inventory){
        return playersI.contains(inventory);
    }

    private int indexOfInv(Inventory i){
        return playersI.indexOf(i);
    }

    public Player isPlayersInv(Inventory i){
        Player rtn = eachPlayer.get(i);
        eachPlayer.remove(i);
        return rtn;
    }

    public Player isEndInv(Inventory i){
        Player rtn = endCh.get(i);
        endCh.remove(i);
        return rtn;
    }

    public boolean isMenuInv(Inventory i){
        return menuInv.containsKey(i);
    }

    public void menuInv(InventoryClickEvent event){
        Player p = (Player) event.getWhoClicked();
        Player target = menuInv.get(event.getClickedInventory());
        switch (event.getSlot()){
            case 0:
                eachPlayer.put(target.getInventory(),target);
                p.openInventory(target.getInventory());
                break;
            case 1:
                endCh.put(target.getInventory(),target);
                p.openInventory(target.getEnderChest());
                break;
        }
    }


    private Inventory createMenuGui(Player p){
        Inventory i = Bukkit.createInventory(null,54,"§l[EH] プレイヤー操作 - "+p.getName());
        i.setItem(0,getItem(Material.CHEST,0,"§6§lインベントリを見る ・ 編集する","§7注 ： 1行目が手の所です"));
        i.setItem(1,getItem(Material.ENDER_CHEST,0,"§5§lエンダーチェストを見る ・ 編集する"));
        menuInv.put(i,p);
        return i;
    }

    public void removeMenu(Inventory i){
        menuInv.remove(i);
    }
}
