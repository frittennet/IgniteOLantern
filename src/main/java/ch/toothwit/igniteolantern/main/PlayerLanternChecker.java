package ch.toothwit.igniteolantern.main;

import java.util.ArrayList; 
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerLanternChecker extends BukkitRunnable { 
	public List<Block> ignitedLanterns = new ArrayList<Block>(); 
	
	private static float radius = 3.14f; 
	
	@SuppressWarnings("deprecation")
	@Override
	public void run() { 
		for(Block b : ignitedLanterns){ 
			byte data = b.getData(); 
			b.setType(Material.PUMPKIN); 
			b.setData(data); 
		} 
		
		for(Player p : IgniteOLantern.get().getServer().getOnlinePlayers()){
			for(int x = -(int)radius;x < (int)radius;x++){ 
				for(int y = -(int)radius;y < (int)radius;y++){ 
					for(int z = -(int)radius;z < (int)radius;z++){ 
						Location l = p.getLocation().clone().add(x, y, z); 
						Block b = l.getBlock() ; 
						if(b.getType() == Material.PUMPKIN || b.getType() == Material.JACK_O_LANTERN){ 
							byte data = b.getData(); 
							b.setType(Material.JACK_O_LANTERN); 
							b.setData(data); 
							ignitedLanterns.add(b); 
						}
					} 
				} 
			} 
		}
	} 
}
