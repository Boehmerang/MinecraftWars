package war.client.flag;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;

public class EntityFlag extends EntityLiving implements IEntityAdditionalSpawnData
{
	private Entity host;
	int hp = 100;

	public EntityFlag(World par1World)
	{
		super(par1World);
		this.isImmuneToFire = true;
		this.setSize(1.1F, 1.1F);
	}

	public EntityFlag(Entity c)
	{
		this(c.worldObj);
		this.setPosition(c.posX, c.posY, c.posZ);
		this.host = c;
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, int ammount)
	{
		return false;
	}

	@Override
	public boolean isPotionApplicable(PotionEffect par1PotionEffect)
	{
		return false;
	}

	@Override
	public void addPotionEffect(PotionEffect par1PotionEffect)
	{

	}

	@Override
	public String getEntityName()
	{
		return "EntityTileTarget";
	}

	@Override
	public void writeSpawnData(ByteArrayDataOutput data)
	{

	}

	@Override
	public void readSpawnData(ByteArrayDataInput data)
	{

	}

	@Override
	public void onUpdate()
	{
		if (!this.worldObj.isRemote)
		{
			if (this.host == null)
			{
				// TODO drop as item or place into world
				this.setDead();
			}
			else
			{
				this.updatePos();
			}
		}
	}

	public void updatePos()
	{
		if (this.host != null && !this.worldObj.isRemote)
		{
			float yaw = this.host.rotationYaw;
			double x = this.host.posX + (1 * Math.cos(yaw));
			double y = this.host.posY = 0.5;
			double z = this.host.posZ + (1 * Math.sin(yaw));
			this.setPosition(x, y, z);
			this.setRotation(-yaw, 0);
		}
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbttagcompound)
	{
		// TODO Auto-generated method stub

	}

	public void moveEntity(double par1, double par3, double par5)
	{

	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbttagcompound)
	{
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean canTriggerWalking()
	{
		return false;
	}

	@Override
	public AxisAlignedBB getCollisionBox(Entity par1Entity)
	{
		return null;

	}

	@Override
	public boolean canBeCollidedWith()
	{
		return false;
	}

	@Override
	public void setVelocity(double par1, double par3, double par5)
	{

	}

	@Override
	public boolean isInsideOfMaterial(Material par1Material)
	{
		return false;
	}

	@Override
	public boolean interact(EntityPlayer player)
	{
		return false;
	}

	@Override
	public int getMaxHealth()
	{
		return Integer.MAX_VALUE;
	}
}
