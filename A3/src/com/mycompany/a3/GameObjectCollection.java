package com.mycompany.a3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import com.codename1.ui.List;

public class GameObjectCollection implements ICollection {
	private Vector<GameObjects> gameObjectCollection;
	
	public GameObjectCollection() {
		gameObjectCollection = new Vector<GameObjects>();
	}
	
	public Vector<GameObjects> getCollection(){
		return gameObjectCollection;
	}
	public IIterator getIterator() {
		return new CollectionIterator();
	}
	
	public class CollectionIterator implements IIterator{
		private int index;
		public CollectionIterator() {
			index = -1;
		}
		
		public boolean hasNext() {
			boolean hasNext = (gameObjectCollection.size()== 0 || index == gameObjectCollection.size() -1 ?  true :  false ) ;
			return hasNext;
		}
		
		public void remove() {
				gameObjectCollection.remove(index);
				index--;
		}
		
		public GameObjects getNext() {
			index++;
			return gameObjectCollection.get(index);
		}
		
	}

	@Override
	public void add(GameObjects gameOBJ) {
		gameObjectCollection.add(gameOBJ);
	}
}
