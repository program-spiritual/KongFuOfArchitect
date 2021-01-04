package fsm.lookup;

public interface IMario {
    State getName();  //以下是定义的事件

    void obtainMushRoom();

    void obtainCape();

    void obtainFireFlower();

    void meetMonster();
}
