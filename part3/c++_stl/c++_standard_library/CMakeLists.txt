
add_library(c++_standard_library aaaa.cpp functional.cpp)
include_directories(${CMAKE_CURRENT_BINARY_DIR})
install(TARGETS c++_standard_library  DESTINATION bin)
install(FILES  DESTINATION include)
add_executable(functional functional.cpp)
