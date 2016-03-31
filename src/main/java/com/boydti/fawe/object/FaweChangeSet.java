package com.boydti.fawe.object;

import java.util.ArrayDeque;
import java.util.Iterator;

import com.sk89q.worldedit.history.change.BlockChange;
import com.sk89q.worldedit.history.change.Change;
import com.sk89q.worldedit.history.changeset.ChangeSet;

public class FaweChangeSet implements ChangeSet {

    private final ArrayDeque<Change> changes = new ArrayDeque<>();

    @Override
    public void add(final Change change) {
        if (change.getClass() == BlockChange.class) {
            final BlockChange bc = (BlockChange) change;
            bc.getCurrent();
            //            BaseBlock previous = bc.getPrevious();
            //            BlockVector pos = bc.getPosition();
            //            int x = pos.getBlockX();
            //            int y = pos.getBlockY();
            //            int z = pos.getBlockZ();
            this.changes.add(bc);
        } else {
            this.changes.add(change);
        }
    }

    @Override
    public Iterator<Change> backwardIterator() {
        return this.changes.descendingIterator();
    }

    @Override
    public Iterator<Change> forwardIterator() {
        return this.changes.iterator();
    }

    @Override
    public int size() {
        return this.changes.size();
    }
}
