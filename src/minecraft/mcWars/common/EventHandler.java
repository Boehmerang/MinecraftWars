package mcWars.common;

import keepcalm.mods.events.PlayerBreakBlockEvent;
import keepcalm.mods.events.events.PlayerMoveEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class EventHandler 
{
	@ForgeSubscribe
	public void onPlayerMove(PlayerMoveEvent ev)
	{
		//  check the players position here to determine the effects this region
		//  has on the player (Dig speed, damage, defense, etc)
		
		if (ev.newX != ev.oldX || ev.newZ != ev.oldZ || ev.newY != ev.oldY)
			{
				ev.entityPlayer.sendChatToPlayer("You have moved!");
			
				System.out.println("You moved!");
			}
	}
	
	@ForgeSubscribe
	public void onBlockBreak(PlayerBreakBlockEvent ev) 
	{
		ev.player.sendChatToPlayer("Stop breaking things!");
	    System.out.println("Break!");
	}	
}
