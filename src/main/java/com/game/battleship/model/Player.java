package com.game.battleship.model;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@AllArgsConstructor
@ToString
public class Player {
    private String name;
    private int gridSize;
    private int shipsCount;
    private int misselsCount;
    private List<Ship> shipsList;
    private List<Missle> misslesList;
    private Map<Ship, Integer> shipsPositions;
    private Map<Missle, Integer> misslePositions;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + gridSize;
        result = prime * result + misselsCount;
        result = prime * result + ((misslePositions == null) ? 0 : misslePositions.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + shipsCount;
        result = prime * result + ((shipsPositions == null) ? 0 : shipsPositions.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Player other = (Player) obj;
        if (gridSize != other.gridSize)
            return false;
        if (misselsCount != other.misselsCount)
            return false;
        if (misslePositions == null) {
            if (other.misslePositions != null)
                return false;
        } else if (!misslePositions.equals(other.misslePositions))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (shipsCount != other.shipsCount)
            return false;
        if (shipsPositions == null) {
            if (other.shipsPositions != null)
                return false;
        } else if (!shipsPositions.equals(other.shipsPositions))
            return false;
        return true;
    }
}