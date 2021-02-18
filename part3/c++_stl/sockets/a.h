#ifndef C___STL_A_H
#define C___STL_A_H

#include <cstdint>
#include <cstdio>
#include <cstdlib>
#include <iostream>

#if __WIN32__

#include <winsock2.h>

#else
#include <sys/socket.h>
#endif

class a {
public:
  static int make_socket(uint16_t port);
};


#endif //C___STL_A_H
