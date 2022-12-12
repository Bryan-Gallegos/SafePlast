package com.example.safeplast;

import com.example.safeplast.Room.Plasticos;

public interface AdapterListener {

    void OnUpdate(Plasticos plasticos);
    void OnDelete(int id, int pos);

}
