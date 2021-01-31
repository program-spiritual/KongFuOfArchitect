#include <iostream>
#include <cstdlib>
#include <pthread.h>

using namespace std;
#define NUM_THREADS  5

void *PrintHello(void *threadid) {
    long tid;
    tid = (long) threadid;
    cout << "Hello World! Thread ID, " << tid << endl;
    pthread_exit(nullptr);
}

int main () {
    try {
        pthread_t threads[NUM_THREADS];
        int rc;
        int i;

        for( i = 0; i < NUM_THREADS; i++ ) {
            cout << "main() : creating thread, " << i << endl;
            rc = pthread_create(&threads[i], nullptr, PrintHello, (void *)i);

            if (rc) {
                cout << "Error:unable to create thread," << rc << endl;
                exit(-1);
            }
        }
        pthread_exit(nullptr);
    } catch (exception &exception) {
        cerr << "error: " << exception.what();
    }
}
