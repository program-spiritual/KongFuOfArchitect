#include <cstdio>
#include <cstddef>

int main () {
    FILE * checkfile;
    long size;
    checkfile = fopen ("Tempfile.txt","rb");

    if (checkfile == nullptr)
        perror ("file can’t open");
    else {
        fseek (checkfile, 0, SEEK_END);    // non-portable
        size = ftell (checkfile);
        fclose (checkfile);
        printf ("Size of Tempfile.txt: %ld bytes.\n",size);
    }
    return 0;
}
