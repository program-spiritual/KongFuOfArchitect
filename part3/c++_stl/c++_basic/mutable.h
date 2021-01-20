//
// Created by 胡宏运 on 2021/1/20.
//

#ifndef C___STL_MUTABLE_H
#define C___STL_MUTABLE_H

#endif //C___STL_MUTABLE_H

class Mutable {
public:
    double len;
    mutable breadth{};
    double height;

    double getVolume();

};


double Mutable::getVolume() {
    return len*breadth*height
}

