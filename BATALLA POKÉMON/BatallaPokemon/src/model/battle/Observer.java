package model.battle;

import model.battle.turn.Subject;

public interface Observer {
    void update(Subject subject);
}
