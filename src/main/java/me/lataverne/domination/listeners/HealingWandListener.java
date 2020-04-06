package me.lataverne.domination.listeners;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import me.lataverne.domination.enums.Items;

import java.util.Objects;

public class HealingWandListener implements Listener {
    @EventHandler
    public void onUse(PlayerInteractEvent event) {
        ItemStack item;

        if (event.getHand() == EquipmentSlot.HAND) {
            item = event.getPlayer().getInventory().getItemInMainHand();
        } else {
            item = event.getPlayer().getInventory().getItemInOffHand();
        }

        if(event.getPlayer().hasCooldown(item.getType())) return;

        if (Items.HEAL_WAND.compareTo(item)) {

            Snowball heealBall =(Snowball) event.getPlayer().launchProjectile(Snowball.class);
            heealBall.setLastDamageCause(null);
            heealBall.setCustomName("ma_boule");
//            if(event.getRightClicked() instanceof Player){
//                Player clickedPlayer = (Player) event.getRightClicked();
//
//                //TODO Fonction obtention et check de l'equipe => eviter de heal un enemi
//                //le joueur est un allier
//                //le joueur n'est pas full vie
//
//                double max_heal = clickedPlayer.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
//                double friend_heal = clickedPlayer.getHealth();
//                double bonus_heal = 6;
//
//                if( friend_heal <= max_heal){
//                    Location location = clickedPlayer.getLocation().clone();
//                    location.setY(clickedPlayer.getLocation().getY()+ 2);
//
//                    clickedPlayer.getLocation().getWorld().spawnParticle(Particle.VILLAGER_HAPPY,location,15);
//
//                    clickedPlayer.setHealth(friend_heal+bonus_heal);
//                    event.getPlayer().setCooldown(item.getType(),20);
//                }
//            }
        }
    }

//    @EventHandler
//    public void onEffect(ProjectileHitEvent event){
//        System.out.println("test");
//        Snowball snowball = (Snowball) event.getEntity();        System.out.println(snowball.getCustomName()+ "  ee");
//        if(Objects.requireNonNull(snowball.getCustomName()).equals("ma_boule")){
//            Player shooter = (Player) event.getEntity().getShooter();         System.out.println("test45");
//            shooter.sendMessage("touché");
//        }
//    }
}
