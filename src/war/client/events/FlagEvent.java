package war.client.events;

import net.minecraft.entity.Entity;
import net.minecraftforge.event.entity.EntityEvent;
import war.client.flag.EntityFlag;

public class FlagEvent extends EntityEvent
{
	public EntityFlag flag;

	public FlagEvent(Entity entity, EntityFlag flag)
	{
		super(entity);
		this.flag = flag;
	}

	public static class FlagPickUpEvent extends FlagEvent
	{
		public FlagPickUpEvent(Entity entity, EntityFlag flag)
		{
			super(entity, flag);
		}
	}

	public static class FlagPickDropEvent extends FlagEvent
	{
		public FlagPickDropEvent(Entity entity, EntityFlag flag)
		{
			super(entity, flag);
		}
	}
}
