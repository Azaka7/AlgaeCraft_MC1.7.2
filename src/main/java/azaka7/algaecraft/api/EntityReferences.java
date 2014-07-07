package azaka7.algaecraft.api;

import net.minecraft.entity.Entity;
import azaka7.algaecraft.api.Reference.*;

/*Refer to AlgaeCraft entities by referring to one of these objects.
 * Get an entity's class file using .getEntityClass();
 * Example:
 *  public boolean isEntityLobster(Entity entity){
		Class entityClass = EntityReferences.entityLobster.getEntityClass();
		return entityClass.isInstance(entity);
	}
 */
public class EntityReferences {
	public static EntityClassObject entityLobster = new EntityClassObject("lobster");
	
}
