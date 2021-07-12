package com.learning.designpatterns.behavioral.memento.impl;

import com.learning.designpatterns.behavioral.memento.intf.Entity;
import com.learning.designpatterns.behavioral.memento.intf.EntityMemento;
import com.learning.designpatterns.behavioral.memento.intf.EntityStateException;

public class EntityMementoImpl implements EntityMemento {

	private Entity state;

	public static EntityMemento build(Entity originator) throws EntityStateException {
		EntityMementoImpl entityMemento = new EntityMementoImpl();
		try {
			entityMemento.state = (Entity) originator.clone();
		} catch (CloneNotSupportedException e) {
			throw new EntityStateException(e);
		}
		return entityMemento;
	}

	private EntityMementoImpl() {
	}

	public Entity getEntity() {
		return state;
	}

}
