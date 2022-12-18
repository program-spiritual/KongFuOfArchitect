#include <cstdio>

int main () {
    if(remove( "Tempfile.txt" ) != 0 )
        perror( "File doesn’t exist, can’t delete" );
    else
        puts( "file deleted successfully " );
    return 0;
}
